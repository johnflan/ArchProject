package ie.ul.csis.cs4135.pcshop.factory.Computer;

public abstract class ComputerBuilder {

	protected ComputerComposite motherboard;
	protected ComputerComposite chassis;
	protected ComputerComposite computer;

	
    public abstract void buildMotherboard();
    public abstract void buildChassis();
    public abstract void buildComputer();
    

    public ComputerComposite getComputer() {
    	return computer;
    }

}