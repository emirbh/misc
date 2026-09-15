package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import cdm.ingest.fpml.confirmation.party.functions.MapPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PartyInformation;
import fpml.consolidated.business.events.WithdrawalPartyTradeInformation;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelatedParty;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapWithdrawalPartyTradeInformationToPartyInformation.MapWithdrawalPartyTradeInformationToPartyInformationDefault.class)
public abstract class MapWithdrawalPartyTradeInformationToPartyInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPartyReference mapPartyReference;
	@Inject protected MapRelatedParty mapRelatedParty;

	/**
	* @param fpmlWithdrawalPartyTradeInformation 
	* @return partyInformation 
	*/
	public PartyInformation evaluate(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation) {
		PartyInformation.PartyInformationBuilder partyInformationBuilder = doEvaluate(fpmlWithdrawalPartyTradeInformation);
		
		final PartyInformation partyInformation;
		if (partyInformationBuilder == null) {
			partyInformation = null;
		} else {
			partyInformation = partyInformationBuilder.build();
			objectValidator.validate(PartyInformation.class, partyInformation);
		}
		
		return partyInformation;
	}

	protected abstract PartyInformation.PartyInformationBuilder doEvaluate(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation);

	public static class MapWithdrawalPartyTradeInformationToPartyInformationDefault extends MapWithdrawalPartyTradeInformationToPartyInformation {
		@Override
		protected PartyInformation.PartyInformationBuilder doEvaluate(WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation) {
			PartyInformation.PartyInformationBuilder partyInformation = PartyInformation.builder();
			return assignOutput(partyInformation, fpmlWithdrawalPartyTradeInformation);
		}
		
		protected PartyInformation.PartyInformationBuilder assignOutput(PartyInformation.PartyInformationBuilder partyInformation, WithdrawalPartyTradeInformation fpmlWithdrawalPartyTradeInformation) {
			partyInformation = toBuilder(PartyInformation.builder()
				.setPartyReference(mapPartyReference.evaluate(MapperS.of(fpmlWithdrawalPartyTradeInformation).<PartyReference>map("getPartyReference", withdrawalPartyTradeInformation -> withdrawalPartyTradeInformation.getPartyReference()).<String>map("getHref", partyReference -> partyReference.getHref()).get()))
				.setRelatedParty(MapperS.of(fpmlWithdrawalPartyTradeInformation).<RelatedParty>mapC("getRelatedParty", withdrawalPartyTradeInformation -> withdrawalPartyTradeInformation.getRelatedParty())
					.mapItem(item -> MapperS.of(mapRelatedParty.evaluate(item.get()))).getMulti())
				.build());
			
			return Optional.ofNullable(partyInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
