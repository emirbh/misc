package drr.standards.iosco.cde.version1.party.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.TradableProductForEvent;
import drr.base.trade.functions.TradeForEvent;
import drr.base.util.party.functions.PartyLei;
import drr.standards.iosco.cde.version1.party.reports.Counterparty1Rule;
import drr.standards.iso.Direction1Enum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Direction1.Direction1Default.class)
public abstract class Direction1 implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Direction1BuyerParty direction1BuyerParty;
	@Inject protected Direction1SellerParty direction1SellerParty;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected PartyLei partyLei;
	@Inject protected TradableProductForEvent tradableProductForEvent;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param event 
	* @return direction 
	*/
	public Direction1Enum evaluate(TransactionReportInstructionBase event) {
		Direction1Enum direction = doEvaluate(event);
		
		return direction;
	}

	protected abstract Direction1Enum doEvaluate(TransactionReportInstructionBase event);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(TransactionReportInstructionBase event);

	protected abstract MapperC<? extends Payout> productPayout(TransactionReportInstructionBase event);

	protected abstract MapperS<? extends TradableProduct> tradableProduct(TransactionReportInstructionBase event);

	protected abstract MapperS<String> reportingParty(TransactionReportInstructionBase event);

	protected abstract MapperS<? extends Party> buyer(TransactionReportInstructionBase event);

	protected abstract MapperS<? extends Party> seller(TransactionReportInstructionBase event);

	public static class Direction1Default extends Direction1 {
		@Override
		protected Direction1Enum doEvaluate(TransactionReportInstructionBase event) {
			Direction1Enum direction = null;
			return assignOutput(direction, event);
		}
		
		protected Direction1Enum assignOutput(Direction1Enum direction, TransactionReportInstructionBase event) {
			if (exists(reportingParty(event)).andNullSafe(areEqual(reportingParty(event), MapperS.of(partyLei.evaluate(buyer(event).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).getMulti())), CardinalityOperator.All)).getOrDefault(false)) {
				direction = Direction1Enum.BYER;
			} else if (exists(reportingParty(event)).andNullSafe(areEqual(reportingParty(event), MapperS.of(partyLei.evaluate(seller(event).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).getMulti())), CardinalityOperator.All)).getOrDefault(false)) {
				direction = Direction1Enum.SLLR;
			} else {
				direction = null;
			}
			
			return direction;
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(TransactionReportInstructionBase event) {
			return tradableProduct(event).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
		
		@Override
		protected MapperC<? extends Payout> productPayout(TransactionReportInstructionBase event) {
			return MapperS.of(economicTermsForProduct.evaluate(tradableProduct(event).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).get())).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout());
		}
		
		@Override
		protected MapperS<? extends TradableProduct> tradableProduct(TransactionReportInstructionBase event) {
			return MapperS.of(tradableProductForEvent.evaluate(event));
		}
		
		@Override
		protected MapperS<String> reportingParty(TransactionReportInstructionBase event) {
			return MapperS.of(counterparty1Rule.evaluate(event));
		}
		
		@Override
		protected MapperS<? extends Party> buyer(TransactionReportInstructionBase event) {
			return MapperS.of(direction1BuyerParty.evaluate(tradeForEvent.evaluate(event)));
		}
		
		@Override
		protected MapperS<? extends Party> seller(TransactionReportInstructionBase event) {
			return MapperS.of(direction1SellerParty.evaluate(tradeForEvent.evaluate(event)));
		}
	}
}
