package ie.ul.csis.cs4135.pcshop.componentDecorator.computerDecorators;

import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.MonitorInterface;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;

public class MonitorDecorator implements MonitorInterface {
	
	private Float price;
	private String brandName;
	private String productName;
	private String monitorType;
	private int monitorSize;
	private MonitorInterface monitor;
	

	public MonitorDecorator(MonitorInterface monitor, String brandName, String productName, Float price, String monitorType, int monitorSize){
		this.price = price;
		this.brandName = brandName;
		this.productName = productName;
		this.monitorType = monitorType;
		this.monitorSize = monitorSize;
		this.monitor = monitor;
	}
	
	@Override
	public Float getPrice() {
		return monitor.getPrice() + price;
	}

	@Override
	public String getBrandName() {
		if( brandName.equalsIgnoreCase(monitor.getBrandName()) )
			return brandName;
		else
			return "Two different brands: "+brandName+", "+monitor.getBrandName();
	}

	@Override
	public String getProductName() {
		if( brandName.equalsIgnoreCase(monitor.getProductName()) )
			return productName;
		else
			return "Two different products: "+productName+", "+monitor.getProductName();
	}

	@Override
	public String getScreenType() {
		if( monitorType.equalsIgnoreCase(monitor.getScreenType()) )
			return monitorType;
		else
			return "Two different monitor types: "+monitorType+", "+monitor.getScreenType();
	}

	@Override
	public int getScreenSize() {
		if( monitorSize == monitor.getScreenSize())
			return monitorSize;
		else
			return -1;
	}

	@Override
	public ComponentInterface getBaseItem() {
		return monitor.getBaseItem();
	}
}