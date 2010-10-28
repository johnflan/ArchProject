public class ComputerFactory extends AbstractProductFactory{

	// reference to builder patterns director
	private ComputerAssembler computerAssembler;

	// pass the observer (OrderManager) to super type
	public ComputerFactory(Observer observer) {
		super(observer);
	}

	public ComponentInterface createProduct(ProductsEnum productType) throws Exception {
		switch(productType){
			case COMPUTER_DESKTOP_GAMING:
				return createGamingDesktopComputer();	
			...
			default:
				// if the enum is not recgonised throw exception
				throw new Exception("Unknown Enum type");
		}
	}
		
	private ComponentInterface createGamingDesktopComputer() {
		// setup and create the assembler (director) passing
		// new specific product builders and the observer ref
		computerAssembler = new ComputerAssembler( new GamingLaptopBuilder( super.orderManagerObserver ) );
		
		// return the new product back up the stack
		return computerAssembler.construct();
	}
}
