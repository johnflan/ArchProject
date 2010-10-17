package ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop;

import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.RamInterface;

public class Ram implements RamInterface {
	
	private Float price;
	private String brandName;
	private String productName;
	
	private String ramType;
	private int ramSize;
	
	
	public Ram(String brandName, String productName, Float price, String ramType, int ramSize){
		this.brandName = brandName;
		this.productName = productName;
		this.price = price;
		this.ramType = ramType;
		this.ramSize = ramSize;
		
	}

	@Override
	public Float getPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBrandName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProductName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRamType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRamSize() {
		// TODO Auto-generated method stub
		return 0;
	}
}