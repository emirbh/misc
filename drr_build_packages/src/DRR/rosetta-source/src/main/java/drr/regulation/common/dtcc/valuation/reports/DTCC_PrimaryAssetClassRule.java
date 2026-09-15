package drr.regulation.common.dtcc.valuation.reports;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.ValuationDetails;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.ValuationTradeInformation;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_PrimaryAssetClassRule.DTCC_PrimaryAssetClassRuleDefault.class)
public abstract class DTCC_PrimaryAssetClassRule implements ReportFunction<ValuationReportInstruction, AssetClassEnum> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public AssetClassEnum evaluate(ValuationReportInstruction input) {
		AssetClassEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract AssetClassEnum doEvaluate(ValuationReportInstruction input);

	public static class DTCC_PrimaryAssetClassRuleDefault extends DTCC_PrimaryAssetClassRule {
		@Override
		protected AssetClassEnum doEvaluate(ValuationReportInstruction input) {
			AssetClassEnum output = null;
			return assignOutput(output, input);
		}
		
		protected AssetClassEnum assignOutput(AssetClassEnum output, ValuationReportInstruction input) {
			final MapperS<CommonAssetClass> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> item.<ValuationDetails>map("getValuationDetails", valuationReportInstruction -> valuationReportInstruction.getValuationDetails()).<ValuationTradeInformation>map("getTradeInformation", valuationDetails -> valuationDetails.getTradeInformation()).<CommonAssetClass>map("getAssetClass", valuationTradeInformation -> valuationTradeInformation.getAssetClass()));
			output = thenArg
				.mapSingleToItem(item -> {
					if (areEqual(item, MapperS.of(CommonAssetClass.INTR), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(AssetClassEnum.INTEREST_RATE);
					}
					if (areEqual(item, MapperS.of(CommonAssetClass.CRDT), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(AssetClassEnum.CREDIT);
					}
					if (areEqual(item, MapperS.of(CommonAssetClass.EQUI), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(AssetClassEnum.EQUITY);
					}
					if (areEqual(item, MapperS.of(CommonAssetClass.COMM), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(AssetClassEnum.COMMODITY);
					}
					if (areEqual(item, MapperS.of(CommonAssetClass.CURR), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(AssetClassEnum.FOREIGN_EXCHANGE);
					}
					return MapperS.<AssetClassEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
