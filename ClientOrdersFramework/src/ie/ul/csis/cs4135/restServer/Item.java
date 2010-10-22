package ie.ul.csis.cs4135.restServer;

public class Item {

	String itemName;
	String itemDescription;
	
	public Item(String itemName, String itemDescription) {
		this.itemName = itemName;
		this.itemDescription = itemDescription;
	}

	public Item(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return itemDescription;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return itemName;
	}

	public void setDescription(String itemDescription) {
		this.itemDescription = itemDescription;
		
	}

}
