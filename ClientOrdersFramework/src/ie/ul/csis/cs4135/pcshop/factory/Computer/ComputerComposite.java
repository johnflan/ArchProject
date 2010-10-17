package ie.ul.csis.cs4135.pcshop.factory.Computer;

import ie.ul.csis.cs4135.pcshop.factory.ComponentComposite;

public class ComputerComposite extends ComponentComposite {
	
	private Float price;
	private String brandName;
	private String productName;
	
	
	/**
    * @param brandName The Brand name of the composite (if any).
    * @param productName The Product name of the composite (if any).
    * @param price The Price of the composite (if Any).
    */
	
	public ComputerComposite(String brandName, String productName, Float price){
		this.price = price;
		this.brandName = brandName;
		this.productName = productName;
	}
	
	
	/**
    * @param price The Price of the composite (if Any).
    */
	public ComputerComposite(Float price){
		this.price = price;
	}
	
	public ComputerComposite(){
		
		this.price = 0.0F;
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
}