package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.math.WeatherUnitEnum;
import cdm.base.math.metafields.FieldWithMetaWeatherUnitEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapWeatherUnitWithScheme.MapWeatherUnitWithSchemeDefault.class)
public abstract class MapWeatherUnitWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param value 
	* @param scheme 
	* @return enumWithScheme 
	*/
	public FieldWithMetaWeatherUnitEnum evaluate(String value, String scheme) {
		FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder enumWithSchemeBuilder = doEvaluate(value, scheme);
		
		final FieldWithMetaWeatherUnitEnum enumWithScheme;
		if (enumWithSchemeBuilder == null) {
			enumWithScheme = null;
		} else {
			enumWithScheme = enumWithSchemeBuilder.build();
			objectValidator.validate(FieldWithMetaWeatherUnitEnum.class, enumWithScheme);
		}
		
		return enumWithScheme;
	}

	protected abstract FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder doEvaluate(String value, String scheme);

	public static class MapWeatherUnitWithSchemeDefault extends MapWeatherUnitWithScheme {
		@Override
		protected FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder doEvaluate(String value, String scheme) {
			FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder enumWithScheme = FieldWithMetaWeatherUnitEnum.builder();
			return assignOutput(enumWithScheme, value, scheme);
		}
		
		protected FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder assignOutput(FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder enumWithScheme, String value, String scheme) {
			final WeatherUnitEnum withMetaArgument = MapperS.of(value).checkedMap("to-enum", WeatherUnitEnum::fromDisplayName, IllegalArgumentException.class).get();
			enumWithScheme = toBuilder(FieldWithMetaWeatherUnitEnum.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(scheme)));
			
			return Optional.ofNullable(enumWithScheme)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
