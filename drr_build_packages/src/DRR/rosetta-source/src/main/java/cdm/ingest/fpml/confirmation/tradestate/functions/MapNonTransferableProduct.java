package cdm.ingest.fpml.confirmation.tradestate.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.product.bondoption.functions.MapBondOptionNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.brokerequityoption.functions.MapBrokerEquityOptionNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.capfloor.functions.MapCapFloorNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.commodityforward.functions.MapCommodityForwardNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.commodityoption.functions.MapCommodityOptionNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.commodityswap.functions.MapCommoditySwapNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.commodityswaption.functions.MapCommoditySwaptionNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.correlationswap.functions.MapCorrelationSwapNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions.MapCreditDefaultSwapNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions.MapCreditDefaultSwapOptionNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.dividendswapoptiontransactionsupplement.functions.MapDividendSwapOptionTransactionSupplementNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions.MapDividendSwapTransactionSupplementNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.equityforward.functions.MapEquityForwardNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.equityoption.functions.MapEquityOptionNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.equityoptiontransactionsupplement.functions.MapEquityOptionTransactionSupplementNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.equityswaptransactionsupplement.functions.MapEquitySwapTransactionSupplementNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.fra.functions.MapFraNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.fxdigitaloption.functions.MapFxDigitalOptionNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.fxoption.functions.MapFxOptionNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.fxsingleleg.functions.MapFxSingleLegNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.fxswap.functions.MapFxSwapNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.fxvarianceswap.functions.MapFxVarianceSwapNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.fxvolatilityswap.functions.MapFxVolatilitySwapNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.genericproduct.functions.MapGenericProductNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.returnswap.functions.MapReturnSwapNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.swap.functions.MapSwapNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.swaption.functions.MapSwaptionNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.varianceoptiontransactionsupplement.functions.MapVarianceOptionTransactionSupplementNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.varianceswap.functions.MapVarianceSwapNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.varianceswaptransactionsupplement.functions.MapVarianceSwapTransactionSupplementNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.volatilityswap.functions.MapVolatilitySwapNonTransferableProduct;
import cdm.ingest.fpml.confirmation.product.volatilityswaptransactionsupplement.functions.MapVolatilitySwapTransactionSupplementNonTransferableProduct;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.bond.option.BondOption;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.com.CommodityForward;
import fpml.consolidated.com.CommodityOption;
import fpml.consolidated.com.CommoditySwap;
import fpml.consolidated.com.CommoditySwaption;
import fpml.consolidated.correlation.swaps.CorrelationSwap;
import fpml.consolidated.dividend.swaps.DividendSwapOptionTransactionSupplement;
import fpml.consolidated.dividend.swaps.DividendSwapTransactionSupplement;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.eq.shared.ReturnSwap;
import fpml.consolidated.eqd.BrokerEquityOption;
import fpml.consolidated.eqd.EquityForward;
import fpml.consolidated.eqd.EquityOption;
import fpml.consolidated.eqd.EquityOptionTransactionSupplement;
import fpml.consolidated.fpmlreturn.swaps.EquitySwapTransactionSupplement;
import fpml.consolidated.fx.FxDigitalOption;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.fx.FxSingleLeg;
import fpml.consolidated.fx.FxSwap;
import fpml.consolidated.fx.FxVarianceSwap;
import fpml.consolidated.fx.FxVolatilitySwap;
import fpml.consolidated.generic.GenericProduct;
import fpml.consolidated.ird.CapFloor;
import fpml.consolidated.ird.Fra;
import fpml.consolidated.ird.Swap;
import fpml.consolidated.ird.Swaption;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.CalculationAgent;
import fpml.consolidated.shared.Product;
import fpml.consolidated.variance.swaps.VarianceOptionTransactionSupplement;
import fpml.consolidated.variance.swaps.VarianceSwap;
import fpml.consolidated.variance.swaps.VarianceSwapTransactionSupplement;
import fpml.consolidated.volatility.swaps.VolatilitySwap;
import fpml.consolidated.volatility.swaps.VolatilitySwapTransactionSupplement;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapNonTransferableProduct.MapNonTransferableProductDefault.class)
public abstract class MapNonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBondOptionNonTransferableProduct mapBondOptionNonTransferableProduct;
	@Inject protected MapBrokerEquityOptionNonTransferableProduct mapBrokerEquityOptionNonTransferableProduct;
	@Inject protected MapCalculationAgent mapCalculationAgent;
	@Inject protected MapCapFloorNonTransferableProduct mapCapFloorNonTransferableProduct;
	@Inject protected MapCommodityForwardNonTransferableProduct mapCommodityForwardNonTransferableProduct;
	@Inject protected MapCommodityOptionNonTransferableProduct mapCommodityOptionNonTransferableProduct;
	@Inject protected MapCommoditySwapNonTransferableProduct mapCommoditySwapNonTransferableProduct;
	@Inject protected MapCommoditySwaptionNonTransferableProduct mapCommoditySwaptionNonTransferableProduct;
	@Inject protected MapCorrelationSwapNonTransferableProduct mapCorrelationSwapNonTransferableProduct;
	@Inject protected MapCreditDefaultSwapNonTransferableProduct mapCreditDefaultSwapNonTransferableProduct;
	@Inject protected MapCreditDefaultSwapOptionNonTransferableProduct mapCreditDefaultSwapOptionNonTransferableProduct;
	@Inject protected MapDividendSwapOptionTransactionSupplementNonTransferableProduct mapDividendSwapOptionTransactionSupplementNonTransferableProduct;
	@Inject protected MapDividendSwapTransactionSupplementNonTransferableProduct mapDividendSwapTransactionSupplementNonTransferableProduct;
	@Inject protected MapEquityForwardNonTransferableProduct mapEquityForwardNonTransferableProduct;
	@Inject protected MapEquityOptionNonTransferableProduct mapEquityOptionNonTransferableProduct;
	@Inject protected MapEquityOptionTransactionSupplementNonTransferableProduct mapEquityOptionTransactionSupplementNonTransferableProduct;
	@Inject protected MapEquitySwapTransactionSupplementNonTransferableProduct mapEquitySwapTransactionSupplementNonTransferableProduct;
	@Inject protected MapFraNonTransferableProduct mapFraNonTransferableProduct;
	@Inject protected MapFxDigitalOptionNonTransferableProduct mapFxDigitalOptionNonTransferableProduct;
	@Inject protected MapFxOptionNonTransferableProduct mapFxOptionNonTransferableProduct;
	@Inject protected MapFxSingleLegNonTransferableProduct mapFxSingleLegNonTransferableProduct;
	@Inject protected MapFxSwapNonTransferableProduct mapFxSwapNonTransferableProduct;
	@Inject protected MapFxVarianceSwapNonTransferableProduct mapFxVarianceSwapNonTransferableProduct;
	@Inject protected MapFxVolatilitySwapNonTransferableProduct mapFxVolatilitySwapNonTransferableProduct;
	@Inject protected MapGenericProductNonTransferableProduct mapGenericProductNonTransferableProduct;
	@Inject protected MapReturnSwapNonTransferableProduct mapReturnSwapNonTransferableProduct;
	@Inject protected MapSwapNonTransferableProduct mapSwapNonTransferableProduct;
	@Inject protected MapSwaptionNonTransferableProduct mapSwaptionNonTransferableProduct;
	@Inject protected MapVarianceOptionTransactionSupplementNonTransferableProduct mapVarianceOptionTransactionSupplementNonTransferableProduct;
	@Inject protected MapVarianceSwapNonTransferableProduct mapVarianceSwapNonTransferableProduct;
	@Inject protected MapVarianceSwapTransactionSupplementNonTransferableProduct mapVarianceSwapTransactionSupplementNonTransferableProduct;
	@Inject protected MapVolatilitySwapNonTransferableProduct mapVolatilitySwapNonTransferableProduct;
	@Inject protected MapVolatilitySwapTransactionSupplementNonTransferableProduct mapVolatilitySwapTransactionSupplementNonTransferableProduct;

	/**
	* @param fpmlTrade 
	* @param cdmCounterpartyList 
	* @return nonTransferableProduct 
	*/
	public NonTransferableProduct evaluate(Trade fpmlTrade, List<? extends Counterparty> cdmCounterpartyList) {
		NonTransferableProduct.NonTransferableProductBuilder nonTransferableProductBuilder = doEvaluate(fpmlTrade, cdmCounterpartyList);
		
		final NonTransferableProduct nonTransferableProduct;
		if (nonTransferableProductBuilder == null) {
			nonTransferableProduct = null;
		} else {
			nonTransferableProduct = nonTransferableProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, nonTransferableProduct);
		}
		
		return nonTransferableProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(Trade fpmlTrade, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapNonTransferableProductDefault extends MapNonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(Trade fpmlTrade, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct = NonTransferableProduct.builder();
			return assignOutput(nonTransferableProduct, fpmlTrade, cdmCounterpartyList);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder nonTransferableProduct, Trade fpmlTrade, List<? extends Counterparty> cdmCounterpartyList) {
			if (exists(MapperS.of(fpmlTrade).<Product>map("getProduct", trade -> trade.getProduct())).getOrDefault(false)) {
				final Product switchArgument = MapperS.of(fpmlTrade).<Product>map("getProduct", trade -> trade.getProduct()).get();
				if (switchArgument == null) {
					nonTransferableProduct = null;
				} else if (switchArgument instanceof BondOption) {
					final BondOption bondOption = (BondOption) switchArgument;
					nonTransferableProduct = toBuilder(mapBondOptionNonTransferableProduct.evaluate(bondOption, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof BrokerEquityOption) {
					final BrokerEquityOption brokerEquityOption = (BrokerEquityOption) switchArgument;
					nonTransferableProduct = toBuilder(mapBrokerEquityOptionNonTransferableProduct.evaluate(brokerEquityOption, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof CapFloor) {
					final CapFloor capFloor = (CapFloor) switchArgument;
					nonTransferableProduct = toBuilder(mapCapFloorNonTransferableProduct.evaluate(capFloor, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof CommodityForward) {
					final CommodityForward commodityForward = (CommodityForward) switchArgument;
					nonTransferableProduct = toBuilder(mapCommodityForwardNonTransferableProduct.evaluate(commodityForward, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof CommodityOption) {
					final CommodityOption commodityOption = (CommodityOption) switchArgument;
					nonTransferableProduct = toBuilder(mapCommodityOptionNonTransferableProduct.evaluate(commodityOption, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof CommoditySwap) {
					final CommoditySwap commoditySwap = (CommoditySwap) switchArgument;
					nonTransferableProduct = toBuilder(mapCommoditySwapNonTransferableProduct.evaluate(commoditySwap, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof CommoditySwaption) {
					final CommoditySwaption commoditySwaption = (CommoditySwaption) switchArgument;
					nonTransferableProduct = toBuilder(mapCommoditySwaptionNonTransferableProduct.evaluate(commoditySwaption, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof CorrelationSwap) {
					final CorrelationSwap correlationSwap = (CorrelationSwap) switchArgument;
					nonTransferableProduct = toBuilder(mapCorrelationSwapNonTransferableProduct.evaluate(correlationSwap, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof CreditDefaultSwap) {
					final CreditDefaultSwap creditDefaultSwap = (CreditDefaultSwap) switchArgument;
					nonTransferableProduct = toBuilder(mapCreditDefaultSwapNonTransferableProduct.evaluate(creditDefaultSwap, MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).get(), cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof CreditDefaultSwapOption) {
					final CreditDefaultSwapOption creditDefaultSwapOption = (CreditDefaultSwapOption) switchArgument;
					nonTransferableProduct = toBuilder(mapCreditDefaultSwapOptionNonTransferableProduct.evaluate(creditDefaultSwapOption, cdmCounterpartyList, MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).get()), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof DividendSwapOptionTransactionSupplement) {
					final DividendSwapOptionTransactionSupplement dividendSwapOptionTransactionSupplement = (DividendSwapOptionTransactionSupplement) switchArgument;
					nonTransferableProduct = toBuilder(mapDividendSwapOptionTransactionSupplementNonTransferableProduct.evaluate(dividendSwapOptionTransactionSupplement, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof DividendSwapTransactionSupplement) {
					final DividendSwapTransactionSupplement dividendSwapTransactionSupplement = (DividendSwapTransactionSupplement) switchArgument;
					nonTransferableProduct = toBuilder(mapDividendSwapTransactionSupplementNonTransferableProduct.evaluate(dividendSwapTransactionSupplement, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof EquityForward) {
					final EquityForward equityForward = (EquityForward) switchArgument;
					nonTransferableProduct = toBuilder(mapEquityForwardNonTransferableProduct.evaluate(equityForward, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof EquityOption) {
					final EquityOption equityOption = (EquityOption) switchArgument;
					nonTransferableProduct = toBuilder(mapEquityOptionNonTransferableProduct.evaluate(equityOption, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof EquityOptionTransactionSupplement) {
					final EquityOptionTransactionSupplement equityOptionTransactionSupplement = (EquityOptionTransactionSupplement) switchArgument;
					nonTransferableProduct = toBuilder(mapEquityOptionTransactionSupplementNonTransferableProduct.evaluate(equityOptionTransactionSupplement, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof EquitySwapTransactionSupplement) {
					final EquitySwapTransactionSupplement equitySwapTransactionSupplement = (EquitySwapTransactionSupplement) switchArgument;
					nonTransferableProduct = toBuilder(mapEquitySwapTransactionSupplementNonTransferableProduct.evaluate(equitySwapTransactionSupplement, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof Fra) {
					final Fra fra = (Fra) switchArgument;
					nonTransferableProduct = toBuilder(mapFraNonTransferableProduct.evaluate(fra, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof FxOption) {
					final FxOption fxOption = (FxOption) switchArgument;
					nonTransferableProduct = toBuilder(mapFxOptionNonTransferableProduct.evaluate(fxOption, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof FxDigitalOption) {
					final FxDigitalOption fxDigitalOption = (FxDigitalOption) switchArgument;
					nonTransferableProduct = toBuilder(mapFxDigitalOptionNonTransferableProduct.evaluate(fxDigitalOption, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof FxSingleLeg) {
					final FxSingleLeg fxSingleLeg = (FxSingleLeg) switchArgument;
					nonTransferableProduct = toBuilder(mapFxSingleLegNonTransferableProduct.evaluate(fxSingleLeg, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof FxSwap) {
					final FxSwap fxSwap = (FxSwap) switchArgument;
					nonTransferableProduct = toBuilder(mapFxSwapNonTransferableProduct.evaluate(fxSwap, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof FxVarianceSwap) {
					final FxVarianceSwap fxVarianceSwap = (FxVarianceSwap) switchArgument;
					nonTransferableProduct = toBuilder(mapFxVarianceSwapNonTransferableProduct.evaluate(fxVarianceSwap, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof FxVolatilitySwap) {
					final FxVolatilitySwap fxVolatilitySwap = (FxVolatilitySwap) switchArgument;
					nonTransferableProduct = toBuilder(mapFxVolatilitySwapNonTransferableProduct.evaluate(fxVolatilitySwap, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof GenericProduct) {
					final GenericProduct genericProduct = (GenericProduct) switchArgument;
					nonTransferableProduct = toBuilder(mapGenericProductNonTransferableProduct.evaluate(genericProduct, cdmCounterpartyList, MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation()).getMulti()), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof ReturnSwap) {
					final ReturnSwap returnSwap = (ReturnSwap) switchArgument;
					nonTransferableProduct = toBuilder(mapReturnSwapNonTransferableProduct.evaluate(returnSwap, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof Swap) {
					final Swap swap = (Swap) switchArgument;
					nonTransferableProduct = toBuilder(mapSwapNonTransferableProduct.evaluate(swap, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof Swaption) {
					final Swaption swaption = (Swaption) switchArgument;
					nonTransferableProduct = toBuilder(mapSwaptionNonTransferableProduct.evaluate(swaption, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof VarianceOptionTransactionSupplement) {
					final VarianceOptionTransactionSupplement varianceOptionTransactionSupplement = (VarianceOptionTransactionSupplement) switchArgument;
					nonTransferableProduct = toBuilder(mapVarianceOptionTransactionSupplementNonTransferableProduct.evaluate(varianceOptionTransactionSupplement, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof VarianceSwap) {
					final VarianceSwap varianceSwap = (VarianceSwap) switchArgument;
					nonTransferableProduct = toBuilder(mapVarianceSwapNonTransferableProduct.evaluate(varianceSwap, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof VarianceSwapTransactionSupplement) {
					final VarianceSwapTransactionSupplement varianceSwapTransactionSupplement = (VarianceSwapTransactionSupplement) switchArgument;
					nonTransferableProduct = toBuilder(mapVarianceSwapTransactionSupplementNonTransferableProduct.evaluate(varianceSwapTransactionSupplement, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof VolatilitySwap) {
					final VolatilitySwap volatilitySwap = (VolatilitySwap) switchArgument;
					nonTransferableProduct = toBuilder(mapVolatilitySwapNonTransferableProduct.evaluate(volatilitySwap, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else if (switchArgument instanceof VolatilitySwapTransactionSupplement) {
					final VolatilitySwapTransactionSupplement volatilitySwapTransactionSupplement = (VolatilitySwapTransactionSupplement) switchArgument;
					nonTransferableProduct = toBuilder(mapVolatilitySwapTransactionSupplementNonTransferableProduct.evaluate(volatilitySwapTransactionSupplement, cdmCounterpartyList), () -> NonTransferableProduct.builder());
				} else {
					nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
						.setEconomicTerms(null)
						.build(), () -> NonTransferableProduct.builder());
				}
			} else {
				nonTransferableProduct = toBuilder(NonTransferableProduct.builder()
					.setEconomicTerms(null)
					.build(), () -> NonTransferableProduct.builder());
			}
			
			nonTransferableProduct
				.getOrCreateEconomicTerms()
				.setCalculationAgent(mapCalculationAgent.evaluate(MapperS.of(fpmlTrade).<CalculationAgent>map("getCalculationAgent", trade -> trade.getCalculationAgent()).get(), MapperS.of(fpmlTrade).<BusinessCenter>map("getCalculationAgentBusinessCenter", trade -> trade.getCalculationAgentBusinessCenter()).get()));
			
			Boolean ifThenElseResult = null;
			if (exists(MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation()).<Boolean>map("getNonStandardTerms", partyTradeInformation -> partyTradeInformation.getNonStandardTerms())).getOrDefault(false)) {
				ifThenElseResult = areEqual(MapperS.of(fpmlTrade).<TradeHeader>map("getTradeHeader", trade -> trade.getTradeHeader()).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation()).<Boolean>map("getNonStandardTerms", partyTradeInformation -> partyTradeInformation.getNonStandardTerms()), MapperS.of(true), CardinalityOperator.Any).get();
			}
			nonTransferableProduct
				.getOrCreateEconomicTerms()
				.setNonStandardisedTerms(ifThenElseResult);
			
			return Optional.ofNullable(nonTransferableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
