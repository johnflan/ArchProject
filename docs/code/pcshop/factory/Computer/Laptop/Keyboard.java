package ie.ul.csis.cs4135.pcshop.factory.Computer.Laptop;

import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.KeyboardInterface;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;

public class Keyboard implements KeyboardInterface {

	private Float price;
	private String brandName;
	private String productName;
	private String charSet;
	
	public Keyboard(Float price, String brandName, String productName, String charSet){
		this.price = price;
		this.brandName = brandName;
		this.productName = productName;
		this.charSet = charSet;
	}
	
	@Override
	public Float getPrice() {		
		return price;
	}

	@Override
	public String getBrandName() {
		return brandName;
	}

	@Override
	public String getProductName() {
		return productName;
	}
	
	public String getCharSet() {
		return charSet;
	}

	@Override
	public ComponentInterface getBaseItem() {
		return this;
	}


}