package drr.regulation.sec.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ClearingAccountOriginEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import javax.inject.Inject;


@ImplementedBy(ClearingAccountOriginRule.ClearingAccountOriginRuleDefault.class)
public abstract class ClearingAccountOriginRule implements ReportFunction<TransactionReportInstruction, ClearingAccountOriginEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.execution.reports.ClearingAccountOriginRule clearingAccountOriginRule;
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ClearingAccountOriginEnum evaluate(TransactionReportInstruction input) {
		ClearingAccountOriginEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ClearingAccountOriginEnum doEvaluate(TransactionReportInstruction input);

	public static class ClearingAccountOriginRuleDefault extends ClearingAccountOriginRule {
		@Override
		protected ClearingAccountOriginEnum doEvaluate(TransactionReportInstruction input) {
			ClearingAccountOriginEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ClearingAccountOriginEnum assignOutput(ClearingAccountOriginEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(clearingAccountOriginRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
