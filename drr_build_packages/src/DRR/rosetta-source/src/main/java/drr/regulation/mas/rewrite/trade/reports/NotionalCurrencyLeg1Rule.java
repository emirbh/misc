package drr.regulation.mas.rewrite.trade.reports;

import cdm.base.math.Measure;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.quantity.functions.CurrencyFromNotional;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutForQuantityLeg1Rule;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import drr.standards.iosco.cde.version3.quantity.functions.Notional;
import javax.inject.Inject;


@ImplementedBy(NotionalCurrencyLeg1Rule.NotionalCurrencyLeg1RuleDefault.class)
public abstract class NotionalCurrencyLeg1Rule implements ReportFunction<TransactionReportInstruction, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CurrencyFromNotional currencyFromNotional;
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;
	@Inject protected Notional notional;
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
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			final MapperS<Measure> thenArg1 = MapperS.of(notional.evaluate(payoutForQuantityLeg1Rule.evaluate(thenArg0.get())));
			output = MapperS.of(currencyFromNotional.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
