package ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop;

import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerBuilder;
import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerComposite;

public class GamingCompBuilder extends ComputerBuilder {
	
	

	@Override
	public void buildMotherboard() {
		
		motherboard = new ComputerComposite("Asus", "Npower", 78.99F);

		motherboard.addComponent(new Ram("Kingston", "HyperX", 48.60f, "DDR2", 512));
		//cpu

	}

	@Override
	public void buildChassais() {
		chassais = new ComputerComposite("Cooltek", "Extreme", 64.80F);
		chassais.addComposite(motherboard);
		
		//power
		//harddrive
		//cdrom
		//motherboard
		
	}

	@Override
	public void buildComputer() {
		computer = new ComputerComposite();
		chassais.addComposite(chassais);

		//monitor
		//keyboard
		//mouse
		//chassais
		//operatingsystem
		
	}
}