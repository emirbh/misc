package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ClearingAccountOriginEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import javax.inject.Inject;


@ImplementedBy(ClearingAccountOriginRule.ClearingAccountOriginRuleDefault.class)
public abstract class ClearingAccountOriginRule implements ReportFunction<TransactionReportInstruction, ClearingAccountOriginEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.execution.reports.ClearingAccountOriginRule clearingAccountOriginRule;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;

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
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = MapperS.of(clearingAccountOriginRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
