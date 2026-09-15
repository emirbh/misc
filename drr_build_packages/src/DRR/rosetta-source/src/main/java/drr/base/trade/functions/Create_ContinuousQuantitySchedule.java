package drr.base.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.quantity.NotionalPeriod;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(Create_ContinuousQuantitySchedule.Create_ContinuousQuantityScheduleDefault.class)
public abstract class Create_ContinuousQuantitySchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportablePeriod Input schedule may only have start dates specified, or may be discontinous.
	* @param endDate End date of the final period.
	* @return continuousReportablePeriod 
	*/
	public List<? extends NotionalPeriod> evaluate(List<? extends NotionalPeriod> reportablePeriod, Date endDate) {
		List<NotionalPeriod.NotionalPeriodBuilder> continuousReportablePeriodBuilder = doEvaluate(reportablePeriod, endDate);
		
		final List<? extends NotionalPeriod> continuousReportablePeriod;
		if (continuousReportablePeriodBuilder == null) {
			continuousReportablePeriod = null;
		} else {
			continuousReportablePeriod = continuousReportablePeriodBuilder.stream().map(NotionalPeriod::build).collect(Collectors.toList());
			objectValidator.validate(NotionalPeriod.class, continuousReportablePeriod);
		}
		
		return continuousReportablePeriod;
	}

	protected abstract List<NotionalPeriod.NotionalPeriodBuilder> doEvaluate(List<? extends NotionalPeriod> reportablePeriod, Date endDate);

	public static class Create_ContinuousQuantityScheduleDefault extends Create_ContinuousQuantitySchedule {
		@Override
		protected List<NotionalPeriod.NotionalPeriodBuilder> doEvaluate(List<? extends NotionalPeriod> reportablePeriod, Date endDate) {
			if (reportablePeriod == null) {
				reportablePeriod = Collections.emptyList();
			}
			List<NotionalPeriod.NotionalPeriodBuilder> continuousReportablePeriod = new ArrayList<>();
			return assignOutput(continuousReportablePeriod, reportablePeriod, endDate);
		}
		
		protected List<NotionalPeriod.NotionalPeriodBuilder> assignOutput(List<NotionalPeriod.NotionalPeriodBuilder> continuousReportablePeriod, List<? extends NotionalPeriod> reportablePeriod, Date endDate) {
			return Optional.ofNullable(continuousReportablePeriod)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
