package ie.ul.csis.cs4135.pcshop;

public class OrderManager {
	
	private Float totalPrice = 0.0f;
	
	public Float getTotalPrice(){
		return totalPrice;
	}
	
	private void setTotalPrice(Float price){
		this.totalPrice = price;
	}

}
