package cdm.ingest.fpml.confirmation.product.commodityoption.functions;

import cdm.ingest.fpml.confirmation.datetime.functions.MapCommodityBusinessCalendarToBusinessCenters;
import cdm.ingest.fpml.confirmation.other.functions.MapDayTypeEnum;
import cdm.product.asset.DayDistributionEnum;
import cdm.product.common.schedule.ObservationDates;
import cdm.product.common.schedule.ParametricDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.CommodityBusinessCalendar;
import fpml.consolidated.com.CommodityFrequencyType;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.fpmlenum.CommodityDayTypeEnum;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityPricingDatesToObservationDates.MapCommodityPricingDatesToObservationDatesDefault.class)
public abstract class MapCommodityPricingDatesToObservationDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityBusinessCalendarToBusinessCenters mapCommodityBusinessCalendarToBusinessCenters;
	@Inject protected MapDayTypeEnum mapDayTypeEnum;

	/**
	* @param fpmlCommodityPricingDates 
	* @return observationDates 
	*/
	public ObservationDates evaluate(CommodityPricingDates fpmlCommodityPricingDates) {
		ObservationDates.ObservationDatesBuilder observationDatesBuilder = doEvaluate(fpmlCommodityPricingDates);
		
		final ObservationDates observationDates;
		if (observationDatesBuilder == null) {
			observationDates = null;
		} else {
			observationDates = observationDatesBuilder.build();
			objectValidator.validate(ObservationDates.class, observationDates);
		}
		
		return observationDates;
	}

	protected abstract ObservationDates.ObservationDatesBuilder doEvaluate(CommodityPricingDates fpmlCommodityPricingDates);

	public static class MapCommodityPricingDatesToObservationDatesDefault extends MapCommodityPricingDatesToObservationDates {
		@Override
		protected ObservationDates.ObservationDatesBuilder doEvaluate(CommodityPricingDates fpmlCommodityPricingDates) {
			ObservationDates.ObservationDatesBuilder observationDates = ObservationDates.builder();
			return assignOutput(observationDates, fpmlCommodityPricingDates);
		}
		
		protected ObservationDates.ObservationDatesBuilder assignOutput(ObservationDates.ObservationDatesBuilder observationDates, CommodityPricingDates fpmlCommodityPricingDates) {
			observationDates = toBuilder(ObservationDates.builder()
				.setParametricDates(ParametricDates.builder()
					.setDayType(mapDayTypeEnum.evaluate(MapperS.of(fpmlCommodityPricingDates).<CommodityDayTypeEnum>map("getDayType", commodityPricingDates -> commodityPricingDates.getDayType()).map("to-string", CommodityDayTypeEnum::toDisplayString).get()))
					.setDayDistribution(MapperS.of(fpmlCommodityPricingDates).<CommodityFrequencyType>map("getDayDistribution", commodityPricingDates -> commodityPricingDates.getDayDistribution()).<String>map("getValue", commodityFrequencyType -> commodityFrequencyType.getValue()).checkedMap("to-enum", DayDistributionEnum::fromDisplayName, IllegalArgumentException.class).get())
					.setBusinessCenters(mapCommodityBusinessCalendarToBusinessCenters.evaluate(MapperS.of(fpmlCommodityPricingDates).<CommodityBusinessCalendar>map("getBusinessCalendar", commodityPricingDates -> commodityPricingDates.getBusinessCalendar()).get()))
					.build())
				.build());
			
			return Optional.ofNullable(observationDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
