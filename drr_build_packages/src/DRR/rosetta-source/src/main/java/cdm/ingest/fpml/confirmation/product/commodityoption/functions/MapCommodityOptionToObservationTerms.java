package cdm.ingest.fpml.confirmation.product.commodityoption.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapCommodityCalculationPeriodsScheduleToCalculationPeriodFrequency;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.ObservationTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.CommodityOption;
import fpml.consolidated.com.CommodityPricingDates;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityOptionToObservationTerms.MapCommodityOptionToObservationTermsDefault.class)
public abstract class MapCommodityOptionToObservationTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityCalculationPeriodsScheduleToCalculationPeriodFrequency mapCommodityCalculationPeriodsScheduleToCalculationPeriodFrequency;
	@Inject protected MapCommodityPricingDatesToObservationDates mapCommodityPricingDatesToObservationDates;

	/**
	* @param fpmlCommodityOption 
	* @return observationTerms 
	*/
	public ObservationTerms evaluate(CommodityOption fpmlCommodityOption) {
		ObservationTerms.ObservationTermsBuilder observationTermsBuilder = doEvaluate(fpmlCommodityOption);
		
		final ObservationTerms observationTerms;
		if (observationTermsBuilder == null) {
			observationTerms = null;
		} else {
			observationTerms = observationTermsBuilder.build();
			objectValidator.validate(ObservationTerms.class, observationTerms);
		}
		
		return observationTerms;
	}

	protected abstract ObservationTerms.ObservationTermsBuilder doEvaluate(CommodityOption fpmlCommodityOption);

	protected abstract MapperS<? extends CommodityCalculationPeriodsSchedule> fpmlCalculationPeriodsSchedule(CommodityOption fpmlCommodityOption);

	protected abstract MapperS<? extends CommodityPricingDates> fpmlPricingDates(CommodityOption fpmlCommodityOption);

	public static class MapCommodityOptionToObservationTermsDefault extends MapCommodityOptionToObservationTerms {
		@Override
		protected ObservationTerms.ObservationTermsBuilder doEvaluate(CommodityOption fpmlCommodityOption) {
			ObservationTerms.ObservationTermsBuilder observationTerms = ObservationTerms.builder();
			return assignOutput(observationTerms, fpmlCommodityOption);
		}
		
		protected ObservationTerms.ObservationTermsBuilder assignOutput(ObservationTerms.ObservationTermsBuilder observationTerms, CommodityOption fpmlCommodityOption) {
			observationTerms = toBuilder(ObservationTerms.builder()
				.setCalculationPeriodDates(CalculationPeriodDates.builder()
					.setCalculationPeriodFrequency(mapCommodityCalculationPeriodsScheduleToCalculationPeriodFrequency.evaluate(fpmlCalculationPeriodsSchedule(fpmlCommodityOption).get()))
					.build())
				.setObservationDates(mapCommodityPricingDatesToObservationDates.evaluate(fpmlPricingDates(fpmlCommodityOption).get()))
				.build());
			
			return Optional.ofNullable(observationTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends CommodityCalculationPeriodsSchedule> fpmlCalculationPeriodsSchedule(CommodityOption fpmlCommodityOption) {
			return MapperS.of(fpmlCommodityOption).<CommodityCalculationPeriodsSchedule>map("getCalculationPeriodsSchedule", commodityOption -> commodityOption.getCalculationPeriodsSchedule());
		}
		
		@Override
		protected MapperS<? extends CommodityPricingDates> fpmlPricingDates(CommodityOption fpmlCommodityOption) {
			return MapperS.of(fpmlCommodityOption).<CommodityPricingDates>map("getPricingDates", commodityOption -> commodityOption.getPricingDates());
		}
	}
}
