package ie.ul.csis.cs4135.pcshop.factory.Computer;

import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;

public class ComputerAssembler {

    private ComputerBuilder computerBuilder;

    ComputerAssembler(ComputerBuilder builder){
    	
    	computerBuilder = builder;

    }

	public ComponentInterface construct() {
		
		//each composite to be built
		computerBuilder.buildMotherboard();
		computerBuilder.buildChassis();
		computerBuilder.buildComputer();
		
		return computerBuilder.getComputer();
	}

}