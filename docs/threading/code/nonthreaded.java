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
