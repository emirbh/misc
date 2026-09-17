package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.metafields.FieldWithMetaCommodityBusinessCalendarEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.CommodityBusinessCalendar;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityBusinessCalendarToBusinessCenters.MapCommodityBusinessCalendarToBusinessCentersDefault.class)
public abstract class MapCommodityBusinessCalendarToBusinessCenters implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityBusinessCalendarEnumWithScheme mapCommodityBusinessCalendarEnumWithScheme;

	/**
	* @param fpmlBusinessCalendar 
	* @return businessCenters 
	*/
	public BusinessCenters evaluate(CommodityBusinessCalendar fpmlBusinessCalendar) {
		BusinessCenters.BusinessCentersBuilder businessCentersBuilder = doEvaluate(fpmlBusinessCalendar);
		
		final BusinessCenters businessCenters;
		if (businessCentersBuilder == null) {
			businessCenters = null;
		} else {
			businessCenters = businessCentersBuilder.build();
			objectValidator.validate(BusinessCenters.class, businessCenters);
		}
		
		return businessCenters;
	}

	protected abstract BusinessCenters.BusinessCentersBuilder doEvaluate(CommodityBusinessCalendar fpmlBusinessCalendar);

	public static class MapCommodityBusinessCalendarToBusinessCentersDefault extends MapCommodityBusinessCalendarToBusinessCenters {
		@Override
		protected BusinessCenters.BusinessCentersBuilder doEvaluate(CommodityBusinessCalendar fpmlBusinessCalendar) {
			BusinessCenters.BusinessCentersBuilder businessCenters = BusinessCenters.builder();
			return assignOutput(businessCenters, fpmlBusinessCalendar);
		}
		
		protected BusinessCenters.BusinessCentersBuilder assignOutput(BusinessCenters.BusinessCentersBuilder businessCenters, CommodityBusinessCalendar fpmlBusinessCalendar) {
			final FieldWithMetaCommodityBusinessCalendarEnum fieldWithMetaCommodityBusinessCalendarEnum = mapCommodityBusinessCalendarEnumWithScheme.evaluate(MapperS.of(fpmlBusinessCalendar).<String>map("getValue", commodityBusinessCalendar -> commodityBusinessCalendar.getValue()).get(), MapperS.of(fpmlBusinessCalendar).<String>map("getCommodityBusinessCalendarScheme", commodityBusinessCalendar -> commodityBusinessCalendar.getCommodityBusinessCalendarScheme()).get());
			businessCenters = toBuilder(BusinessCenters.builder()
				.setCommodityBusinessCalendar((fieldWithMetaCommodityBusinessCalendarEnum == null ? Collections.<FieldWithMetaCommodityBusinessCalendarEnum>emptyList() : Collections.singletonList(fieldWithMetaCommodityBusinessCalendarEnum)))
				.build());
			
			return Optional.ofNullable(businessCenters)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
