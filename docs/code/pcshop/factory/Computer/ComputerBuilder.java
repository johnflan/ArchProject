package ie.ul.csis.cs4135.pcshop.factory.Computer;

import java.util.Observer;

public abstract class ComputerBuilder {

	protected ComputerComposite motherboard;
	protected ComputerComposite chassis;
	protected ComputerComposite computer;
	
	protected Observer orderManagerObserver;

	
    public abstract void buildMotherboard();
    public abstract void buildChassis();
    public abstract void buildComputer();
    
    public ComputerBuilder(Observer observer){
    	orderManagerObserver = observer;
    }
    

    public ComputerComposite getComputer() {
    	return computer;
    }

}