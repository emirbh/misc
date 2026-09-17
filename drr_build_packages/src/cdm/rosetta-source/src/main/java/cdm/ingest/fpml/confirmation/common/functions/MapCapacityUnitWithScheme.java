package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.math.CapacityUnitEnum;
import cdm.base.math.metafields.FieldWithMetaCapacityUnitEnum;
import cdm.ingest.fpml.confirmation.other.functions.MapCapacityUnitEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.metafields.MetaFields;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCapacityUnitWithScheme.MapCapacityUnitWithSchemeDefault.class)
public abstract class MapCapacityUnitWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCapacityUnitEnum mapCapacityUnitEnum;

	/**
	* @param value 
	* @param scheme 
	* @return enumWithScheme 
	*/
	public FieldWithMetaCapacityUnitEnum evaluate(String value, String scheme) {
		FieldWithMetaCapacityUnitEnum.FieldWithMetaCapacityUnitEnumBuilder enumWithSchemeBuilder = doEvaluate(value, scheme);
		
		final FieldWithMetaCapacityUnitEnum enumWithScheme;
		if (enumWithSchemeBuilder == null) {
			enumWithScheme = null;
		} else {
			enumWithScheme = enumWithSchemeBuilder.build();
			objectValidator.validate(FieldWithMetaCapacityUnitEnum.class, enumWithScheme);
		}
		
		return enumWithScheme;
	}

	protected abstract FieldWithMetaCapacityUnitEnum.FieldWithMetaCapacityUnitEnumBuilder doEvaluate(String value, String scheme);

	public static class MapCapacityUnitWithSchemeDefault extends MapCapacityUnitWithScheme {
		@Override
		protected FieldWithMetaCapacityUnitEnum.FieldWithMetaCapacityUnitEnumBuilder doEvaluate(String value, String scheme) {
			FieldWithMetaCapacityUnitEnum.FieldWithMetaCapacityUnitEnumBuilder enumWithScheme = FieldWithMetaCapacityUnitEnum.builder();
			return assignOutput(enumWithScheme, value, scheme);
		}
		
		protected FieldWithMetaCapacityUnitEnum.FieldWithMetaCapacityUnitEnumBuilder assignOutput(FieldWithMetaCapacityUnitEnum.FieldWithMetaCapacityUnitEnumBuilder enumWithScheme, String value, String scheme) {
			final CapacityUnitEnum withMetaArgument = mapCapacityUnitEnum.evaluate(value);
			enumWithScheme = toBuilder(FieldWithMetaCapacityUnitEnum.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(scheme)));
			
			return Optional.ofNullable(enumWithScheme)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
