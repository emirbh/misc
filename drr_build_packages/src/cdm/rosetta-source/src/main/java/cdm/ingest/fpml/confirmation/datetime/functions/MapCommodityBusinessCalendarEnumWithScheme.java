package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.CommodityBusinessCalendarEnum;
import cdm.base.datetime.metafields.FieldWithMetaCommodityBusinessCalendarEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityBusinessCalendarEnumWithScheme.MapCommodityBusinessCalendarEnumWithSchemeDefault.class)
public abstract class MapCommodityBusinessCalendarEnumWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param value 
	* @param scheme 
	* @return commodityBusinessCalendar 
	*/
	public FieldWithMetaCommodityBusinessCalendarEnum evaluate(String value, String scheme) {
		FieldWithMetaCommodityBusinessCalendarEnum.FieldWithMetaCommodityBusinessCalendarEnumBuilder commodityBusinessCalendarBuilder = doEvaluate(value, scheme);
		
		final FieldWithMetaCommodityBusinessCalendarEnum commodityBusinessCalendar;
		if (commodityBusinessCalendarBuilder == null) {
			commodityBusinessCalendar = null;
		} else {
			commodityBusinessCalendar = commodityBusinessCalendarBuilder.build();
			objectValidator.validate(FieldWithMetaCommodityBusinessCalendarEnum.class, commodityBusinessCalendar);
		}
		
		return commodityBusinessCalendar;
	}

	protected abstract FieldWithMetaCommodityBusinessCalendarEnum.FieldWithMetaCommodityBusinessCalendarEnumBuilder doEvaluate(String value, String scheme);

	public static class MapCommodityBusinessCalendarEnumWithSchemeDefault extends MapCommodityBusinessCalendarEnumWithScheme {
		@Override
		protected FieldWithMetaCommodityBusinessCalendarEnum.FieldWithMetaCommodityBusinessCalendarEnumBuilder doEvaluate(String value, String scheme) {
			FieldWithMetaCommodityBusinessCalendarEnum.FieldWithMetaCommodityBusinessCalendarEnumBuilder commodityBusinessCalendar = FieldWithMetaCommodityBusinessCalendarEnum.builder();
			return assignOutput(commodityBusinessCalendar, value, scheme);
		}
		
		protected FieldWithMetaCommodityBusinessCalendarEnum.FieldWithMetaCommodityBusinessCalendarEnumBuilder assignOutput(FieldWithMetaCommodityBusinessCalendarEnum.FieldWithMetaCommodityBusinessCalendarEnumBuilder commodityBusinessCalendar, String value, String scheme) {
			final CommodityBusinessCalendarEnum withMetaArgument = MapperS.of(value).checkedMap("to-enum", CommodityBusinessCalendarEnum::fromDisplayName, IllegalArgumentException.class).get();
			commodityBusinessCalendar = toBuilder(FieldWithMetaCommodityBusinessCalendarEnum.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(scheme)));
			
			return Optional.ofNullable(commodityBusinessCalendar)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
