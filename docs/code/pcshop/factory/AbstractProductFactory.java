package ie.ul.csis.cs4135.pcshop.factory;

import java.util.Observer;

import ie.ul.csis.cs4135.pcshop.ProductsEnum;

public abstract class AbstractProductFactory {
	
	protected Observer orderManagerObserver;
	
	public abstract ComponentInterface createProduct(ProductsEnum productType) throws Exception;
	
	
	/**
    * Default constructor, a reference to the parent orderManager
    * is necessary to get product changes.
    *
    * @param observer An object that supports the observer interface
    */
	
	public AbstractProductFactory(Observer observer) {
		
		orderManagerObserver = observer;
		
	}
	
}