package drr.regulation.common.trade.price.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
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
	@Inject protected drr.standards.iosco.cde.version3.price.reports.OptionPremiumAmountRule optionPremiumAmountRule;

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
			if (areEqual(MapperS.of(contractTypeRule.evaluate(input)), MapperS.of(CommonContractType.OPTN), CardinalityOperator.All).andNullSafe(notExists(MapperS.of(optionPremiumAmountRule.evaluate(input)))).getOrDefault(false)) {
				output = BigDecimal.valueOf(0);
			} else {
				output = optionPremiumAmountRule.evaluate(input);
			}
			
			return output;
		}
	}
}
