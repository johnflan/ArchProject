package ie.ul.csis.cs4135.pcshop.taxRegion;

public class FranceTax extends AbstractTaxState {

	Float taxRate = 0.196f;

	@Override
	public Float calculateTax(Float subTotal) {

		return subTotal * taxRate;
	}

	@Override
	public String getCurrencyCode() {

		return "eur";
	}

}
