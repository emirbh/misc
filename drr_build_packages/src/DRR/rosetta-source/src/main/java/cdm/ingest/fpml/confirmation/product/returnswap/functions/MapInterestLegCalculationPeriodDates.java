package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
import cdm.product.common.schedule.CalculationPeriodDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.InterestLegCalculationPeriodDates;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapInterestLegCalculationPeriodDates.MapInterestLegCalculationPeriodDatesDefault.class)
public abstract class MapInterestLegCalculationPeriodDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;

	/**
	* @param fpmlInterestLegCalculationPeriodDates 
	* @return calculationPeriodDates 
	*/
	public CalculationPeriodDates evaluate(InterestLegCalculationPeriodDates fpmlInterestLegCalculationPeriodDates) {
		CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDatesBuilder = doEvaluate(fpmlInterestLegCalculationPeriodDates);
		
		final CalculationPeriodDates calculationPeriodDates;
		if (calculationPeriodDatesBuilder == null) {
			calculationPeriodDates = null;
		} else {
			calculationPeriodDates = calculationPeriodDatesBuilder.build();
			objectValidator.validate(CalculationPeriodDates.class, calculationPeriodDates);
		}
		
		return calculationPeriodDates;
	}

	protected abstract CalculationPeriodDates.CalculationPeriodDatesBuilder doEvaluate(InterestLegCalculationPeriodDates fpmlInterestLegCalculationPeriodDates);

	public static class MapInterestLegCalculationPeriodDatesDefault extends MapInterestLegCalculationPeriodDates {
		@Override
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder doEvaluate(InterestLegCalculationPeriodDates fpmlInterestLegCalculationPeriodDates) {
			CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates = CalculationPeriodDates.builder();
			return assignOutput(calculationPeriodDates, fpmlInterestLegCalculationPeriodDates);
		}
		
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder assignOutput(CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates, InterestLegCalculationPeriodDates fpmlInterestLegCalculationPeriodDates) {
			calculationPeriodDates = toBuilder(CalculationPeriodDates.builder()
				.setEffectiveDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlInterestLegCalculationPeriodDates).<AdjustableOrRelativeDate>map("getEffectiveDate", interestLegCalculationPeriodDates -> interestLegCalculationPeriodDates.getEffectiveDate()).get()))
				.setTerminationDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlInterestLegCalculationPeriodDates).<AdjustableOrRelativeDate>map("getTerminationDate", interestLegCalculationPeriodDates -> interestLegCalculationPeriodDates.getTerminationDate()).get()))
				.build(), () -> CalculationPeriodDates.builder());
			
			calculationPeriodDates
				.getOrCreateMeta().setExternalKey(MapperS.of(fpmlInterestLegCalculationPeriodDates).<String>map("getId", interestLegCalculationPeriodDates -> interestLegCalculationPeriodDates.getId()).get());
			
			return Optional.ofNullable(calculationPeriodDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
