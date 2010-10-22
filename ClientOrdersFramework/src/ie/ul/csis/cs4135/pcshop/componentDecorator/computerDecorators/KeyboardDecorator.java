package ie.ul.csis.cs4135.pcshop.componentDecorator.computerDecorators;

import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.KeyboardInterface;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;

public class KeyboardDecorator implements KeyboardInterface{
	
	private Float price;
	private String brandName;
	private String productName;
	private String charSet;
	private KeyboardInterface keyboard; 
	
	public KeyboardDecorator(KeyboardInterface keyboard, Float price, String brandName, String productName, String charSet){
		this.keyboard = keyboard;
		this.price = price;
		this.brandName = brandName;
		this.productName = brandName;
		this.charSet = charSet;
	}
	
	public String getCharSet() {
		if( charSet.equalsIgnoreCase(keyboard.getCharSet()) )
			return charSet;
		else
			return "Two different charSets: "+charSet+", "+keyboard.getCharSet();
	}

	@Override
	public Float getPrice() {
		return keyboard.getPrice() + price;
	}

	@Override
	public String getBrandName() {
		if( brandName.equalsIgnoreCase(keyboard.getBrandName()) )
			return brandName;
		else
			return "Two different brands: "+brandName+", "+keyboard.getBrandName();
	}

	@Override
	public String getProductName() {
		if( productName.equalsIgnoreCase(keyboard.getProductName()) )
			return productName;
		else
			return "Two different products: "+productName+", "+keyboard.getProductName();
	}

	@Override
	public ComponentInterface getBaseItem() {
		return keyboard.getBaseItem();
	}
}
