package drr.standards.iosco.cde.version1.party.functions;

import cdm.base.staticdata.party.BuyerSeller;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.functions.ExtractCounterpartyByRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.Trade;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.qualification.functions.Qualify_InterestRate_Forward_Debt;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCapFloor;
import drr.base.qualification.product.functions.IsCommodityForward;
import drr.base.qualification.product.functions.IsCredit;
import drr.base.qualification.product.functions.IsEquityForward;
import drr.base.qualification.product.functions.IsProductETD;
import drr.base.qualification.product.functions.IsSingleCommodityPayoutProduct;
import drr.base.qualification.product.functions.IsTotalReturnSwapDebtUnderlier;
import drr.base.qualification.product.functions.IsVarianceSwap;
import drr.base.qualification.product.functions.IsVolatilitySwap;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.standards.iso.Direction1Enum;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Direction1BuyerParty.Direction1BuyerPartyDefault.class)
public abstract class Direction1BuyerParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CapFloorPayerReceiver capFloorPayerReceiver;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ExtractCounterpartyByRole extractCounterpartyByRole;
	@Inject protected IsCapFloor isCapFloor;
	@Inject protected IsCommodityForward isCommodityForward;
	@Inject protected IsCredit isCredit;
	@Inject protected IsEquityForward isEquityForward;
	@Inject protected IsProductETD isProductETD;
	@Inject protected IsSingleCommodityPayoutProduct isSingleCommodityPayoutProduct;
	@Inject protected IsTotalReturnSwapDebtUnderlier isTotalReturnSwapDebtUnderlier;
	@Inject protected IsVarianceSwap isVarianceSwap;
	@Inject protected IsVolatilitySwap isVolatilitySwap;
	@Inject protected Qualify_InterestRate_Forward_Debt qualify_InterestRate_Forward_Debt;

	/**
	* @param trade 
	* @return party 
	*/
	public Party evaluate(Trade trade) {
		Party.PartyBuilder partyBuilder = doEvaluate(trade);
		
		final Party party;
		if (partyBuilder == null) {
			party = null;
		} else {
			party = partyBuilder.build();
			objectValidator.validate(Party.class, party);
		}
		
		return party;
	}

	protected abstract Party.PartyBuilder doEvaluate(Trade trade);

	protected abstract MapperC<? extends Payout> productPayout(Trade trade);

	protected abstract MapperS<? extends Counterparty> counterparty(Trade trade);

	public static class Direction1BuyerPartyDefault extends Direction1BuyerParty {
		@Override
		protected Party.PartyBuilder doEvaluate(Trade trade) {
			Party.PartyBuilder party = Party.builder();
			return assignOutput(party, trade);
		}
		
		protected Party.PartyBuilder assignOutput(Party.PartyBuilder party, Trade trade) {
			final ReferenceWithMetaParty referenceWithMetaParty = counterparty(trade).<ReferenceWithMetaParty>map("getPartyReference", _counterparty -> _counterparty.getPartyReference()).get();
			if (referenceWithMetaParty == null) {
				party = null;
			} else {
				party = toBuilder(referenceWithMetaParty.getValue());
			}
			
			return Optional.ofNullable(party)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends Payout> productPayout(Trade trade) {
			return MapperS.of(economicTermsForProduct.evaluate(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout());
		}
		
		@Override
		protected MapperS<? extends Counterparty> counterparty(Trade trade) {
			if (exists(productPayout(trade).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout())).getOrDefault(false)) {
				return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(trade).<Counterparty>mapC("getCounterparty", _trade -> _trade.getCounterparty()).getMulti(), productPayout(trade).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<BuyerSeller>map("getBuyerSeller", optionPayout -> optionPayout.getBuyerSeller()).<CounterpartyRoleEnum>map("getBuyer", buyerSeller -> buyerSeller.getBuyer()).get()));
			}
			final Boolean boolean0 = isCredit.evaluate(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).get());
			if ((boolean0 == null ? false : boolean0)) {
				return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(trade).<Counterparty>mapC("getCounterparty", _trade -> _trade.getCounterparty()).getMulti(), productPayout(trade).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<PayerReceiver>map("getPayerReceiver", creditDefaultPayout -> creditDefaultPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", payerReceiver -> payerReceiver.getReceiver()).get()));
			}
			if (ComparisonResult.ofNullSafe(MapperS.of(isVarianceSwap.evaluate(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isVolatilitySwap.evaluate(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isTotalReturnSwapDebtUnderlier.evaluate(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).get())))).getOrDefault(false)) {
				return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(trade).<Counterparty>mapC("getCounterparty", _trade -> _trade.getCounterparty()).getMulti(), productPayout(trade).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<PayerReceiver>map("getPayerReceiver", performancePayout -> performancePayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", payerReceiver -> payerReceiver.getReceiver()).get()));
			}
			final Boolean boolean1 = isCapFloor.evaluate(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).get());
			if ((boolean1 == null ? false : boolean1)) {
				return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(trade).<Counterparty>mapC("getCounterparty", _trade -> _trade.getCounterparty()).getMulti(), MapperS.of(capFloorPayerReceiver.evaluate(productPayout(trade).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).get(), Direction1Enum.BYER)).getOrDefault(productPayout(trade).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<PayerReceiver>map("getPayerReceiver", interestRatePayout -> interestRatePayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", payerReceiver -> payerReceiver.getReceiver()).get())));
			}
			if (ComparisonResult.ofNullSafe(MapperS.of(isProductETD.evaluate(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).get()))).andNullSafe(exists(productPayout(trade).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_Forward_Debt.evaluate(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isEquityForward.evaluate(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).get()))).andNullSafe(exists(productPayout(trade).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout())))).getOrDefault(false)) {
				return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(trade).<Counterparty>mapC("getCounterparty", _trade -> _trade.getCounterparty()).getMulti(), productPayout(trade).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<PayerReceiver>map("getPayerReceiver", settlementPayout -> settlementPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer()).get()));
			}
			final Boolean boolean2 = isSingleCommodityPayoutProduct.evaluate(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).get());
			if ((boolean2 == null ? false : boolean2)) {
				return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(trade).<Counterparty>mapC("getCounterparty", _trade -> _trade.getCounterparty()).getMulti(), productPayout(trade).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<PayerReceiver>map("getPayerReceiver", commodityPayout -> commodityPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer()).get()));
			}
			final Boolean boolean3 = isCommodityForward.evaluate(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).get());
			if ((boolean3 == null ? false : boolean3)) {
				return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(trade).<Counterparty>mapC("getCounterparty", _trade -> _trade.getCounterparty()).getMulti(), productPayout(trade).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<PayerReceiver>map("getPayerReceiver", settlementPayout -> settlementPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", payerReceiver -> payerReceiver.getReceiver()).get()));
			}
			return MapperS.<Counterparty>ofNull();
		}
	}
}
