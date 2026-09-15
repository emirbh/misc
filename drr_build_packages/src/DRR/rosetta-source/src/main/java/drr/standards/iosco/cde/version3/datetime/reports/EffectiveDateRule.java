package drr.standards.iosco.cde.version3.datetime.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(EffectiveDateRule.EffectiveDateRuleDefault.class)
public abstract class EffectiveDateRule implements ReportFunction<TransactionReportInstructionBase, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.datetime.reports.EffectiveDateRule effectiveDateRule;

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

	public static class EffectiveDateRuleDefault extends EffectiveDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstructionBase input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstructionBase input) {
			output = effectiveDateRule.evaluate(input);
			
			return output;
		}
	}
}
