@Test
public void testComputerModificatorFlow() throws Exception{

	// ensure a new orderManager has a totalPrice of 0.0
	assertEquals(new Float(0.0f), orderManager.getTotalPrice());
	
	// test a price stored in the orderManager is correct
	// for a selected product
	orderManager.addProduct(ProductsEnum.COMPUTER_LAPTOP_GAMING);
	assertEquals(orderManager.getProductPrice(ProductsEnum.COMPUTER_LAPTOP_GAMING), orderManager.getSubTotalPrice());
	
	// store the price of an un-decorated product
	Float subTotalOfGamingLaptop = orderManager.getProductPrice(ProductsEnum.COMPUTER_LAPTOP_GAMING);
	
	// create and decorate the product
	List<ComponentInterface> products = orderManager.getOrder();
	ComputerModificator modifyer = orderManager.modifyComputerProduct(products.get(0));		
	modifyer.addHarddisk(2, 100000);
	modifyer.addRam("Kingson", "FXX", 4.00f, "speedy ram", 512);

	// ensure that the modifications were added to the total price
	assertTrue(orderManager.getSubTotalPrice() > subTotalOfGamingLaptop);	
}
