package drr.standards.iosco.cde.version1.price.reports;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.util.datetime.functions.AdjustableOrAdjustedOrRelativeDateResolution;
import drr.standards.iosco.cde.version1.payment.functions.OptionPremiumOnEventDate;
import javax.inject.Inject;


@ImplementedBy(OptionPremiumPaymentDateRule.OptionPremiumPaymentDateRuleDefault.class)
public abstract class OptionPremiumPaymentDateRule implements ReportFunction<TransactionReportInstructionBase, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableOrAdjustedOrRelativeDateResolution adjustableOrAdjustedOrRelativeDateResolution;
	@Inject protected OptionPremiumOnEventDate optionPremiumOnEventDate;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstructionBase input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstructionBase input);

	public static class OptionPremiumPaymentDateRuleDefault extends OptionPremiumPaymentDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstructionBase input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstructionBase input) {
			output = adjustableOrAdjustedOrRelativeDateResolution.evaluate(MapperS.of(optionPremiumOnEventDate.evaluate(input)).<AdjustableOrAdjustedOrRelativeDate>map("getSettlementDate", transfer -> transfer.getSettlementDate()).get());
			
			return output;
		}
	}
}
