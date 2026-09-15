package drr.regulation.common.dtcc.trade.reports;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.contract.reports.AssetClassRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_PrimaryAssetClassRule.DTCC_PrimaryAssetClassRuleDefault.class)
public abstract class DTCC_PrimaryAssetClassRule implements ReportFunction<TransactionReportInstruction, AssetClassEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AssetClassRule assetClassRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public AssetClassEnum evaluate(TransactionReportInstruction input) {
		AssetClassEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract AssetClassEnum doEvaluate(TransactionReportInstruction input);

	public static class DTCC_PrimaryAssetClassRuleDefault extends DTCC_PrimaryAssetClassRule {
		@Override
		protected AssetClassEnum doEvaluate(TransactionReportInstruction input) {
			AssetClassEnum output = null;
			return assignOutput(output, input);
		}
		
		protected AssetClassEnum assignOutput(AssetClassEnum output, TransactionReportInstruction input) {
			final MapperS<CommonAssetClass> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(assetClassRule.evaluate(item.get())));
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
