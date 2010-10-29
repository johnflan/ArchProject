public class OrderResource extends BaseResource {
	
	// the annotation defines is is the GET method
	// for this resource and it consumes JSON
	@Get("json")
	public String toJson(){
		
		try {
			// this saves the users state by ip address
			// in a correctly RESTful implementation this
			// would not be done
			String ipAddress = this.getClientInfo().getAddress();
			OrderManager orderManager = getOrderManager(ipAddress);

			//pass serialize the OrderManager and return the JSON
			return toJsonString(orderManager);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
