package cdm.ingest.fpml.confirmation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.ReferenceWithMetaString;
import fpml.consolidated.shared.IdentifiedCurrencyReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCurrencyReference.MapCurrencyReferenceDefault.class)
public abstract class MapCurrencyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithReference mapStringWithReference;

	/**
	* @param fpmlIdentifiedCurrencyReference 
	* @return currencyReference 
	*/
	public ReferenceWithMetaString evaluate(IdentifiedCurrencyReference fpmlIdentifiedCurrencyReference) {
		ReferenceWithMetaString.ReferenceWithMetaStringBuilder currencyReferenceBuilder = doEvaluate(fpmlIdentifiedCurrencyReference);
		
		final ReferenceWithMetaString currencyReference;
		if (currencyReferenceBuilder == null) {
			currencyReference = null;
		} else {
			currencyReference = currencyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaString.class, currencyReference);
		}
		
		return currencyReference;
	}

	protected abstract ReferenceWithMetaString.ReferenceWithMetaStringBuilder doEvaluate(IdentifiedCurrencyReference fpmlIdentifiedCurrencyReference);

	public static class MapCurrencyReferenceDefault extends MapCurrencyReference {
		@Override
		protected ReferenceWithMetaString.ReferenceWithMetaStringBuilder doEvaluate(IdentifiedCurrencyReference fpmlIdentifiedCurrencyReference) {
			ReferenceWithMetaString.ReferenceWithMetaStringBuilder currencyReference = ReferenceWithMetaString.builder();
			return assignOutput(currencyReference, fpmlIdentifiedCurrencyReference);
		}
		
		protected ReferenceWithMetaString.ReferenceWithMetaStringBuilder assignOutput(ReferenceWithMetaString.ReferenceWithMetaStringBuilder currencyReference, IdentifiedCurrencyReference fpmlIdentifiedCurrencyReference) {
			currencyReference = toBuilder(mapStringWithReference.evaluate(null, MapperS.of(fpmlIdentifiedCurrencyReference).<String>map("getHref", identifiedCurrencyReference -> identifiedCurrencyReference.getHref()).get()));
			
			return Optional.ofNullable(currencyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
