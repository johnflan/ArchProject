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
		  setChanged();
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
		setChanged();
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
		setChanged();
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
		setChanged();
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
	
	public Float getCompositePrice(){
		return price;
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

	public ComponentInterface getComponentByString(String childType){
		return components.get(childType);	
	}
	
	public ComponentInterface getCompositeByString(String childType){
		return composites.get(childType);	
	}
	
	public  Map<String,ComponentInterface> getComponentMap(){
		return components;	
	}
	
	public Map<String,ComponentComposite> getCompositeMap(){
		return composites;	
	}
	
	public List<ComponentComposite> getCompositeChildren() {
		
		List<ComponentComposite> list = new ArrayList<ComponentComposite>();
		list.addAll(composites.values());
		return list;
	}

	public List<ComponentInterface> getComponentChildren() {
	
		List<ComponentInterface> list = new ArrayList<ComponentInterface>();
		list.addAll(components.values());
		return list;
	}
	
	public ComponentInterface getCompositeByStringRecursively(String compositeType){
		
		ComponentComposite parent = this;
		ComponentInterface child = null;
		List<ComponentComposite> compositesChildren;
		//check current level in tree for childType, if null go down a level
		child = parent.getCompositeByString(compositeType);
		//if child was found assign and return parent
		if(child != null)
			return child;
		//recursively go through all composite of this level
		else{
			//get list of composite children
			compositesChildren = parent.getCompositeChildren();
			Iterator<ComponentComposite> childerenItr = compositesChildren.iterator();
			//for every composite in a list search for the componentType until u find it
			while(childerenItr.hasNext() ){
				child = childerenItr.next().getCompositeByStringRecursively(compositeType);
			}
		}
		return child;
	}
	
public ComponentInterface getComponentByStringRecursively(String componentType){
		
		ComponentComposite parent = this;
		ComponentInterface child = null;
		List<ComponentComposite> compositesChildren;
		//check current level in tree for childType, if null go down a level
		child = parent.getComponentByString(componentType);
		//if child was found assign and return parent
		if(child != null)
			return child;
		//recursively go through all composite of this level
		else{
			//get list of composite children
			compositesChildren = parent.getCompositeChildren();
			Iterator<ComponentComposite> childerenItr = compositesChildren.iterator();
			//for every composite in a list search for the componentType until u find it
			while(childerenItr.hasNext() ){
				child = childerenItr.next().getComponentByStringRecursively(componentType);
			}
		}
		return child;
	}
}