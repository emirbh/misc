package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapPartyReference.MapPartyReferenceDefault.class)
public abstract class MapPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlPartyHref 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(String fpmlPartyHref) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlPartyHref);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(String fpmlPartyHref);

	public static class MapPartyReferenceDefault extends MapPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(String fpmlPartyHref) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlPartyHref);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, String fpmlPartyHref) {
			if (exists(MapperS.of(fpmlPartyHref)).getOrDefault(false)) {
				partyReference = toBuilder(ReferenceWithMetaParty.builder().setValue(null).setExternalReference(fpmlPartyHref).build());
			} else {
				partyReference = toBuilder(ReferenceWithMetaParty.builder().build());
			}
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
