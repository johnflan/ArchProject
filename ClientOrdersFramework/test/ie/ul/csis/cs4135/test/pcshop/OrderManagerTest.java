package ie.ul.csis.cs4135.test.pcshop;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import ie.ul.csis.cs4135.pcshop.OrderManager;
import ie.ul.csis.cs4135.pcshop.ProductsEnum;
import ie.ul.csis.cs4135.pcshop.componentDecorator.ComputerModificator;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;
import ie.ul.csis.cs4135.pcshop.taxRegion.TaxRegionEnum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderManagerTest {
	
	OrderManager orderManager;

	@Before
	public void setUp() throws Exception {
		
		orderManager = new OrderManager(TaxRegionEnum.IRELAND);
		
	}


	@Test
	public void testDefaultOrderManager() {

		assertEquals("Zero price (default)", new Float(0), orderManager.getTotalPrice());
		assertEquals("Empty orderlist", 0, orderManager.getOrder().size());
		assertEquals("Empty ComponentInterface list", new ArrayList<ComponentInterface>(), orderManager.getOrder());

	}
	
	@Test
	public void testAddProduct() throws Exception {
		
		//add a product to the order
		assertNotNull("Returning a null product", orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING));
		assertNotNull("Returning a null product", orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_HOME));
		assertNotNull("Returning a null product", orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_OFFICE));
		assertNotNull("Returning a null product", orderManager.addProduct(ProductsEnum.COMPUTER_LAPTOP_GAMING));
		assertNotNull("Returning a null product", orderManager.addProduct(ProductsEnum.COMPUTER_LAPTOP_OFFICE));
		assertNotNull("Returning a null product", orderManager.addProduct(ProductsEnum.COMPUTER_LAPTOP_ULTRAMOBILE));
		
		//make sure price is greater than 0
		assertFalse("Price should be greater than 0.0 - but is " + orderManager.getTotalPrice() , orderManager.getTotalPrice().equals(new Float(0f)));
		
		//remove the product and ensure the list is empty
		List<ComponentInterface> order = orderManager.getOrder();
		
//		Iterator<ComponentInterface> productItr = order.iterator();
//		while(productItr.hasNext())
//			orderManager.removeProduct(productItr.next());

		
		for (ComponentInterface product : order)
			orderManager.removeProduct(product);
		
		assertTrue("Should return an empty list", orderManager.getOrder().size() == 0);

		//the price should now be 0.0
		assertTrue("Price should be 0.0 - " + orderManager.getTotalPrice(), orderManager.getTotalPrice().equals(new Float(0.0)));
	}
	
	@Test 
	public void addLaptopProducts() throws Exception{
		//ULTRAMOBILE_LAPTOP test
		assertEquals("Price should be zero and is:", new Float(0.0F), orderManager.getTotalPrice());
		ComponentInterface laptop = orderManager.addProduct(ProductsEnum.COMPUTER_LAPTOP_ULTRAMOBILE);
		assertEquals("Price should be and is:", orderManager.getProductPrice(ProductsEnum.COMPUTER_LAPTOP_ULTRAMOBILE), orderManager.getSubTotalPrice());
		orderManager.removeProduct(laptop);
		
		//OFFICE_LAPTOP test
		assertEquals("Price should be zero and is:", new Float(0.0F), orderManager.getTotalPrice());
		laptop = orderManager.addProduct(ProductsEnum.COMPUTER_LAPTOP_OFFICE);
		assertEquals("Price should be and is:", orderManager.getProductPrice(ProductsEnum.COMPUTER_LAPTOP_OFFICE), orderManager.getSubTotalPrice());
		orderManager.removeProduct(laptop);
		
		//GAMING_LAPTOP test
		assertEquals("Price should be zero and is:", new Float(0.0F), orderManager.getTotalPrice());
		laptop = orderManager.addProduct(ProductsEnum.COMPUTER_LAPTOP_GAMING);
		assertEquals("Price should be and is:", orderManager.getProductPrice(ProductsEnum.COMPUTER_LAPTOP_GAMING), orderManager.getSubTotalPrice());
		orderManager.removeProduct(laptop);
	}
	
	@Test
	public void addComputerProducts() throws Exception{
		//Home test
		assertEquals("Price should be zero and is:", new Float(0.0F), orderManager.getTotalPrice());
		ComponentInterface comp = orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_HOME);
		assertEquals("Price should be and is:", orderManager.getProductPrice(ProductsEnum.COMPUTER_DESKTOP_HOME), orderManager.getSubTotalPrice());
		orderManager.removeProduct(comp);
		
		//Office test
		assertEquals("Price should be zero and is:", new Float(0.0F), orderManager.getTotalPrice());
		comp = orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_OFFICE);
		assertEquals("Price should be and is:", orderManager.getProductPrice(ProductsEnum.COMPUTER_DESKTOP_OFFICE), orderManager.getSubTotalPrice());
		orderManager.removeProduct(comp);
		
		//Game test
		assertEquals("Price should be zero and is:", new Float(0.0F), orderManager.getTotalPrice());
		comp = orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING);
		assertEquals("Price should be and is: ", orderManager.getProductPrice(ProductsEnum.COMPUTER_DESKTOP_GAMING), orderManager.getSubTotalPrice());
		orderManager.removeProduct(comp);
	}
	
	@Test
	public void testComputerModificatorFlow() throws Exception{
		
		//add a product to the order, get its price
		// decorte the product and confirm the price has changed
		// then remove the decorated product
		
		assertEquals(new Float(0.0f), orderManager.getTotalPrice());
		
		orderManager.addProduct(ProductsEnum.COMPUTER_LAPTOP_GAMING);
		
		assertEquals(orderManager.getProductPrice(ProductsEnum.COMPUTER_LAPTOP_GAMING), orderManager.getSubTotalPrice());
		
		
		Float subTotalOfGamingLaptop = orderManager.getProductPrice(ProductsEnum.COMPUTER_LAPTOP_GAMING);
		
		List<ComponentInterface> products = orderManager.getOrder();
		ComputerModificator modifyer = orderManager.modifyComputerProduct(products.get(0));		
		modifyer.addHarddisk(2, 100000);
		modifyer.addRam("Kingson", "FXX", 4.00f, "speedy ram", 512);

		//ensure that the modifications were added to the total price
		assertTrue(orderManager.getSubTotalPrice() > subTotalOfGamingLaptop);
		
		
	}
	
	@Test
	public void testCurrencyConversionWebservice(){
		
		//assuming that the the Pound remains stronger... 
		assertTrue(orderManager.getTotalPrice() > orderManager.getPriceInOtherCurrency(TaxRegionEnum.UNITED_KINGDOM));
	
	}
	
	@Test
	public void testAddExternalProduct(){
		
		try {
			OrderManager localOrderManager = new OrderManager(TaxRegionEnum.IRELAND);
		
			localOrderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING);
			localOrderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING);
			List<ComponentInterface> localProduct = localOrderManager.getOrder();
			
			orderManager.addExternalProduct(localProduct.get(0));
			
			Float price = orderManager.getSubTotalPrice();
			
			List<ComponentInterface> realOrder = orderManager.getOrder();
			
			ComputerModificator mod = orderManager.modifyComputerProduct(realOrder.get(0));
			
			mod.addCpu("Intel", "Core2Duo", 25.00f, "MyType", 2.66f, 12);
			
			Float newPrice = orderManager.getSubTotalPrice();
			
			assertTrue(newPrice > price);
			
			orderManager.addExternalProduct(localProduct.get(1));
			
			assertTrue(orderManager.getSubTotalPrice() > newPrice);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
