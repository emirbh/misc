package drr.base.util.party.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.base.staticdata.party.functions.FilterRelatedPartyByRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExtractPartyFromRelatedPartyByRole.ExtractPartyFromRelatedPartyByRoleDefault.class)
public abstract class ExtractPartyFromRelatedPartyByRole implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterRelatedPartyByRole filterRelatedPartyByRole;

	/**
	* @param relatedParties 
	* @param partyRole 
	* @return party 
	*/
	public Party evaluate(List<? extends RelatedParty> relatedParties, PartyRoleEnum partyRole) {
		Party.PartyBuilder partyBuilder = doEvaluate(relatedParties, partyRole);
		
		final Party party;
		if (partyBuilder == null) {
			party = null;
		} else {
			party = partyBuilder.build();
			objectValidator.validate(Party.class, party);
		}
		
		return party;
	}

	protected abstract Party.PartyBuilder doEvaluate(List<? extends RelatedParty> relatedParties, PartyRoleEnum partyRole);

	public static class ExtractPartyFromRelatedPartyByRoleDefault extends ExtractPartyFromRelatedPartyByRole {
		@Override
		protected Party.PartyBuilder doEvaluate(List<? extends RelatedParty> relatedParties, PartyRoleEnum partyRole) {
			if (relatedParties == null) {
				relatedParties = Collections.emptyList();
			}
			Party.PartyBuilder party = Party.builder();
			return assignOutput(party, relatedParties, partyRole);
		}
		
		protected Party.PartyBuilder assignOutput(Party.PartyBuilder party, List<? extends RelatedParty> relatedParties, PartyRoleEnum partyRole) {
			final ReferenceWithMetaParty referenceWithMetaParty = distinctIgnoringPrecision(MapperC.<RelatedParty>of(filterRelatedPartyByRole.evaluate(relatedParties, partyRole)).<ReferenceWithMetaParty>map("getPartyReference", relatedParty -> relatedParty.getPartyReference())).get();
			if (referenceWithMetaParty == null) {
				party = null;
			} else {
				party = toBuilder(referenceWithMetaParty.getValue());
			}
			
			return Optional.ofNullable(party)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
