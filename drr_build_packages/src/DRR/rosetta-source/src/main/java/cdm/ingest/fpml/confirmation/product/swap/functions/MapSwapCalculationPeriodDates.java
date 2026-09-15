package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableDateOrAdjustedRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessDayAdjustments;
import cdm.ingest.fpml.confirmation.datetime.functions.MapCalculationPeriodFrequency;
import cdm.product.common.schedule.CalculationPeriodDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.fpmlenum.StubPeriodTypeEnum;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustedRelativeDateOffset;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.CalculationPeriodFrequency;
import fpml.consolidated.shared.RelativeDateOffset;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSwapCalculationPeriodDates.MapSwapCalculationPeriodDatesDefault.class)
public abstract class MapSwapCalculationPeriodDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDateOrAdjustedRelativeDate mapAdjustableDateOrAdjustedRelativeDate;
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapCalculationPeriodFrequency mapCalculationPeriodFrequency;

	/**
	* @param fpmlCalculationPeriodDates 
	* @return calculationPeriodDates 
	*/
	public CalculationPeriodDates evaluate(fpml.consolidated.ird.CalculationPeriodDates fpmlCalculationPeriodDates) {
		CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDatesBuilder = doEvaluate(fpmlCalculationPeriodDates);
		
		final CalculationPeriodDates calculationPeriodDates;
		if (calculationPeriodDatesBuilder == null) {
			calculationPeriodDates = null;
		} else {
			calculationPeriodDates = calculationPeriodDatesBuilder.build();
			objectValidator.validate(CalculationPeriodDates.class, calculationPeriodDates);
		}
		
		return calculationPeriodDates;
	}

	protected abstract CalculationPeriodDates.CalculationPeriodDatesBuilder doEvaluate(fpml.consolidated.ird.CalculationPeriodDates fpmlCalculationPeriodDates);

	public static class MapSwapCalculationPeriodDatesDefault extends MapSwapCalculationPeriodDates {
		@Override
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder doEvaluate(fpml.consolidated.ird.CalculationPeriodDates fpmlCalculationPeriodDates) {
			CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates = CalculationPeriodDates.builder();
			return assignOutput(calculationPeriodDates, fpmlCalculationPeriodDates);
		}
		
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder assignOutput(CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates, fpml.consolidated.ird.CalculationPeriodDates fpmlCalculationPeriodDates) {
			calculationPeriodDates = toBuilder(CalculationPeriodDates.builder()
				.setEffectiveDate(mapAdjustableDateOrAdjustedRelativeDate.evaluate(MapperS.of(fpmlCalculationPeriodDates).<AdjustableDate>map("getEffectiveDate", _calculationPeriodDates -> _calculationPeriodDates.getEffectiveDate()).get(), MapperS.of(fpmlCalculationPeriodDates).<AdjustedRelativeDateOffset>map("getRelativeEffectiveDate", _calculationPeriodDates -> _calculationPeriodDates.getRelativeEffectiveDate()).get()))
				.setTerminationDate(mapAdjustableOrRelativeDate.evaluate(AdjustableOrRelativeDate.builder()
					.setAdjustableDate(MapperS.of(fpmlCalculationPeriodDates).<AdjustableDate>map("getTerminationDate", _calculationPeriodDates -> _calculationPeriodDates.getTerminationDate()).get())
					.setRelativeDate(MapperS.of(fpmlCalculationPeriodDates).<RelativeDateOffset>map("getRelativeTerminationDate", _calculationPeriodDates -> _calculationPeriodDates.getRelativeTerminationDate()).get())
					.build()))
				.setCalculationPeriodDatesAdjustments(mapBusinessDayAdjustments.evaluate(MapperS.of(fpmlCalculationPeriodDates).<BusinessDayAdjustments>map("getCalculationPeriodDatesAdjustments", _calculationPeriodDates -> _calculationPeriodDates.getCalculationPeriodDatesAdjustments()).get()))
				.setCalculationPeriodFrequency(mapCalculationPeriodFrequency.evaluate(MapperS.of(fpmlCalculationPeriodDates).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", _calculationPeriodDates -> _calculationPeriodDates.getCalculationPeriodFrequency()).get()))
				.setFirstPeriodStartDate(mapAdjustableDateOrAdjustedRelativeDate.evaluate(MapperS.of(fpmlCalculationPeriodDates).<AdjustableDate>map("getFirstPeriodStartDate", _calculationPeriodDates -> _calculationPeriodDates.getFirstPeriodStartDate()).get(), null))
				.setFirstRegularPeriodStartDate(MapperS.of(fpmlCalculationPeriodDates).<ZonedDateTime>map("getFirstRegularPeriodStartDate", _calculationPeriodDates -> _calculationPeriodDates.getFirstRegularPeriodStartDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setLastRegularPeriodEndDate(MapperS.of(fpmlCalculationPeriodDates).<ZonedDateTime>map("getLastRegularPeriodEndDate", _calculationPeriodDates -> _calculationPeriodDates.getLastRegularPeriodEndDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setStubPeriodType(MapperS.of(fpmlCalculationPeriodDates).<StubPeriodTypeEnum>map("getStubPeriodType", _calculationPeriodDates -> _calculationPeriodDates.getStubPeriodType()).checkedMap("to-enum", e -> cdm.product.common.schedule.StubPeriodTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.build(), () -> CalculationPeriodDates.builder());
			
			calculationPeriodDates
				.getOrCreateMeta().setExternalKey(MapperS.of(fpmlCalculationPeriodDates).<String>map("getId", _calculationPeriodDates -> _calculationPeriodDates.getId()).get());
			
			return Optional.ofNullable(calculationPeriodDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
