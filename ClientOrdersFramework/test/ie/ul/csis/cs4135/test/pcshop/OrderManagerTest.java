package ie.ul.csis.cs4135.test.pcshop;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
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

	@After
	public void tearDown() throws Exception {
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
		assertNotNull("Returning a null product", orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING));
		assertNotNull("Returning a null product", orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING));
		
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
	public void testRemovingProduct() {


	}
	
	
	@Test
	public void testTax() {


	}
	

}
