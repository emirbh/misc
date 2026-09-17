package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.base.staticdata.party.Counterparty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapSwaptionPhysicalSettlementToAncillaryParty.MapSwaptionPhysicalSettlementToAncillaryPartyDefault.class)
public abstract class MapSwaptionPhysicalSettlementToAncillaryParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAncillaryParty mapAncillaryParty;

	/**
	* @param fpmlSwaptionPhysicalSettlement 
	* @return ancillaryParty 
	*/
	public AncillaryParty evaluate(SwaptionPhysicalSettlement fpmlSwaptionPhysicalSettlement) {
		AncillaryParty.AncillaryPartyBuilder ancillaryPartyBuilder = doEvaluate(fpmlSwaptionPhysicalSettlement);
		
		final AncillaryParty ancillaryParty;
		if (ancillaryPartyBuilder == null) {
			ancillaryParty = null;
		} else {
			ancillaryParty = ancillaryPartyBuilder.build();
			objectValidator.validate(AncillaryParty.class, ancillaryParty);
		}
		
		return ancillaryParty;
	}

	protected abstract AncillaryParty.AncillaryPartyBuilder doEvaluate(SwaptionPhysicalSettlement fpmlSwaptionPhysicalSettlement);

	public static class MapSwaptionPhysicalSettlementToAncillaryPartyDefault extends MapSwaptionPhysicalSettlementToAncillaryParty {
		@Override
		protected AncillaryParty.AncillaryPartyBuilder doEvaluate(SwaptionPhysicalSettlement fpmlSwaptionPhysicalSettlement) {
			AncillaryParty.AncillaryPartyBuilder ancillaryParty = AncillaryParty.builder();
			return assignOutput(ancillaryParty, fpmlSwaptionPhysicalSettlement);
		}
		
		protected AncillaryParty.AncillaryPartyBuilder assignOutput(AncillaryParty.AncillaryPartyBuilder ancillaryParty, SwaptionPhysicalSettlement fpmlSwaptionPhysicalSettlement) {
			if (exists(MapperS.of(fpmlSwaptionPhysicalSettlement).<PartyReference>map("getPredeterminedClearingOrganizationPartyReference", swaptionPhysicalSettlement -> swaptionPhysicalSettlement.getPredeterminedClearingOrganizationPartyReference())).getOrDefault(false)) {
				ancillaryParty = toBuilder(mapAncillaryParty.evaluate(AncillaryRoleEnum.PREDETERMINED_CLEARING_ORGANIZATION_PARTY, MapperS.of(fpmlSwaptionPhysicalSettlement).<PartyReference>map("getPredeterminedClearingOrganizationPartyReference", swaptionPhysicalSettlement -> swaptionPhysicalSettlement.getPredeterminedClearingOrganizationPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).getMulti(), null, Collections.<Counterparty>emptyList()));
			} else {
				ancillaryParty = null;
			}
			
			return Optional.ofNullable(ancillaryParty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
