package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(NextFloatingReferenceResetDateLeg2Rule.NextFloatingReferenceResetDateLeg2RuleDefault.class)
public abstract class NextFloatingReferenceResetDateLeg2Rule implements ReportFunction<TransactionReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
	@Inject protected drr.regulation.common.trade.payment.reports.NextFloatingReferenceResetDateLeg2Rule nextFloatingReferenceResetDateLeg2Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstruction input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstruction input);

	public static class NextFloatingReferenceResetDateLeg2RuleDefault extends NextFloatingReferenceResetDateLeg2Rule {
		@Override
		protected Date doEvaluate(TransactionReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			output = MapperS.of(nextFloatingReferenceResetDateLeg2Rule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
