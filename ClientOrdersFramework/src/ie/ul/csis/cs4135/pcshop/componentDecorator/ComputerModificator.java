package ie.ul.csis.cs4135.pcshop.componentDecorator;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ie.ul.csis.cs4135.pcshop.componentDecorator.computerDecorators.MonitorDecorator;
import ie.ul.csis.cs4135.pcshop.componentDecorator.computerDecorators.RamDecorator;
import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.MonitorInterface;
import ie.ul.csis.cs4135.pcshop.computerComponentInterfaces.RamInterface;
import ie.ul.csis.cs4135.pcshop.factory.ComponentComposite;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;

public class ComputerModificator implements DecoratorInterface {
	
	ComponentComposite orderItem;
	
	public ComputerModificator(ComponentInterface orderItem){
		//TODO add type checking before casing
		this.orderItem = (ComponentComposite)orderItem;
	}
	
	public void addMonitors(String brandName, String productName, Float price, String monitorType, int monitorSize) {
		ComponentComposite parent = getParentOfDecoratableComponent("monitor", orderItem);
		MonitorInterface monitor = (MonitorInterface) parent.getComponentByString("monitor");
		ComponentInterface decoratedMonitor = new MonitorDecorator(monitor, brandName, productName, price, monitorType, monitorSize);
		parent.removeComponent("monitor");
		parent.addComponent("monitor", decoratedMonitor);
	}

	public void addHarddisk(int quantity, int size) {
	}
	
	public void addRam(String brandName, String productName, Float price, String ramType, int ramSize) {
		//find parent of component to be decorated
		//TODO force ram to be the same origin (brand name)
		//TODO do type checking of ram before casting to RamInterface
		ComponentComposite parent = getParentOfDecoratableComponent("ram", orderItem);
		RamInterface ram = (RamInterface) parent.getComponentByString("ram");
		ComponentInterface decoratedRam = new RamDecorator(ram, brandName, productName, price, ramType, ramSize);
		parent.removeComponent("ram");
		parent.addComponent("ram", decoratedRam);
		
	}
	
	public ComponentComposite getParentOfDecoratableComponent(String componentType, ComponentComposite parentComposite){
		
		ComponentComposite parent = null;
		ComponentInterface child;
		List<ComponentComposite> compositesChildren;
		//check current level in tree for childType, if null go down a level
		child = parentComposite.getComponentByString(componentType);
		//if child was found assign and return parent
		if(child != null)
			parent = parentComposite;
		//recursively go through all composite of this level
		else{
			//get list of composite children
			compositesChildren = parentComposite.getCompositeChildren();
			Iterator<ComponentComposite> childerenItr = compositesChildren.iterator();
			//for every composite in a list search for the componentType until u find it
			while(parent == null){
				parent = getParentOfDecoratableComponent(componentType, childerenItr.next());
			}
		}
		return parent;
	}
	
	public ComponentComposite getParentOfDecoratableComposite(String componentType, ComponentComposite parentComposite){
		
		ComponentComposite parent = null;
		ComponentInterface child;
		List<ComponentComposite> compositesChildren;
		
		//check current level in tree for childType, if null go down a level
		child = parentComposite.getCompositeByString(componentType);
		//if child was found assign and return parent
		if(child != null)
			parent = parentComposite;
		//recursively go through all composite of this level
		else{
			//get list of composite children
			compositesChildren = parentComposite.getCompositeChildren();
			Iterator<ComponentComposite> childerenItr = compositesChildren.iterator();
			//for every composite in a list search for the componentType until u find it
			while(parent == null){
				parent = getParentOfDecoratableComposite(componentType, childerenItr.next());
			}
		}
		return parent;
	}
	
	public void stripComponentItemOfDecorators(String componentType, ComponentComposite rootOfComponentTree){
		ComponentComposite parent = getParentOfDecoratableComponent(componentType, rootOfComponentTree);
		ComponentInterface child = parent.getComponentByString(componentType);
		ComponentInterface baseChild = child.getBaseItem();
		if( baseChild == child){
			System.out.println("This component is not decorated! Iz not possiBLE");
		}else{
			parent.removeComponent(componentType);
			parent.addComponent(componentType, baseChild);
			System.out.println("Component stripped now!");
		}
	}
	
	public void stripCompositetrlItemOfDecorators(String componentType, ComponentComposite rootOfComponentTree){
		ComponentComposite parent = getParentOfDecoratableComposite(componentType, rootOfComponentTree);
		ComponentInterface child = parent.getCompositeByString(componentType);
		ComponentInterface baseChild = child.getBaseItem();
		if( baseChild == child){
			System.out.println("This composite is not decorated!");
		}else{
			parent.removeComponent(componentType);
			parent.addComponent(componentType, baseChild);
			System.out.println("Composite stripped now!");
		}
	}
}