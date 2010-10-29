package ie.ul.csis.cs4135.pcshop.factory.Computer.Laptop;

import java.util.Observer;

import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerBuilder;
import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerComposite;

public class UltraMobileLaptopBuilder extends ComputerBuilder {
	
	

	public UltraMobileLaptopBuilder(Observer observer) {
		super(observer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buildMotherboard() {
		
		motherboard = new ComputerComposite("Toshiba", "R700", 10.0f);
		motherboard.addObserver(orderManagerObserver);
		motherboard.addComponent("ram", new Ram("Kingston", "HyperX", 10.0f, "DDR3", 2048));
		motherboard.addComponent("cpu", new Cpu("Intel", "i7", 10.0f, "E6800", 2.66f, 4));

	}

	@Override
	public void buildChassis() {
		chassis = new ComputerComposite("Toshiba", "R700", 100.0f);
		chassis.addObserver(orderManagerObserver);
		chassis.addComposite("motherboard", motherboard);
		
		//power
		//harddrive
		//cdrom
		
	}

	@Override
	public void buildComputer() {
		computer = new ComputerComposite("Toshiba", "Protege R700", 1.0f);
		computer.addObserver(orderManagerObserver);
		computer.addComposite("chassis", chassis);

		computer.addComponent("monitor", new Monitor("Toshiba", "R700", 1.0f, "lcd", 11));
		//monitor
		//keyboard
		//mouse
		//operatingsystem
		
	}
}
