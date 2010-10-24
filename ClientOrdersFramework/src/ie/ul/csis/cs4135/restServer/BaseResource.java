package ie.ul.csis.cs4135.restServer;

import java.util.concurrent.ConcurrentMap;

import org.restlet.resource.ServerResource;
import ie.ul.csis.cs4135.pcshop.OrderManager;

/** 
 * Base resource class that supports common behaviours or attributes shared by 
 * all resources. 
 *  
 */  

public class BaseResource extends ServerResource {
	  


	    protected OrderManager getOrderManager(String ipaddress){
	    	
	    	return ((PCShopApplication) getApplication()).getOrderManager(ipaddress);
	    	
	    }
	    
}
