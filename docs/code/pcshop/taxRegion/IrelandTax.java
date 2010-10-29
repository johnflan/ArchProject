package ie.ul.csis.cs4135.pcshop.taxRegion;

class IrelandTax extends AbstractTaxState{
	
	Float taxRate = 0.21f;

	@Override
	public Float calculateTax(Float subTotal) {

		return subTotal * taxRate;
	}

	@Override
	public String getCurrencyCode() {

		return "eur";
	}
}