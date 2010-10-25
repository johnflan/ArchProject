package ie.ul.csis.cs4135.pcshop.taxRegion;

public class GermanyTax extends AbstractTaxState {

	Float taxRate = 0.19f;

	@Override
	public Float calculateTax(Float subTotal) {

		return subTotal * taxRate;
	}

	@Override
	public String getCurrencyCode() {

		return "eur";
	}

}
