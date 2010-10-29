package ie.ul.csis.cs4135.pcshop.factory.Computer.Laptop;

import java.util.Observer;

import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerBuilder;
import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerComposite;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.Cpu;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.Monitor;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.Ram;

public class GamingLaptopBuilder extends ComputerBuilder {

	public GamingLaptopBuilder(Observer observer) {
		super(observer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buildMotherboard() {
		
		motherboard = new ComputerComposite("HP", "DV6000", 158.99F);
		motherboard.addObserver(orderManagerObserver);
		motherboard.addComponent("ram", new Ram("Corsair", "XMS3", 50.0f, "DDR3", 1024));
		motherboard.addComponent("cpu", new Cpu("Intel", "i3", 73.21f, "E6800", 1.6f, 4));
	}

	@Override
	public void buildChassis() {
		chassis = new ComputerComposite("HP", "Mk 5 gray", 64.80F);
		chassis.addObserver(orderManagerObserver);
		chassis.addComposite("motherboard", motherboard);
		
		//power
		//harddrive
		//cdrom	
	}

	@Override
	public void buildComputer() {
		computer = new ComputerComposite("HP", "Pavilion", 0.0f);
		computer.addObserver(orderManagerObserver);
		computer.addComposite("chassis", chassis);

		computer.addComponent("monitor", new Monitor("HP", "Standard 18", 56.50f, "lcd", 18));
		//monitor
		//keyboard
		//mouse
		//operatingsystem		
	}
}