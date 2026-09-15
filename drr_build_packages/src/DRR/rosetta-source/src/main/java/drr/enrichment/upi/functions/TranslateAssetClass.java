package drr.enrichment.upi.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(TranslateAssetClass.TranslateAssetClassDefault.class)
public abstract class TranslateAssetClass implements RosettaFunction {

	/**
	* @param assetClass 
	* @return assetClassString 
	*/
	public AnnaDsbAssetClassEnum evaluate(AssetClassEnum assetClass) {
		AnnaDsbAssetClassEnum assetClassString = doEvaluate(assetClass);
		
		return assetClassString;
	}

	protected abstract AnnaDsbAssetClassEnum doEvaluate(AssetClassEnum assetClass);

	public static class TranslateAssetClassDefault extends TranslateAssetClass {
		@Override
		protected AnnaDsbAssetClassEnum doEvaluate(AssetClassEnum assetClass) {
			AnnaDsbAssetClassEnum assetClassString = null;
			return assignOutput(assetClassString, assetClass);
		}
		
		protected AnnaDsbAssetClassEnum assignOutput(AnnaDsbAssetClassEnum assetClassString, AssetClassEnum assetClass) {
			if (areEqual(MapperS.of(assetClass), MapperS.of(AssetClassEnum.INTEREST_RATE), CardinalityOperator.All).getOrDefault(false)) {
				assetClassString = AnnaDsbAssetClassEnum.RATES;
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(AssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All).getOrDefault(false)) {
				assetClassString = AnnaDsbAssetClassEnum.FOREIGN_EXCHANGE;
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(AssetClassEnum.CREDIT), CardinalityOperator.All).getOrDefault(false)) {
				assetClassString = AnnaDsbAssetClassEnum.CREDIT;
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(AssetClassEnum.EQUITY), CardinalityOperator.All).getOrDefault(false)) {
				assetClassString = AnnaDsbAssetClassEnum.EQUITY;
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(AssetClassEnum.COMMODITY), CardinalityOperator.All).getOrDefault(false)) {
				assetClassString = AnnaDsbAssetClassEnum.COMMODITIES;
			} else {
				assetClassString = null;
			}
			
			return assetClassString;
		}
	}
}
