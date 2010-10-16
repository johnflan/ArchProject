package ie.ul.csis.cs4135.pcshop;

import ie.ul.csis.cs4135.pcshop.componentDecorator.DecoratorInterface;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;

/*
 */
public class OrderManager implements Observer{

	private List order;
	
	public DecoratorInterface decorator;
	
	public Float subTotalPrice;
	
	public void OrderManager(Enum region) {
	}
	
	private void setTaxRegion(Enum region) {
	}
	
	public void changeTaxRegion(Enum region) {
	}
	
	public ComponentInterface addComputer(Enum type) {
	return null;
	}
	
	public Float getTotalPrice() {
	return null;
	}
	
	public void removeProduct(ComponentInterface product) {
	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}