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
import fpml.consolidated.confirmation.processes.ConfirmationAgreed;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.Party;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapConfirmationAgreedToTradeState.MapConfirmationAgreedToTradeStateDefault.class)
public abstract class MapConfirmationAgreedToTradeState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlTrade getFpmlTrade;
	@Inject protected MapTradeState mapTradeState;

	/**
	* @param fpmlConfirmationAgreed 
	* @return tradeState 
	*/
	public TradeState evaluate(ConfirmationAgreed fpmlConfirmationAgreed) {
		TradeState.TradeStateBuilder tradeStateBuilder = doEvaluate(fpmlConfirmationAgreed);
		
		final TradeState tradeState;
		if (tradeStateBuilder == null) {
			tradeState = null;
		} else {
			tradeState = tradeStateBuilder.build();
			objectValidator.validate(TradeState.class, tradeState);
		}
		
		return tradeState;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(ConfirmationAgreed fpmlConfirmationAgreed);

	protected abstract MapperS<? extends Trade> fpmlTrade(ConfirmationAgreed fpmlConfirmationAgreed);

	public static class MapConfirmationAgreedToTradeStateDefault extends MapConfirmationAgreedToTradeState {
		@Override
		protected TradeState.TradeStateBuilder doEvaluate(ConfirmationAgreed fpmlConfirmationAgreed) {
			TradeState.TradeStateBuilder tradeState = TradeState.builder();
			return assignOutput(tradeState, fpmlConfirmationAgreed);
		}
		
		protected TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder tradeState, ConfirmationAgreed fpmlConfirmationAgreed) {
			tradeState = toBuilder(mapTradeState.evaluate(MapperS.of(fpmlConfirmationAgreed).<Trade>map("getTrade", confirmationAgreed -> confirmationAgreed.getTrade()).get(), MapperS.of(fpmlConfirmationAgreed).<Party>mapC("getParty", confirmationAgreed -> confirmationAgreed.getParty()).getMulti(), MapperS.of(fpmlConfirmationAgreed).<Account>mapC("getAccount", confirmationAgreed -> confirmationAgreed.getAccount()).getMulti(), Collections.<BasicQuotation>emptyList(), Collections.<PartyTradeIdentifier>emptyList()));
			
			return Optional.ofNullable(tradeState)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Trade> fpmlTrade(ConfirmationAgreed fpmlConfirmationAgreed) {
			return MapperS.of(getFpmlTrade.evaluate(MapperS.of(fpmlConfirmationAgreed).<TradePackage>map("getTradePackage", confirmationAgreed -> confirmationAgreed.getTradePackage()).get(), MapperS.of(fpmlConfirmationAgreed).<Trade>map("getTrade", confirmationAgreed -> confirmationAgreed.getTrade()).get(), MapperS.of(fpmlConfirmationAgreed).<TradeNovationContent>map("getNovation", confirmationAgreed -> confirmationAgreed.getNovation()).get(), MapperS.of(fpmlConfirmationAgreed).<TradeNotionalChange>map("getTermination", confirmationAgreed -> confirmationAgreed.getTermination()).get(), MapperS.of(fpmlConfirmationAgreed).<TradeAmendmentContent>map("getAmendment", confirmationAgreed -> confirmationAgreed.getAmendment()).get()));
		}
	}
}
