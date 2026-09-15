package drr.regulation.sec.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import javax.inject.Inject;


@ImplementedBy(EffectiveDateRule.EffectiveDateRuleDefault.class)
public abstract class EffectiveDateRule implements ReportFunction<TransactionReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.datetime.reports.EffectiveDateRule effectiveDateRule;
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

	public static class EffectiveDateRuleDefault extends EffectiveDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			output = MapperS.of(effectiveDateRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
