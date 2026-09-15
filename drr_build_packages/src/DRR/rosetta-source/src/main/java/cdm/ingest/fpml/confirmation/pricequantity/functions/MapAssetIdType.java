package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.ingest.fpml.confirmation.common.functions.StringContains;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import javax.inject.Inject;


@ImplementedBy(MapAssetIdType.MapAssetIdTypeDefault.class)
public abstract class MapAssetIdType implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected StringContains stringContains;

	/**
	* @param instrumentIdScheme 
	* @return identifierType 
	*/
	public AssetIdTypeEnum evaluate(String instrumentIdScheme) {
		AssetIdTypeEnum identifierType = doEvaluate(instrumentIdScheme);
		
		return identifierType;
	}

	protected abstract AssetIdTypeEnum doEvaluate(String instrumentIdScheme);

	public static class MapAssetIdTypeDefault extends MapAssetIdType {
		@Override
		protected AssetIdTypeEnum doEvaluate(String instrumentIdScheme) {
			AssetIdTypeEnum identifierType = null;
			return assignOutput(identifierType, instrumentIdScheme);
		}
		
		protected AssetIdTypeEnum assignOutput(AssetIdTypeEnum identifierType, String instrumentIdScheme) {
			final Boolean boolean0 = stringContains.evaluate(instrumentIdScheme, "CUSIP");
			if ((boolean0 == null ? false : boolean0)) {
				identifierType = AssetIdTypeEnum.CUSIP;
			} else {
				final Boolean boolean1 = stringContains.evaluate(instrumentIdScheme, "ISIN");
				if ((boolean1 == null ? false : boolean1)) {
					identifierType = AssetIdTypeEnum.ISIN;
				} else {
					final Boolean boolean2 = stringContains.evaluate(instrumentIdScheme, "RIC");
					if ((boolean2 == null ? false : boolean2)) {
						identifierType = AssetIdTypeEnum.RIC;
					} else {
						final Boolean boolean3 = stringContains.evaluate(instrumentIdScheme, "Bloomberg");
						if ((boolean3 == null ? false : boolean3)) {
							identifierType = AssetIdTypeEnum.BBGID;
						} else {
							final Boolean boolean4 = stringContains.evaluate(instrumentIdScheme, "commodity-reference-price");
							if ((boolean4 == null ? false : boolean4)) {
								identifierType = AssetIdTypeEnum.ISDACRP;
							} else {
								final Boolean boolean5 = stringContains.evaluate(instrumentIdScheme, "iso4914");
								if ((boolean5 == null ? false : boolean5)) {
									identifierType = AssetIdTypeEnum.UPI;
								} else {
									final Boolean boolean6 = stringContains.evaluate(instrumentIdScheme, "-id-RED-");
									if ((boolean6 == null ? false : boolean6)) {
										identifierType = AssetIdTypeEnum.REDID;
									} else {
										identifierType = AssetIdTypeEnum.OTHER;
									}
								}
							}
						}
					}
				}
			}
			
			return identifierType;
		}
	}
}
