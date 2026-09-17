package cdm.ingest.fpml.confirmation.message.functions;

import cdm.event.common.TradeState;
import cdm.ingest.fpml.confirmation.common.functions.GetFpmlTrade;
import cdm.ingest.fpml.confirmation.tradestate.functions.MapTradeState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.confirmation.processes.RequestClearing;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.Party;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRequestClearingToTradeState.MapRequestClearingToTradeStateDefault.class)
public abstract class MapRequestClearingToTradeState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlTrade getFpmlTrade;
	@Inject protected MapTradeState mapTradeState;

	/**
	* @param fpmlRequestClearing 
	* @return tradeState 
	*/
	public TradeState evaluate(RequestClearing fpmlRequestClearing) {
		TradeState.TradeStateBuilder tradeStateBuilder = doEvaluate(fpmlRequestClearing);
		
		final TradeState tradeState;
		if (tradeStateBuilder == null) {
			tradeState = null;
		} else {
			tradeState = tradeStateBuilder.build();
			objectValidator.validate(TradeState.class, tradeState);
		}
		
		return tradeState;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(RequestClearing fpmlRequestClearing);

	protected abstract MapperS<? extends Trade> fpmlTrade(RequestClearing fpmlRequestClearing);

	public static class MapRequestClearingToTradeStateDefault extends MapRequestClearingToTradeState {
		@Override
		protected TradeState.TradeStateBuilder doEvaluate(RequestClearing fpmlRequestClearing) {
			TradeState.TradeStateBuilder tradeState = TradeState.builder();
			return assignOutput(tradeState, fpmlRequestClearing);
		}
		
		protected TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder tradeState, RequestClearing fpmlRequestClearing) {
			tradeState = toBuilder(mapTradeState.evaluate(fpmlTrade(fpmlRequestClearing).get(), MapperS.of(fpmlRequestClearing).<Party>mapC("getParty", requestClearing -> requestClearing.getParty()).getMulti(), MapperS.of(fpmlRequestClearing).<Account>mapC("getAccount", requestClearing -> requestClearing.getAccount()).getMulti(), Collections.<BasicQuotation>emptyList(), Collections.<PartyTradeIdentifier>emptyList()));
			
			return Optional.ofNullable(tradeState)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Trade> fpmlTrade(RequestClearing fpmlRequestClearing) {
			return MapperS.of(getFpmlTrade.evaluate(MapperS.of(fpmlRequestClearing).<TradePackage>map("getTradePackage", requestClearing -> requestClearing.getTradePackage()).get(), MapperS.of(fpmlRequestClearing).<Trade>map("getTrade", requestClearing -> requestClearing.getTrade()).get(), null, null, null));
		}
	}
}
