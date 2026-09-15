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


@ImplementedBy(NotionalAmountScheduleRule.NotionalAmountScheduleRuleDefault.class)
public abstract class NotionalAmountScheduleRule implements ReportFunction<PayoutLegWithAuxiliary, List<? extends NotionalPeriod>> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.quantity.reports.NotionalAmountScheduleRule notionalAmountScheduleRule;

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

	public static class NotionalAmountScheduleRuleDefault extends NotionalAmountScheduleRule {
		@Override
		protected List<NotionalPeriod.NotionalPeriodBuilder> doEvaluate(PayoutLegWithAuxiliary input) {
			List<NotionalPeriod.NotionalPeriodBuilder> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<NotionalPeriod.NotionalPeriodBuilder> assignOutput(List<NotionalPeriod.NotionalPeriodBuilder> output, PayoutLegWithAuxiliary input) {
			output = toBuilder(notionalAmountScheduleRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
