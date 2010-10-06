package ie.ul.csis.cs4135.test.pcshop;

import static org.junit.Assert.*;
import ie.ul.csis.cs4135.pcshop.OrderManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderManagerTest {
	
	OrderManager orderManager;

	@Before
	public void setUp() throws Exception {
		
		orderManager = new OrderManager();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTotalPrice() {

		assertEquals("Zero price (default)", new Float(0), orderManager.getTotalPrice());
		
	}

}
