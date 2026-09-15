package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.functions.DefaultPercentageToDecimal;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.price.functions.IsDefaultPrice;
import javax.inject.Inject;


@ImplementedBy(PriceNotationRule.PriceNotationRuleDefault.class)
public abstract class PriceNotationRule implements ReportFunction<TransactionReportInstruction, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected DefaultPercentageToDecimal defaultPercentageToDecimal;
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
	@Inject protected IsDefaultPrice isDefaultPrice;
	@Inject protected drr.standards.iosco.cde.version3.price.reports.PriceNotationRule priceNotationRule;

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

	public static class PriceNotationRuleDefault extends PriceNotationRule {
		@Override
		protected PriceNotationEnum doEvaluate(TransactionReportInstruction input) {
			PriceNotationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			output = MapperS.of(defaultPercentageToDecimal.evaluate(priceNotationRule.evaluate(thenArg.get()), isDefaultPrice.evaluate(thenArg.get()))).get();
			
			return output;
		}
	}
}
