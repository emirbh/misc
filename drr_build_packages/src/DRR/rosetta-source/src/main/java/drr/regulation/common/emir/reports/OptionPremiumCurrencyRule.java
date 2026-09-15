package drr.regulation.common.emir.reports;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.contract.reports.ContractTypeRule;
import drr.regulation.common.trade.reports.PayoutForQuantityLeg1Rule;
import drr.standards.iosco.cde.version3.quantity.reports.NotionalCurrencyRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OptionPremiumCurrencyRule.OptionPremiumCurrencyRuleDefault.class)
public abstract class OptionPremiumCurrencyRule implements ReportFunction<TransactionReportInstruction, ISOCurrencyCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ContractTypeRule contractTypeRule;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected NotionalCurrencyRule notionalCurrencyRule;
	@Inject protected drr.standards.iosco.cde.version3.price.reports.OptionPremiumCurrencyRule optionPremiumCurrencyRule;
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

	public static class OptionPremiumCurrencyRuleDefault extends OptionPremiumCurrencyRule {
		@Override
		protected ISOCurrencyCodeEnum doEvaluate(TransactionReportInstruction input) {
			ISOCurrencyCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCurrencyCodeEnum assignOutput(ISOCurrencyCodeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<ISOCurrencyCodeEnum> ifThenElseResult;
			if (exists(MapperS.of(optionPremiumCurrencyRule.evaluate(thenArg.get()))).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(optionPremiumCurrencyRule.evaluate(thenArg.get()));
			} else if (areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWPT)), MapperS.of(contractTypeRule.evaluate(thenArg.get())), CardinalityOperator.Any).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(notionalCurrencyRule.evaluate(payoutForQuantityLeg1Rule.evaluate(thenArg.get())));
			} else {
				ifThenElseResult = MapperS.<ISOCurrencyCodeEnum>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
