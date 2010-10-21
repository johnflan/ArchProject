package ie.ul.csis.cs4135.pcshop.componentDecorator.computerDecorators;

import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.CpuInterface;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;

public class CpuDecorator implements CpuInterface {

	private Float price;
	private String brandName;
	private String productName;
	private String cpuType;
	private Float cpuSpeed;
	private int cpuNumCores;
	private CpuInterface cpu;
	
	public CpuDecorator(CpuInterface cpu, String brandName, String productName, Float price, String cpuType, Float cpuSpeed, int cpuNumCores){
		this.price = price;
		this.brandName = brandName;
		this.productName = productName;
		this.cpuType = cpuType;
		this.cpuSpeed = cpuSpeed;
		this.cpuNumCores = cpuNumCores;
		this.cpu = cpu;
	}
	@Override
	public Float getPrice() {
		return cpu.getPrice() + price;
	}

	@Override
	public String getBrandName() {
		if( brandName.equalsIgnoreCase(cpu.getBrandName()) )
			return brandName;
		else
			return "Two different brands: "+brandName+", "+cpu.getBrandName();
	}

	@Override
	public String getProductName() {
		if( productName.equalsIgnoreCase(cpu.getProductName()) )
			return productName;
		else
			return "Two different brands: "+productName+", "+cpu.getProductName();
	}

	@Override
	public int getNumCores() {
		if( cpuNumCores == cpu.getNumCores())
			return cpuNumCores;
		else
			return -1;
	}

	@Override
	public Float getCoreSpeed() {
		if( cpuSpeed == cpu.getCoreSpeed() )
			return cpuSpeed;
		else
			return -1F;
	}

	@Override
	public ComponentInterface getBaseItem() {
		return cpu.getBaseItem();
	}
}