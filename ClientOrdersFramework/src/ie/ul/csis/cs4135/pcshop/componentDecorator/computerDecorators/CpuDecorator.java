package ie.ul.csis.cs4135.pcshop.componentDecorator.computerDecorators;

import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.CpuInterface;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;

public class CpuDecorator implements CpuInterface {

	@Override
	public Float getPrice() {
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
	public int getNumCores() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Float getCoreSpeed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComponentInterface getBaseItem() {
		// TODO Auto-generated method stub
		return null;
	}
}