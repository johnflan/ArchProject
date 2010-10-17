package ie.ul.csis.cs4135.pcshop.factory;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.List;

public abstract class ComponentComposite extends Observable implements ComponentInterface  {

	private List<ComponentInterface> components = new ArrayList();
	private List<ComponentComposite> composites = new ArrayList();

	public void addComponent(ComponentInterface component) {
		
	  if (component != null){
		  
		  components.add(component);
		  notifyObservers();
	  }
		  
	}
	
	
	/**
    * Removes a child component.
    *
    * @param Takes a ref to a component to be removed.
    * @return returns true on success.
    */
	
	public boolean removeComponent(ComponentInterface component) {
	  
		components.remove(component);
		notifyObservers();
		return false;
	}
	
	
	public void addComposite(ComponentComposite composite) {
		
		composites.add(composite);
		notifyObservers();

	}
	
	
	/**
    * Removes a child composite.
    *
    * @param Takes a ref to a composite to be removed.
    * @return returns true on success.
    */
	
	public boolean removeComposite(ComponentComposite composite) {
	  
		composites.remove(composite);
		notifyObservers();
		return false;
	}
	
	
	/**
    * Returns a list of all components and composites as a List of ComponentInterfaces
    *
    * @return returns true on success.
    */
	
	public List<ComponentInterface> getChildren() {
		
		List<ComponentInterface> mergedList = new ArrayList<ComponentInterface>();
		mergedList.addAll(components);
		mergedList.addAll(composites);
		return mergedList;
	}
	
	public Float getPrice(){
		
		Float price = 0.0f;
		
		for (ComponentInterface component : components)
			price += component.getPrice();
		
		for (ComponentComposite composite : composites)
			price += composite.getPrice();
		
		return price;
		
		
	}

  

}