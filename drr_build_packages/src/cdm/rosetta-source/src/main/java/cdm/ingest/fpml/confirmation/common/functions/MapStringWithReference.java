package cdm.ingest.fpml.confirmation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.metafields.ReferenceWithMetaString;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapStringWithReference.MapStringWithReferenceDefault.class)
public abstract class MapStringWithReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param value 
	* @param reference 
	* @return stringWithReference 
	*/
	public ReferenceWithMetaString evaluate(String value, String reference) {
		ReferenceWithMetaString.ReferenceWithMetaStringBuilder stringWithReferenceBuilder = doEvaluate(value, reference);
		
		final ReferenceWithMetaString stringWithReference;
		if (stringWithReferenceBuilder == null) {
			stringWithReference = null;
		} else {
			stringWithReference = stringWithReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaString.class, stringWithReference);
		}
		
		return stringWithReference;
	}

	protected abstract ReferenceWithMetaString.ReferenceWithMetaStringBuilder doEvaluate(String value, String reference);

	public static class MapStringWithReferenceDefault extends MapStringWithReference {
		@Override
		protected ReferenceWithMetaString.ReferenceWithMetaStringBuilder doEvaluate(String value, String reference) {
			ReferenceWithMetaString.ReferenceWithMetaStringBuilder stringWithReference = ReferenceWithMetaString.builder();
			return assignOutput(stringWithReference, value, reference);
		}
		
		protected ReferenceWithMetaString.ReferenceWithMetaStringBuilder assignOutput(ReferenceWithMetaString.ReferenceWithMetaStringBuilder stringWithReference, String value, String reference) {
			stringWithReference = toBuilder(ReferenceWithMetaString.builder().setValue(value).setExternalReference(reference).build());
			
			return Optional.ofNullable(stringWithReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
