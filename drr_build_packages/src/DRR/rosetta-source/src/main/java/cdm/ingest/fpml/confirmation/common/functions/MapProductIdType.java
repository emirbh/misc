package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.staticdata.asset.common.ProductIdTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import javax.inject.Inject;


@ImplementedBy(MapProductIdType.MapProductIdTypeDefault.class)
public abstract class MapProductIdType implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected StringContains stringContains;

	/**
	* @param productIdScheme 
	* @return source 
	*/
	public ProductIdTypeEnum evaluate(String productIdScheme) {
		ProductIdTypeEnum source = doEvaluate(productIdScheme);
		
		return source;
	}

	protected abstract ProductIdTypeEnum doEvaluate(String productIdScheme);

	public static class MapProductIdTypeDefault extends MapProductIdType {
		@Override
		protected ProductIdTypeEnum doEvaluate(String productIdScheme) {
			ProductIdTypeEnum source = null;
			return assignOutput(source, productIdScheme);
		}
		
		protected ProductIdTypeEnum assignOutput(ProductIdTypeEnum source, String productIdScheme) {
			final Boolean boolean0 = stringContains.evaluate(productIdScheme, "CUSIP");
			if ((boolean0 == null ? false : boolean0)) {
				source = ProductIdTypeEnum.CUSIP;
			} else {
				final Boolean boolean1 = stringContains.evaluate(productIdScheme, "ISIN");
				if ((boolean1 == null ? false : boolean1)) {
					source = ProductIdTypeEnum.ISIN;
				} else {
					final Boolean boolean2 = stringContains.evaluate(productIdScheme, "RIC");
					if ((boolean2 == null ? false : boolean2)) {
						source = ProductIdTypeEnum.RIC;
					} else {
						final Boolean boolean3 = stringContains.evaluate(productIdScheme, "Bloomberg");
						if ((boolean3 == null ? false : boolean3)) {
							source = ProductIdTypeEnum.BBGID;
						} else {
							final Boolean boolean4 = stringContains.evaluate(productIdScheme, "commodity-reference-price");
							if ((boolean4 == null ? false : boolean4)) {
								source = ProductIdTypeEnum.ISDACRP;
							} else {
								final Boolean boolean5 = stringContains.evaluate(productIdScheme, "iso4914");
								if ((boolean5 == null ? false : boolean5)) {
									source = ProductIdTypeEnum.UPI;
								} else {
									source = ProductIdTypeEnum.OTHER;
								}
							}
						}
					}
				}
			}
			
			return source;
		}
	}
}
