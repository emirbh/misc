package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.contract.reports.ContractTypeRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OptionPremiumPaymentDateRule.OptionPremiumPaymentDateRuleDefault.class)
public abstract class OptionPremiumPaymentDateRule implements ReportFunction<TransactionReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ContractTypeRule contractTypeRule;
	@Inject protected EffectiveDateRule effectiveDateRule;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected drr.standards.iosco.cde.version3.price.reports.OptionPremiumPaymentDateRule optionPremiumPaymentDateRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstruction input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstruction input);

	public static class OptionPremiumPaymentDateRuleDefault extends OptionPremiumPaymentDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			final MapperS<Date> ifThenElseResult;
			if (exists(MapperS.of(optionPremiumPaymentDateRule.evaluate(thenArg.get()))).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(optionPremiumPaymentDateRule.evaluate(thenArg.get()));
			} else if (areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWPT)), MapperS.of(contractTypeRule.evaluate(thenArg.get())), CardinalityOperator.Any).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(effectiveDateRule.evaluate(thenArg.get()));
			} else {
				ifThenElseResult = MapperS.<Date>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
