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

public class compositePatternTest {
	ComputerModificator decorator;
	ComputerComposite computer;
	ComputerComposite chassis;
	ComputerComposite mobo;
	ComponentInterface RAM;
	ComponentInterface monitor;
	ComponentInterface cpu;
	
	
	@Before
	public void setUp(){
		
		computer = new ComputerComposite("brandName", "productName", 1000.0F);
		chassis  = new ComputerComposite("brandName", "productName", 100.0F);
		mobo     = new ComputerComposite("brandName", "productName", 10.0F);
		RAM      = new Ram("brandName", "productName", 1.0F, "DDR2", 1024);
		monitor  = new Monitor("brandName", "productName", 0.1F, "monitorType", 22);
 		cpu      = new Cpu("brandName", "productName", 4.0F, "cpuType", 2400.0F, 4);
		
		chassis.addComposite("mobo", mobo);
		computer.addComposite("chassis", chassis);
		mobo.addComponent("ram", RAM);
		computer.addComponent("monitor", monitor);
		
		decorator = new ComputerModificator(computer);
		
	}
	
	
	@After
	public void tearDown(){
	}
	
	@Test	
	public void testFind(){
		assertNotNull("Ram not found", computer.getCompositeByStringRecursively("mobo"));
		assertNotNull("Ram not found", computer.getComponentByStringRecursively("ram"));
	}
	
	
	
}
