package cdm.ingest.fpml.confirmation.message.functions;

import cdm.event.common.TradeState;
import cdm.ingest.fpml.confirmation.tradestate.functions.MapTradeState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.main.DataDocument;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.Party;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDataDocumentToTradeState.MapDataDocumentToTradeStateDefault.class)
public abstract class MapDataDocumentToTradeState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapTradeState mapTradeState;

	/**
	* @param fpmlDataDocument 
	* @return tradeState 
	*/
	public TradeState evaluate(DataDocument fpmlDataDocument) {
		TradeState.TradeStateBuilder tradeStateBuilder = doEvaluate(fpmlDataDocument);
		
		final TradeState tradeState;
		if (tradeStateBuilder == null) {
			tradeState = null;
		} else {
			tradeState = tradeStateBuilder.build();
			objectValidator.validate(TradeState.class, tradeState);
		}
		
		return tradeState;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDataDocumentToTradeStateDefault extends MapDataDocumentToTradeState {
		@Override
		protected TradeState.TradeStateBuilder doEvaluate(DataDocument fpmlDataDocument) {
			TradeState.TradeStateBuilder tradeState = TradeState.builder();
			return assignOutput(tradeState, fpmlDataDocument);
		}
		
		protected TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder tradeState, DataDocument fpmlDataDocument) {
			tradeState = toBuilder(mapTradeState.evaluate(MapperS.of(fpmlDataDocument).<Trade>mapC("getTrade", dataDocument -> dataDocument.getTrade()).get(), MapperS.of(fpmlDataDocument).<Party>mapC("getParty", dataDocument -> dataDocument.getParty()).getMulti(), MapperS.of(fpmlDataDocument).<Account>mapC("getAccount", dataDocument -> dataDocument.getAccount()).getMulti(), Collections.<BasicQuotation>emptyList(), Collections.<PartyTradeIdentifier>emptyList()));
			
			return Optional.ofNullable(tradeState)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
