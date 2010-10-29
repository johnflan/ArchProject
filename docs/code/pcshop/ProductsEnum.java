package ie.ul.csis.cs4135.pcshop;

public enum ProductsEnum {
	COMPUTER_DESKTOP_GAMING("COMPUTER_DESKTOP_GAMING"),
	COMPUTER_DESKTOP_OFFICE("COMPUTER_DESKTOP_OFFICE"),
	COMPUTER_DESKTOP_HOME("COMPUTER_DESKTOP_HOME"),
	COMPUTER_LAPTOP_ULTRAMOBILE("COMPUTER_LAPTOP_ULTRAMOBILE"),
	COMPUTER_LAPTOP_OFFICE("COMPUTER_LAPTOP_OFFICE"),
	COMPUTER_LAPTOP_GAMING("COMPUTER_LAPTOP_GAMING");
	
	
	private final String value;
	
	ProductsEnum(String value) {  
		   this.value = value;  
	}  
		  
	public static ProductsEnum fromValue(String value) { 
		
		  if (value != null)
			  for (ProductsEnum product : values())
				  if (product.value.equals(value))
					  return product;  

		  
		   // you may return a default value  
		   return null;  
		   // or throw an exception  
		   // throw new IllegalArgumentException("Invalid color: " + value);  
	 }  
	
	public String toValue() {  
		   return value;  
	 }  

}
