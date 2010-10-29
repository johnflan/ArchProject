package ie.ul.csis.cs4135.pcshop;

import ie.ul.csis.cs4135.pcshop.componentDecorator.ComputerModificator;
import ie.ul.csis.cs4135.pcshop.componentDecorator.DecoratorInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import ie.ul.csis.cs4135.pcshop.factory.AbstractProductFactory;
import ie.ul.csis.cs4135.pcshop.factory.ComponentComposite;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;
import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerFactory;
import ie.ul.csis.cs4135.pcshop.taxRegion.AbstractTaxState;
import ie.ul.csis.cs4135.pcshop.taxRegion.CurrencyConverterService;
import ie.ul.csis.cs4135.pcshop.taxRegion.TaxRegionEnum;
import ie.ul.csis.cs4135.pcshop.taxRegion.TaxStateFactory;

public class OrderManager implements Observer{

	private List<ComponentInterface> order = new ArrayList<ComponentInterface>();
	private Float subTotalPrice;
	private AbstractTaxState taxCalculator;
	private AbstractProductFactory productFactory;
	private Float secondCurrency = new Float(0.0f);
	
	
    /** 
     * To instantiate a new OrderManager you must pass the default region
     * the shop is to operate from.
     * 
     * @param region The locale the shop is operating in {@code TaxRegionEnum }
     */  
	
	public OrderManager(TaxRegionEnum region) throws Exception {
		setTaxRegion(region);
		subTotalPrice = 0.0F;
		productFactory = new ComputerFactory(this);

	}
	
    /** 
	 *	Add a new product to the shopping cart, the available products are available
	 *	under the ProductsEnum.
	 *
	 *	If you only wish to query the price call the {@code getProductPrice(ComponentInterface)}
	 *	method.
	 *
	 *	@param productType Type of product you wish to add.
     */  
		
	public ComponentInterface addProduct(ProductsEnum productType) throws Exception {
		
		ComponentInterface newProduct = productFactory.createProduct(productType);
		order.add( newProduct );
		update(null, null);
		return newProduct;
	}
	
	
	/**
    * Returns a copy of the order list. Its modification will not effect the
    * state of the OrderManagers basket.
    *
    * @return List<ComponentInterface>
    */
	
	public List<ComponentInterface> getOrder(){
		
		List<ComponentInterface> returnList = new ArrayList<ComponentInterface>(order);
		return returnList;

	}
	
	/**
    * Total price of the basket including taxes and charges
    *
    * @return Float
    */
	
	public Float getTotalPrice() {
		
		return taxCalculator.calculateTax(subTotalPrice) + getSubTotalPrice();
	}
	
	/**
    * Price of the products in the basket, less any additional charges
    *
    * @return Float
    */
	
	public Float getSubTotalPrice() {
		
		//recalculatePrice();
		return subTotalPrice;
	}
	
	/**
    * Returns the price of the taxes for the basket.
    *
    * @return Float
    */
	
	public Float getTaxes() {
		
		return taxCalculator.calculateTax(getSubTotalPrice());
	}
	
	
	/**
    * Remove a product from the basket, takes a reference to a
    * product. This reference can be accessed by calling {@code getOrder()}
    *
	* @param product reference to a product
    */
	
	public void removeProduct(ComponentInterface product) {
		order.remove(product);
		update(null, null);
	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		
		recalculatePrice();
		
	}
	
	public void setTaxRegion(TaxRegionEnum region) throws Exception {
		
		taxCalculator = TaxStateFactory.getCalculator(region);
		
	}
	
	/**
    * Calls a webservice to convert the current basket total price
    * to a foregin currency. This does not change the region of the
    * basket, only returns the converted currency.
    *
	* @param toRegion Takes a TaxRegionEnum region
    */
	
	public Float getPriceInOtherCurrency(TaxRegionEnum toRegion){
		
		AbstractTaxState toCurrency;
		try {
				// TODO: create a test to return totalprice
				// if the toRegion is the same and the currentRegion
				toCurrency = TaxStateFactory.getCalculator(toRegion);
				
				CurrencyConverterService currencyConverter =  new CurrencyConverterService(
						taxCalculator.getCurrencyCode(), toCurrency.getCurrencyCode(), 
						taxCalculator.calculateTax(subTotalPrice) + subTotalPrice,
						secondCurrency);
	
				return currencyConverter.getForeginRate();


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Float(0.0f);
		}

		
	}
	
	private void recalculatePrice(){
		
		subTotalPrice = 0.0f;
		
		for (ComponentInterface product : order)
			subTotalPrice += product.getPrice();

	}
	
	
	/**
    * To add or remove components to a particular product, this
    * will return a {@code ComputerModificator} with the available
    * options for that particular product.
    * 
    * <B>What sort of name is ComputerModificator :)</B>
    *
	* @param product Takes a TaxRegionEnum region
	* @return ComputerModificator
    */
	
	public ComputerModificator modifyComputerProduct(ComponentInterface product) throws Exception{
		//create decorator with this reference
		ComputerModificator decorator = new ComputerModificator(product);
		return decorator;
	}
	
	/**
    * Requests the price for the particular product.
    * This does not add anything to the basket.
    *
	* @param productType Takes a ProductEnum product
	* @return Float The product price
    */
	
	public Float getProductPrice(ProductsEnum productType){

			ComponentInterface newProduct;
			try{
				newProduct = productFactory.createProduct(productType);
				return newProduct.getPrice();
				
			} catch (Exception e) {
				e.printStackTrace();
				return 0.0f;
			}
	
	}
	
	public void addExternalProduct(ComponentInterface product){
		
		if(product == null)
			return;
		
		List<ComponentComposite> composites = ((ComponentComposite) product).getCompositeChildren();
		boolean hasComposite = true;
		
		while(hasComposite){
			
			if (composites == null)
				break;
			
			Iterator<ComponentComposite> compositeItr = composites.iterator();
			List<ComponentComposite> tmpComposites = new ArrayList<ComponentComposite>();
			
			while (compositeItr.hasNext()){
				ComponentComposite currentComposite = compositeItr.next();
				currentComposite.deleteObservers();
				currentComposite.addObserver(this);
				tmpComposites.addAll(currentComposite.getCompositeChildren());
			}
			
			composites = tmpComposites;
			
			if (composites.size() == 0)
				hasComposite = false;
			
		}
		
		order.add(product);
		update(null, null);
	}

}