package drr.regulation.sec.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import drr.standards.iosco.cde.version2.execution.reports.SettlementCurrencyRule;
import javax.inject.Inject;


@ImplementedBy(SettlementCurrencyLeg2Rule.SettlementCurrencyLeg2RuleDefault.class)
public abstract class SettlementCurrencyLeg2Rule implements ReportFunction<TransactionReportInstruction, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;
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
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(settlementCurrencyRule.evaluate(payoutLeg2Rule.evaluate(item.get())))).get();
			
			return output;
		}
	}
}
