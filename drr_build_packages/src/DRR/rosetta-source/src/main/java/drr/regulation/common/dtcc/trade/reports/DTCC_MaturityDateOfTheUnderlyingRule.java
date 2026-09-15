package drr.regulation.common.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.datetime.reports.MaturityDateOfTheUnderlierRule;
import javax.inject.Inject;


@ImplementedBy(DTCC_MaturityDateOfTheUnderlyingRule.DTCC_MaturityDateOfTheUnderlyingRuleDefault.class)
public abstract class DTCC_MaturityDateOfTheUnderlyingRule implements ReportFunction<TransactionReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected MaturityDateOfTheUnderlierRule maturityDateOfTheUnderlierRule;

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

	public static class DTCC_MaturityDateOfTheUnderlyingRuleDefault extends DTCC_MaturityDateOfTheUnderlyingRule {
		@Override
		protected Date doEvaluate(TransactionReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstruction input) {
			output = maturityDateOfTheUnderlierRule.evaluate(input);
			
			return output;
		}
	}
}
