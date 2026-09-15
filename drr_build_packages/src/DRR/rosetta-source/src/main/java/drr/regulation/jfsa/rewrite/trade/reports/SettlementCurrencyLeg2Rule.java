package drr.regulation.jfsa.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import drr.standards.iosco.cde.version3.execution.reports.SettlementCurrencyRule;
import javax.inject.Inject;


@ImplementedBy(SettlementCurrencyLeg2Rule.SettlementCurrencyLeg2RuleDefault.class)
public abstract class SettlementCurrencyLeg2Rule implements ReportFunction<TransactionReportInstruction, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected SettlementCurrencyRule settlementCurrencyRule;

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

	public static class SettlementCurrencyLeg2RuleDefault extends SettlementCurrencyLeg2Rule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(TransactionReportInstruction input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			output = MapperS.of(settlementCurrencyRule.evaluate(payoutLeg2Rule.evaluate(thenArg.get()))).get();
			
			return output;
		}
	}
}
