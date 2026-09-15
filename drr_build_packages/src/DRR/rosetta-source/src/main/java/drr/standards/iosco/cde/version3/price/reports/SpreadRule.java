package drr.standards.iosco.cde.version3.price.reports;

import cdm.observable.asset.PriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(SpreadRule.SpreadRuleDefault.class)
public abstract class SpreadRule implements ReportFunction<PayoutLegWithAuxiliary, PriceSchedule> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.price.reports.SpreadRule spreadRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceSchedule evaluate(PayoutLegWithAuxiliary input) {
		PriceSchedule.PriceScheduleBuilder outputBuilder = doEvaluate(input);
		
		final PriceSchedule output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(PriceSchedule.class, output);
		}
		
		return output;
	}

	protected abstract PriceSchedule.PriceScheduleBuilder doEvaluate(PayoutLegWithAuxiliary input);

	public static class SpreadRuleDefault extends SpreadRule {
		@Override
		protected PriceSchedule.PriceScheduleBuilder doEvaluate(PayoutLegWithAuxiliary input) {
			PriceSchedule.PriceScheduleBuilder output = PriceSchedule.builder();
			return assignOutput(output, input);
		}
		
		protected PriceSchedule.PriceScheduleBuilder assignOutput(PriceSchedule.PriceScheduleBuilder output, PayoutLegWithAuxiliary input) {
			output = toBuilder(spreadRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
