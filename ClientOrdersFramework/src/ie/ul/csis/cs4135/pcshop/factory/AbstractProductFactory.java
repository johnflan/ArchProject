package ie.ul.csis.cs4135.pcshop.factory;

import ie.ul.csis.cs4135.pcshop.ProductsEnum;

public abstract class AbstractProductFactory {
	
	public abstract ComponentInterface createProduct(ProductsEnum productType) throws Exception;
	
}