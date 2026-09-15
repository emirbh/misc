package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.event.common.TransferState;
import cdm.observable.asset.FeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.bond.option.BondOption;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.cd.FeeLeg;
import fpml.consolidated.cd.InitialPayment;
import fpml.consolidated.cd.SinglePayment;
import fpml.consolidated.com.CommodityBasketOption;
import fpml.consolidated.com.CommodityOption;
import fpml.consolidated.com.CommodityPremium;
import fpml.consolidated.com.CommoditySwaption;
import fpml.consolidated.correlation.swaps.CorrelationSwap;
import fpml.consolidated.dividend.swaps.DividendSwapOptionTransactionSupplement;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.eq.shared.EquityPremium;
import fpml.consolidated.eq.shared.ReturnSwap;
import fpml.consolidated.eq.shared.ReturnSwapAdditionalPayment;
import fpml.consolidated.eqd.BrokerEquityOption;
import fpml.consolidated.eqd.EquityOption;
import fpml.consolidated.eqd.EquityOptionTransactionSupplement;
import fpml.consolidated.fpmlreturn.swaps.EquitySwapTransactionSupplement;
import fpml.consolidated.fx.FxDigitalOption;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.fx.FxOptionPremium;
import fpml.consolidated.fx.FxVarianceSwap;
import fpml.consolidated.fx.FxVolatilitySwap;
import fpml.consolidated.generic.GenericProduct;
import fpml.consolidated.ird.CapFloor;
import fpml.consolidated.ird.Fra;
import fpml.consolidated.ird.Swap;
import fpml.consolidated.ird.Swaption;
import fpml.consolidated.option.shared.ClassifiablePayment;
import fpml.consolidated.option.shared.Premium;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.SimplePayment;
import fpml.consolidated.variance.swaps.VarianceOptionTransactionSupplement;
import fpml.consolidated.variance.swaps.VarianceSwap;
import fpml.consolidated.volatility.swaps.VolatilitySwap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapTransferStateList.MapTransferStateListDefault.class)
public abstract class MapTransferStateList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapClassifiablePaymentListToTransferStateList mapClassifiablePaymentListToTransferStateList;
	@Inject protected MapCommodityPremiumListToTransferStateList mapCommodityPremiumListToTransferStateList;
	@Inject protected MapEquityPremiumListToTransferStateList mapEquityPremiumListToTransferStateList;
	@Inject protected MapEquityPremiumToTransferState mapEquityPremiumToTransferState;
	@Inject protected MapFxOptionPremiumListToTransferStateList mapFxOptionPremiumListToTransferStateList;
	@Inject protected MapInitialPaymentToTransferState mapInitialPaymentToTransferState;
	@Inject protected MapPaymentListToTransferStateList mapPaymentListToTransferStateList;
	@Inject protected MapPremiumListToTransferStateList mapPremiumListToTransferStateList;
	@Inject protected MapReturnSwapAdditionalPaymentListToTransferStateList mapReturnSwapAdditionalPaymentListToTransferStateList;
	@Inject protected MapSimplePaymentToTransferState mapSimplePaymentToTransferState;
	@Inject protected MapSinglePaymentListToTransferStateList mapSinglePaymentListToTransferStateList;

	/**
	* @param fpmlTrade 
	* @return transfer 
	*/
	public List<? extends TransferState> evaluate(Trade fpmlTrade) {
		List<TransferState.TransferStateBuilder> transferBuilder = doEvaluate(fpmlTrade);
		
		final List<? extends TransferState> transfer;
		if (transferBuilder == null) {
			transfer = null;
		} else {
			transfer = transferBuilder.stream().map(TransferState::build).collect(Collectors.toList());
			objectValidator.validate(TransferState.class, transfer);
		}
		
		return transfer;
	}

	protected abstract List<TransferState.TransferStateBuilder> doEvaluate(Trade fpmlTrade);

	protected abstract MapperS<? extends Product> fpmlProduct(Trade fpmlTrade);

	public static class MapTransferStateListDefault extends MapTransferStateList {
		@Override
		protected List<TransferState.TransferStateBuilder> doEvaluate(Trade fpmlTrade) {
			List<TransferState.TransferStateBuilder> transfer = new ArrayList<>();
			return assignOutput(transfer, fpmlTrade);
		}
		
		protected List<TransferState.TransferStateBuilder> assignOutput(List<TransferState.TransferStateBuilder> transfer, Trade fpmlTrade) {
			final Product switchArgument0 = fpmlProduct(fpmlTrade).get();
			if (switchArgument0 == null) {
				transfer.addAll(toBuilder(Collections.<TransferState>emptyList()));
			} else if (switchArgument0 instanceof FxVolatilitySwap) {
				final FxVolatilitySwap fxVolatilitySwap = (FxVolatilitySwap) switchArgument0;
				transfer.addAll(toBuilder(mapPaymentListToTransferStateList.evaluate(MapperS.of(fxVolatilitySwap).<Payment>mapC("getAdditionalPayment", _fxVolatilitySwap -> _fxVolatilitySwap.getAdditionalPayment()).getMulti(), FeeTypeEnum.UPFRONT)));
			} else if (switchArgument0 instanceof FxVarianceSwap) {
				final FxVarianceSwap fxVarianceSwap = (FxVarianceSwap) switchArgument0;
				transfer.addAll(toBuilder(mapPaymentListToTransferStateList.evaluate(MapperS.of(fxVarianceSwap).<Payment>mapC("getAdditionalPayment", _fxVarianceSwap -> _fxVarianceSwap.getAdditionalPayment()).getMulti(), FeeTypeEnum.UPFRONT)));
			} else if (switchArgument0 instanceof Swap) {
				final Swap swap = (Swap) switchArgument0;
				transfer.addAll(toBuilder(mapPaymentListToTransferStateList.evaluate(MapperS.of(swap).<Payment>mapC("getAdditionalPayment", _swap -> _swap.getAdditionalPayment()).getMulti(), FeeTypeEnum.UPFRONT)));
			} else if (switchArgument0 instanceof GenericProduct) {
				final GenericProduct genericProduct0 = (GenericProduct) switchArgument0;
				transfer.addAll(toBuilder(mapPaymentListToTransferStateList.evaluate(MapperS.of(genericProduct0).<Payment>mapC("getAdditionalPayment", genericProduct -> genericProduct.getAdditionalPayment()).getMulti(), FeeTypeEnum.UPFRONT)));
			} else if (switchArgument0 instanceof Fra) {
				final Fra fra = (Fra) switchArgument0;
				transfer.addAll(toBuilder(mapPaymentListToTransferStateList.evaluate(MapperS.of(fra).<Payment>mapC("getAdditionalPayment", _fra -> _fra.getAdditionalPayment()).getMulti(), FeeTypeEnum.UPFRONT)));
			} else if (switchArgument0 instanceof CorrelationSwap) {
				final CorrelationSwap correlationSwap = (CorrelationSwap) switchArgument0;
				transfer.addAll(toBuilder(mapClassifiablePaymentListToTransferStateList.evaluate(MapperS.of(correlationSwap).<ClassifiablePayment>mapC("getAdditionalPayment", _correlationSwap -> _correlationSwap.getAdditionalPayment()).getMulti(), FeeTypeEnum.UPFRONT)));
			} else if (switchArgument0 instanceof VolatilitySwap) {
				final VolatilitySwap volatilitySwap = (VolatilitySwap) switchArgument0;
				transfer.addAll(toBuilder(mapClassifiablePaymentListToTransferStateList.evaluate(MapperS.of(volatilitySwap).<ClassifiablePayment>mapC("getAdditionalPayment", _volatilitySwap -> _volatilitySwap.getAdditionalPayment()).getMulti(), FeeTypeEnum.UPFRONT)));
			} else if (switchArgument0 instanceof VarianceSwap) {
				final VarianceSwap varianceSwap = (VarianceSwap) switchArgument0;
				transfer.addAll(toBuilder(mapClassifiablePaymentListToTransferStateList.evaluate(MapperS.of(varianceSwap).<ClassifiablePayment>mapC("getAdditionalPayment", _varianceSwap -> _varianceSwap.getAdditionalPayment()).getMulti(), FeeTypeEnum.UPFRONT)));
			} else if (switchArgument0 instanceof CapFloor) {
				final CapFloor capFloor0 = (CapFloor) switchArgument0;
				transfer.addAll(toBuilder(mapPaymentListToTransferStateList.evaluate(MapperS.of(capFloor0).<Payment>mapC("getAdditionalPayment", capFloor -> capFloor.getAdditionalPayment()).getMulti(), FeeTypeEnum.UPFRONT)));
			} else if (switchArgument0 instanceof EquitySwapTransactionSupplement) {
				final EquitySwapTransactionSupplement equitySwapTransactionSupplement = (EquitySwapTransactionSupplement) switchArgument0;
				transfer.addAll(toBuilder(mapReturnSwapAdditionalPaymentListToTransferStateList.evaluate(MapperS.of(equitySwapTransactionSupplement).<ReturnSwapAdditionalPayment>mapC("getAdditionalPayment", _equitySwapTransactionSupplement -> _equitySwapTransactionSupplement.getAdditionalPayment()).getMulti(), FeeTypeEnum.UPFRONT)));
			} else if (switchArgument0 instanceof ReturnSwap) {
				final ReturnSwap returnSwap = (ReturnSwap) switchArgument0;
				transfer.addAll(toBuilder(mapReturnSwapAdditionalPaymentListToTransferStateList.evaluate(MapperS.of(returnSwap).<ReturnSwapAdditionalPayment>mapC("getAdditionalPayment", _returnSwap -> _returnSwap.getAdditionalPayment()).getMulti(), FeeTypeEnum.UPFRONT)));
			} else {
				transfer.addAll(toBuilder(Collections.<TransferState>emptyList()));
			}
			
			final Product switchArgument1 = fpmlProduct(fpmlTrade).get();
			if (switchArgument1 == null) {
				transfer.addAll(toBuilder(Collections.<TransferState>emptyList()));
			} else if (switchArgument1 instanceof CreditDefaultSwap) {
				final CreditDefaultSwap creditDefaultSwap = (CreditDefaultSwap) switchArgument1;
				if (exists(MapperS.of(creditDefaultSwap).<FeeLeg>map("getFeeLeg", _creditDefaultSwap -> _creditDefaultSwap.getFeeLeg()).<InitialPayment>map("getInitialPayment", feeLeg -> feeLeg.getInitialPayment())).getOrDefault(false)) {
					final TransferState transferState0 = mapInitialPaymentToTransferState.evaluate(MapperS.of(creditDefaultSwap).<FeeLeg>map("getFeeLeg", _creditDefaultSwap -> _creditDefaultSwap.getFeeLeg()).<InitialPayment>map("getInitialPayment", feeLeg -> feeLeg.getInitialPayment()).get(), FeeTypeEnum.UPFRONT);
					if (transferState0 == null) {
						transfer.addAll(toBuilder(Collections.<TransferState>emptyList()));
					} else {
						transfer.addAll(toBuilder(Collections.singletonList(transferState0)));
					}
				} else if (exists(MapperS.of(creditDefaultSwap).<FeeLeg>map("getFeeLeg", _creditDefaultSwap -> _creditDefaultSwap.getFeeLeg()).<SinglePayment>mapC("getSinglePayment", feeLeg -> feeLeg.getSinglePayment())).getOrDefault(false)) {
					transfer.addAll(toBuilder(mapSinglePaymentListToTransferStateList.evaluate(MapperS.of(creditDefaultSwap).<FeeLeg>map("getFeeLeg", _creditDefaultSwap -> _creditDefaultSwap.getFeeLeg()).<SinglePayment>mapC("getSinglePayment", feeLeg -> feeLeg.getSinglePayment()).getMulti(), FeeTypeEnum.UPFRONT)));
				} else {
					transfer.addAll(toBuilder(Collections.<TransferState>emptyList()));
				}
			} else {
				transfer.addAll(toBuilder(Collections.<TransferState>emptyList()));
			}
			
			final Product switchArgument2 = fpmlProduct(fpmlTrade).get();
			if (switchArgument2 == null) {
				transfer.addAll(toBuilder(Collections.<TransferState>emptyList()));
			} else if (switchArgument2 instanceof EquityOption) {
				final EquityOption equityOption = (EquityOption) switchArgument2;
				final TransferState transferState1 = mapEquityPremiumToTransferState.evaluate(MapperS.of(equityOption).<EquityPremium>map("getEquityPremium", _equityOption -> _equityOption.getEquityPremium()).get(), FeeTypeEnum.PREMIUM);
				if (transferState1 == null) {
					transfer.addAll(toBuilder(Collections.<TransferState>emptyList()));
				} else {
					transfer.addAll(toBuilder(Collections.singletonList(transferState1)));
				}
			} else {
				transfer.addAll(toBuilder(Collections.<TransferState>emptyList()));
			}
			
			final Product switchArgument3 = fpmlProduct(fpmlTrade).get();
			if (switchArgument3 == null) {
				transfer.addAll(toBuilder(Collections.<TransferState>emptyList()));
			} else if (switchArgument3 instanceof GenericProduct) {
				final GenericProduct genericProduct1 = (GenericProduct) switchArgument3;
				final TransferState transferState2 = mapSimplePaymentToTransferState.evaluate(MapperS.of(genericProduct1).<SimplePayment>map("getPremium", genericProduct -> genericProduct.getPremium()).get(), FeeTypeEnum.PREMIUM);
				if (transferState2 == null) {
					transfer.addAll(toBuilder(Collections.<TransferState>emptyList()));
				} else {
					transfer.addAll(toBuilder(Collections.singletonList(transferState2)));
				}
			} else if (switchArgument3 instanceof CapFloor) {
				final CapFloor capFloor1 = (CapFloor) switchArgument3;
				transfer.addAll(toBuilder(mapPaymentListToTransferStateList.evaluate(MapperS.of(capFloor1).<Payment>mapC("getPremium", capFloor -> capFloor.getPremium()).getMulti(), FeeTypeEnum.PREMIUM)));
			} else if (switchArgument3 instanceof Swaption) {
				final Swaption swaption = (Swaption) switchArgument3;
				transfer.addAll(toBuilder(mapPaymentListToTransferStateList.evaluate(MapperS.of(swaption).<Payment>mapC("getPremium", _swaption -> _swaption.getPremium()).getMulti(), FeeTypeEnum.PREMIUM)));
			} else if (switchArgument3 instanceof FxDigitalOption) {
				final FxDigitalOption fxDigitalOption = (FxDigitalOption) switchArgument3;
				transfer.addAll(toBuilder(mapFxOptionPremiumListToTransferStateList.evaluate(MapperS.of(fxDigitalOption).<FxOptionPremium>mapC("getPremium", _fxDigitalOption -> _fxDigitalOption.getPremium()).getMulti(), FeeTypeEnum.PREMIUM)));
			} else if (switchArgument3 instanceof FxOption) {
				final FxOption fxOption = (FxOption) switchArgument3;
				transfer.addAll(toBuilder(mapFxOptionPremiumListToTransferStateList.evaluate(MapperS.of(fxOption).<FxOptionPremium>mapC("getPremium", _fxOption -> _fxOption.getPremium()).getMulti(), FeeTypeEnum.PREMIUM)));
			} else if (switchArgument3 instanceof DividendSwapOptionTransactionSupplement) {
				final DividendSwapOptionTransactionSupplement dividendSwapOptionTransactionSupplement = (DividendSwapOptionTransactionSupplement) switchArgument3;
				transfer.addAll(toBuilder(mapEquityPremiumListToTransferStateList.evaluate(MapperS.of(dividendSwapOptionTransactionSupplement).<EquityPremium>map("getEquityPremium", _dividendSwapOptionTransactionSupplement -> _dividendSwapOptionTransactionSupplement.getEquityPremium()).getMulti(), FeeTypeEnum.PREMIUM)));
			} else if (switchArgument3 instanceof VarianceOptionTransactionSupplement) {
				final VarianceOptionTransactionSupplement varianceOptionTransactionSupplement = (VarianceOptionTransactionSupplement) switchArgument3;
				transfer.addAll(toBuilder(mapEquityPremiumListToTransferStateList.evaluate(MapperS.of(varianceOptionTransactionSupplement).<EquityPremium>map("getEquityPremium", _varianceOptionTransactionSupplement -> _varianceOptionTransactionSupplement.getEquityPremium()).getMulti(), FeeTypeEnum.PREMIUM)));
			} else if (switchArgument3 instanceof CommodityBasketOption) {
				final CommodityBasketOption commodityBasketOption = (CommodityBasketOption) switchArgument3;
				transfer.addAll(toBuilder(mapCommodityPremiumListToTransferStateList.evaluate(MapperS.of(commodityBasketOption).<CommodityPremium>mapC("getPremium", _commodityBasketOption -> _commodityBasketOption.getPremium()).getMulti(), FeeTypeEnum.PREMIUM)));
			} else if (switchArgument3 instanceof CommodityOption) {
				final CommodityOption commodityOption = (CommodityOption) switchArgument3;
				transfer.addAll(toBuilder(mapCommodityPremiumListToTransferStateList.evaluate(MapperS.of(commodityOption).<CommodityPremium>mapC("getPremium", _commodityOption -> _commodityOption.getPremium()).getMulti(), FeeTypeEnum.PREMIUM)));
			} else if (switchArgument3 instanceof CommoditySwaption) {
				final CommoditySwaption commoditySwaption = (CommoditySwaption) switchArgument3;
				transfer.addAll(toBuilder(mapCommodityPremiumListToTransferStateList.evaluate(MapperS.of(commoditySwaption).<CommodityPremium>map("getPremium", _commoditySwaption -> _commoditySwaption.getPremium()).getMulti(), FeeTypeEnum.PREMIUM)));
			} else if (switchArgument3 instanceof EquityOptionTransactionSupplement) {
				final EquityOptionTransactionSupplement equityOptionTransactionSupplement = (EquityOptionTransactionSupplement) switchArgument3;
				transfer.addAll(toBuilder(mapEquityPremiumListToTransferStateList.evaluate(MapperS.of(equityOptionTransactionSupplement).<EquityPremium>map("getEquityPremium", _equityOptionTransactionSupplement -> _equityOptionTransactionSupplement.getEquityPremium()).getMulti(), FeeTypeEnum.PREMIUM)));
			} else if (switchArgument3 instanceof BondOption) {
				final BondOption bondOption = (BondOption) switchArgument3;
				transfer.addAll(toBuilder(mapPremiumListToTransferStateList.evaluate(MapperS.of(bondOption).<Premium>map("getPremium", _bondOption -> _bondOption.getPremium()).getMulti(), FeeTypeEnum.PREMIUM)));
			} else if (switchArgument3 instanceof CreditDefaultSwapOption) {
				final CreditDefaultSwapOption creditDefaultSwapOption = (CreditDefaultSwapOption) switchArgument3;
				transfer.addAll(toBuilder(mapPremiumListToTransferStateList.evaluate(MapperS.of(creditDefaultSwapOption).<Premium>map("getPremium", _creditDefaultSwapOption -> _creditDefaultSwapOption.getPremium()).getMulti(), FeeTypeEnum.PREMIUM)));
			} else if (switchArgument3 instanceof BrokerEquityOption) {
				final BrokerEquityOption brokerEquityOption = (BrokerEquityOption) switchArgument3;
				transfer.addAll(toBuilder(mapEquityPremiumListToTransferStateList.evaluate(MapperS.of(brokerEquityOption).<EquityPremium>map("getEquityPremium", _brokerEquityOption -> _brokerEquityOption.getEquityPremium()).getMulti(), FeeTypeEnum.PREMIUM)));
			} else {
				transfer.addAll(toBuilder(Collections.<TransferState>emptyList()));
			}
			
			transfer.addAll(toBuilder(mapPaymentListToTransferStateList.evaluate(MapperS.of(fpmlTrade).<Payment>mapC("getOtherPartyPayment", trade -> trade.getOtherPartyPayment()).getMulti(), FeeTypeEnum.UPFRONT)));
			
			return Optional.ofNullable(transfer)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Product> fpmlProduct(Trade fpmlTrade) {
			return MapperS.of(fpmlTrade).<Product>map("getProduct", trade -> trade.getProduct());
		}
	}
}
