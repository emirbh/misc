package cdm.ingest.fpml.confirmation.tradestate.functions;

import cdm.ingest.fpml.confirmation.product.bondoption.functions.MapBondOptionPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.brokerequityoption.functions.MapBrokerEquityOptionPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.capfloor.functions.MapCapFloorPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.commodityforward.functions.MapCommodityForwardPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.commodityoption.functions.MapCommodityOptionPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.commodityswap.functions.MapCommoditySwapPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.commodityswaption.functions.MapCommoditySwaptionPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.correlationswap.functions.MapCorrelationSwapPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions.MapCreditDefaultSwapPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions.MapCreditDefaultSwapOptionPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.dividendswapoptiontransactionsupplement.functions.MapDividendSwapOptionTransactionSupplementPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions.MapDividendSwapTransactionSupplementPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.equityforward.functions.MapEquityForwardPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.equityoption.functions.MapEquityOptionPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.equityoptiontransactionsupplement.functions.MapEquityOptionTransactionSupplementPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.equityswaptransactionsupplement.functions.MapEquitySwapTransactionSupplementPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.fra.functions.MapFraPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.fxoption.functions.MapFxOptionPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.fxsingleleg.functions.MapFxSingleLegPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.fxswap.functions.MapFxSwapPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.fxvarianceswap.functions.MapFxVarianceSwapPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.fxvolatilityswap.functions.MapFxVolatilitySwapPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.genericproduct.functions.MapGenericProductPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.returnswap.functions.MapReturnSwapPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.swap.functions.MapSwapPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.swaption.functions.MapSwaptionPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.varianceoptiontransactionsupplement.functions.MapVarianceOptionTransactionSupplementPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.varianceswap.functions.MapVarianceSwapPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.varianceswaptransactionsupplement.functions.MapVarianceSwapTransactionSupplementPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.volatilityswap.functions.MapVolatilitySwapPriceQuantityList;
import cdm.ingest.fpml.confirmation.product.volatilityswaptransactionsupplement.functions.MapVolatilitySwapTransactionSupplementPriceQuantityList;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.BasicQuotation;
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


