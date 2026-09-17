package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.PartyIdentifier;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import cdm.ingest.fpml.confirmation.other.functions.MapPartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPartyIdentifier.MapPartyIdentifierDefault.class)
public abstract class MapPartyIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPartyIdentifierTypeEnum mapPartyIdentifierTypeEnum;
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param identifierValue 
	* @param identifierScheme 
	* @return partyIdentifier 
	*/
	public PartyIdentifier evaluate(String identifierValue, String identifierScheme) {
		PartyIdentifier.PartyIdentifierBuilder partyIdentifierBuilder = doEvaluate(identifierValue, identifierScheme);
		
		final PartyIdentifier partyIdentifier;
		if (partyIdentifierBuilder == null) {
			partyIdentifier = null;
		} else {
			partyIdentifier = partyIdentifierBuilder.build();
			objectValidator.validate(PartyIdentifier.class, partyIdentifier);
		}
		
		return partyIdentifier;
	}

	protected abstract PartyIdentifier.PartyIdentifierBuilder doEvaluate(String identifierValue, String identifierScheme);

	public static class MapPartyIdentifierDefault extends MapPartyIdentifier {
		@Override
		protected PartyIdentifier.PartyIdentifierBuilder doEvaluate(String identifierValue, String identifierScheme) {
			PartyIdentifier.PartyIdentifierBuilder partyIdentifier = PartyIdentifier.builder();
			return assignOutput(partyIdentifier, identifierValue, identifierScheme);
		}
		
		protected PartyIdentifier.PartyIdentifierBuilder assignOutput(PartyIdentifier.PartyIdentifierBuilder partyIdentifier, String identifierValue, String identifierScheme) {
			partyIdentifier = toBuilder(PartyIdentifier.builder()
				.setIdentifier(mapStringWithScheme.evaluate(identifierValue, identifierScheme))
				.setIdentifierType(mapPartyIdentifierTypeEnum.evaluate(identifierScheme))
				.build());
			
			return Optional.ofNullable(partyIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
