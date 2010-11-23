package ie.ul.csis.cs4135.test.pcshop;

import static org.junit.Assert.*;

import ie.ul.csis.cs4135.pcshop.OrderManager;
import ie.ul.csis.cs4135.pcshop.ProductsEnum;
import ie.ul.csis.cs4135.pcshop.taxRegion.TaxRegionEnum;
import org.junit.Before;
import org.junit.Test;

public class ThreadsTest {
	
	OrderManager orderManagerThreaded;
	OrderManager orderManager;

	@Before
	public void setUp() throws Exception {
		orderManager = new OrderManager(TaxRegionEnum.IRELAND);
		orderManagerThreaded = new OrderManager(TaxRegionEnum.IRELAND, true);
	}
	
	public long timedNonThreadSpeedOnce() throws Exception{
		long startTime = System.nanoTime();
		orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING);
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}
	
	public long timedThreadSpeedOnce() throws Exception{
		long startTime = System.nanoTime();	
		orderManagerThreaded.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING);
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}
	
	public long timedThreadSpeed100() throws Exception{
		long startTime = System.nanoTime();
		for(int i=0; i < 100;i++)
			orderManagerThreaded.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING);
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}
	
	public long timedNonthreadSpeed100() throws Exception{
		long startTime = System.nanoTime();
		for(int i=0; i < 100;i++)
			orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING);
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}

	public long timedThreadSpeed1000() throws Exception{
		long startTime = System.nanoTime();
		for(int i=0; i < 1000;i++)
			orderManagerThreaded.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING);
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}
	
	public long timedNonthreadSpeed1000() throws Exception{
		long startTime = System.nanoTime();
		for(int i=0; i < 1000;i++)
			orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING);
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}

	public long timedThreadSpeed10000() throws Exception{
		long startTime = System.nanoTime();
		for(int i=0; i < 10000;i++)
			orderManagerThreaded.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING);
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}
	
	public long timedNonthreadSpeed10000() throws Exception{
		long startTime = System.nanoTime();
		for(int i=0; i < 10000;i++)
			orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING);
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}
	
	public long timedThreadSpeed100000() throws Exception{
		long startTime = System.nanoTime();
		for(int i=0; i < 100000;i++)
			orderManagerThreaded.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING);
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}
	
	public long timedNonthreadSpeed100000() throws Exception{
		long startTime = System.nanoTime();
		for(int i=0; i < 100000;i++)
			orderManager.addProduct(ProductsEnum.COMPUTER_DESKTOP_GAMING);
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}
	
	@Test
	public void allTests() throws Exception{

		
		System.out.println("100,000 nonthread  - " + timedNonthreadSpeed100000());
		System.out.println("100,000 thread     - " + timedThreadSpeed100000());
		System.out.println("100,000 nonthread  - " + timedNonthreadSpeed100000());
		System.out.println("100,000 thread     - " + timedThreadSpeed100000());
	}
}
