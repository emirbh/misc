package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import javax.inject.Inject;


@ImplementedBy(MapTaxonomySourceEnum.MapTaxonomySourceEnumDefault.class)
public abstract class MapTaxonomySourceEnum implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected StringContains stringContains;

	/**
	* @param productTypeScheme 
	* @return source 
	*/
	public TaxonomySourceEnum evaluate(String productTypeScheme) {
		TaxonomySourceEnum source = doEvaluate(productTypeScheme);
		
		return source;
	}

	protected abstract TaxonomySourceEnum doEvaluate(String productTypeScheme);

	public static class MapTaxonomySourceEnumDefault extends MapTaxonomySourceEnum {
		@Override
		protected TaxonomySourceEnum doEvaluate(String productTypeScheme) {
			TaxonomySourceEnum source = null;
			return assignOutput(source, productTypeScheme);
		}
		
		protected TaxonomySourceEnum assignOutput(TaxonomySourceEnum source, String productTypeScheme) {
			final Boolean boolean0 = stringContains.evaluate(productTypeScheme, "www.fpml.org/coding-scheme/product-taxonomy");
			if ((boolean0 == null ? false : boolean0)) {
				source = TaxonomySourceEnum.ISDA;
			} else {
				final Boolean boolean1 = stringContains.evaluate(productTypeScheme, "iso10962");
				if ((boolean1 == null ? false : boolean1)) {
					source = TaxonomySourceEnum.CFI;
				} else {
					final Boolean boolean2 = stringContains.evaluate(productTypeScheme, "emir-contract-type");
					if ((boolean2 == null ? false : boolean2)) {
						source = TaxonomySourceEnum.EMIR;
					} else {
						source = TaxonomySourceEnum.OTHER;
					}
				}
			}
			
			return source;
		}
	}
}
