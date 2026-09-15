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
import fpml.consolidated.confirmation.processes.ExecutionNotification;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.Party;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapExecutionNotificationToTradeState.MapExecutionNotificationToTradeStateDefault.class)
public abstract class MapExecutionNotificationToTradeState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlTrade getFpmlTrade;
	@Inject protected MapTradeState mapTradeState;

	/**
	* @param fpmlExecutionNotification 
	* @return tradeState 
	*/
	public TradeState evaluate(ExecutionNotification fpmlExecutionNotification) {
		TradeState.TradeStateBuilder tradeStateBuilder = doEvaluate(fpmlExecutionNotification);
		
		final TradeState tradeState;
		if (tradeStateBuilder == null) {
			tradeState = null;
		} else {
			tradeState = tradeStateBuilder.build();
			objectValidator.validate(TradeState.class, tradeState);
		}
		
		return tradeState;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(ExecutionNotification fpmlExecutionNotification);

	protected abstract MapperS<? extends Trade> fpmlTrade(ExecutionNotification fpmlExecutionNotification);

	public static class MapExecutionNotificationToTradeStateDefault extends MapExecutionNotificationToTradeState {
		@Override
		protected TradeState.TradeStateBuilder doEvaluate(ExecutionNotification fpmlExecutionNotification) {
			TradeState.TradeStateBuilder tradeState = TradeState.builder();
			return assignOutput(tradeState, fpmlExecutionNotification);
		}
		
		protected TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder tradeState, ExecutionNotification fpmlExecutionNotification) {
			tradeState = toBuilder(mapTradeState.evaluate(fpmlTrade(fpmlExecutionNotification).get(), MapperS.of(fpmlExecutionNotification).<Party>mapC("getParty", executionNotification -> executionNotification.getParty()).getMulti(), MapperS.of(fpmlExecutionNotification).<Account>mapC("getAccount", executionNotification -> executionNotification.getAccount()).getMulti(), Collections.<BasicQuotation>emptyList(), Collections.<PartyTradeIdentifier>emptyList()));
			
			return Optional.ofNullable(tradeState)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Trade> fpmlTrade(ExecutionNotification fpmlExecutionNotification) {
			return MapperS.of(getFpmlTrade.evaluate(MapperS.of(fpmlExecutionNotification).<TradePackage>map("getTradePackage", executionNotification -> executionNotification.getTradePackage()).get(), MapperS.of(fpmlExecutionNotification).<Trade>map("getTrade", executionNotification -> executionNotification.getTrade()).get(), null, null, null));
		}
	}
}
