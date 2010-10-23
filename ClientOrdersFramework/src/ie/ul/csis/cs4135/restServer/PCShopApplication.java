package ie.ul.csis.cs4135.restServer;

import ie.ul.csis.cs4135.pcshop.OrderManager;
import ie.ul.csis.cs4135.restServer.pcShopResource.ProductsResource;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class PCShopApplication extends Application {
	
    /** The list of items is persisted in memory. */  
    private final ConcurrentMap<String, OrderManager> items = new ConcurrentHashMap<String, OrderManager>();  
  
    /** 
     * Creates a root Restlet that will receive all incoming calls. 
     */  
    @Override  
    public Restlet createInboundRoot() {  
    	
        // Create a router Restlet that defines routes.  
        Router router = new Router(getContext());  
  
        // Defines a route for the resource "list of items"  
        router.attach("/products", ProductsResource.class); 
        
        // Defines a route for the resource "item"  
        // router.attach("/items/{itemName}", ItemResource.class);  
  
        return router;  
    }  
  
    /** 
     * Returns the list of registered items. 
     *  
     * @return the list of registered items. 
     */  
    public ConcurrentMap<String, OrderManager> getItems() {  
        return items;  
    }  

}
