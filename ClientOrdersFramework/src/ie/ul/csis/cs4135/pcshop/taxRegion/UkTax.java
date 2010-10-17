package ie.ul.csis.cs4135.pcshop.taxRegion;

public class UkTax extends AbstractTaxState{

	Float taxRate = 0.1f;

	@Override
	public Float calculateTax(Float subTotal) {

		return subTotal * taxRate;
	}
	
}