package ie.ul.csis.cs4135.pcshop.factory.Computer;

import java.util.Observer;

import ie.ul.csis.cs4135.pcshop.ProductsEnum;
import ie.ul.csis.cs4135.pcshop.factory.AbstractProductFactory;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.GamingCompBuilder;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.HomeCompBuilder;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.OfficeCompBuilder;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Laptop.GamingLaptopBuilder;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Laptop.OfficeLaptopBuilder;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Laptop.UltraMobileLaptopBuilder;

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
				
			case COMPUTER_DESKTOP_HOME:
				return createHomeDesktopComputer();
				
			case COMPUTER_LAPTOP_OFFICE:
				return createOfficeLaptop();
				
			case COMPUTER_LAPTOP_ULTRAMOBILE:
				return createUltramobileLaptop();
				
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
	
	private ComponentInterface createHomeDesktopComputer() {
		computerAssembler = new ComputerAssembler( new HomeCompBuilder( super.orderManagerObserver ) );
		return computerAssembler.construct();
	}
	
	private ComponentInterface createOfficeLaptop() {
		computerAssembler = new ComputerAssembler( new OfficeLaptopBuilder( super.orderManagerObserver ) );
		return computerAssembler.construct();
	}
	
	private ComponentInterface createUltramobileLaptop() {
		computerAssembler = new ComputerAssembler( new UltraMobileLaptopBuilder( super.orderManagerObserver ) );
		return computerAssembler.construct();
	}

}