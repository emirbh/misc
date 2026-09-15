package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.PeriodicDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.CalculationPeriodFrequency;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPeriodicDates.MapPeriodicDatesDefault.class)
public abstract class MapPeriodicDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapCalculationPeriodFrequency mapCalculationPeriodFrequency;

	/**
	* @param fpmlPeriodicDates 
	* @return periodicDates 
	*/
	public PeriodicDates evaluate(fpml.consolidated.shared.PeriodicDates fpmlPeriodicDates) {
		PeriodicDates.PeriodicDatesBuilder periodicDatesBuilder = doEvaluate(fpmlPeriodicDates);
		
		final PeriodicDates periodicDates;
		if (periodicDatesBuilder == null) {
			periodicDates = null;
		} else {
			periodicDates = periodicDatesBuilder.build();
			objectValidator.validate(PeriodicDates.class, periodicDates);
		}
		
		return periodicDates;
	}

	protected abstract PeriodicDates.PeriodicDatesBuilder doEvaluate(fpml.consolidated.shared.PeriodicDates fpmlPeriodicDates);

	public static class MapPeriodicDatesDefault extends MapPeriodicDates {
		@Override
		protected PeriodicDates.PeriodicDatesBuilder doEvaluate(fpml.consolidated.shared.PeriodicDates fpmlPeriodicDates) {
			PeriodicDates.PeriodicDatesBuilder periodicDates = PeriodicDates.builder();
			return assignOutput(periodicDates, fpmlPeriodicDates);
		}
		
		protected PeriodicDates.PeriodicDatesBuilder assignOutput(PeriodicDates.PeriodicDatesBuilder periodicDates, fpml.consolidated.shared.PeriodicDates fpmlPeriodicDates) {
			periodicDates = toBuilder(PeriodicDates.builder()
				.setStartDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlPeriodicDates).<AdjustableOrRelativeDate>map("getCalculationStartDate", _periodicDates -> _periodicDates.getCalculationStartDate()).get()))
				.setEndDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlPeriodicDates).<AdjustableOrRelativeDate>map("getCalculationEndDate", _periodicDates -> _periodicDates.getCalculationEndDate()).get()))
				.setPeriodFrequency(mapCalculationPeriodFrequency.evaluate(MapperS.of(fpmlPeriodicDates).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", _periodicDates -> _periodicDates.getCalculationPeriodFrequency()).get()))
				.setPeriodDatesAdjustments(mapBusinessDayAdjustments.evaluate(MapperS.of(fpmlPeriodicDates).<BusinessDayAdjustments>map("getCalculationPeriodDatesAdjustments", _periodicDates -> _periodicDates.getCalculationPeriodDatesAdjustments()).get()))
				.build());
			
			return Optional.ofNullable(periodicDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
