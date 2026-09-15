package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.ingest.fpml.confirmation.other.functions.MapDayOfWeekEnum;
import cdm.ingest.fpml.confirmation.other.functions.MapDayTypeEnum;
import cdm.product.asset.metafields.FieldWithMetaDayDistributionEnum;
import cdm.product.common.schedule.ParametricDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.CommodityBusinessCalendar;
import fpml.consolidated.com.CommodityFrequencyType;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.fpmlenum.CommodityDayTypeEnum;
import fpml.consolidated.fpmlenum.DayOfWeekEnum;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapParametricDates.MapParametricDatesDefault.class)
public abstract class MapParametricDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityBusinessCalendarToBusinessCenters mapCommodityBusinessCalendarToBusinessCenters;
	@Inject protected MapDayDistributionEnumWithScheme mapDayDistributionEnumWithScheme;
	@Inject protected MapDayOfWeekEnum mapDayOfWeekEnum;
	@Inject protected MapDayTypeEnum mapDayTypeEnum;

	/**
	* @param fpmlCommodityPricingDates 
	* @return parametricDates 
	*/
	public ParametricDates evaluate(CommodityPricingDates fpmlCommodityPricingDates) {
		ParametricDates.ParametricDatesBuilder parametricDatesBuilder = doEvaluate(fpmlCommodityPricingDates);
		
		final ParametricDates parametricDates;
		if (parametricDatesBuilder == null) {
			parametricDates = null;
		} else {
			parametricDates = parametricDatesBuilder.build();
			objectValidator.validate(ParametricDates.class, parametricDates);
		}
		
		return parametricDates;
	}

	protected abstract ParametricDates.ParametricDatesBuilder doEvaluate(CommodityPricingDates fpmlCommodityPricingDates);

	public static class MapParametricDatesDefault extends MapParametricDates {
		@Override
		protected ParametricDates.ParametricDatesBuilder doEvaluate(CommodityPricingDates fpmlCommodityPricingDates) {
			ParametricDates.ParametricDatesBuilder parametricDates = ParametricDates.builder();
			return assignOutput(parametricDates, fpmlCommodityPricingDates);
		}
		
		protected ParametricDates.ParametricDatesBuilder assignOutput(ParametricDates.ParametricDatesBuilder parametricDates, CommodityPricingDates fpmlCommodityPricingDates) {
			final FieldWithMetaDayDistributionEnum fieldWithMetaDayDistributionEnum = mapDayDistributionEnumWithScheme.evaluate(MapperS.of(fpmlCommodityPricingDates).<CommodityFrequencyType>map("getDayDistribution", commodityPricingDates -> commodityPricingDates.getDayDistribution()).<String>map("getValue", commodityFrequencyType -> commodityFrequencyType.getValue()).get(), MapperS.of(fpmlCommodityPricingDates).<CommodityFrequencyType>map("getDayDistribution", commodityPricingDates -> commodityPricingDates.getDayDistribution()).<String>map("getCommodityFrequencyTypeScheme", commodityFrequencyType -> commodityFrequencyType.getCommodityFrequencyTypeScheme()).get());
			final Integer integer = MapperS.of(fpmlCommodityPricingDates).<Integer>map("getDayNumber", commodityPricingDates -> commodityPricingDates.getDayNumber()).get();
			parametricDates = toBuilder(ParametricDates.builder()
				.setDayType(mapDayTypeEnum.evaluate(MapperS.of(fpmlCommodityPricingDates).<CommodityDayTypeEnum>map("getDayType", commodityPricingDates -> commodityPricingDates.getDayType()).map("to-string", CommodityDayTypeEnum::toDisplayString).get()))
				.setDayDistribution((fieldWithMetaDayDistributionEnum == null ? null : fieldWithMetaDayDistributionEnum.getValue()))
				.setDayOfWeek(MapperS.of(fpmlCommodityPricingDates).<DayOfWeekEnum>mapC("getDayOfWeek", commodityPricingDates -> commodityPricingDates.getDayOfWeek())
					.mapItem(item -> MapperS.of(mapDayOfWeekEnum.evaluate(item.map("to-string", DayOfWeekEnum::toDisplayString).get()))).getMulti())
				.setDayFrequency((integer == null ? null : BigDecimal.valueOf(integer)))
				.setBusinessCenters(mapCommodityBusinessCalendarToBusinessCenters.evaluate(MapperS.of(fpmlCommodityPricingDates).<CommodityBusinessCalendar>map("getBusinessCalendar", commodityPricingDates -> commodityPricingDates.getBusinessCalendar()).get()))
				.build());
			
			return Optional.ofNullable(parametricDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
