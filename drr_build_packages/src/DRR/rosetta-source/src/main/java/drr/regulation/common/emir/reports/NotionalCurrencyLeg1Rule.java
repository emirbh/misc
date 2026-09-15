package drr.regulation.common.emir.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutForQuantityLeg1Rule;
import drr.standards.iosco.cde.version3.quantity.reports.NotionalCurrencyRule;
import javax.inject.Inject;


@ImplementedBy(NotionalCurrencyLeg1Rule.NotionalCurrencyLeg1RuleDefault.class)
public abstract class NotionalCurrencyLeg1Rule implements ReportFunction<TransactionReportInstruction, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected NotionalCurrencyRule notionalCurrencyRule;
	@Inject protected PayoutForQuantityLeg1Rule payoutForQuantityLeg1Rule;

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

	public static class NotionalCurrencyLeg1RuleDefault extends NotionalCurrencyLeg1Rule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(TransactionReportInstruction input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(notionalCurrencyRule.evaluate(payoutForQuantityLeg1Rule.evaluate(item.get())))).get();
			
			return output;
		}
	}
}
