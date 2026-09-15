package drr.standards.iosco.cde.version1.price.reports;

import cdm.base.math.NonNegativeQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iosco.cde.version1.payment.functions.OptionPremiumOnEventDate;
import drr.standards.iso.functions.FormatToShortFraction5DecimalNumber;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(OptionPremiumAmountRule.OptionPremiumAmountRuleDefault.class)
public abstract class OptionPremiumAmountRule implements ReportFunction<TransactionReportInstructionBase, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToShortFraction5DecimalNumber formatToShortFraction5DecimalNumber;
	@Inject protected OptionPremiumOnEventDate optionPremiumOnEventDate;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransactionReportInstructionBase input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstructionBase input);

	public static class OptionPremiumAmountRuleDefault extends OptionPremiumAmountRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstructionBase input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstructionBase input) {
			final MapperS<BigDecimal> thenArg = MapperS.of(optionPremiumOnEventDate.evaluate(input)).<NonNegativeQuantity>map("getQuantity", transfer -> transfer.getQuantity()).<BigDecimal>map("getValue", nonNegativeQuantity -> nonNegativeQuantity.getValue());
			output = MapperS.of(formatToShortFraction5DecimalNumber.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
