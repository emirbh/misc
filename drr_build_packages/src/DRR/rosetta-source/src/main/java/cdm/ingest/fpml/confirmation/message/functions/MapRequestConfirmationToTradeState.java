package cdm.ingest.fpml.confirmation.message.functions;

import cdm.event.common.TradeState;
import cdm.ingest.fpml.confirmation.common.functions.GetFpmlTrade;
import cdm.ingest.fpml.confirmation.tradestate.functions.MapTradeState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.confirmation.processes.RequestConfirmation;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.Party;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRequestConfirmationToTradeState.MapRequestConfirmationToTradeStateDefault.class)
public abstract class MapRequestConfirmationToTradeState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlTrade getFpmlTrade;
	@Inject protected MapTradeState mapTradeState;

	/**
	* @param fpmlRequestConfirmation 
	* @return tradeState 
	*/
	public TradeState evaluate(RequestConfirmation fpmlRequestConfirmation) {
		TradeState.TradeStateBuilder tradeStateBuilder = doEvaluate(fpmlRequestConfirmation);
		
		final TradeState tradeState;
		if (tradeStateBuilder == null) {
			tradeState = null;
		} else {
			tradeState = tradeStateBuilder.build();
			objectValidator.validate(TradeState.class, tradeState);
		}
		
		return tradeState;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(RequestConfirmation fpmlRequestConfirmation);

	protected abstract MapperS<? extends Trade> fpmlTrade(RequestConfirmation fpmlRequestConfirmation);

	public static class MapRequestConfirmationToTradeStateDefault extends MapRequestConfirmationToTradeState {
		@Override
		protected TradeState.TradeStateBuilder doEvaluate(RequestConfirmation fpmlRequestConfirmation) {
			TradeState.TradeStateBuilder tradeState = TradeState.builder();
			return assignOutput(tradeState, fpmlRequestConfirmation);
		}
		
		protected TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder tradeState, RequestConfirmation fpmlRequestConfirmation) {
			tradeState = toBuilder(mapTradeState.evaluate(fpmlTrade(fpmlRequestConfirmation).get(), MapperS.of(fpmlRequestConfirmation).<Party>mapC("getParty", requestConfirmation -> requestConfirmation.getParty()).getMulti(), MapperS.of(fpmlRequestConfirmation).<Account>mapC("getAccount", requestConfirmation -> requestConfirmation.getAccount()).getMulti(), Collections.<BasicQuotation>emptyList(), Collections.<PartyTradeIdentifier>emptyList()));
			
			return Optional.ofNullable(tradeState)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Trade> fpmlTrade(RequestConfirmation fpmlRequestConfirmation) {
			return MapperS.of(getFpmlTrade.evaluate(MapperS.of(fpmlRequestConfirmation).<TradePackage>map("getTradePackage", requestConfirmation -> requestConfirmation.getTradePackage()).get(), MapperS.of(fpmlRequestConfirmation).<Trade>map("getTrade", requestConfirmation -> requestConfirmation.getTrade()).get(), MapperS.of(fpmlRequestConfirmation).<TradeNovationContent>map("getNovation", requestConfirmation -> requestConfirmation.getNovation()).get(), MapperS.of(fpmlRequestConfirmation).<TradeNotionalChange>map("getTermination", requestConfirmation -> requestConfirmation.getTermination()).get(), MapperS.of(fpmlRequestConfirmation).<TradeAmendmentContent>map("getAmendment", requestConfirmation -> requestConfirmation.getAmendment()).get()));
		}
	}
}
