package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.Party;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.ExchangeId;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapExchangeIdToAssetParty.MapExchangeIdToAssetPartyDefault.class)
public abstract class MapExchangeIdToAssetParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPartyIdentifier mapPartyIdentifier;
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlExchangeId 
	* @return party 
	*/
	public Party evaluate(ExchangeId fpmlExchangeId) {
		Party.PartyBuilder partyBuilder = doEvaluate(fpmlExchangeId);
		
		final Party party;
		if (partyBuilder == null) {
			party = null;
		} else {
			party = partyBuilder.build();
			objectValidator.validate(Party.class, party);
		}
		
		return party;
	}

	protected abstract Party.PartyBuilder doEvaluate(ExchangeId fpmlExchangeId);

	public static class MapExchangeIdToAssetPartyDefault extends MapExchangeIdToAssetParty {
		@Override
		protected Party.PartyBuilder doEvaluate(ExchangeId fpmlExchangeId) {
			Party.PartyBuilder party = Party.builder();
			return assignOutput(party, fpmlExchangeId);
		}
		
		protected Party.PartyBuilder assignOutput(Party.PartyBuilder party, ExchangeId fpmlExchangeId) {
			party = toBuilder(Party.builder()
				.setPartyId(MapperS.of(fpmlExchangeId)
					.mapSingleToItem(item -> MapperS.of(mapPartyIdentifier.evaluate(item.<String>map("getValue", exchangeId -> exchangeId.getValue()).get(), item.<String>map("getExchangeIdScheme", exchangeId -> exchangeId.getExchangeIdScheme()).get()))).getMulti())
				.setName(mapStringWithScheme.evaluate(MapperS.of(fpmlExchangeId).<String>map("getValue", exchangeId -> exchangeId.getValue()).get(), MapperS.of(fpmlExchangeId).<String>map("getExchangeIdScheme", exchangeId -> exchangeId.getExchangeIdScheme()).get()))
				.build());
			
			return Optional.ofNullable(party)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
