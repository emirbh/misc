package cdm.ingest.fpml.confirmation.tradestate.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.event.common.Trade;
import cdm.ingest.fpml.confirmation.datetime.functions.MapIdentifiedDate;
import cdm.ingest.fpml.confirmation.header.functions.MapTradeIdentifierList;
import cdm.ingest.fpml.confirmation.legal.functions.MapContractDetails;
import cdm.ingest.fpml.confirmation.other.functions.MapNotionalAdjustmentEnum;
import cdm.ingest.fpml.confirmation.party.functions.MapAccountList;
import cdm.ingest.fpml.confirmation.party.functions.MapAncillaryPartyList;
import cdm.ingest.fpml.confirmation.party.functions.MapCounterpartyList;
import cdm.ingest.fpml.confirmation.party.functions.MapPartyList;
import cdm.ingest.fpml.confirmation.party.functions.MapPartyRoleList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.Party;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTrade.MapTradeDefault.class)
public abstract class MapTrade implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractNotionalAdjustmentByLeg extractNotionalAdjustmentByLeg;
	@Inject protected MapAccountList mapAccountList;
	@Inject protected MapAncillaryPartyList mapAncillaryPartyList;
	@Inject protected MapCollateral mapCollateral;
	@Inject protected MapContractDetails mapContractDetails;
	@Inject protected MapCounterpartyList mapCounterpartyList;
	@Inject protected MapExecutionDetails mapExecutionDetails;
	@Inject protected MapIdentifiedDate mapIdentifiedDate;
	@Inject protected MapNonTransferableProduct mapNonTransferableProduct;
	@Inject protected MapNotionalAdjustmentEnum mapNotionalAdjustmentEnum;
	@Inject protected MapPartyList mapPartyList;
	@Inject protected MapPartyRoleList mapPartyRoleList;
	@Inject protected MapTradeIdentifierList mapTradeIdentifierList;
	@Inject protected MapTradeLotList mapTradeLotList;

	/**
	* @param fpmlTrade 
	* @param fpmlPartyList 
	* @param fpmlAccountList 
	* @param fpmlQuoteList 
	* @param fpmlAdditionalPartyTradeIdentifierList Additional PartyTradeIdentifier - i.e., not specified on the FpML trade.
	* @return trade 
	*/
	public Trade evaluate(fpml.consolidated.doc.Trade fpmlTrade, List<? extends Party> fpmlPartyList, List<? extends Account> fpmlAccountList, List<? extends BasicQuotation> fpmlQuoteList, List<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifierList) {
		Trade.TradeBuilder tradeBuilder = doEvaluate(fpmlTrade, fpmlPartyList, fpmlAccountList, fpmlQuoteList, fpmlAdditionalPartyTradeIdentifierList);
		
		final Trade trade;
		if (tradeBuilder == null) {
			trade = null;
		} else {
			trade = tradeBuilder.build();
			objectValidator.validate(Trade.class, trade);
		}
		
		return trade;
	}

	protected abstract Trade.TradeBuilder doEvaluate(fpml.consolidated.doc.Trade fpmlTrade, List<? extends Party> fpmlPartyList, List<? extends Account> fpmlAccountList, List<? extends BasicQuotation> fpmlQuoteList, List<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifierList);

	protected abstract MapperC<? extends Counterparty> counterpartyList(fpml.consolidated.doc.Trade fpmlTrade, List<? extends Party> fpmlPartyList, List<? extends Account> fpmlAccountList, List<? extends BasicQuotation> fpmlQuoteList, List<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifierList);

	public static class MapTradeDefault extends MapTrade {
		@Override
		protected Trade.TradeBuilder doEvaluate(fpml.consolidated.doc.Trade fpmlTrade, List<? extends Party> fpmlPartyList, List<? extends Account> fpmlAccountList, List<? extends BasicQuotation> fpmlQuoteList, List<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifierList) {
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
			Trade.TradeBuilder trade = Trade.builder();
			return assignOutput(trade, fpmlTrade, fpmlPartyList, fpmlAccountList, fpmlQuoteList, fpmlAdditionalPartyTradeIdentifierList);
		}
		
		protected Trade.TradeBuilder assignOutput(Trade.TradeBuilder trade, fpml.consolidated.doc.Trade fpmlTrade, List<? extends Party> fpmlPartyList, List<? extends Account> fpmlAccountList, List<? extends BasicQuotation> fpmlQuoteList, List<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifierList) {
			trade = toBuilder(Trade.builder()
				.setProduct(mapNonTransferableProduct.evaluate(fpmlTrade, counterpartyList(fpmlTrade, fpmlPartyList, fpmlAccountList, fpmlQuoteList, fpmlAdditionalPartyTradeIdentifierList).getMulti()))
				.setTradeLot(new ArrayList(mapTradeLotList.evaluate(fpmlTrade, fpmlQuoteList)))
				.setCounterparty(new ArrayList<>(counterpartyList(fpmlTrade, fpmlPartyList, fpmlAccountList, fpmlQuoteList, fpmlAdditionalPartyTradeIdentifierList).getMulti()))
				.setAncillaryParty(new ArrayList(mapAncillaryPartyList.evaluate(fpmlTrade, counterpartyList(fpmlTrade, fpmlPartyList, fpmlAccountList, fpmlQuoteList, fpmlAdditionalPartyTradeIdentifierList).getMulti())))
				.setAdjustment(mapNotionalAdjustmentEnum.evaluate(extractNotionalAdjustmentByLeg.evaluate(fpmlTrade)))
				.setTradeIdentifier(new ArrayList(mapTradeIdentifierList.evaluate(MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", _trade -> _trade.getTradeHeader()).get(), fpmlAdditionalPartyTradeIdentifierList)))
				.setTradeDate(mapIdentifiedDate.evaluate(MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", _trade -> _trade.getTradeHeader()).<IdentifiedDate>map("getTradeDate", tradeHeader -> tradeHeader.getTradeDate()).get()))
				.setParty(new ArrayList(mapPartyList.evaluate(fpmlPartyList, MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", _trade -> _trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation()).getMulti())))
				.setPartyRole(new ArrayList(mapPartyRoleList.evaluate(fpmlTrade)))
				.setContractDetails(mapContractDetails.evaluate(fpmlTrade, counterpartyList(fpmlTrade, fpmlPartyList, fpmlAccountList, fpmlQuoteList, fpmlAdditionalPartyTradeIdentifierList).getMulti()))
				.setAccount(new ArrayList(mapAccountList.evaluate(fpmlTrade, fpmlAccountList)))
				.setCollateral(mapCollateral.evaluate(MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", _trade -> _trade.getTradeHeader()).get()))
				.setExecutionDetails(mapExecutionDetails.evaluate(fpmlTrade, fpmlQuoteList))
				.build());
			
			return Optional.ofNullable(trade)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends Counterparty> counterpartyList(fpml.consolidated.doc.Trade fpmlTrade, List<? extends Party> fpmlPartyList, List<? extends Account> fpmlAccountList, List<? extends BasicQuotation> fpmlQuoteList, List<? extends PartyTradeIdentifier> fpmlAdditionalPartyTradeIdentifierList) {
			return MapperC.<Counterparty>of(mapCounterpartyList.evaluate(fpmlTrade));
		}
	}
}
