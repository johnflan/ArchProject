package ie.ul.csis.cs4135.pcshop.factory.Computer;

import ie.ul.csis.cs4135.pcshop.factory.ComponentComposite;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;

public class ComputerComposite extends ComponentComposite {
	
	
	public ComputerComposite(String brandName, String productName, Float price){
		super.price = price;
		super.brandName = brandName;
		super.productName = productName;

	}
	
	public ComputerComposite(){

		super.price = 0.0f;
	}

	@Override
	public ComponentInterface getBaseItem() {
		return this;
	}


}