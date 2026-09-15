package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.contract.reports.ContractTypeRule;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OptionPremiumAmountRule.OptionPremiumAmountRuleDefault.class)
public abstract class OptionPremiumAmountRule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ContractTypeRule contractTypeRule;
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
	@Inject protected drr.regulation.common.trade.price.reports.OptionPremiumAmountRule optionPremiumAmountRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransactionReportInstruction input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstruction input);

	public static class OptionPremiumAmountRuleDefault extends OptionPremiumAmountRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			final MapperS<TransactionReportInstruction> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> areEqual(MapperS.of(contractTypeRule.evaluate(item.get())), MapperS.of(CommonContractType.OPTN), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(contractTypeRule.evaluate(item.get())), MapperS.of(CommonContractType.SWPT), CardinalityOperator.All)).get());
			output = MapperS.of(optionPremiumAmountRule.evaluate(thenArg1.get())).get();
			
			return output;
		}
	}
}
