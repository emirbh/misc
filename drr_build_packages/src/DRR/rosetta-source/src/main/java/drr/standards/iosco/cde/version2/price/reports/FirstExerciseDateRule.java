package drr.standards.iosco.cde.version2.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(FirstExerciseDateRule.FirstExerciseDateRuleDefault.class)
public abstract class FirstExerciseDateRule implements ReportFunction<TransactionReportInstructionBase, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.price.reports.FirstExerciseDateRule firstExerciseDateRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstructionBase input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstructionBase input);

	public static class FirstExerciseDateRuleDefault extends FirstExerciseDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstructionBase input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstructionBase input) {
			output = firstExerciseDateRule.evaluate(input);
			
			return output;
		}
	}
}
