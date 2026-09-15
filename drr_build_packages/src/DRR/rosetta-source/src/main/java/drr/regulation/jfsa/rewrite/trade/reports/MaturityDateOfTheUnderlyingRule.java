package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.datetime.reports.MaturityDateOfTheUnderlierRule;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import javax.inject.Inject;


@ImplementedBy(MaturityDateOfTheUnderlyingRule.MaturityDateOfTheUnderlyingRuleDefault.class)
public abstract class MaturityDateOfTheUnderlyingRule implements ReportFunction<TransactionReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;
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

	public static class MaturityDateOfTheUnderlyingRuleDefault extends MaturityDateOfTheUnderlyingRule {
		@Override
		protected Date doEvaluate(TransactionReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			output = MapperS.of(maturityDateOfTheUnderlierRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
