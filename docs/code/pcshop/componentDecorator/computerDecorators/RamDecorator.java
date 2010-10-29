 package ie.ul.csis.cs4135.pcshop.componentDecorator.computerDecorators;

import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.RamInterface;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;

public class RamDecorator implements RamInterface {

	private RamInterface ram;
	private Float price;
	private String brandName;
	private String productName;
	private String ramType;
	private int ramSize;
	
	public RamDecorator(RamInterface ram, String brandName, String productName, Float price, String ramType, int ramSize){
		this.ram = ram;
		this.brandName = brandName;
		this.productName = productName;
		this.price = price;
		this.ramType = ramType;
		this.ramSize = ramSize;
	}
	
	@Override
	public Float getPrice() {
		return ram.getPrice() + this.price;
	}
	
	@Override
	public String getBrandName() {
		if( brandName.equalsIgnoreCase(ram.getBrandName()) )
			return brandName;
		else
			return "Two different brands: "+brandName+", "+ram.getBrandName();
	}
	
	@Override
	public String getProductName() {
		if( productName.equalsIgnoreCase(ram.getProductName()) )
			return productName;
		else
			return "Two different products: "+productName+", "+ram.getProductName();
	}
	
	@Override
	public String getRamType() {
		if( ramType.equalsIgnoreCase(ram.getRamType()) )
			return ramType;
		else
			return "Two different types: "+ramType+", "+ram.getRamType();
	}
	
	@Override
	public int getRamSize() {
		return (ram.getRamSize()+ ramSize);
	}

	@Override
	public ComponentInterface getBaseItem() {
		return ram.getBaseItem();
	}
}