@ImplementedBy(MapPriceQuantityList.MapPriceQuantityListDefault.class)
public abstract class MapPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBondOptionPriceQuantityList mapBondOptionPriceQuantityList;
	@Inject protected MapBrokerEquityOptionPriceQuantityList mapBrokerEquityOptionPriceQuantityList;
	@Inject protected MapCapFloorPriceQuantityList mapCapFloorPriceQuantityList;
	@Inject protected MapCommodityForwardPriceQuantityList mapCommodityForwardPriceQuantityList;
	@Inject protected MapCommodityOptionPriceQuantityList mapCommodityOptionPriceQuantityList;
	@Inject protected MapCommoditySwapPriceQuantityList mapCommoditySwapPriceQuantityList;
	@Inject protected MapCommoditySwaptionPriceQuantityList mapCommoditySwaptionPriceQuantityList;
	@Inject protected MapCorrelationSwapPriceQuantityList mapCorrelationSwapPriceQuantityList;
	@Inject protected MapCreditDefaultSwapOptionPriceQuantityList mapCreditDefaultSwapOptionPriceQuantityList;
	@Inject protected MapCreditDefaultSwapPriceQuantityList mapCreditDefaultSwapPriceQuantityList;
	@Inject protected MapDividendSwapOptionTransactionSupplementPriceQuantityList mapDividendSwapOptionTransactionSupplementPriceQuantityList;
	@Inject protected MapDividendSwapTransactionSupplementPriceQuantityList mapDividendSwapTransactionSupplementPriceQuantityList;
	@Inject protected MapEquityForwardPriceQuantityList mapEquityForwardPriceQuantityList;
	@Inject protected MapEquityOptionPriceQuantityList mapEquityOptionPriceQuantityList;
	@Inject protected MapEquityOptionTransactionSupplementPriceQuantityList mapEquityOptionTransactionSupplementPriceQuantityList;
	@Inject protected MapEquitySwapTransactionSupplementPriceQuantityList mapEquitySwapTransactionSupplementPriceQuantityList;
	@Inject protected MapFraPriceQuantityList mapFraPriceQuantityList;
	@Inject protected MapFxOptionPriceQuantityList mapFxOptionPriceQuantityList;
	@Inject protected MapFxSingleLegPriceQuantityList mapFxSingleLegPriceQuantityList;
	@Inject protected MapFxSwapPriceQuantityList mapFxSwapPriceQuantityList;
	@Inject protected MapFxVarianceSwapPriceQuantityList mapFxVarianceSwapPriceQuantityList;
	@Inject protected MapFxVolatilitySwapPriceQuantityList mapFxVolatilitySwapPriceQuantityList;
	@Inject protected MapGenericProductPriceQuantityList mapGenericProductPriceQuantityList;
	@Inject protected MapReturnSwapPriceQuantityList mapReturnSwapPriceQuantityList;
	@Inject protected MapSwapPriceQuantityList mapSwapPriceQuantityList;
	@Inject protected MapSwaptionPriceQuantityList mapSwaptionPriceQuantityList;
	@Inject protected MapVarianceOptionTransactionSupplementPriceQuantityList mapVarianceOptionTransactionSupplementPriceQuantityList;
	@Inject protected MapVarianceSwapPriceQuantityList mapVarianceSwapPriceQuantityList;
	@Inject protected MapVarianceSwapTransactionSupplementPriceQuantityList mapVarianceSwapTransactionSupplementPriceQuantityList;
	@Inject protected MapVolatilitySwapPriceQuantityList mapVolatilitySwapPriceQuantityList;
	@Inject protected MapVolatilitySwapTransactionSupplementPriceQuantityList mapVolatilitySwapTransactionSupplementPriceQuantityList;

	/**
	* @param fpmlTrade 
	* @param fpmlQuotation 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(Trade fpmlTrade, BasicQuotation fpmlQuotation) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlTrade, fpmlQuotation);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(Trade fpmlTrade, BasicQuotation fpmlQuotation);

	public static class MapPriceQuantityListDefault extends MapPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(Trade fpmlTrade, BasicQuotation fpmlQuotation) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlTrade, fpmlQuotation);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, Trade fpmlTrade, BasicQuotation fpmlQuotation) {
			final Product switchArgument = MapperS.of(fpmlTrade).<Product>map("getProduct", trade -> trade.getProduct()).get();
			if (switchArgument == null) {
				priceQuantityList.addAll(toBuilder(Collections.<PriceQuantity>emptyList()));
			} else if (switchArgument instanceof BondOption) {
				final BondOption bondOption = (BondOption) switchArgument;
				priceQuantityList.addAll(toBuilder(mapBondOptionPriceQuantityList.evaluate(bondOption)));
			} else if (switchArgument instanceof BrokerEquityOption) {
				final BrokerEquityOption brokerEquityOption = (BrokerEquityOption) switchArgument;
				priceQuantityList.addAll(toBuilder(mapBrokerEquityOptionPriceQuantityList.evaluate(brokerEquityOption)));
			} else if (switchArgument instanceof CapFloor) {
				final CapFloor capFloor = (CapFloor) switchArgument;
				priceQuantityList.addAll(toBuilder(mapCapFloorPriceQuantityList.evaluate(capFloor)));
			} else if (switchArgument instanceof CommodityForward) {
				final CommodityForward commodityForward = (CommodityForward) switchArgument;
				priceQuantityList.addAll(toBuilder(mapCommodityForwardPriceQuantityList.evaluate(commodityForward)));
			} else if (switchArgument instanceof CommodityOption) {
				final CommodityOption commodityOption = (CommodityOption) switchArgument;
				priceQuantityList.addAll(toBuilder(mapCommodityOptionPriceQuantityList.evaluate(commodityOption)));
			} else if (switchArgument instanceof CommoditySwap) {
				final CommoditySwap commoditySwap = (CommoditySwap) switchArgument;
				priceQuantityList.addAll(toBuilder(mapCommoditySwapPriceQuantityList.evaluate(commoditySwap)));
			} else if (switchArgument instanceof CommoditySwaption) {
				final CommoditySwaption commoditySwaption = (CommoditySwaption) switchArgument;
				priceQuantityList.addAll(toBuilder(mapCommoditySwaptionPriceQuantityList.evaluate(commoditySwaption)));
			} else if (switchArgument instanceof CorrelationSwap) {
				final CorrelationSwap correlationSwap = (CorrelationSwap) switchArgument;
				priceQuantityList.addAll(toBuilder(mapCorrelationSwapPriceQuantityList.evaluate(correlationSwap)));
			} else if (switchArgument instanceof CreditDefaultSwap) {
				final CreditDefaultSwap creditDefaultSwap = (CreditDefaultSwap) switchArgument;
				priceQuantityList.addAll(toBuilder(mapCreditDefaultSwapPriceQuantityList.evaluate(creditDefaultSwap)));
			} else if (switchArgument instanceof CreditDefaultSwapOption) {
				final CreditDefaultSwapOption creditDefaultSwapOption = (CreditDefaultSwapOption) switchArgument;
				priceQuantityList.addAll(toBuilder(mapCreditDefaultSwapOptionPriceQuantityList.evaluate(creditDefaultSwapOption)));
			} else if (switchArgument instanceof DividendSwapOptionTransactionSupplement) {
				final DividendSwapOptionTransactionSupplement dividendSwapOptionTransactionSupplement = (DividendSwapOptionTransactionSupplement) switchArgument;
				priceQuantityList.addAll(toBuilder(mapDividendSwapOptionTransactionSupplementPriceQuantityList.evaluate(dividendSwapOptionTransactionSupplement)));
			} else if (switchArgument instanceof DividendSwapTransactionSupplement) {
				final DividendSwapTransactionSupplement dividendSwapTransactionSupplement = (DividendSwapTransactionSupplement) switchArgument;
				priceQuantityList.addAll(toBuilder(mapDividendSwapTransactionSupplementPriceQuantityList.evaluate(dividendSwapTransactionSupplement)));
			} else if (switchArgument instanceof EquityForward) {
				final EquityForward equityForward = (EquityForward) switchArgument;
				priceQuantityList.addAll(toBuilder(mapEquityForwardPriceQuantityList.evaluate(equityForward)));
			} else if (switchArgument instanceof EquityOption) {
				final EquityOption equityOption = (EquityOption) switchArgument;
				priceQuantityList.addAll(toBuilder(mapEquityOptionPriceQuantityList.evaluate(equityOption)));
			} else if (switchArgument instanceof EquityOptionTransactionSupplement) {
				final EquityOptionTransactionSupplement equityOptionTransactionSupplement = (EquityOptionTransactionSupplement) switchArgument;
				priceQuantityList.addAll(toBuilder(mapEquityOptionTransactionSupplementPriceQuantityList.evaluate(equityOptionTransactionSupplement)));
			} else if (switchArgument instanceof EquitySwapTransactionSupplement) {
				final EquitySwapTransactionSupplement equitySwapTransactionSupplement = (EquitySwapTransactionSupplement) switchArgument;
				priceQuantityList.addAll(toBuilder(mapEquitySwapTransactionSupplementPriceQuantityList.evaluate(equitySwapTransactionSupplement)));
			} else if (switchArgument instanceof Fra) {
				final Fra fra = (Fra) switchArgument;
				priceQuantityList.addAll(toBuilder(mapFraPriceQuantityList.evaluate(fra)));
			} else if (switchArgument instanceof FxOption) {
				final FxOption fxOption = (FxOption) switchArgument;
				priceQuantityList.addAll(toBuilder(mapFxOptionPriceQuantityList.evaluate(fxOption)));
			} else if (switchArgument instanceof FxSingleLeg) {
				final FxSingleLeg fxSingleLeg = (FxSingleLeg) switchArgument;
				priceQuantityList.addAll(toBuilder(mapFxSingleLegPriceQuantityList.evaluate(fxSingleLeg)));
			} else if (switchArgument instanceof FxSwap) {
				final FxSwap fxSwap = (FxSwap) switchArgument;
				priceQuantityList.addAll(toBuilder(mapFxSwapPriceQuantityList.evaluate(fxSwap)));
			} else if (switchArgument instanceof FxVarianceSwap) {
				final FxVarianceSwap fxVarianceSwap = (FxVarianceSwap) switchArgument;
				priceQuantityList.addAll(toBuilder(mapFxVarianceSwapPriceQuantityList.evaluate(fxVarianceSwap)));
			} else if (switchArgument instanceof FxVolatilitySwap) {
				final FxVolatilitySwap fxVolatilitySwap = (FxVolatilitySwap) switchArgument;
				priceQuantityList.addAll(toBuilder(mapFxVolatilitySwapPriceQuantityList.evaluate(fxVolatilitySwap)));
			} else if (switchArgument instanceof GenericProduct) {
				final GenericProduct genericProduct = (GenericProduct) switchArgument;
				priceQuantityList.addAll(toBuilder(mapGenericProductPriceQuantityList.evaluate(genericProduct, fpmlQuotation)));
			} else if (switchArgument instanceof ReturnSwap) {
				final ReturnSwap returnSwap = (ReturnSwap) switchArgument;
				priceQuantityList.addAll(toBuilder(mapReturnSwapPriceQuantityList.evaluate(returnSwap)));
			} else if (switchArgument instanceof Swap) {
				final Swap swap = (Swap) switchArgument;
				priceQuantityList.addAll(toBuilder(mapSwapPriceQuantityList.evaluate(swap)));
			} else if (switchArgument instanceof Swaption) {
				final Swaption swaption = (Swaption) switchArgument;
				priceQuantityList.addAll(toBuilder(mapSwaptionPriceQuantityList.evaluate(swaption)));
			} else if (switchArgument instanceof VarianceOptionTransactionSupplement) {
				final VarianceOptionTransactionSupplement varianceOptionTransactionSupplement = (VarianceOptionTransactionSupplement) switchArgument;
				priceQuantityList.addAll(toBuilder(mapVarianceOptionTransactionSupplementPriceQuantityList.evaluate(varianceOptionTransactionSupplement)));
			} else if (switchArgument instanceof VarianceSwap) {
				final VarianceSwap varianceSwap = (VarianceSwap) switchArgument;
				priceQuantityList.addAll(toBuilder(mapVarianceSwapPriceQuantityList.evaluate(varianceSwap)));
			} else if (switchArgument instanceof VarianceSwapTransactionSupplement) {
				final VarianceSwapTransactionSupplement varianceSwapTransactionSupplement = (VarianceSwapTransactionSupplement) switchArgument;
				priceQuantityList.addAll(toBuilder(mapVarianceSwapTransactionSupplementPriceQuantityList.evaluate(varianceSwapTransactionSupplement)));
			} else if (switchArgument instanceof VolatilitySwap) {
				final VolatilitySwap volatilitySwap = (VolatilitySwap) switchArgument;
				priceQuantityList.addAll(toBuilder(mapVolatilitySwapPriceQuantityList.evaluate(volatilitySwap)));
			} else if (switchArgument instanceof VolatilitySwapTransactionSupplement) {
				final VolatilitySwapTransactionSupplement volatilitySwapTransactionSupplement = (VolatilitySwapTransactionSupplement) switchArgument;
				priceQuantityList.addAll(toBuilder(mapVolatilitySwapTransactionSupplementPriceQuantityList.evaluate(volatilitySwapTransactionSupplement)));
			} else {
				priceQuantityList.addAll(toBuilder(Collections.<PriceQuantity>emptyList()));
			}
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
