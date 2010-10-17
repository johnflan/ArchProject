package ie.ul.csis.cs4135.pcshop.factory.Computer;

import ie.ul.csis.cs4135.pcshop.factory.ComponentComposite;

public class ComputerComposite extends ComponentComposite {
	
	
	public ComputerComposite(String brandName, String productName, Float price){
		super.price = price;
		super.brandName = brandName;
		super.productName = productName;

	}
	
	public ComputerComposite(){

		super.price = 0.0f;
	}


}