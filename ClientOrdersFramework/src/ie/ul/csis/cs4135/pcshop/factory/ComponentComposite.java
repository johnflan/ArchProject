package ie.ul.csis.cs4135.pcshop.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.List;
import java.util.Set;

public abstract class ComponentComposite extends Observable implements ComponentInterface  {

	private Map<String, ComponentInterface> components = new HashMap<String, ComponentInterface>();
	private Map<String, ComponentComposite> composites = new HashMap<String, ComponentComposite>();
	
	protected Float price;
	protected String brandName;
	protected String productName;
	
	
	/**
    * @param brandName The Brand name of the composite (if any).
    * @param productName The Product name of the composite (if any).
    * @param price The Price of the composite (if Any).
    */
	
	public ComponentComposite(String brandName, String productName, Float price){
		this.price = price;
		this.brandName = brandName;
		this.productName = productName;
		
	}
	
	public ComponentComposite(){

		price = 0.0f;
	}

	public void addComponent(String componentName, ComponentInterface component) {
		
		  components.put(componentName, component);
		  notifyObservers();
		  
	}
	
	
	/**
    * Removes a child component.
    *
    * @param Takes a ref to a component to be removed.
    * @return returns true on success.
    */
	
	public boolean removeComponent(String componentName) {
		  
		components.remove(componentName);
		notifyObservers();
		return false;
	}
	
	/**
    * Returns a list of component names 
    *
    * @return a List<String> of components.
    */
	
	public List<String> getComponentNames() {
		  
		List<String> nameList = new ArrayList<String>();
		
		Set<String> names = components.keySet();
		Iterator<String> nameItr = names.iterator();
		
		while(nameItr.hasNext())
			nameList.add(nameItr.next());

		return nameList;
	}
	
	
	public void addComposite(String compositeName, ComponentComposite composite) {
		
		composites.put(compositeName, composite);
		notifyObservers();

	}
	
	
	/**
    * Removes a child composite.
    *
    * @param Takes a ref to a composite to be removed.
    * @return returns true on success.
    */
	
	public boolean removeComposite(String compositeName) {
	  
		composites.remove(compositeName);
		notifyObservers();
		return false;
	}
	
	/**
    * Returns a list of composite names 
    *
    * @return a List<String> of composites.
    */
	
	public List<String> getCompositeNames() {
		  
		List<String> nameList = new ArrayList<String>();
		
		Set<String> names = composites.keySet();
		Iterator<String> nameItr = names.iterator();
		
		while(nameItr.hasNext())
			nameList.add(nameItr.next());

		return nameList;
	}
	
	
	/**
    * Returns a list of all components and composites as a List of ComponentInterfaces
    *
    * @return returns true on success.
    */
	
	public List<ComponentInterface> getChildren() {
		
		List<ComponentInterface> mergedList = new ArrayList<ComponentInterface>();
		mergedList.addAll(components.values());
		mergedList.addAll(composites.values());

		
		return mergedList;
	}
	
	public Float getPrice(){
		
		Float leafPrices = 0.0f;
		
		for (ComponentInterface component : components.values())
			leafPrices += component.getPrice();
		
		for (ComponentComposite composite : composites.values())
			leafPrices += composite.getPrice();
		
		return price + leafPrices;
		
		
	}
	
	public String getBrandName() {
		return brandName;
	}


	public String getProductName() {

		return productName;
	}
	
	
	public String toString(){
		
		return productName + " " + brandName + ", price: " + price; 
	}

  

}