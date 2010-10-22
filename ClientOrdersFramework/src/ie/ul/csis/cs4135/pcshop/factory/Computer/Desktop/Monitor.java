package ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop;

import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.MonitorInterface;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;

public class Monitor implements MonitorInterface {
	
	private Float price;
	private String brandName;
	private String productName;
	
	private String monitorType;
	private int monitorSize;
	
	/**
    * Default constructor
    *
    * @param brandName 
    * @param productName
    * @param price
    * @param monitorType
    * @param monitorSize
    */
	
	public Monitor(String brandName, String productName, Float price, String monitorType, int monitorSize){
		this.brandName = brandName;
		this.productName = productName;
		this.price = price;
		
		this.monitorSize = monitorSize;
		this.monitorType = monitorType;	
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

	@Override
	public String getScreenType() {
		return monitorType;
	}

	@Override
	public int getScreenSize() {
		return monitorSize;
	}

	@Override
	public ComponentInterface getBaseItem() {
		return this;
	}
}