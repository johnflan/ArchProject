package ie.ul.csis.cs4135.restServer.pcShopResource;

import ie.ul.csis.cs4135.restServer.BaseResource;

import org.restlet.ext.json.JsonRepresentation;
import org.restlet.ext.xstream.XstreamConverter;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.UniformResource;

public class ProductsResource extends BaseResource {
	
	//TODO: List of products
	
	
    @Override  
    protected void doInit() throws ResourceException {  
        
    	//Create the list of products
    	//store them in a class level variable
    	
    }  
	
	
	@Get("json")
	public TestObject toJson(){
		
		// return a json list of products
		TestObject testObj = new TestObject();

		return testObj;
	}
	
	
	//takes a product name and adds it to the order
	
	@Post("json")
	public Representation post(){
		
		// check if a product exists, if so create a new object
		// as in get OrderManager to create the new Product
		
		return null;
	}

}
