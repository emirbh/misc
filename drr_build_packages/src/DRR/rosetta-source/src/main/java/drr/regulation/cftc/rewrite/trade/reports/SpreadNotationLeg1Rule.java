package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.functions.DefaultPercentageToDecimal;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.standards.iosco.cde.version2.price.reports.SpreadNotationEnumRule;
import javax.inject.Inject;


@ImplementedBy(SpreadNotationLeg1Rule.SpreadNotationLeg1RuleDefault.class)
public abstract class SpreadNotationLeg1Rule implements ReportFunction<TransactionReportInstruction, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected DefaultPercentageToDecimal defaultPercentageToDecimal;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
	@Inject protected SpreadNotationEnumRule spreadNotationEnumRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceNotationEnum evaluate(TransactionReportInstruction input) {
		PriceNotationEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PriceNotationEnum doEvaluate(TransactionReportInstruction input);

	public static class SpreadNotationLeg1RuleDefault extends SpreadNotationLeg1Rule {
		@Override
		protected PriceNotationEnum doEvaluate(TransactionReportInstruction input) {
			PriceNotationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = MapperS.of(defaultPercentageToDecimal.evaluate(spreadNotationEnumRule.evaluate(payoutLeg1Rule.evaluate(thenArg.get())), false)).get();
			
			return output;
		}
	}
}
