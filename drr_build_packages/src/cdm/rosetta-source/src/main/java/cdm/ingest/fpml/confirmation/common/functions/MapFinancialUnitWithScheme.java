package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.metafields.FieldWithMetaFinancialUnitEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFinancialUnitWithScheme.MapFinancialUnitWithSchemeDefault.class)
public abstract class MapFinancialUnitWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param value 
	* @param scheme 
	* @return enumWithScheme 
	*/
	public FieldWithMetaFinancialUnitEnum evaluate(String value, String scheme) {
		FieldWithMetaFinancialUnitEnum.FieldWithMetaFinancialUnitEnumBuilder enumWithSchemeBuilder = doEvaluate(value, scheme);
		
		final FieldWithMetaFinancialUnitEnum enumWithScheme;
		if (enumWithSchemeBuilder == null) {
			enumWithScheme = null;
		} else {
			enumWithScheme = enumWithSchemeBuilder.build();
			objectValidator.validate(FieldWithMetaFinancialUnitEnum.class, enumWithScheme);
		}
		
		return enumWithScheme;
	}

	protected abstract FieldWithMetaFinancialUnitEnum.FieldWithMetaFinancialUnitEnumBuilder doEvaluate(String value, String scheme);

	public static class MapFinancialUnitWithSchemeDefault extends MapFinancialUnitWithScheme {
		@Override
		protected FieldWithMetaFinancialUnitEnum.FieldWithMetaFinancialUnitEnumBuilder doEvaluate(String value, String scheme) {
			FieldWithMetaFinancialUnitEnum.FieldWithMetaFinancialUnitEnumBuilder enumWithScheme = FieldWithMetaFinancialUnitEnum.builder();
			return assignOutput(enumWithScheme, value, scheme);
		}
		
		protected FieldWithMetaFinancialUnitEnum.FieldWithMetaFinancialUnitEnumBuilder assignOutput(FieldWithMetaFinancialUnitEnum.FieldWithMetaFinancialUnitEnumBuilder enumWithScheme, String value, String scheme) {
			final FinancialUnitEnum withMetaArgument = MapperS.of(value).checkedMap("to-enum", FinancialUnitEnum::fromDisplayName, IllegalArgumentException.class).get();
			enumWithScheme = toBuilder(FieldWithMetaFinancialUnitEnum.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(scheme)));
			
			return Optional.ofNullable(enumWithScheme)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
