package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.OptionTypeCode;
import javax.inject.Inject;


@ImplementedBy(OptionTypeRule.OptionTypeRuleDefault.class)
public abstract class OptionTypeRule implements ReportFunction<TransactionReportInstruction, OptionTypeCode> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected drr.regulation.common.trade.contract.reports.OptionTypeRule optionTypeRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public OptionTypeCode evaluate(TransactionReportInstruction input) {
		OptionTypeCode output = doEvaluate(input);
		
		return output;
	}

	protected abstract OptionTypeCode doEvaluate(TransactionReportInstruction input);

	public static class OptionTypeRuleDefault extends OptionTypeRule {
		@Override
		protected OptionTypeCode doEvaluate(TransactionReportInstruction input) {
			OptionTypeCode output = null;
			return assignOutput(output, input);
		}
		
		protected OptionTypeCode assignOutput(OptionTypeCode output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(optionTypeRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
