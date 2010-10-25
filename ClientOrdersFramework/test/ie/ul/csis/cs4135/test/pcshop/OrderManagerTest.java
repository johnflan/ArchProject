package ie.ul.csis.cs4135.test.pcshop;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import ie.ul.csis.cs4135.pcshop.OrderManager;
import ie.ul.csis.cs4135.pcshop.ProductsEnum;
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
		assertEquals("Price should be and is:", new Float(159.72F), orderManager.getTotalPrice());
		orderManager.removeProduct(laptop);
		
		//OFFICE_LAPTOP test
		assertEquals("Price should be zero and is:", new Float(0.0F), orderManager.getTotalPrice());
		laptop = orderManager.addProduct(ProductsEnum.COMPUTER_LAPTOP_OFFICE);
		assertEquals("Price should be and is:", new Float(367.235F), orderManager.getTotalPrice());
		orderManager.removeProduct(laptop);
		
		//GAMING_LAPTOP test
		assertEquals("Price should be zero and is:", new Float(0.0F), orderManager.getTotalPrice());
		laptop = orderManager.addProduct(ProductsEnum.COMPUTER_LAPTOP_GAMING);
		assertEquals("Price should be and is:", new Float(488.235F), orderManager.getTotalPrice());
		orderManager.removeProduct(laptop);
	}
	
	@Test
	public void addComputerProducts() throws Exception{
		//Home test
		assertEquals("Price should be zero and is:", new Float(0.0F), orderManager.getTotalPrice());
		ComponentInterface comp = orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_HOME);
		assertEquals("Price should be and is:", new Float(273F), orderManager.getTotalPrice());
		orderManager.removeProduct(comp);
		
		//Office test
		assertEquals("Price should be zero and is:", new Float(0.0F), orderManager.getTotalPrice());
		comp = orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_OFFICE);
		assertEquals("Price should be and is:", new Float(553.44F), orderManager.getTotalPrice());
		orderManager.removeProduct(comp);
		
		//Game test
		assertEquals("Price should be zero and is:", new Float(0.0F), orderManager.getTotalPrice());
		comp = orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING);
		assertEquals("Price should be and is: ", new Float(845.79F), orderManager.getTotalPrice());
		orderManager.removeProduct(comp);
	}
	
	@Test
	public void testDecorateProduct(){
		
		
	}
	}
}
