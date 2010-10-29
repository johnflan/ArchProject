package ie.ul.csis.cs4135.pcshop.taxRegion;

class UkTax extends AbstractTaxState{

	Float taxRate = 0.17f;

	@Override
	public Float calculateTax(Float subTotal) {

		return subTotal * taxRate;
	}

	@Override
	public String getCurrencyCode() {

		return "gbp";
	}
	
}