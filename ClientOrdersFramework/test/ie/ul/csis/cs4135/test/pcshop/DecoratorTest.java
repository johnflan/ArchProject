package ie.ul.csis.cs4135.test.pcshop;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ie.ul.csis.cs4135.pcshop.OrderManager;
import ie.ul.csis.cs4135.pcshop.ProductsEnum;
import ie.ul.csis.cs4135.pcshop.componentDecorator.ComputerModificator;
import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.RamInterface;
import ie.ul.csis.cs4135.pcshop.factory.ComponentComposite;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;
import ie.ul.csis.cs4135.pcshop.factory.Computer.ComputerComposite;
import ie.ul.csis.cs4135.pcshop.factory.Computer.Desktop.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DecoratorTest{
	
	ComputerModificator decorator;
	ComputerComposite computer;
	ComputerComposite chassis;
	ComputerComposite mobo;
	ComponentInterface RAM;
	ComponentInterface monitor;
	
	
	@Before
	public void setUp(){
		
		computer = new ComputerComposite("brandName", "productName", 1000.0F);
		chassis  = new ComputerComposite("brandName", "productName", 100.0F);
		mobo     = new ComputerComposite("brandName", "productName", 10.0F);
		RAM      = new Ram("brandName", "productName", 1.0F, "DDR2", 1024);
		monitor  = new Monitor("brandName", "productName", 0.1F, "monitorType", 22);
 		
		
		chassis.addComposite("mobo", mobo);
		computer.addComposite("chassis", chassis);
		
		
		decorator = new ComputerModificator(computer);
		
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void preTest(){
		assertEquals("Price before decoration expected", new Float(1110.0F), computer.getPrice());	
	}
	@Test
	public void testRAMDecorator() {
		//add ram to test it
		mobo.addComponent("ram", RAM);
		
		assertEquals("Price before decoration expected", new Float(1111.0F), computer.getPrice());
		//add decorated ram
		decorator.addRam("brandName", "productName", 1.0F, "DDR2", 1024);
		assertEquals("Price before decoration expected", new Float(1112.0F), computer.getPrice());
		decorator.addRam("brandName", "productName", 1.0F, "DDR2", 1024);
		assertEquals("Price before decoration expected", new Float(1113.0F), computer.getPrice());
		decorator.stripComponentItemOfDecorators("ram", computer);
		assertEquals("Price before decoration expected", new Float(1111.0F), computer.getPrice());
	}
	
	@Test
	public void testMonitorDecorator() {
		//add monitor to test it
		computer.addComponent("monitor", monitor);
		
		decorator.addMonitors("brandName", "productName", 0.1F, "monitorType", 23);
		assertEquals("Decorate monitor 1", new Float(1110.2F), computer.getPrice());
		decorator.addMonitors("brandName", "productName", 0.1F, "monitorType", 23);
		assertEquals("Decorate monitor 2", new Float(1110.3F), computer.getPrice());
		decorator.stripComponentItemOfDecorators("monitor", computer);
		assertEquals("Remove decorators", new Float(1110.1F), computer.getPrice());
	}
	
}