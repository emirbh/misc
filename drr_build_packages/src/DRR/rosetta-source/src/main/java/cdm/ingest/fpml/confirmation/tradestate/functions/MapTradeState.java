package cdm.ingest.fpml.confirmation.tradestate.functions;

import cdm.event.common.TradeState;
import cdm.ingest.fpml.confirmation.payment.functions.MapTransferStateList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.Party;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTradeState.MapTradeStateDefault.class)
public abstract class MapTradeState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapTrade mapTrade;
	@Inject protected MapTransferStateList mapTransferStateList;

	/**
	* @param fpmlTrade 
	* @param fpmlPartyList 
	* @param fpmlAccountList 
	* @param fpmlQuoteList 
	* @param fpmlAdditionalPartyTradeIdentifierList Additional PartyTradeIdentifier - i.e., not specified on the FpML trade.
	* @return tradeState 
	*/
	public TradeState evaluate(Trade fpmlTrade, List<? extends Party> fpmlPartyList, List<? extends Account> fpmlAccountList, List<? extends BasicQuotation> fpmlQuoteList, List<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifierList) {
		TradeState.TradeStateBuilder tradeStateBuilder = doEvaluate(fpmlTrade, fpmlPartyList, fpmlAccountList, fpmlQuoteList, fpmlAdditionalPartyTradeIdentifierList);
		
		final TradeState tradeState;
		if (tradeStateBuilder == null) {
			tradeState = null;
		} else {
			tradeState = tradeStateBuilder.build();
			objectValidator.validate(TradeState.class, tradeState);
		}
		
		return tradeState;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(Trade fpmlTrade, List<? extends Party> fpmlPartyList, List<? extends Account> fpmlAccountList, List<? extends BasicQuotation> fpmlQuoteList, List<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifierList);

	public static class MapTradeStateDefault extends MapTradeState {
		@Override
		protected TradeState.TradeStateBuilder doEvaluate(Trade fpmlTrade, List<? extends Party> fpmlPartyList, List<? extends Account> fpmlAccountList, List<? extends BasicQuotation> fpmlQuoteList, List<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifierList) {
			if (fpmlPartyList == null) {
				fpmlPartyList = Collections.emptyList();
			}
			if (fpmlAccountList == null) {
				fpmlAccountList = Collections.emptyList();
			}
			if (fpmlQuoteList == null) {
				fpmlQuoteList = Collections.emptyList();
			}
			if (fpmlAdditionalPartyTradeIdentifierList == null) {
				fpmlAdditionalPartyTradeIdentifierList = Collections.emptyList();
			}
			TradeState.TradeStateBuilder tradeState = TradeState.builder();
			return assignOutput(tradeState, fpmlTrade, fpmlPartyList, fpmlAccountList, fpmlQuoteList, fpmlAdditionalPartyTradeIdentifierList);
		}
		
		protected TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder tradeState, Trade fpmlTrade, List<? extends Party> fpmlPartyList, List<? extends Account> fpmlAccountList, List<? extends BasicQuotation> fpmlQuoteList, List<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifierList) {
			tradeState = toBuilder(TradeState.builder()
				.setTrade(mapTrade.evaluate(fpmlTrade, fpmlPartyList, fpmlAccountList, fpmlQuoteList, fpmlAdditionalPartyTradeIdentifierList))
				.setTransferHistory(new ArrayList(mapTransferStateList.evaluate(fpmlTrade)))
				.build());
			
			return Optional.ofNullable(tradeState)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
