public class ComputerFactory extends AbstractProductFactory{

	private ComputerAssembler computerAssembler;

	public ComputerFactory(Observer observer) {
		super(observer);
	}

	public ComponentInterface createProduct(ProductsEnum productType) throws Exception {
		switch(productType){
			case COMPUTER_DESKTOP_GAMING:
				return createGamingDesktopComputer();	
			...
			default:
				throw new Exception("Unknown Enum type");
		}
	}
		
	private ComponentInterface createGamingDesktopComputer() {
		computerAssembler = new ComputerAssembler( new GamingLaptopBuilder( super.orderManagerObserver ) );
		return computerAssembler.construct();
	}
}
