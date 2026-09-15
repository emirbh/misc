package drr.standards.iosco.cde.version1.price.functions;

import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.asset.VarianceReturnTerms;
import cdm.product.asset.VolatilityReturnTerms;
import cdm.product.asset.metafields.ReferenceWithMetaFixedRateSpecification;
import cdm.product.common.schedule.RateSchedule;
import cdm.product.common.settlement.FixedPrice;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionStrike;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Product;
import cdm.product.template.ReturnTerms;
import cdm.product.template.StrikeSchedule;
import cdm.product.template.TradableProduct;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCap;
import drr.base.qualification.product.functions.IsEquitySwap;
import drr.base.qualification.product.functions.IsFloor;
import drr.base.qualification.product.functions.IsIRSwaption;
import drr.base.qualification.product.functions.IsOption;
import drr.base.qualification.product.functions.IsVarianceSwap;
import drr.base.qualification.product.functions.IsVolatilitySwap;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.functions.TradableProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(StrikePrice.StrikePriceDefault.class)
public abstract class StrikePrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCap isCap;
	@Inject protected IsEquitySwap isEquitySwap;
	@Inject protected IsFloor isFloor;
	@Inject protected IsIRSwaption isIRSwaption;
	@Inject protected IsOption isOption;
	@Inject protected IsVarianceSwap isVarianceSwap;
	@Inject protected IsVolatilitySwap isVolatilitySwap;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;
	@Inject protected TradableProductForEvent tradableProductForEvent;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param reportableEvent 
	* @return prices 
	*/
	public PriceSchedule evaluate(ReportableEventBase reportableEvent) {
		PriceSchedule.PriceScheduleBuilder pricesBuilder = doEvaluate(reportableEvent);
		
		final PriceSchedule prices;
		if (pricesBuilder == null) {
			prices = null;
		} else {
			prices = pricesBuilder.build();
			objectValidator.validate(PriceSchedule.class, prices);
		}
		
		return prices;
	}

	protected abstract PriceSchedule.PriceScheduleBuilder doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends TradableProduct> tradableProduct(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	public static class StrikePriceDefault extends StrikePrice {
		@Override
		protected PriceSchedule.PriceScheduleBuilder doEvaluate(ReportableEventBase reportableEvent) {
			PriceSchedule.PriceScheduleBuilder prices = PriceSchedule.builder();
			return assignOutput(prices, reportableEvent);
		}
		
		protected PriceSchedule.PriceScheduleBuilder assignOutput(PriceSchedule.PriceScheduleBuilder prices, ReportableEventBase reportableEvent) {
			final Boolean boolean0 = isIRSwaption.evaluate(product(reportableEvent).get());
			final MapperC<? extends PriceSchedule> thenArg;
			if ((boolean0 == null ? false : boolean0)) {
				thenArg = MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification()).<RateSchedule>map("getRateSchedule", fixedRateSpecification -> fixedRateSpecification.getRateSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", rateSchedule -> rateSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue());
			} else if (areEqual(MapperS.of(qualify_Commodity_Swaption.evaluate(economicTermsForProduct.evaluate(product(reportableEvent).get()))), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				thenArg = MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<FixedPricePayout>map("getFixedPricePayout", payout -> payout.getFixedPricePayout()).<FixedPrice>map("getFixedPrice", fixedPricePayout -> fixedPricePayout.getFixedPrice()).<ReferenceWithMetaPriceSchedule>map("getPrice", fixedPrice -> fixedPrice.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue());
			} else if (ComparisonResult.ofNullSafe(MapperS.of(isOption.evaluate(product(reportableEvent).get()))).andNullSafe(exists(MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice()))).getOrDefault(false)) {
				thenArg = MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice());
			} else if (ComparisonResult.ofNullSafe(MapperS.of(isOption.evaluate(product(reportableEvent).get()))).andNullSafe(exists(MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<ReferenceWithMetaFixedRateSpecification>map("getStrikeReference", optionStrike -> optionStrike.getStrikeReference()))).getOrDefault(false)) {
				thenArg = MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<ReferenceWithMetaFixedRateSpecification>map("getStrikeReference", optionStrike -> optionStrike.getStrikeReference()).<FixedRateSpecification>map("Type coercion", referenceWithMetaFixedRateSpecification -> referenceWithMetaFixedRateSpecification.getValue()).<RateSchedule>map("getRateSchedule", fixedRateSpecification -> fixedRateSpecification.getRateSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", rateSchedule -> rateSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue());
			} else {
				final Boolean boolean1 = isCap.evaluate(product(reportableEvent).get());
				if ((boolean1 == null ? false : boolean1)) {
					thenArg = MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<StrikeSchedule>map("getCapRateSchedule", floatingRateSpecification -> floatingRateSpecification.getCapRateSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", strikeSchedule -> strikeSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue());
				} else {
					final Boolean boolean2 = isFloor.evaluate(product(reportableEvent).get());
					if ((boolean2 == null ? false : boolean2)) {
						thenArg = MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<StrikeSchedule>map("getFloorRateSchedule", floatingRateSpecification -> floatingRateSpecification.getFloorRateSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", strikeSchedule -> strikeSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue());
					} else {
						final Boolean boolean3 = isVarianceSwap.evaluate(product(reportableEvent).get());
						if ((boolean3 == null ? false : boolean3)) {
							thenArg = MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<ReturnTerms>map("getReturnTerms", performancePayout -> performancePayout.getReturnTerms()).<VarianceReturnTerms>map("getVarianceReturnTerms", returnTerms -> returnTerms.getVarianceReturnTerms()).<Price>map("getVarianceStrikePrice", varianceReturnTerms -> varianceReturnTerms.getVarianceStrikePrice());
						} else {
							final Boolean boolean4 = isVolatilitySwap.evaluate(product(reportableEvent).get());
							if ((boolean4 == null ? false : boolean4)) {
								thenArg = MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<ReturnTerms>map("getReturnTerms", performancePayout -> performancePayout.getReturnTerms()).<VolatilityReturnTerms>map("getVolatilityReturnTerms", returnTerms -> returnTerms.getVolatilityReturnTerms()).<Price>map("getVolatilityStrikePrice", volatilityReturnTerms -> volatilityReturnTerms.getVolatilityStrikePrice());
							} else {
								final Boolean boolean5 = isEquitySwap.evaluate(tradableProduct(reportableEvent).get());
								if ((boolean5 == null ? false : boolean5)) {
									thenArg = tradableProduct(reportableEvent).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice())
										.filterItemNullSafe(item -> areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule0 -> fieldWithMetaPriceSchedule0 == null ? null : fieldWithMetaPriceSchedule0.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.VARIANCE), CardinalityOperator.All).orNullSafe(areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule1 -> fieldWithMetaPriceSchedule1 == null ? null : fieldWithMetaPriceSchedule1.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.VOLATILITY), CardinalityOperator.All)).get()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue());
								} else {
									thenArg = MapperC.<PriceSchedule>ofNull();
								}
							}
						}
					}
				}
			}
			prices = toBuilder(MapperS.of(thenArg.get()).get());
			
			return Optional.ofNullable(prices)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends TradableProduct> tradableProduct(ReportableEventBase reportableEvent) {
			return MapperS.of(tradableProductForEvent.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent) {
			return MapperS.of(productForEvent.evaluate(reportableEvent));
		}
	}
}
