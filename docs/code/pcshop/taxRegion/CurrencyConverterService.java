package ie.ul.csis.cs4135.pcshop.taxRegion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

public class CurrencyConverterService {
	
	String fromCurrency;
	String toCurrency;
	Float fromRate;
	Float toRate;
	
	Float orderManagerFloat;
	
	public CurrencyConverterService(String fromCurrency, String toCurrency, Float fromRate, Float orderManagerFloat){
		
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.fromRate = fromRate;
		this.orderManagerFloat = orderManagerFloat;	
		
	}
	
	public Float getForeginRate(){
		
		try {
    		
			URL convert = new URL("http://www.exchangerate-api.com/" + fromCurrency + "/" + toCurrency + "/" + fromRate + "?k=UTfY5-jdWtU-Si6jt");
			BufferedReader in = new BufferedReader(new InputStreamReader(convert.openStream()));
			String answer = in.readLine();
			in.close();
			
			Float newRate = Float.parseFloat(answer);
			
			
			return newRate;

	
		}	catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
    
}
