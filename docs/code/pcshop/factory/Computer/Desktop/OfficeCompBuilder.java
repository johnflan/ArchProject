package ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop;

import java.util.Observer;

import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerBuilder;
import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerComposite;

public class OfficeCompBuilder extends ComputerBuilder {

	public OfficeCompBuilder(Observer observer) {
		super(observer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buildMotherboard() {
		
		motherboard = new ComputerComposite("Asus", "Npower", 78.99F);
		motherboard.addObserver(orderManagerObserver);
		motherboard.addComponent("ram", new Ram("Kingston", "HyperX", 48.01f, "DDR2", 512));
		motherboard.addComponent("cpu", new Cpu("Intel", "i7", 163.44f, "E6800", 3.2f, 4));

	}

	@Override
	public void buildChassis() {
		chassis = new ComputerComposite("Cooltek", "Extreme", 64.56F);
		chassis.addObserver(orderManagerObserver);
		chassis.addComposite("motherboard", motherboard);
		
		//power
		//harddrive
		//cdrom
		
	}

	@Override
	public void buildComputer() {
		computer = new ComputerComposite("Dell", "Optiflex", 0.0f);
		computer.addObserver(orderManagerObserver);
		computer.addComposite("chassis", chassis);

		computer.addComponent("monitor", new Monitor("Sony", "Visionmaster", 164.00f, "lcd", 22));
		//monitor
		//keyboard
		//mouse
		//operatingsystem
		
	}
}