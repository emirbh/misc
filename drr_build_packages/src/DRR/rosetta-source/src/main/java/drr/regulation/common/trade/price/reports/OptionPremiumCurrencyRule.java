package drr.regulation.common.trade.price.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutForQuantityLeg1Rule;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.standards.iosco.cde.version3.execution.reports.SettlementCurrencyRule;
import drr.standards.iosco.cde.version3.quantity.reports.NotionalCurrencyRule;
import javax.inject.Inject;


@ImplementedBy(OptionPremiumCurrencyRule.OptionPremiumCurrencyRuleDefault.class)
public abstract class OptionPremiumCurrencyRule implements ReportFunction<TransactionReportInstruction, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected NotionalCurrencyRule notionalCurrencyRule;
	@Inject protected drr.standards.iosco.cde.version3.price.reports.OptionPremiumCurrencyRule optionPremiumCurrencyRule;
	@Inject protected PayoutForQuantityLeg1Rule payoutForQuantityLeg1Rule;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
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

	public static class OptionPremiumCurrencyRuleDefault extends OptionPremiumCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(TransactionReportInstruction input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(MapperS.of(optionPremiumCurrencyRule.evaluate(item.get())).getOrDefault(settlementCurrencyRule.evaluate(payoutLeg1Rule.evaluate(item.get()))))).getOrDefault(notionalCurrencyRule.evaluate(payoutForQuantityLeg1Rule.evaluate(input)));
			
			return output;
		}
	}
}
