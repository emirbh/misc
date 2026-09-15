package drr.regulation.mas.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.collateral.reports.VariationMarginCollateralPortfolioCodeRule;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import javax.inject.Inject;


@ImplementedBy(VariationMarginCollateralPortfolioCodeDTCCRule.VariationMarginCollateralPortfolioCodeDTCCRuleDefault.class)
public abstract class VariationMarginCollateralPortfolioCodeDTCCRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;
	@Inject protected VariationMarginCollateralPortfolioCodeRule variationMarginCollateralPortfolioCodeRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class VariationMarginCollateralPortfolioCodeDTCCRuleDefault extends VariationMarginCollateralPortfolioCodeDTCCRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			final FieldWithMetaString fieldWithMetaString = thenArg
				.mapSingleToItem(item -> {
					final String string = variationMarginCollateralPortfolioCodeRule.evaluate(item.get());
					return string == null ? MapperS.<FieldWithMetaString>ofNull() : MapperS.of(FieldWithMetaString.builder().setValue(string).build());
				}).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
