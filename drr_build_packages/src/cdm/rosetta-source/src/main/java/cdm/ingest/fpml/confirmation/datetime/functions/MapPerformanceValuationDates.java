package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.observable.asset.PerformanceValuationDates;
import cdm.observable.common.DeterminationMethodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.AdjustableDateOrRelativeDateSequence;
import fpml.consolidated.eq.shared.EquityValuation;
import fpml.consolidated.fpmlenum.TimeTypeEnum;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.RelativeDateSequence;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPerformanceValuationDates.MapPerformanceValuationDatesDefault.class)
public abstract class MapPerformanceValuationDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDateOrRelativeDateSequenceToAdjustableOrAdjustedRelativeDate mapAdjustableDateOrRelativeDateSequenceToAdjustableOrAdjustedRelativeDate;
	@Inject protected MapAdjustableRelativeOrPeriodicDates mapAdjustableRelativeOrPeriodicDates;
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;

	/**
	* @param fpmlDeterminationMethod 
	* @param fpmlEquityValuation 
	* @return performanceValuationDates 
	*/
	public PerformanceValuationDates evaluate(DeterminationMethod fpmlDeterminationMethod, EquityValuation fpmlEquityValuation) {
		PerformanceValuationDates.PerformanceValuationDatesBuilder performanceValuationDatesBuilder = doEvaluate(fpmlDeterminationMethod, fpmlEquityValuation);
		
		final PerformanceValuationDates performanceValuationDates;
		if (performanceValuationDatesBuilder == null) {
			performanceValuationDates = null;
		} else {
			performanceValuationDates = performanceValuationDatesBuilder.build();
			objectValidator.validate(PerformanceValuationDates.class, performanceValuationDates);
		}
		
		return performanceValuationDates;
	}

	protected abstract PerformanceValuationDates.PerformanceValuationDatesBuilder doEvaluate(DeterminationMethod fpmlDeterminationMethod, EquityValuation fpmlEquityValuation);

	public static class MapPerformanceValuationDatesDefault extends MapPerformanceValuationDates {
		@Override
		protected PerformanceValuationDates.PerformanceValuationDatesBuilder doEvaluate(DeterminationMethod fpmlDeterminationMethod, EquityValuation fpmlEquityValuation) {
			PerformanceValuationDates.PerformanceValuationDatesBuilder performanceValuationDates = PerformanceValuationDates.builder();
			return assignOutput(performanceValuationDates, fpmlDeterminationMethod, fpmlEquityValuation);
		}
		
		protected PerformanceValuationDates.PerformanceValuationDatesBuilder assignOutput(PerformanceValuationDates.PerformanceValuationDatesBuilder performanceValuationDates, DeterminationMethod fpmlDeterminationMethod, EquityValuation fpmlEquityValuation) {
			performanceValuationDates = toBuilder(PerformanceValuationDates.builder()
				.setDeterminationMethod(MapperS.of(fpmlDeterminationMethod).<String>map("getValue", determinationMethod -> determinationMethod.getValue()).checkedMap("to-enum", DeterminationMethodEnum::fromDisplayName, IllegalArgumentException.class).get())
				.setValuationDates(mapAdjustableRelativeOrPeriodicDates.evaluate(MapperS.of(fpmlEquityValuation).<AdjustableRelativeOrPeriodicDates>map("getValuationDates", equityValuation -> equityValuation.getValuationDates()).get()))
				.setValuationDate(mapAdjustableDateOrRelativeDateSequenceToAdjustableOrAdjustedRelativeDate.evaluate(MapperS.of(fpmlEquityValuation).<AdjustableDateOrRelativeDateSequence>map("getValuationDate", equityValuation -> equityValuation.getValuationDate()).<AdjustableDate>map("getAdjustableDate", adjustableDateOrRelativeDateSequence -> adjustableDateOrRelativeDateSequence.getAdjustableDate()).get(), MapperS.of(fpmlEquityValuation).<AdjustableDateOrRelativeDateSequence>map("getValuationDate", equityValuation -> equityValuation.getValuationDate()).<RelativeDateSequence>map("getRelativeDateSequence", adjustableDateOrRelativeDateSequence -> adjustableDateOrRelativeDateSequence.getRelativeDateSequence()).get(), MapperS.of(fpmlEquityValuation).<AdjustableDateOrRelativeDateSequence>map("getValuationDate", equityValuation -> equityValuation.getValuationDate()).<String>map("getId", adjustableDateOrRelativeDateSequence -> adjustableDateOrRelativeDateSequence.getId()).get()))
				.setValuationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlEquityValuation).<BusinessCenterTime>map("getValuationTime", equityValuation -> equityValuation.getValuationTime()).get()))
				.setValuationTimeType(MapperS.of(fpmlEquityValuation).<TimeTypeEnum>map("getValuationTimeType", equityValuation -> equityValuation.getValuationTimeType()).checkedMap("to-enum", e -> cdm.observable.common.TimeTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.build());
			
			return Optional.ofNullable(performanceValuationDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
