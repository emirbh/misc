package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaAssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.MetaFields;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAssetClassWithScheme.MapAssetClassWithSchemeDefault.class)
public abstract class MapAssetClassWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param value 
	* @param scheme 
	* @return enumWithScheme 
	*/
	public FieldWithMetaAssetClassEnum evaluate(String value, String scheme) {
		FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder enumWithSchemeBuilder = doEvaluate(value, scheme);
		
		final FieldWithMetaAssetClassEnum enumWithScheme;
		if (enumWithSchemeBuilder == null) {
			enumWithScheme = null;
		} else {
			enumWithScheme = enumWithSchemeBuilder.build();
			objectValidator.validate(FieldWithMetaAssetClassEnum.class, enumWithScheme);
		}
		
		return enumWithScheme;
	}

	protected abstract FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder doEvaluate(String value, String scheme);

	public static class MapAssetClassWithSchemeDefault extends MapAssetClassWithScheme {
		@Override
		protected FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder doEvaluate(String value, String scheme) {
			FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder enumWithScheme = FieldWithMetaAssetClassEnum.builder();
			return assignOutput(enumWithScheme, value, scheme);
		}
		
		protected FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder assignOutput(FieldWithMetaAssetClassEnum.FieldWithMetaAssetClassEnumBuilder enumWithScheme, String value, String scheme) {
			final AssetClassEnum withMetaArgument = MapperS.of(value).checkedMap("to-enum", AssetClassEnum::fromDisplayName, IllegalArgumentException.class).get();
			enumWithScheme = toBuilder(FieldWithMetaAssetClassEnum.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(scheme)));
			
			return Optional.ofNullable(enumWithScheme)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
