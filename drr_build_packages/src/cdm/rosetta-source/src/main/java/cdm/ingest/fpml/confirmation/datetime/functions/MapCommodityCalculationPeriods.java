package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.product.common.schedule.CalculationPeriodDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityCalculationPeriods.MapCommodityCalculationPeriodsDefault.class)
public abstract class MapCommodityCalculationPeriods implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityCalculationPeriodFrequency mapCommodityCalculationPeriodFrequency;

	/**
	* @param fpmlCommodityCalculationPeriodsSchedule 
	* @return calculationPeriodDates 
	*/
	public CalculationPeriodDates evaluate(CommodityCalculationPeriodsSchedule fpmlCommodityCalculationPeriodsSchedule) {
		CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDatesBuilder = doEvaluate(fpmlCommodityCalculationPeriodsSchedule);
		
		final CalculationPeriodDates calculationPeriodDates;
		if (calculationPeriodDatesBuilder == null) {
			calculationPeriodDates = null;
		} else {
			calculationPeriodDates = calculationPeriodDatesBuilder.build();
			objectValidator.validate(CalculationPeriodDates.class, calculationPeriodDates);
		}
		
		return calculationPeriodDates;
	}

	protected abstract CalculationPeriodDates.CalculationPeriodDatesBuilder doEvaluate(CommodityCalculationPeriodsSchedule fpmlCommodityCalculationPeriodsSchedule);

	public static class MapCommodityCalculationPeriodsDefault extends MapCommodityCalculationPeriods {
		@Override
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder doEvaluate(CommodityCalculationPeriodsSchedule fpmlCommodityCalculationPeriodsSchedule) {
			CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates = CalculationPeriodDates.builder();
			return assignOutput(calculationPeriodDates, fpmlCommodityCalculationPeriodsSchedule);
		}
		
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder assignOutput(CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates, CommodityCalculationPeriodsSchedule fpmlCommodityCalculationPeriodsSchedule) {
			calculationPeriodDates = toBuilder(CalculationPeriodDates.builder()
				.setCalculationPeriodFrequency(mapCommodityCalculationPeriodFrequency.evaluate(fpmlCommodityCalculationPeriodsSchedule))
				.build());
			
			return Optional.ofNullable(calculationPeriodDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
