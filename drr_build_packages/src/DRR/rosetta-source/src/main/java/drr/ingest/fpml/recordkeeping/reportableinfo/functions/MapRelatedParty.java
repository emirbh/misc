package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import cdm.base.staticdata.party.RelatedParty;
import cdm.ingest.fpml.confirmation.other.functions.MapPartyRoleEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PartyRole;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRelatedParty.MapRelatedPartyDefault.class)
public abstract class MapRelatedParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPartyReference mapPartyReference;
	@Inject protected MapPartyRoleEnum mapPartyRoleEnum;

	/**
	* @param fpmlRelatedParty 
	* @return relatedParty 
	*/
	public RelatedParty evaluate(fpml.consolidated.shared.RelatedParty fpmlRelatedParty) {
		RelatedParty.RelatedPartyBuilder relatedPartyBuilder = doEvaluate(fpmlRelatedParty);
		
		final RelatedParty relatedParty;
		if (relatedPartyBuilder == null) {
			relatedParty = null;
		} else {
			relatedParty = relatedPartyBuilder.build();
			objectValidator.validate(RelatedParty.class, relatedParty);
		}
		
		return relatedParty;
	}

	protected abstract RelatedParty.RelatedPartyBuilder doEvaluate(fpml.consolidated.shared.RelatedParty fpmlRelatedParty);

	public static class MapRelatedPartyDefault extends MapRelatedParty {
		@Override
		protected RelatedParty.RelatedPartyBuilder doEvaluate(fpml.consolidated.shared.RelatedParty fpmlRelatedParty) {
			RelatedParty.RelatedPartyBuilder relatedParty = RelatedParty.builder();
			return assignOutput(relatedParty, fpmlRelatedParty);
		}
		
		protected RelatedParty.RelatedPartyBuilder assignOutput(RelatedParty.RelatedPartyBuilder relatedParty, fpml.consolidated.shared.RelatedParty fpmlRelatedParty) {
			relatedParty = toBuilder(RelatedParty.builder()
				.setPartyReference(mapPartyReference.evaluate(MapperS.of(fpmlRelatedParty).<PartyReference>map("getPartyReference", _relatedParty -> _relatedParty.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get()))
				.setRole(mapPartyRoleEnum.evaluate(MapperS.of(fpmlRelatedParty).<PartyRole>map("getRole", _relatedParty -> _relatedParty.getRole()).<String>map("getValue", partyRole -> partyRole.getValue()).get()))
				.build());
			
			return Optional.ofNullable(relatedParty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
