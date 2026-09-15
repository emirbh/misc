package drr.regulation.sec.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import drr.standards.iso.ClearedEnum;
import javax.inject.Inject;


@ImplementedBy(ClearedRule.ClearedRuleDefault.class)
public abstract class ClearedRule implements ReportFunction<TransactionReportInstruction, ClearedEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.execution.reports.ClearedRule clearedRule;
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ClearedEnum evaluate(TransactionReportInstruction input) {
		ClearedEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ClearedEnum doEvaluate(TransactionReportInstruction input);

	public static class ClearedRuleDefault extends ClearedRule {
		@Override
		protected ClearedEnum doEvaluate(TransactionReportInstruction input) {
			ClearedEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ClearedEnum assignOutput(ClearedEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(clearedRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
