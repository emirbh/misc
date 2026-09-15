package drr.regulation.sec.rewrite.dtcc.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import javax.inject.Inject;


@ImplementedBy(DTCC_MaturityDateOfTheUnderlyingRule.DTCC_MaturityDateOfTheUnderlyingRuleDefault.class)
public abstract class DTCC_MaturityDateOfTheUnderlyingRule implements ReportFunction<TransactionReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_MaturityDateOfTheUnderlyingRule dTCC_MaturityDateOfTheUnderlyingRule;
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;

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
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			output = MapperS.of(dTCC_MaturityDateOfTheUnderlyingRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
