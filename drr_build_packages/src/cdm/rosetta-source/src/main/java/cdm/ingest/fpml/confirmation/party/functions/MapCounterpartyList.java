package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.product.bondoption.functions.MapBondOptionCounterpartyList;
import cdm.ingest.fpml.confirmation.product.brokerequityoption.functions.MapBrokerEquityOptionCounterpartyList;
import cdm.ingest.fpml.confirmation.product.capfloor.functions.MapCapFloorCounterpartyList;
import cdm.ingest.fpml.confirmation.product.commodityforward.functions.MapCommodityForwardCounterpartyList;
import cdm.ingest.fpml.confirmation.product.commodityoption.functions.MapCommodityOptionCounterpartyList;
import cdm.ingest.fpml.confirmation.product.commodityswap.functions.MapCommoditySwapCounterpartyList;
import cdm.ingest.fpml.confirmation.product.commodityswaption.functions.MapCommoditySwaptionCounterpartyList;
import cdm.ingest.fpml.confirmation.product.correlationswap.functions.MapCorrelationSwapCounterpartyList;
import cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions.MapCreditDefaultSwapCounterpartyList;
import cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions.MapCreditDefaultSwapOptionCounterpartyList;
import cdm.ingest.fpml.confirmation.product.dividendswapoptiontransactionsupplement.functions.MapDividendSwapOptionTransactionSupplementCounterpartyList;
import cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions.MapDividendSwapTransactionSupplementCounterpartyList;
import cdm.ingest.fpml.confirmation.product.equityforward.functions.MapEquityForwardCounterpartyList;
import cdm.ingest.fpml.confirmation.product.equityoption.functions.MapEquityOptionCounterpartyList;
import cdm.ingest.fpml.confirmation.product.equityoptiontransactionsupplement.functions.MapEquityOptionTransactionSupplementCounterpartyList;
import cdm.ingest.fpml.confirmation.product.equityswaptransactionsupplement.functions.MapEquitySwapTransactionSupplementCounterpartyList;
import cdm.ingest.fpml.confirmation.product.fra.functions.MapFraCounterpartyList;
import cdm.ingest.fpml.confirmation.product.fxdigitaloption.functions.MapFxDigitalOptionCounterpartyList;
import cdm.ingest.fpml.confirmation.product.fxoption.functions.MapFxOptionCounterpartyList;
import cdm.ingest.fpml.confirmation.product.fxsingleleg.functions.MapFxSingleLegCounterpartyList;
import cdm.ingest.fpml.confirmation.product.fxswap.functions.MapFxSwapCounterpartyList;
import cdm.ingest.fpml.confirmation.product.fxvarianceswap.functions.MapFxVarianceSwapCounterpartyList;
import cdm.ingest.fpml.confirmation.product.fxvolatilityswap.functions.MapFxVolatilitySwapCounterpartyList;
import cdm.ingest.fpml.confirmation.product.genericproduct.functions.MapGenericProductCounterpartyList;
import cdm.ingest.fpml.confirmation.product.returnswap.functions.MapReturnSwapCounterpartyList;
import cdm.ingest.fpml.confirmation.product.swap.functions.MapSwapCounterpartyList;
import cdm.ingest.fpml.confirmation.product.swaption.functions.MapSwaptionCounterpartyList;
import cdm.ingest.fpml.confirmation.product.varianceoptiontransactionsupplement.functions.MapVarianceOptionTransactionSupplementCounterpartyList;
import cdm.ingest.fpml.confirmation.product.varianceswap.functions.MapVarianceSwapCounterpartyList;
import cdm.ingest.fpml.confirmation.product.varianceswaptransactionsupplement.functions.MapVarianceSwapTransactionSupplementCounterpartyList;
import cdm.ingest.fpml.confirmation.product.volatilityswap.functions.MapVolatilitySwapCounterpartyList;
import cdm.ingest.fpml.confirmation.product.volatilityswaptransactionsupplement.functions.MapVolatilitySwapTransactionSupplementCounterpartyList;
import com.google.inject.ImplementedBy;
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
import fpml.consolidated.doc.Trade;
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
import fpml.consolidated.shared.Product;
import fpml.consolidated.variance.swaps.VarianceOptionTransactionSupplement;
import fpml.consolidated.variance.swaps.VarianceSwap;
import fpml.consolidated.variance.swaps.VarianceSwapTransactionSupplement;
import fpml.consolidated.volatility.swaps.VolatilitySwap;
import fpml.consolidated.volatility.swaps.VolatilitySwapTransactionSupplement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCounterpartyList.MapCounterpartyListDefault.class)
public abstract class MapCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBondOptionCounterpartyList mapBondOptionCounterpartyList;
	@Inject protected MapBrokerEquityOptionCounterpartyList mapBrokerEquityOptionCounterpartyList;
	@Inject protected MapCapFloorCounterpartyList mapCapFloorCounterpartyList;
	@Inject protected MapCommodityForwardCounterpartyList mapCommodityForwardCounterpartyList;
	@Inject protected MapCommodityOptionCounterpartyList mapCommodityOptionCounterpartyList;
	@Inject protected MapCommoditySwapCounterpartyList mapCommoditySwapCounterpartyList;
	@Inject protected MapCommoditySwaptionCounterpartyList mapCommoditySwaptionCounterpartyList;
	@Inject protected MapCorrelationSwapCounterpartyList mapCorrelationSwapCounterpartyList;
	@Inject protected MapCreditDefaultSwapCounterpartyList mapCreditDefaultSwapCounterpartyList;
	@Inject protected MapCreditDefaultSwapOptionCounterpartyList mapCreditDefaultSwapOptionCounterpartyList;
	@Inject protected MapDividendSwapOptionTransactionSupplementCounterpartyList mapDividendSwapOptionTransactionSupplementCounterpartyList;
	@Inject protected MapDividendSwapTransactionSupplementCounterpartyList mapDividendSwapTransactionSupplementCounterpartyList;
	@Inject protected MapEquityForwardCounterpartyList mapEquityForwardCounterpartyList;
	@Inject protected MapEquityOptionCounterpartyList mapEquityOptionCounterpartyList;
	@Inject protected MapEquityOptionTransactionSupplementCounterpartyList mapEquityOptionTransactionSupplementCounterpartyList;
	@Inject protected MapEquitySwapTransactionSupplementCounterpartyList mapEquitySwapTransactionSupplementCounterpartyList;
	@Inject protected MapFraCounterpartyList mapFraCounterpartyList;
	@Inject protected MapFxDigitalOptionCounterpartyList mapFxDigitalOptionCounterpartyList;
	@Inject protected MapFxOptionCounterpartyList mapFxOptionCounterpartyList;
	@Inject protected MapFxSingleLegCounterpartyList mapFxSingleLegCounterpartyList;
	@Inject protected MapFxSwapCounterpartyList mapFxSwapCounterpartyList;
	@Inject protected MapFxVarianceSwapCounterpartyList mapFxVarianceSwapCounterpartyList;
	@Inject protected MapFxVolatilitySwapCounterpartyList mapFxVolatilitySwapCounterpartyList;
	@Inject protected MapGenericProductCounterpartyList mapGenericProductCounterpartyList;
	@Inject protected MapReturnSwapCounterpartyList mapReturnSwapCounterpartyList;
	@Inject protected MapSwapCounterpartyList mapSwapCounterpartyList;
	@Inject protected MapSwaptionCounterpartyList mapSwaptionCounterpartyList;
	@Inject protected MapVarianceOptionTransactionSupplementCounterpartyList mapVarianceOptionTransactionSupplementCounterpartyList;
	@Inject protected MapVarianceSwapCounterpartyList mapVarianceSwapCounterpartyList;
	@Inject protected MapVarianceSwapTransactionSupplementCounterpartyList mapVarianceSwapTransactionSupplementCounterpartyList;
	@Inject protected MapVolatilitySwapCounterpartyList mapVolatilitySwapCounterpartyList;
	@Inject protected MapVolatilitySwapTransactionSupplementCounterpartyList mapVolatilitySwapTransactionSupplementCounterpartyList;

	/**
	* @param fpmlTrade 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(Trade fpmlTrade) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlTrade);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(Trade fpmlTrade);

	public static class MapCounterpartyListDefault extends MapCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(Trade fpmlTrade) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlTrade);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, Trade fpmlTrade) {
			final Product switchArgument = MapperS.of(fpmlTrade).<Product>map("getProduct", trade -> trade.getProduct()).get();
			if (switchArgument == null) {
				counterpartyList.addAll(toBuilder(Collections.<Counterparty>emptyList()));
			} else if (switchArgument instanceof BondOption) {
				final BondOption bondOption = (BondOption) switchArgument;
				counterpartyList.addAll(toBuilder(mapBondOptionCounterpartyList.evaluate(bondOption)));
			} else if (switchArgument instanceof BrokerEquityOption) {
				final BrokerEquityOption brokerEquityOption = (BrokerEquityOption) switchArgument;
				counterpartyList.addAll(toBuilder(mapBrokerEquityOptionCounterpartyList.evaluate(brokerEquityOption)));
			} else if (switchArgument instanceof CapFloor) {
				final CapFloor capFloor = (CapFloor) switchArgument;
				counterpartyList.addAll(toBuilder(mapCapFloorCounterpartyList.evaluate(capFloor)));
			} else if (switchArgument instanceof CommodityForward) {
				final CommodityForward commodityForward = (CommodityForward) switchArgument;
				counterpartyList.addAll(toBuilder(mapCommodityForwardCounterpartyList.evaluate(commodityForward)));
			} else if (switchArgument instanceof CommodityOption) {
				final CommodityOption commodityOption = (CommodityOption) switchArgument;
				counterpartyList.addAll(toBuilder(mapCommodityOptionCounterpartyList.evaluate(commodityOption)));
			} else if (switchArgument instanceof CommoditySwap) {
				final CommoditySwap commoditySwap = (CommoditySwap) switchArgument;
				counterpartyList.addAll(toBuilder(mapCommoditySwapCounterpartyList.evaluate(commoditySwap)));
			} else if (switchArgument instanceof CommoditySwaption) {
				final CommoditySwaption commoditySwaption = (CommoditySwaption) switchArgument;
				counterpartyList.addAll(toBuilder(mapCommoditySwaptionCounterpartyList.evaluate(commoditySwaption)));
			} else if (switchArgument instanceof CorrelationSwap) {
				final CorrelationSwap correlationSwap = (CorrelationSwap) switchArgument;
				counterpartyList.addAll(toBuilder(mapCorrelationSwapCounterpartyList.evaluate(correlationSwap)));
			} else if (switchArgument instanceof CreditDefaultSwap) {
				final CreditDefaultSwap creditDefaultSwap = (CreditDefaultSwap) switchArgument;
				counterpartyList.addAll(toBuilder(mapCreditDefaultSwapCounterpartyList.evaluate(creditDefaultSwap)));
			} else if (switchArgument instanceof CreditDefaultSwapOption) {
				final CreditDefaultSwapOption creditDefaultSwapOption = (CreditDefaultSwapOption) switchArgument;
				counterpartyList.addAll(toBuilder(mapCreditDefaultSwapOptionCounterpartyList.evaluate(creditDefaultSwapOption)));
			} else if (switchArgument instanceof DividendSwapOptionTransactionSupplement) {
				final DividendSwapOptionTransactionSupplement dividendSwapOptionTransactionSupplement = (DividendSwapOptionTransactionSupplement) switchArgument;
				counterpartyList.addAll(toBuilder(mapDividendSwapOptionTransactionSupplementCounterpartyList.evaluate(dividendSwapOptionTransactionSupplement)));
			} else if (switchArgument instanceof DividendSwapTransactionSupplement) {
				final DividendSwapTransactionSupplement dividendSwapTransactionSupplement = (DividendSwapTransactionSupplement) switchArgument;
				counterpartyList.addAll(toBuilder(mapDividendSwapTransactionSupplementCounterpartyList.evaluate(dividendSwapTransactionSupplement)));
			} else if (switchArgument instanceof EquityForward) {
				final EquityForward equityForward = (EquityForward) switchArgument;
				counterpartyList.addAll(toBuilder(mapEquityForwardCounterpartyList.evaluate(equityForward)));
			} else if (switchArgument instanceof EquityOption) {
				final EquityOption equityOption = (EquityOption) switchArgument;
				counterpartyList.addAll(toBuilder(mapEquityOptionCounterpartyList.evaluate(equityOption)));
			} else if (switchArgument instanceof EquityOptionTransactionSupplement) {
				final EquityOptionTransactionSupplement equityOptionTransactionSupplement = (EquityOptionTransactionSupplement) switchArgument;
				counterpartyList.addAll(toBuilder(mapEquityOptionTransactionSupplementCounterpartyList.evaluate(equityOptionTransactionSupplement)));
			} else if (switchArgument instanceof EquitySwapTransactionSupplement) {
				final EquitySwapTransactionSupplement equitySwapTransactionSupplement = (EquitySwapTransactionSupplement) switchArgument;
				counterpartyList.addAll(toBuilder(mapEquitySwapTransactionSupplementCounterpartyList.evaluate(equitySwapTransactionSupplement)));
			} else if (switchArgument instanceof Fra) {
				final Fra fra = (Fra) switchArgument;
				counterpartyList.addAll(toBuilder(mapFraCounterpartyList.evaluate(fra)));
			} else if (switchArgument instanceof FxOption) {
				final FxOption fxOption = (FxOption) switchArgument;
				counterpartyList.addAll(toBuilder(mapFxOptionCounterpartyList.evaluate(fxOption)));
			} else if (switchArgument instanceof FxDigitalOption) {
				final FxDigitalOption fxDigitalOption = (FxDigitalOption) switchArgument;
				counterpartyList.addAll(toBuilder(mapFxDigitalOptionCounterpartyList.evaluate(fxDigitalOption)));
			} else if (switchArgument instanceof FxSingleLeg) {
				final FxSingleLeg fxSingleLeg = (FxSingleLeg) switchArgument;
				counterpartyList.addAll(toBuilder(mapFxSingleLegCounterpartyList.evaluate(fxSingleLeg)));
			} else if (switchArgument instanceof FxSwap) {
				final FxSwap fxSwap = (FxSwap) switchArgument;
				counterpartyList.addAll(toBuilder(mapFxSwapCounterpartyList.evaluate(fxSwap)));
			} else if (switchArgument instanceof FxVarianceSwap) {
				final FxVarianceSwap fxVarianceSwap = (FxVarianceSwap) switchArgument;
				counterpartyList.addAll(toBuilder(mapFxVarianceSwapCounterpartyList.evaluate(fxVarianceSwap)));
			} else if (switchArgument instanceof FxVolatilitySwap) {
				final FxVolatilitySwap fxVolatilitySwap = (FxVolatilitySwap) switchArgument;
				counterpartyList.addAll(toBuilder(mapFxVolatilitySwapCounterpartyList.evaluate(fxVolatilitySwap)));
			} else if (switchArgument instanceof GenericProduct) {
				final GenericProduct genericProduct = (GenericProduct) switchArgument;
				counterpartyList.addAll(toBuilder(mapGenericProductCounterpartyList.evaluate(genericProduct)));
			} else if (switchArgument instanceof ReturnSwap) {
				final ReturnSwap returnSwap = (ReturnSwap) switchArgument;
				counterpartyList.addAll(toBuilder(mapReturnSwapCounterpartyList.evaluate(returnSwap)));
			} else if (switchArgument instanceof Swap) {
				final Swap swap = (Swap) switchArgument;
				counterpartyList.addAll(toBuilder(mapSwapCounterpartyList.evaluate(swap)));
			} else if (switchArgument instanceof Swaption) {
				final Swaption swaption = (Swaption) switchArgument;
				counterpartyList.addAll(toBuilder(mapSwaptionCounterpartyList.evaluate(swaption)));
			} else if (switchArgument instanceof VarianceOptionTransactionSupplement) {
				final VarianceOptionTransactionSupplement varianceOptionTransactionSupplement = (VarianceOptionTransactionSupplement) switchArgument;
				counterpartyList.addAll(toBuilder(mapVarianceOptionTransactionSupplementCounterpartyList.evaluate(varianceOptionTransactionSupplement)));
			} else if (switchArgument instanceof VarianceSwap) {
				final VarianceSwap varianceSwap = (VarianceSwap) switchArgument;
				counterpartyList.addAll(toBuilder(mapVarianceSwapCounterpartyList.evaluate(varianceSwap)));
			} else if (switchArgument instanceof VarianceSwapTransactionSupplement) {
				final VarianceSwapTransactionSupplement varianceSwapTransactionSupplement = (VarianceSwapTransactionSupplement) switchArgument;
				counterpartyList.addAll(toBuilder(mapVarianceSwapTransactionSupplementCounterpartyList.evaluate(varianceSwapTransactionSupplement)));
			} else if (switchArgument instanceof VolatilitySwap) {
				final VolatilitySwap volatilitySwap = (VolatilitySwap) switchArgument;
				counterpartyList.addAll(toBuilder(mapVolatilitySwapCounterpartyList.evaluate(volatilitySwap)));
			} else if (switchArgument instanceof VolatilitySwapTransactionSupplement) {
				final VolatilitySwapTransactionSupplement volatilitySwapTransactionSupplement = (VolatilitySwapTransactionSupplement) switchArgument;
				counterpartyList.addAll(toBuilder(mapVolatilitySwapTransactionSupplementCounterpartyList.evaluate(volatilitySwapTransactionSupplement)));
			} else {
				counterpartyList.addAll(toBuilder(Collections.<Counterparty>emptyList()));
			}
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
