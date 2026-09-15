package drr.base.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.price.PricePeriod;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(Create_ContinuousPriceSchedule.Create_ContinuousPriceScheduleDefault.class)
public abstract class Create_ContinuousPriceSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportablePeriod Input schedule may only have start dates specified, or may be discontinous.
	* @param endDate End date of the final period.
	* @return continuousReportablePeriod 
	*/
	public List<? extends PricePeriod> evaluate(List<? extends PricePeriod> reportablePeriod, Date endDate) {
		List<PricePeriod.PricePeriodBuilder> continuousReportablePeriodBuilder = doEvaluate(reportablePeriod, endDate);
		
		final List<? extends PricePeriod> continuousReportablePeriod;
		if (continuousReportablePeriodBuilder == null) {
			continuousReportablePeriod = null;
		} else {
			continuousReportablePeriod = continuousReportablePeriodBuilder.stream().map(PricePeriod::build).collect(Collectors.toList());
			objectValidator.validate(PricePeriod.class, continuousReportablePeriod);
		}
		
		return continuousReportablePeriod;
	}

	protected abstract List<PricePeriod.PricePeriodBuilder> doEvaluate(List<? extends PricePeriod> reportablePeriod, Date endDate);

	public static class Create_ContinuousPriceScheduleDefault extends Create_ContinuousPriceSchedule {
		@Override
		protected List<PricePeriod.PricePeriodBuilder> doEvaluate(List<? extends PricePeriod> reportablePeriod, Date endDate) {
			if (reportablePeriod == null) {
				reportablePeriod = Collections.emptyList();
			}
			List<PricePeriod.PricePeriodBuilder> continuousReportablePeriod = new ArrayList<>();
			return assignOutput(continuousReportablePeriod, reportablePeriod, endDate);
		}
		
		protected List<PricePeriod.PricePeriodBuilder> assignOutput(List<PricePeriod.PricePeriodBuilder> continuousReportablePeriod, List<? extends PricePeriod> reportablePeriod, Date endDate) {
			return Optional.ofNullable(continuousReportablePeriod)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
