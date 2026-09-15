package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import drr.standards.iosco.cde.version3.underlier.reports.UnderlyingAssetPriceSourceLeg1Rule;
import drr.standards.iosco.cde.version3.underlier.reports.UnderlyingAssetPriceSourceLeg2Rule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnderlyingAssetPriceSourceRule.UnderlyingAssetPriceSourceRuleDefault.class)
public abstract class UnderlyingAssetPriceSourceRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected UnderlyingAssetPriceSourceLeg1Rule underlyingAssetPriceSourceLeg1Rule;
	@Inject protected UnderlyingAssetPriceSourceLeg2Rule underlyingAssetPriceSourceLeg2Rule;

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

	public static class UnderlyingAssetPriceSourceRuleDefault extends UnderlyingAssetPriceSourceRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(underlyingAssetPriceSourceLeg1Rule.evaluate(item.get()))).getOrDefault(false)) {
						return MapperS.of(underlyingAssetPriceSourceLeg1Rule.evaluate(item.get()));
					}
					return MapperS.of(underlyingAssetPriceSourceLeg2Rule.evaluate(item.get()));
				}).get();
			
			return output;
		}
	}
}
