package ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop;

import java.util.Observer;

import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerBuilder;
import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerComposite;

public class HomeCompBuilder extends ComputerBuilder {
	
	

	public HomeCompBuilder(Observer observer) {
		super(observer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buildMotherboard() {
		
		motherboard = new ComputerComposite("Gigabyte", "X58A-UD9", 35.85F);
		motherboard.addObserver(orderManagerObserver);
		motherboard.addComponent("ram", new Ram("Dell", "PowerEdge", 48.15f, "DDR", 2048));
		motherboard.addComponent("cpu", new Cpu("Intel", "i5", 70.50f, "E6800", 2.6f, 4));

	}

	@Override
	public void buildChassis() {
		chassis = new ComputerComposite("Antec", "900", 34.50F);
		chassis.addObserver(orderManagerObserver);
		chassis.addComposite("motherboard", motherboard);
		
		//power
		//harddrive
		//cdrom
		
	}

	@Override
	public void buildComputer() {
		computer = new ComputerComposite("Dell", "Homeflex", 0.0f);
		computer.addObserver(orderManagerObserver);
		computer.addComposite("chassis", chassis);

		computer.addComponent("monitor", new Monitor("Samsung", "SynchMaster", 84.00f, "lcd", 22));
		//monitor
		//keyboard
		//mouse
		//operatingsystem
		
	}
}