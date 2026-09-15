package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
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
				.filterSingleNullSafe(item -> areEqual(MapperS.of(contractTypeRule.evaluate(item.get())), MapperS.of(CommonContractType.OPTN), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(contractTypeRule.evaluate(item.get())), MapperS.of(CommonContractType.SWPT), CardinalityOperator.All)).get());
			output = MapperS.of(optionPremiumPaymentDateRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
