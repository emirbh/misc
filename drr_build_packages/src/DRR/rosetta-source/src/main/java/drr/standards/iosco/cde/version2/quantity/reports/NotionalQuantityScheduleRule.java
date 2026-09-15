package drr.standards.iosco.cde.version2.quantity.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.quantity.NotionalPeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(NotionalQuantityScheduleRule.NotionalQuantityScheduleRuleDefault.class)
public abstract class NotionalQuantityScheduleRule implements ReportFunction<PayoutLegWithAuxiliary, List<? extends NotionalPeriod>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.quantity.reports.NotionalQuantityScheduleRule notionalQuantityScheduleRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<? extends NotionalPeriod> evaluate(PayoutLegWithAuxiliary input) {
		List<NotionalPeriod.NotionalPeriodBuilder> outputBuilder = doEvaluate(input);
		
		final List<? extends NotionalPeriod> output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.stream().map(NotionalPeriod::build).collect(Collectors.toList());
			objectValidator.validate(NotionalPeriod.class, output);
		}
		
		return output;
	}

	protected abstract List<NotionalPeriod.NotionalPeriodBuilder> doEvaluate(PayoutLegWithAuxiliary input);

	public static class NotionalQuantityScheduleRuleDefault extends NotionalQuantityScheduleRule {
		@Override
		protected List<NotionalPeriod.NotionalPeriodBuilder> doEvaluate(PayoutLegWithAuxiliary input) {
			List<NotionalPeriod.NotionalPeriodBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<NotionalPeriod.NotionalPeriodBuilder> assignOutput(List<NotionalPeriod.NotionalPeriodBuilder> output, PayoutLegWithAuxiliary input) {
			output = toBuilder(notionalQuantityScheduleRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
