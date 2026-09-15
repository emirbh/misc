package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.quantity.functions.QuantityFrequency;
import javax.inject.Inject;


@ImplementedBy(QuantityFrequencyMultiplierLeg2Rule.QuantityFrequencyMultiplierLeg2RuleDefault.class)
public abstract class QuantityFrequencyMultiplierLeg2Rule implements ReportFunction<TransactionReportInstruction, Integer> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected QuantityFrequency quantityFrequency;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Integer evaluate(TransactionReportInstruction input) {
		Integer output = doEvaluate(input);
		
		return output;
	}

	protected abstract Integer doEvaluate(TransactionReportInstruction input);

	public static class QuantityFrequencyMultiplierLeg2RuleDefault extends QuantityFrequencyMultiplierLeg2Rule {
		@Override
		protected Integer doEvaluate(TransactionReportInstruction input) {
			Integer output = null;
			return assignOutput(output, input);
		}
		
		protected Integer assignOutput(Integer output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(quantityFrequency.evaluate(payoutLeg2Rule.evaluate(item.get()))).<Integer>map("getPeriodMultiplier", _quantityFrequency -> _quantityFrequency.getPeriodMultiplier())).get();
			
			return output;
		}
	}
}
