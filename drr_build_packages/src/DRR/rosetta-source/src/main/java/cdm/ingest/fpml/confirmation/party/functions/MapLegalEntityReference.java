package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaLegalEntity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.LegalEntityReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapLegalEntityReference.MapLegalEntityReferenceDefault.class)
public abstract class MapLegalEntityReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlLegalEntityReference 
	* @return legalEntity 
	*/
	public ReferenceWithMetaLegalEntity evaluate(LegalEntityReference fpmlLegalEntityReference) {
		ReferenceWithMetaLegalEntity.ReferenceWithMetaLegalEntityBuilder legalEntityBuilder = doEvaluate(fpmlLegalEntityReference);
		
		final ReferenceWithMetaLegalEntity legalEntity;
		if (legalEntityBuilder == null) {
			legalEntity = null;
		} else {
			legalEntity = legalEntityBuilder.build();
			objectValidator.validate(ReferenceWithMetaLegalEntity.class, legalEntity);
		}
		
		return legalEntity;
	}

	protected abstract ReferenceWithMetaLegalEntity.ReferenceWithMetaLegalEntityBuilder doEvaluate(LegalEntityReference fpmlLegalEntityReference);

	public static class MapLegalEntityReferenceDefault extends MapLegalEntityReference {
		@Override
		protected ReferenceWithMetaLegalEntity.ReferenceWithMetaLegalEntityBuilder doEvaluate(LegalEntityReference fpmlLegalEntityReference) {
			ReferenceWithMetaLegalEntity.ReferenceWithMetaLegalEntityBuilder legalEntity = ReferenceWithMetaLegalEntity.builder();
			return assignOutput(legalEntity, fpmlLegalEntityReference);
		}
		
		protected ReferenceWithMetaLegalEntity.ReferenceWithMetaLegalEntityBuilder assignOutput(ReferenceWithMetaLegalEntity.ReferenceWithMetaLegalEntityBuilder legalEntity, LegalEntityReference fpmlLegalEntityReference) {
			legalEntity = toBuilder(ReferenceWithMetaLegalEntity.builder().setValue(null).setExternalReference(MapperS.of(fpmlLegalEntityReference).<String>map("getHref", legalEntityReference -> legalEntityReference.getHref()).get()).build());
			
			return Optional.ofNullable(legalEntity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
