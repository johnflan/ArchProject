package ie.ul.csis.cs4135.pcshop;

import ie.ul.csis.cs4135.pcshop.componentDecorator.DecoratorInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import ie.ul.csis.cs4135.pcshop.factory.AbstractProductFactory;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;
import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerFactory;
import ie.ul.csis.cs4135.pcshop.taxRegion.AbstractTaxState;
import ie.ul.csis.cs4135.pcshop.taxRegion.TaxRegionEnum;
import ie.ul.csis.cs4135.pcshop.taxRegion.TaxStateFactory;

public class OrderManager implements Observer{

	private List<ComponentInterface> order = new ArrayList();
	private DecoratorInterface decorator;
	private Float subTotalPrice;
	private TaxRegionEnum taxRegion;
	private AbstractTaxState taxCalculator;
	private AbstractProductFactory productFactory;
	
	
	public OrderManager(TaxRegionEnum region) throws Exception {
		
		setTaxRegion(region);
		subTotalPrice = 0.0F;
		productFactory = new ComputerFactory();
		
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
		
		//FIXME: test
		recalculatePrice();
		
		return taxCalculator.calculateTax(subTotalPrice) + subTotalPrice;
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
	
	private void recalculatePrice(){
		
		subTotalPrice = 0.0f;
		
		for (ComponentInterface product : order)
			subTotalPrice += product.getPrice();
		
		
	}

}