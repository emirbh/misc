package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import drr.standards.iso.FrequencyPeriodEnum;
import javax.inject.Inject;


@ImplementedBy(QuantityFrequencyPeriodLeg2Rule.QuantityFrequencyPeriodLeg2RuleDefault.class)
public abstract class QuantityFrequencyPeriodLeg2Rule implements ReportFunction<TransactionReportInstruction, FrequencyPeriodEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected drr.regulation.common.trade.quantity.reports.QuantityFrequencyPeriodLeg2Rule quantityFrequencyPeriodLeg2Rule;

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
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			output = MapperS.of(quantityFrequencyPeriodLeg2Rule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
