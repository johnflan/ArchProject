package ie.ul.csis.cs4135.pcshop.factory.Computer;

import com.sun.istack.internal.Builder;

import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;

public class ComputerAssembler {

    private ComputerBuilder computerBuilder;

    
    ComputerAssembler(ComputerBuilder builder){
    	
    	computerBuilder = builder;
    }

	public ComponentInterface construct() {
		
		computerBuilder.buildMotherboard();
		computerBuilder.buildChassis();
		computerBuilder.buildComputer();
		
		return computerBuilder.getComputer();
	}

}