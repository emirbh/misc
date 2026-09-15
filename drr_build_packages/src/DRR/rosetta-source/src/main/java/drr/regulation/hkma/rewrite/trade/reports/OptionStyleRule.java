package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import drr.standards.iso.OptionStyleEnum;
import javax.inject.Inject;


@ImplementedBy(OptionStyleRule.OptionStyleRuleDefault.class)
public abstract class OptionStyleRule implements ReportFunction<TransactionReportInstruction, OptionStyleEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected drr.regulation.common.trade.contract.reports.OptionStyleRule optionStyleRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public OptionStyleEnum evaluate(TransactionReportInstruction input) {
		OptionStyleEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract OptionStyleEnum doEvaluate(TransactionReportInstruction input);

	public static class OptionStyleRuleDefault extends OptionStyleRule {
		@Override
		protected OptionStyleEnum doEvaluate(TransactionReportInstruction input) {
			OptionStyleEnum output = null;
			return assignOutput(output, input);
		}
		
		protected OptionStyleEnum assignOutput(OptionStyleEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(optionStyleRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
