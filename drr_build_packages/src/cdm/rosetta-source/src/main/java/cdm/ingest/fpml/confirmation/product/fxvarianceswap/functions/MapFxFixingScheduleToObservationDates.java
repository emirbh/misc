package cdm.ingest.fpml.confirmation.product.fxvarianceswap.functions;

import cdm.base.datetime.BusinessDayAdjustments;
import cdm.base.datetime.PeriodicDates;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenterOrBusinessCenterReference;
import cdm.ingest.fpml.confirmation.datetime.functions.MapUnadjustedDateToAdjustableOrRelativeDate;
import cdm.product.common.schedule.ObservationDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fx.FxFixingScheduleSimple;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxFixingScheduleToObservationDates.MapFxFixingScheduleToObservationDatesDefault.class)
public abstract class MapFxFixingScheduleToObservationDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterOrBusinessCenterReference mapBusinessCenterOrBusinessCenterReference;
	@Inject protected MapUnadjustedDateToAdjustableOrRelativeDate mapUnadjustedDateToAdjustableOrRelativeDate;

	/**
	* @param fpmlFixingSchedule 
	* @return observationDates 
	*/
	public ObservationDates evaluate(FxFixingScheduleSimple fpmlFixingSchedule) {
		ObservationDates.ObservationDatesBuilder observationDatesBuilder = doEvaluate(fpmlFixingSchedule);
		
		final ObservationDates observationDates;
		if (observationDatesBuilder == null) {
			observationDates = null;
		} else {
			observationDates = observationDatesBuilder.build();
			objectValidator.validate(ObservationDates.class, observationDates);
		}
		
		return observationDates;
	}

	protected abstract ObservationDates.ObservationDatesBuilder doEvaluate(FxFixingScheduleSimple fpmlFixingSchedule);

	public static class MapFxFixingScheduleToObservationDatesDefault extends MapFxFixingScheduleToObservationDates {
		@Override
		protected ObservationDates.ObservationDatesBuilder doEvaluate(FxFixingScheduleSimple fpmlFixingSchedule) {
			ObservationDates.ObservationDatesBuilder observationDates = ObservationDates.builder();
			return assignOutput(observationDates, fpmlFixingSchedule);
		}
		
		protected ObservationDates.ObservationDatesBuilder assignOutput(ObservationDates.ObservationDatesBuilder observationDates, FxFixingScheduleSimple fpmlFixingSchedule) {
			final Date ifThenElseResult0;
			if (exists(MapperS.of(fpmlFixingSchedule).<ZonedDateTime>map("getStartDate", fxFixingScheduleSimple -> fxFixingScheduleSimple.getStartDate())).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(fpmlFixingSchedule).<ZonedDateTime>map("getStartDate", fxFixingScheduleSimple -> fxFixingScheduleSimple.getStartDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get();
			} else {
				ifThenElseResult0 = MapperS.of(fpmlFixingSchedule).<ZonedDateTime>map("getStartDate", fxFixingScheduleSimple -> fxFixingScheduleSimple.getStartDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get();
			}
			final Date ifThenElseResult1;
			if (exists(MapperS.of(fpmlFixingSchedule).<ZonedDateTime>map("getEndDate", fxFixingScheduleSimple -> fxFixingScheduleSimple.getEndDate())).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(fpmlFixingSchedule).<ZonedDateTime>map("getEndDate", fxFixingScheduleSimple -> fxFixingScheduleSimple.getEndDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get();
			} else {
				ifThenElseResult1 = MapperS.of(fpmlFixingSchedule).<ZonedDateTime>map("getEndDate", fxFixingScheduleSimple -> fxFixingScheduleSimple.getEndDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get();
			}
			observationDates = toBuilder(ObservationDates.builder()
				.setPeriodicSchedule(PeriodicDates.builder()
					.setStartDate(mapUnadjustedDateToAdjustableOrRelativeDate.evaluate(ifThenElseResult0, null))
					.setEndDate(mapUnadjustedDateToAdjustableOrRelativeDate.evaluate(ifThenElseResult1, null))
					.setPeriodDatesAdjustments(BusinessDayAdjustments.builder()
						.setBusinessDayConvention(null)
						.setBusinessCenters(mapBusinessCenterOrBusinessCenterReference.evaluate(MapperS.of(fpmlFixingSchedule).<BusinessCenters>map("getBusinessCenters", fxFixingScheduleSimple -> fxFixingScheduleSimple.getBusinessCenters()).get(), MapperS.of(fpmlFixingSchedule).<BusinessCentersReference>map("getBusinessCentersReference", fxFixingScheduleSimple -> fxFixingScheduleSimple.getBusinessCentersReference()).get()))
						.build())
					.setDayType(MapperS.of(fpmlFixingSchedule).<DayTypeEnum>map("getDayType", fxFixingScheduleSimple -> fxFixingScheduleSimple.getDayType()).checkedMap("to-enum", e -> cdm.base.datetime.DayTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
					.build())
				.build());
			
			return Optional.ofNullable(observationDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
