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
		
		assertNotNull("Returning a null product", orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING));
		
		System.out.println(orderManager.getTotalPrice());
		
		//assertNotSame("Price should be greater than 0", new Float(0f), orderManager.getTotalPrice());


	}
	
	@Test
	public void testRemovingProduct() {


	}
	
	
	@Test
	public void testTax() {


	}
	

}
