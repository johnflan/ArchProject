package ie.ul.csis.cs4135.restServer;

import java.util.concurrent.ConcurrentMap;

import org.restlet.data.Form;
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
	    
	    protected void setHeaders(){
	    	
	    	Form responseHeaders = (Form) getResponse().getAttributes().get("org.restlet.http.headers");
		    if (responseHeaders == null) {
		        responseHeaders = new Form();
		        getResponse().getAttributes().put("org.restlet.http.headers", responseHeaders);
		    }
		    responseHeaders.add("Access-Control-Allow-Origin", "*");
		    responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
			responseHeaders.set("Access-Control-Allow-Headers", "Content-Type");
			responseHeaders.set("Access-Control-Max-Age", "86400");
	    	
	    }
	    
}
