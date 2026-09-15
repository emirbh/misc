package drr.standards.iosco.cde.version3.price.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.price.DefaultingType;
import drr.base.trade.price.PricePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(GetReportableStrikePricePeriod.GetReportableStrikePricePeriodDefault.class)
public abstract class GetReportableStrikePricePeriod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.price.functions.GetReportableStrikePricePeriod getReportableStrikePricePeriod;

	/**
	* @param reportableEvent 
	* @param defaultingType 
	* @return reportablePeriod 
	*/
	public List<? extends PricePeriod> evaluate(ReportableEventBase reportableEvent, DefaultingType defaultingType) {
		List<PricePeriod.PricePeriodBuilder> reportablePeriodBuilder = doEvaluate(reportableEvent, defaultingType);
		
		final List<? extends PricePeriod> reportablePeriod;
		if (reportablePeriodBuilder == null) {
			reportablePeriod = null;
		} else {
			reportablePeriod = reportablePeriodBuilder.stream().map(PricePeriod::build).collect(Collectors.toList());
			objectValidator.validate(PricePeriod.class, reportablePeriod);
		}
		
		return reportablePeriod;
	}

	protected abstract List<PricePeriod.PricePeriodBuilder> doEvaluate(ReportableEventBase reportableEvent, DefaultingType defaultingType);

	public static class GetReportableStrikePricePeriodDefault extends GetReportableStrikePricePeriod {
		@Override
		protected List<PricePeriod.PricePeriodBuilder> doEvaluate(ReportableEventBase reportableEvent, DefaultingType defaultingType) {
			List<PricePeriod.PricePeriodBuilder> reportablePeriod = new ArrayList<>();
			return assignOutput(reportablePeriod, reportableEvent, defaultingType);
		}
		
		protected List<PricePeriod.PricePeriodBuilder> assignOutput(List<PricePeriod.PricePeriodBuilder> reportablePeriod, ReportableEventBase reportableEvent, DefaultingType defaultingType) {
			reportablePeriod.addAll(toBuilder(getReportableStrikePricePeriod.evaluate(reportableEvent, defaultingType)));
			
			return Optional.ofNullable(reportablePeriod)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
