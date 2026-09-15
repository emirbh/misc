package cdm.ingest.fpml.confirmation.product.fxoption.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.PeriodicDates;
import cdm.ingest.fpml.confirmation.datetime.functions.MapCalculationPeriodFrequency;
import cdm.product.common.schedule.ObservationDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.fx.FxAverageRateObservationSchedule;
import fpml.consolidated.shared.CalculationPeriodFrequency;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapObservationScheduleToObservationDates.MapObservationScheduleToObservationDatesDefault.class)
public abstract class MapObservationScheduleToObservationDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCalculationPeriodFrequency mapCalculationPeriodFrequency;

	/**
	* @param fpmlObservationSchedule 
	* @return observationSchedule 
	*/
	public ObservationDates evaluate(FxAverageRateObservationSchedule fpmlObservationSchedule) {
		ObservationDates.ObservationDatesBuilder observationScheduleBuilder = doEvaluate(fpmlObservationSchedule);
		
		final ObservationDates observationSchedule;
		if (observationScheduleBuilder == null) {
			observationSchedule = null;
		} else {
			observationSchedule = observationScheduleBuilder.build();
			objectValidator.validate(ObservationDates.class, observationSchedule);
		}
		
		return observationSchedule;
	}

	protected abstract ObservationDates.ObservationDatesBuilder doEvaluate(FxAverageRateObservationSchedule fpmlObservationSchedule);

	public static class MapObservationScheduleToObservationDatesDefault extends MapObservationScheduleToObservationDates {
		@Override
		protected ObservationDates.ObservationDatesBuilder doEvaluate(FxAverageRateObservationSchedule fpmlObservationSchedule) {
			ObservationDates.ObservationDatesBuilder observationSchedule = ObservationDates.builder();
			return assignOutput(observationSchedule, fpmlObservationSchedule);
		}
		
		protected ObservationDates.ObservationDatesBuilder assignOutput(ObservationDates.ObservationDatesBuilder observationSchedule, FxAverageRateObservationSchedule fpmlObservationSchedule) {
			observationSchedule = toBuilder(ObservationDates.builder()
				.setPeriodicSchedule(PeriodicDates.builder()
					.setStartDate(AdjustableOrRelativeDate.builder()
						.setAdjustableDate(AdjustableDate.builder()
							.setUnadjustedDate(MapperS.of(fpmlObservationSchedule).<ZonedDateTime>map("getStartDate", fxAverageRateObservationSchedule -> fxAverageRateObservationSchedule.getStartDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
							.build())
						.build())
					.setEndDate(AdjustableOrRelativeDate.builder()
						.setAdjustableDate(AdjustableDate.builder()
							.setUnadjustedDate(MapperS.of(fpmlObservationSchedule).<ZonedDateTime>map("getEndDate", fxAverageRateObservationSchedule -> fxAverageRateObservationSchedule.getEndDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
							.build())
						.build())
					.setPeriodFrequency(mapCalculationPeriodFrequency.evaluate(MapperS.of(fpmlObservationSchedule).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", fxAverageRateObservationSchedule -> fxAverageRateObservationSchedule.getCalculationPeriodFrequency()).get()))
					.build())
				.build());
			
			return Optional.ofNullable(observationSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
