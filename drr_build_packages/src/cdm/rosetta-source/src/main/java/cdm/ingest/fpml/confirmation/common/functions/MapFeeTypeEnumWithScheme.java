package cdm.ingest.fpml.confirmation.common.functions;

import cdm.ingest.fpml.confirmation.other.functions.MapFeeTypeEnum;
import cdm.observable.asset.FeeTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaFeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.metafields.MetaFields;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFeeTypeEnumWithScheme.MapFeeTypeEnumWithSchemeDefault.class)
public abstract class MapFeeTypeEnumWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFeeTypeEnum mapFeeTypeEnum;

	/**
	* @param value 
	* @param scheme 
	* @return enumWithScheme 
	*/
	public FieldWithMetaFeeTypeEnum evaluate(String value, String scheme) {
		FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder enumWithSchemeBuilder = doEvaluate(value, scheme);
		
		final FieldWithMetaFeeTypeEnum enumWithScheme;
		if (enumWithSchemeBuilder == null) {
			enumWithScheme = null;
		} else {
			enumWithScheme = enumWithSchemeBuilder.build();
			objectValidator.validate(FieldWithMetaFeeTypeEnum.class, enumWithScheme);
		}
		
		return enumWithScheme;
	}

	protected abstract FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder doEvaluate(String value, String scheme);

	public static class MapFeeTypeEnumWithSchemeDefault extends MapFeeTypeEnumWithScheme {
		@Override
		protected FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder doEvaluate(String value, String scheme) {
			FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder enumWithScheme = FieldWithMetaFeeTypeEnum.builder();
			return assignOutput(enumWithScheme, value, scheme);
		}
		
		protected FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder assignOutput(FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder enumWithScheme, String value, String scheme) {
			final FeeTypeEnum withMetaArgument = mapFeeTypeEnum.evaluate(value);
			enumWithScheme = toBuilder(FieldWithMetaFeeTypeEnum.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(scheme)));
			
			return Optional.ofNullable(enumWithScheme)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
