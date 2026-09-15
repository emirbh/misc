package drr.standards.iosco.cde.version1.price.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Security;
import cdm.observable.asset.Basket;
import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.common.settlement.FixedPrice;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.qualification.functions.Qualify_BaseProduct_EquityForward;
import cdm.product.qualification.functions.Qualify_Commodity_Option_NonStandard;
import cdm.product.qualification.functions.Qualify_Credit_Option_NonStandard;
import cdm.product.qualification.functions.Qualify_InterestRate_Forward_Debt;
import cdm.product.template.EconomicTerms;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradableProduct;
import cdm.product.template.TradeLot;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCommodityForward;
import drr.base.qualification.product.functions.IsCommoditySwapFixedFloat;
import drr.base.qualification.product.functions.IsEquityOther;
import drr.base.qualification.product.functions.IsEquitySwap;
import drr.base.qualification.product.functions.IsFixedFloatZeroCouponSwapKnownAmount;
import drr.base.qualification.product.functions.IsProductETD;
import drr.base.qualification.product.functions.IsTotalReturnSwapDebtUnderlier;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.functions.TradableProductForEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Price.PriceDefault.class)
public abstract class Price implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCommodityForward isCommodityForward;
	@Inject protected IsCommoditySwapFixedFloat isCommoditySwapFixedFloat;
	@Inject protected IsEquityOther isEquityOther;
	@Inject protected IsEquitySwap isEquitySwap;
	@Inject protected IsFixedFloatZeroCouponSwapKnownAmount isFixedFloatZeroCouponSwapKnownAmount;
	@Inject protected IsProductETD isProductETD;
	@Inject protected IsTotalReturnSwapDebtUnderlier isTotalReturnSwapDebtUnderlier;
	@Inject protected PriceOfZeroCouponSwaps priceOfZeroCouponSwaps;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_BaseProduct_EquityForward qualify_BaseProduct_EquityForward;
	@Inject protected Qualify_Commodity_Option_NonStandard qualify_Commodity_Option_NonStandard;
	@Inject protected Qualify_Credit_Option_NonStandard qualify_Credit_Option_NonStandard;
	@Inject protected Qualify_InterestRate_Forward_Debt qualify_InterestRate_Forward_Debt;
	@Inject protected TradableProductForEvent tradableProductForEvent;

	/**
	* @param reportableEvent 
	* @return price 
	*/
	public PriceSchedule evaluate(ReportableEventBase reportableEvent) {
		PriceSchedule.PriceScheduleBuilder priceBuilder = doEvaluate(reportableEvent);
		
		final PriceSchedule price;
		if (priceBuilder == null) {
			price = null;
		} else {
			price = priceBuilder.build();
			objectValidator.validate(PriceSchedule.class, price);
		}
		
		return price;
	}

	protected abstract PriceSchedule.PriceScheduleBuilder doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends TradableProduct> tradableProduct(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent);

	public static class PriceDefault extends Price {
		@Override
		protected PriceSchedule.PriceScheduleBuilder doEvaluate(ReportableEventBase reportableEvent) {
			PriceSchedule.PriceScheduleBuilder price = PriceSchedule.builder();
			return assignOutput(price, reportableEvent);
		}
		
		protected PriceSchedule.PriceScheduleBuilder assignOutput(PriceSchedule.PriceScheduleBuilder price, ReportableEventBase reportableEvent) {
			final MapperC<PriceSchedule> thenArg;
			if (ComparisonResult.ofNullSafe(MapperS.of(isEquitySwap.evaluate(tradableProduct(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isEquityOther.evaluate(tradableProduct(reportableEvent).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Option_NonStandard.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Credit_Option_NonStandard.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				if (exists(MapperS.of(economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<ReferenceWithMetaPriceSchedule>mapC("getInitialValuationPrice", performancePayout -> performancePayout.getInitialValuationPrice())).getOrDefault(false)) {
					thenArg = MapperS.of(economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<ReferenceWithMetaPriceSchedule>mapC("getInitialValuationPrice", performancePayout -> performancePayout.getInitialValuationPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue());
				} else {
					thenArg = tradableProduct(reportableEvent).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice())
						.filterItemNullSafe(item -> areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule0 -> fieldWithMetaPriceSchedule0 == null ? null : fieldWithMetaPriceSchedule0.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.ASSET_PRICE), CardinalityOperator.All).orNullSafe(areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule1 -> fieldWithMetaPriceSchedule1 == null ? null : fieldWithMetaPriceSchedule1.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.CASH_PRICE), CardinalityOperator.All)).get()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue());
				}
			} else {
				final FieldWithMetaBasketConstituent fieldWithMetaBasketConstituent = MapperS.of(economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Basket>map("getBasket", observable -> observable.getBasket()).<FieldWithMetaBasketConstituent>mapC("getBasketConstituent", basket -> basket.getBasketConstituent()).get();
				if (ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_EquityForward.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(exists(economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout())).andNullSafe(areEqual((fieldWithMetaBasketConstituent == null ? MapperS.<BasketConstituent>ofNull() : MapperS.of(fieldWithMetaBasketConstituent.getValue())).<Asset>map("getAsset", basketConstituent -> basketConstituent.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()).<InstrumentTypeEnum>map("getInstrumentType", security -> security.getInstrumentType()), MapperS.of(InstrumentTypeEnum.EQUITY), CardinalityOperator.All))).getOrDefault(false)) {
					thenArg = MapperS.of(economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaPriceSchedule>mapC("getPriceSchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getPriceSchedule()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue()).getMulti().isEmpty() ? tradableProduct(reportableEvent).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice())
						.filterItemNullSafe(item -> areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule0 -> fieldWithMetaPriceSchedule0 == null ? null : fieldWithMetaPriceSchedule0.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.ASSET_PRICE), CardinalityOperator.All).orNullSafe(areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule1 -> fieldWithMetaPriceSchedule1 == null ? null : fieldWithMetaPriceSchedule1.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.CASH_PRICE), CardinalityOperator.All)).get()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()) : MapperS.of(economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaPriceSchedule>mapC("getPriceSchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getPriceSchedule()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue());
				} else if (ComparisonResult.ofNullSafe(MapperS.of(isTotalReturnSwapDebtUnderlier.evaluate(tradableProduct(reportableEvent).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_Forward_Debt.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
					thenArg = tradableProduct(reportableEvent).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice())
						.filterItemNullSafe(item -> areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule0 -> fieldWithMetaPriceSchedule0 == null ? null : fieldWithMetaPriceSchedule0.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.ASSET_PRICE), CardinalityOperator.All).orNullSafe(areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule1 -> fieldWithMetaPriceSchedule1 == null ? null : fieldWithMetaPriceSchedule1.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.CASH_PRICE), CardinalityOperator.All)).get()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue());
				} else if (onlyExists(economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()), Arrays.asList("AssetPayout", "CommodityPayout", "CreditDefaultPayout", "FixedPricePayout", "InterestRatePayout", "OptionPayout", "PerformancePayout", "SettlementPayout"), Arrays.asList("SettlementPayout")).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isProductETD.evaluate(tradableProduct(reportableEvent).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).get())))).getOrDefault(false)) {
					thenArg = tradableProduct(reportableEvent).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice())
						.filterItemNullSafe(item -> areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule0 -> fieldWithMetaPriceSchedule0 == null ? null : fieldWithMetaPriceSchedule0.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.ASSET_PRICE), CardinalityOperator.All).orNullSafe(areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule1 -> fieldWithMetaPriceSchedule1 == null ? null : fieldWithMetaPriceSchedule1.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.CASH_PRICE), CardinalityOperator.All)).orNullSafe(areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule2 -> fieldWithMetaPriceSchedule2 == null ? null : fieldWithMetaPriceSchedule2.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.EXCHANGE_RATE), CardinalityOperator.All)).get()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue());
				} else {
					final Boolean boolean0 = isCommoditySwapFixedFloat.evaluate(tradableProduct(reportableEvent).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).get());
					if ((boolean0 == null ? false : boolean0)) {
						thenArg = MapperC.of(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForEvent.evaluate(reportableEvent))).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<FixedPricePayout>map("getFixedPricePayout", payout -> payout.getFixedPricePayout()).get()).<FixedPrice>map("getFixedPrice", fixedPricePayout -> fixedPricePayout.getFixedPrice()).<ReferenceWithMetaPriceSchedule>map("getPrice", fixedPrice -> fixedPrice.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule0 -> referenceWithMetaPriceSchedule0 == null ? null : referenceWithMetaPriceSchedule0.getValue()));
					} else {
						final Boolean boolean1 = isCommodityForward.evaluate(tradableProduct(reportableEvent).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).get());
						if ((boolean1 == null ? false : boolean1)) {
							if (exists(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForEvent.evaluate(reportableEvent))).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<FixedPricePayout>map("getFixedPricePayout", payout -> payout.getFixedPricePayout()).get())).getOrDefault(false)) {
								thenArg = MapperC.of(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForEvent.evaluate(reportableEvent))).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<FixedPricePayout>map("getFixedPricePayout", payout -> payout.getFixedPricePayout()).get()).<FixedPrice>map("getFixedPrice", fixedPricePayout -> fixedPricePayout.getFixedPrice()).<ReferenceWithMetaPriceSchedule>map("getPrice", fixedPrice -> fixedPrice.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule1 -> referenceWithMetaPriceSchedule1 == null ? null : referenceWithMetaPriceSchedule1.getValue()));
							} else if (exists(MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForEvent.evaluate(reportableEvent))).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get())).getOrDefault(false)) {
								thenArg = MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForEvent.evaluate(reportableEvent))).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaPriceSchedule>mapC("getPriceSchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getPriceSchedule()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue());
							} else {
								thenArg = MapperC.<PriceSchedule>ofNull();
							}
						} else {
							final Boolean boolean2 = isFixedFloatZeroCouponSwapKnownAmount.evaluate(productForEvent.evaluate(reportableEvent));
							if ((boolean2 == null ? false : boolean2)) {
								thenArg = MapperC.of(Collections.singletonList(priceOfZeroCouponSwaps.evaluate(reportableEvent)));
							} else {
								thenArg = MapperC.<PriceSchedule>ofNull();
							}
						}
					}
				}
			}
			price = toBuilder(MapperS.of(thenArg.get()).get());
			
			return Optional.ofNullable(price)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends TradableProduct> tradableProduct(ReportableEventBase reportableEvent) {
			return MapperS.of(tradableProductForEvent.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent) {
			return MapperS.of(economicTermsForProduct.evaluate(tradableProduct(reportableEvent).<NonTransferableProduct>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).get()));
		}
	}
}
