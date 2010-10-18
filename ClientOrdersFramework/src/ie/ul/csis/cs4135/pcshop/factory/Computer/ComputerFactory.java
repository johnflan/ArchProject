package ie.ul.csis.cs4135.pcshop.factory.Computer;

import java.util.Observer;

import ie.ul.csis.cs4135.pcshop.ProductsEnum;
import ie.ul.csis.cs4135.pcshop.factory.AbstractProductFactory;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.GamingCompBuilder;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.OfficeCompBuilder;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Laptop.GamingLaptopBuilder;

public class ComputerFactory extends AbstractProductFactory{
	
	public ComputerFactory(Observer observer) {
		super(observer);

	}

	private ComputerAssembler computerAssembler;

	@Override
	public ComponentInterface createProduct(ProductsEnum productType) throws Exception {
		
		switch(productType){
			case COMPUTER_DESKTOP_GAMING:
				return createGamingDesktopComputer();
				
			case COMPUTER_DESKTOP_OFFICE:
				return createOfficeDesktopComputer();
				
			case COMPUTER_LAPTOP_GAMING:
				return createGamingLaptopComputer();
				
			default:
				throw new Exception("Unknown Enum type");
		}
		
	}
	
	private ComponentInterface createGamingDesktopComputer() {

		computerAssembler = new ComputerAssembler( new GamingCompBuilder( super.orderManagerObserver ) );
		return computerAssembler.construct();
		
	}
	
	private ComponentInterface createOfficeDesktopComputer() {
		
		computerAssembler = new ComputerAssembler( new OfficeCompBuilder( super.orderManagerObserver ) );
		return computerAssembler.construct();
	}
	
	private ComponentInterface createGamingLaptopComputer() {
		computerAssembler = new ComputerAssembler( new GamingLaptopBuilder( super.orderManagerObserver ) );
		return computerAssembler.construct();
	}


}