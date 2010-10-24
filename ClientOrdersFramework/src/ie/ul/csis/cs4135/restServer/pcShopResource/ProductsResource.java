package ie.ul.csis.cs4135.restServer.pcShopResource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ie.ul.csis.cs4135.pcshop.OrderManager;
import ie.ul.csis.cs4135.pcshop.ProductsEnum;
import ie.ul.csis.cs4135.restServer.BaseResource;
import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

public class ProductsResource extends BaseResource {
	
	//TODO: List of products
	
	
    @Override  
    protected void doInit() throws ResourceException {  
        
    	//Create the list of products
    	//store them in a class level variable
    	
    }  
	
	
	@Get("json")
	public String toJson(){
		
		List<String> products = new ArrayList<String>();

		for (ProductsEnum product : ProductsEnum.values()){
			
			System.out.println(product);
			products.add( product.toString() );
			
		}
			
		System.out.println("size of products array: " + products.size());
		
		String jsonArray = "{ \n\"products\" : [";
		
		if (!products.isEmpty()){
			
			Iterator<String> listItr = products.iterator();
			
			jsonArray += "\"" + listItr.next() + "\"";
			
			while (listItr.hasNext())
				jsonArray += ", \"" + listItr.next() + "\"";

		}
		
		jsonArray += "]\n}";
		
		// return a json list of products

		return jsonArray;
	}
	
	
	//takes a product name and adds it to the order
	
	@Post("json")
	public Representation post(Representation entity){
		
		try {
			  if (entity.getMediaType().equals(MediaType.APPLICATION_JSON, true)) {
				  
				  OrderManager orderManager = getOrderManager(this.getClientInfo().getAddress());
				  
				  System.out.println("Ordermanager price: " + orderManager.getTotalPrice());

				  //apparently can only call entity.getText() once after that only returns null
				  
				  String inputJson = entity.getText();
				  
				  String[] jsonArray = inputJson.split("\"");
				  
				  ProductsEnum product = ProductsEnum.valueOf(jsonArray[3]);
				  
				  //TODO: ordermanager.add product()
				  orderManager.addProduct(product);
				  
				  System.out.println("Ordermanager price: " + orderManager.getTotalPrice());
				  
				  JsonRepresentation json = new JsonRepresentation(entity);
				  
				  				  
				  //json.getJsonObject();
				  
				  getResponse().setStatus(Status.SUCCESS_OK);
				   
			  } else {
				  getResponse().setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
			  }
			  
		} catch (Exception e) {
			
			e.printStackTrace();
			getResponse().setStatus(Status.SERVER_ERROR_INTERNAL);
		}
		
		
		// check if a product exists, if so create a new object
		// as in get OrderManager to create the new Product
		
		return null;

	}

}
