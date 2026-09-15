package drr.regulation.jfsa.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import javax.inject.Inject;


@ImplementedBy(CallCurrencyRule.CallCurrencyRuleDefault.class)
public abstract class CallCurrencyRule implements ReportFunction<TransactionReportInstruction, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.quantity.reports.CallCurrencyRule callCurrencyRule;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCurrencyCodeEnum evaluate(TransactionReportInstruction input) {
		ISOCurrencyCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCurrencyCodeEnum doEvaluate(TransactionReportInstruction input);

	public static class CallCurrencyRuleDefault extends CallCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(TransactionReportInstruction input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			output = MapperS.of(callCurrencyRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
