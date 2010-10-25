package ie.ul.csis.cs4135.pcshop.taxRegion;

public class UsaTax extends AbstractTaxState {

	Float taxRate = 0.1025f;

	@Override
	public Float calculateTax(Float subTotal) {

		return subTotal * taxRate;
	}

	@Override
	public String getCurrencyCode() {

		return "usd";
	}

}
