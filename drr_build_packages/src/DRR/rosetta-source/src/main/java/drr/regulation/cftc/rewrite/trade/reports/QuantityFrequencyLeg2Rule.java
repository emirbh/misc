package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.quantity.reports.QuantityFrequencyPeriodLeg2Rule;
import drr.standards.iso.FrequencyPeriodEnum;
import javax.inject.Inject;


@ImplementedBy(QuantityFrequencyLeg2Rule.QuantityFrequencyLeg2RuleDefault.class)
public abstract class QuantityFrequencyLeg2Rule implements ReportFunction<TransactionReportInstruction, FrequencyPeriodEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected QuantityFrequencyPeriodLeg2Rule quantityFrequencyPeriodLeg2Rule;

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

	public static class QuantityFrequencyLeg2RuleDefault extends QuantityFrequencyLeg2Rule {
		@Override
		protected FrequencyPeriodEnum doEvaluate(TransactionReportInstruction input) {
			FrequencyPeriodEnum output = null;
			return assignOutput(output, input);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(quantityFrequencyPeriodLeg2Rule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
