package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.event.common.PartyChangeInstruction;
import cdm.ingest.fpml.confirmation.header.functions.MapTradeIdentifierSequenceToTradeIdentifier;
import cdm.ingest.fpml.confirmation.party.functions.MapCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPartyChangeInstruction.MapPartyChangeInstructionDefault.class)
public abstract class MapPartyChangeInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterpartyList mapCounterpartyList;
	@Inject protected MapPartyChangePayerReceiverModelToCounterparty mapPartyChangePayerReceiverModelToCounterparty;
	@Inject protected MapTradeIdentifierSequenceToTradeIdentifier mapTradeIdentifierSequenceToTradeIdentifier;

	/**
	* @param fpmlNovation 
	* @return partyChange 
	*/
	public PartyChangeInstruction evaluate(TradeNovationContent fpmlNovation) {
		PartyChangeInstruction.PartyChangeInstructionBuilder partyChangeBuilder = doEvaluate(fpmlNovation);
		
		final PartyChangeInstruction partyChange;
		if (partyChangeBuilder == null) {
			partyChange = null;
		} else {
			partyChange = partyChangeBuilder.build();
			objectValidator.validate(PartyChangeInstruction.class, partyChange);
		}
		
		return partyChange;
	}

	protected abstract PartyChangeInstruction.PartyChangeInstructionBuilder doEvaluate(TradeNovationContent fpmlNovation);

	protected abstract MapperC<? extends Counterparty> counterpartyList(TradeNovationContent fpmlNovation);

	public static class MapPartyChangeInstructionDefault extends MapPartyChangeInstruction {
		@Override
		protected PartyChangeInstruction.PartyChangeInstructionBuilder doEvaluate(TradeNovationContent fpmlNovation) {
			PartyChangeInstruction.PartyChangeInstructionBuilder partyChange = PartyChangeInstruction.builder();
			return assignOutput(partyChange, fpmlNovation);
		}
		
		protected PartyChangeInstruction.PartyChangeInstructionBuilder assignOutput(PartyChangeInstruction.PartyChangeInstructionBuilder partyChange, TradeNovationContent fpmlNovation) {
			partyChange = toBuilder(PartyChangeInstruction.builder()
				.setCounterparty(mapPartyChangePayerReceiverModelToCounterparty.evaluate(MapperS.of(fpmlNovation).<PartyReference>map("getTransferee", tradeNovationContent -> tradeNovationContent.getTransferee()).get(), MapperS.of(fpmlNovation).<PartyReference>map("getTransferor", tradeNovationContent -> tradeNovationContent.getTransferor()).get(), counterpartyList(fpmlNovation).getMulti()))
				.setTradeId(MapperS.of(fpmlNovation).<PartyTradeIdentifier>mapC("getNewTradeIdentifier", tradeNovationContent -> tradeNovationContent.getNewTradeIdentifier())
					.mapItem(item -> MapperS.of(mapTradeIdentifierSequenceToTradeIdentifier.evaluate(item.get()))).getMulti())
				.build());
			
			return Optional.ofNullable(partyChange)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends Counterparty> counterpartyList(TradeNovationContent fpmlNovation) {
			return MapperC.<Counterparty>of(mapCounterpartyList.evaluate(MapperS.of(fpmlNovation).<Trade>map("getOldTrade", tradeNovationContent -> tradeNovationContent.getOldTrade()).get()));
		}
	}
}
