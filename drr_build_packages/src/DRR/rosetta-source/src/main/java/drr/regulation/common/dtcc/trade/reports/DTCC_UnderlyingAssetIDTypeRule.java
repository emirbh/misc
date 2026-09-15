package drr.regulation.common.dtcc.trade.reports;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_UnderlyingAssetIDTypeRule.DTCC_UnderlyingAssetIDTypeRuleDefault.class)
public abstract class DTCC_UnderlyingAssetIDTypeRule implements ReportFunction<AssetIdentifier, String> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(AssetIdentifier input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(AssetIdentifier input);

	public static class DTCC_UnderlyingAssetIDTypeRuleDefault extends DTCC_UnderlyingAssetIDTypeRule {
		@Override
		protected String doEvaluate(AssetIdentifier input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, AssetIdentifier input) {
			if (areEqual(MapperS.of(input).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.All).getOrDefault(false)) {
				output = "ISIN";
			} else if (areEqual(MapperC.<AssetIdTypeEnum>of(MapperS.of(AssetIdTypeEnum.BBGID), MapperS.of(AssetIdTypeEnum.BBGTICKER)), MapperS.of(input).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), CardinalityOperator.Any).getOrDefault(false)) {
				output = "Bloomberg";
			} else if (areEqual(MapperS.of(input).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.CUSIP), CardinalityOperator.All).getOrDefault(false)) {
				output = "CUSIP";
			} else if (areEqual(MapperS.of(input).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.RIC), CardinalityOperator.All).getOrDefault(false)) {
				output = "RIC";
			} else if (areEqual(MapperS.of(input).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.SEDOL), CardinalityOperator.All).getOrDefault(false)) {
				output = "SEDOL";
			} else if (areEqual(MapperS.of(input).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.REDID), CardinalityOperator.All).getOrDefault(false)) {
				output = "REDID";
			} else if (areEqual(MapperS.of(input).<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.VALOREN), CardinalityOperator.All).getOrDefault(false)) {
				output = "Valoren";
			} else {
				output = "SingleOther";
			}
			
			return output;
		}
	}
}
