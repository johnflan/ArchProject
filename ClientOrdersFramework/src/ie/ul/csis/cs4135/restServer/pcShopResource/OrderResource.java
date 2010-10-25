package ie.ul.csis.cs4135.restServer.pcShopResource;

import java.util.Iterator;
import java.util.List;
import org.restlet.resource.Get;
import ie.ul.csis.cs4135.pcshop.OrderManager;
import ie.ul.csis.cs4135.pcshop.factory.ComponentInterface;
import ie.ul.csis.cs4135.restServer.BaseResource;

public class OrderResource extends BaseResource {
	
	
	@Get("json")
	public String toJson(){
		
		try {
			
			String ipAddress = this.getClientInfo().getAddress();
			OrderManager orderManager = getOrderManager(ipAddress);

			
			return toJsonString(orderManager);
		
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String toJsonString(OrderManager orderManager){
		
		//OrderList, Subtotal, tax, total
		
		String json = "{\n";
		
		json += "\t\"subtotal\" : " + orderManager.getSubTotalPrice() + ",\n";
		
		json += "\t\"taxes\" : " + orderManager.getTaxes() + ",\n";
		
		json += "\t\"total\" : " + orderManager.getTotalPrice() + ",\n";
		
		//Iterate over the order and populate the list
		//json += "\t\"order\" : " +  ",\n";
		
		json += "\t\"order\" : " +productToJson(orderManager);

		
		json += "\n}";
		
		return json;
	}
	
	private String productToJson(OrderManager orderMgr){
		
		setHeaders();
		
		List<ComponentInterface> order = orderMgr.getOrder();
		Iterator<ComponentInterface> orderIterator = order.iterator();
		ComponentInterface product;
		String orderJson;
		String json = "";
		int id = 0;
		
		if(orderIterator.hasNext())
			json += "[";
		
		while (orderIterator.hasNext()){
			
			product = orderIterator.next();
			orderJson = "\n\t\t{";
			orderJson += "\t\"productID\" : \"" + id++ + "\",\n";
			orderJson += "\t\t\t\"brandName\" : \"" + product.getBrandName() + "\",\n";
			orderJson += "\t\t\t\"productName\" : \"" + product.getProductName() + "\",\n";
			orderJson += "\t\t\t\"price\" : " + product.getPrice() + "\n";
			
			
			if(orderIterator.hasNext())
				json += orderJson + "\t\t},\n";
			else
				json += orderJson + "\t\t}\n";
		}
		
		return json + "]";
	}

}
