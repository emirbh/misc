package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.base.staticdata.party.Counterparty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapAncillaryParty.MapAncillaryPartyDefault.class)
public abstract class MapAncillaryParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterpartyRoleEnum mapCounterpartyRoleEnum;
	@Inject protected MapPartyReference mapPartyReference;

	/**
	* @param cdmAncillaryRole 
	* @param fpmlPartyHrefList 
	* @param fpmlOnBehalfOfPartyHref 
	* @param cdmCounterpartyList 
	* @return ancillaryParty 
	*/
	public AncillaryParty evaluate(AncillaryRoleEnum cdmAncillaryRole, List<String> fpmlPartyHrefList, String fpmlOnBehalfOfPartyHref, List<? extends Counterparty> cdmCounterpartyList) {
		AncillaryParty.AncillaryPartyBuilder ancillaryPartyBuilder = doEvaluate(cdmAncillaryRole, fpmlPartyHrefList, fpmlOnBehalfOfPartyHref, cdmCounterpartyList);
		
		final AncillaryParty ancillaryParty;
		if (ancillaryPartyBuilder == null) {
			ancillaryParty = null;
		} else {
			ancillaryParty = ancillaryPartyBuilder.build();
			objectValidator.validate(AncillaryParty.class, ancillaryParty);
		}
		
		return ancillaryParty;
	}

	protected abstract AncillaryParty.AncillaryPartyBuilder doEvaluate(AncillaryRoleEnum cdmAncillaryRole, List<String> fpmlPartyHrefList, String fpmlOnBehalfOfPartyHref, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapAncillaryPartyDefault extends MapAncillaryParty {
		@Override
		protected AncillaryParty.AncillaryPartyBuilder doEvaluate(AncillaryRoleEnum cdmAncillaryRole, List<String> fpmlPartyHrefList, String fpmlOnBehalfOfPartyHref, List<? extends Counterparty> cdmCounterpartyList) {
			if (fpmlPartyHrefList == null) {
				fpmlPartyHrefList = Collections.emptyList();
			}
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			AncillaryParty.AncillaryPartyBuilder ancillaryParty = AncillaryParty.builder();
			return assignOutput(ancillaryParty, cdmAncillaryRole, fpmlPartyHrefList, fpmlOnBehalfOfPartyHref, cdmCounterpartyList);
		}
		
		protected AncillaryParty.AncillaryPartyBuilder assignOutput(AncillaryParty.AncillaryPartyBuilder ancillaryParty, AncillaryRoleEnum cdmAncillaryRole, List<String> fpmlPartyHrefList, String fpmlOnBehalfOfPartyHref, List<? extends Counterparty> cdmCounterpartyList) {
			if (exists(MapperC.<String>of(fpmlPartyHrefList)).getOrDefault(false)) {
				ancillaryParty = toBuilder(AncillaryParty.builder()
					.setRole(cdmAncillaryRole)
					.setPartyReference(MapperC.<String>of(fpmlPartyHrefList)
						.mapItem(item -> MapperS.of(mapPartyReference.evaluate(item.get()))).getMulti())
					.setOnBehalfOf(mapCounterpartyRoleEnum.evaluate(fpmlOnBehalfOfPartyHref, cdmCounterpartyList))
					.build());
			} else {
				ancillaryParty = null;
			}
			
			return Optional.ofNullable(ancillaryParty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
