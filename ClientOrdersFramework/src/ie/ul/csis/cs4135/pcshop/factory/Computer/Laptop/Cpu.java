package ie.ul.csis.cs4135.pcshop.factory.Computer.Laptop;

import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.CpuInterface;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;

public class Cpu implements CpuInterface {

	private Float price;
	private String brandName;
	private String productName;
	
	private String cpuType;
	private Float cpuSpeed;
	private int cpuNumCores;
	
	
	/**
    * Default constructor
    *
    * @param brandName 
    * @param productName
    * @param price
    * @param cpuType
    * @param cpuSpeed
    * @param cpuNumCores
    */
	
	public Cpu(String brandName, String productName, Float price, String cpuType, Float cpuSpeed, int cpuNumCores){
		this.brandName = brandName;
		this.productName = productName;
		this.price = price;
		
		this.setCpuType(cpuType);
		this.cpuSpeed = cpuSpeed;
		this.cpuNumCores = cpuNumCores;
		
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
	public int getNumCores() {
		return cpuNumCores;
	}

	@Override
	public Float getCoreSpeed() {
		return cpuSpeed;
	}

	public void setCpuType(String cpuType) {
		this.cpuType = cpuType;
	}

	public String getCpuType() {
		return cpuType;
	}

	@Override
	public ComponentInterface getBaseItem() {
		return this;
	}
}