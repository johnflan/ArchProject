package ie.ul.csis.cs4135.pcshop;

import ie.ul.csis.cs4135.pcshop.componentDecorator.ComputerModificator;
import ie.ul.csis.cs4135.pcshop.componentDecorator.DecoratorInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import ie.ul.csis.cs4135.pcshop.factory.AbstractProductFactory;
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
	
	public OrderManager(TaxRegionEnum region) throws Exception {
		setTaxRegion(region);
		subTotalPrice = 0.0F;
		productFactory = new ComputerFactory(this);

	}
	
	public void changeTaxRegion(TaxRegionEnum region) throws Exception {
		
		setTaxRegion(region);
	}
	
	public ComponentInterface addProduct(ProductsEnum productType) throws Exception {
		
		ComponentInterface newProduct = productFactory.createProduct(productType);
		
		order.add( newProduct );

		return newProduct;
	}
	
	
	/**
    * Returns a copy of the order list, not a reference to the private one.
    *
    * @return List<ComponentInterface>
    */
	
	public List<ComponentInterface> getOrder(){
		
		List<ComponentInterface> returnList = new ArrayList<ComponentInterface>(order);
		return returnList;

	}
	
	public Float getTotalPrice() {
		
		return taxCalculator.calculateTax(subTotalPrice) + getSubTotalPrice();
	}
	
	
	public Float getSubTotalPrice() {
		
		recalculatePrice();
		return subTotalPrice;
	}
	
	public Float getTaxes() {
		
		return taxCalculator.calculateTax(getSubTotalPrice());
	}
	
	public void removeProduct(ComponentInterface product) {
		
		order.remove(product);
	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		
		
		recalculatePrice();
		
	}
	
	private void setTaxRegion(TaxRegionEnum region) throws Exception {
		
		taxCalculator = TaxStateFactory.getCalculator(region);
		
	}
	
	public Float getPriceInOther(TaxRegionEnum toRegion){
		
		String toCurrency;
		
		switch(toRegion){
		
			case IRELAND:
				toCurrency = "eur";
				break;
				
			case UNITED_KINGDOM:
				toCurrency = "gbp";
				break;
				
			default:
				return null;
		}

		

		CurrencyConverterService currencyConverter =  new CurrencyConverterService(
								taxCalculator.getCurrencyCode(), toCurrency, 
								taxCalculator.calculateTax(subTotalPrice) + subTotalPrice,
								secondCurrency);
		
		return currencyConverter.getForeginRate();
	}
	
	private void recalculatePrice(){
		
		subTotalPrice = 0.0f;
		
		for (ComponentInterface product : order)
			subTotalPrice += product.getPrice();

	}
	
	public ComputerModificator modifyComputerProduct(ComponentInterface rootOfProductTree) throws Exception{
		//create decorator with this reference
		ComputerModificator decorator = new ComputerModificator(rootOfProductTree);
		return decorator;
	}
	
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

}