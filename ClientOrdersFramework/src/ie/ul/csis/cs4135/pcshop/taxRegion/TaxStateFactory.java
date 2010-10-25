package ie.ul.csis.cs4135.pcshop.taxRegion;

public class TaxStateFactory {
	
	public static AbstractTaxState getCalculator(TaxRegionEnum region) throws Exception{
		
		switch(region){
			case IRELAND:
				return new IrelandTax();
				
			case UNITED_KINGDOM:
				return new UkTax();
				
			case FRANCE:
				return new FranceTax();
				
			case GERMANY:
				return new GermanyTax();
				
			case SPAIN:
				return new FranceTax();
				
			case USA:
				return new UsaTax();
				
			default:
				throw new Exception("Unknown TaxStateEnum");
		}

	}

}
