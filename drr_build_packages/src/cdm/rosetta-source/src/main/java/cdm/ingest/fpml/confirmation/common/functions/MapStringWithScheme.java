package cdm.ingest.fpml.confirmation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.MetaFields;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapStringWithScheme.MapStringWithSchemeDefault.class)
public abstract class MapStringWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param value 
	* @param scheme 
	* @return stringWithScheme 
	*/
	public FieldWithMetaString evaluate(String value, String scheme) {
		FieldWithMetaString.FieldWithMetaStringBuilder stringWithSchemeBuilder = doEvaluate(value, scheme);
		
		final FieldWithMetaString stringWithScheme;
		if (stringWithSchemeBuilder == null) {
			stringWithScheme = null;
		} else {
			stringWithScheme = stringWithSchemeBuilder.build();
			objectValidator.validate(FieldWithMetaString.class, stringWithScheme);
		}
		
		return stringWithScheme;
	}

	protected abstract FieldWithMetaString.FieldWithMetaStringBuilder doEvaluate(String value, String scheme);

	public static class MapStringWithSchemeDefault extends MapStringWithScheme {
		@Override
		protected FieldWithMetaString.FieldWithMetaStringBuilder doEvaluate(String value, String scheme) {
			FieldWithMetaString.FieldWithMetaStringBuilder stringWithScheme = FieldWithMetaString.builder();
			return assignOutput(stringWithScheme, value, scheme);
		}
		
		protected FieldWithMetaString.FieldWithMetaStringBuilder assignOutput(FieldWithMetaString.FieldWithMetaStringBuilder stringWithScheme, String value, String scheme) {
			final String withMetaArgument = value;
			stringWithScheme = toBuilder(FieldWithMetaString.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScheme(scheme)));
			
			return Optional.ofNullable(stringWithScheme)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
