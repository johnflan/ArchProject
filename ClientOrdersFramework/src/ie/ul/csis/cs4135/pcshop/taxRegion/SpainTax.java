package ie.ul.csis.cs4135.pcshop.taxRegion;

public class SpainTax extends AbstractTaxState {

	Float taxRate = 0.18f;

	@Override
	public Float calculateTax(Float subTotal) {

		return subTotal * taxRate;
	}

	@Override
	public String getCurrencyCode() {

		return "eur";
	}

}
