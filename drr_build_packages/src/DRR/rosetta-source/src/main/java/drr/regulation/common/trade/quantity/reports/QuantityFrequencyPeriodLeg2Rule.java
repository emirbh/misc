package drr.regulation.common.trade.quantity.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.quantity.functions.QuantityFrequency;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.standards.iso.FrequencyPeriodEnum;
import javax.inject.Inject;


@ImplementedBy(QuantityFrequencyPeriodLeg2Rule.QuantityFrequencyPeriodLeg2RuleDefault.class)
public abstract class QuantityFrequencyPeriodLeg2Rule implements ReportFunction<TransactionReportInstruction, FrequencyPeriodEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected QuantityFrequency quantityFrequency;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public FrequencyPeriodEnum evaluate(TransactionReportInstruction input) {
		FrequencyPeriodEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input);

	public static class QuantityFrequencyPeriodLeg2RuleDefault extends QuantityFrequencyPeriodLeg2Rule {
		@Override
		protected FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input) {
			FrequencyPeriodEnum output = null;
			return assignOutput(output, input);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum output, TransactionReportInstruction input) {
			output = MapperS.of(quantityFrequency.evaluate(payoutLeg2Rule.evaluate(input))).<FrequencyPeriodEnum>map("getPeriod", _quantityFrequency -> _quantityFrequency.getPeriod()).get();
			
			return output;
		}
	}
}
