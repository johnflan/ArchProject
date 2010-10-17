package ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop;

import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerBuilder;
import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerComposite;

public class GamingCompBuilder extends ComputerBuilder {
	
	

	@Override
	public void buildMotherboard() {
		
		motherboard = new ComputerComposite("Asus", "Npower", 78.99F);

		motherboard.addComponent("ram", new Ram("Kingston", "HyperX", 48.60f, "DDR2", 512));
		motherboard.addComponent("cpu", new Cpu("Intel", "Core2Duo", 63.44f, "E6800", 2.6f, 4));

	}

	@Override
	public void buildChassis() {
		chassis = new ComputerComposite("Cooltek", "Extreme", 64.80F);
		chassis.addComposite("motherboard", motherboard);
		
		//power
		//harddrive
		//cdrom
		
	}

	@Override
	public void buildComputer() {
		computer = new ComputerComposite("Dell", "Optiflex", 0.0f);
		computer.addComposite("chassis", chassis);

		computer.addComponent("monitor", new Monitor("Sony", "Visionmaster", 164.00f, "lcd", 22));
		//monitor
		//keyboard
		//mouse
		//operatingsystem
		
	}
}