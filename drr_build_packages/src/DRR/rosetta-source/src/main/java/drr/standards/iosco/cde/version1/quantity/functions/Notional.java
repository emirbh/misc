package drr.standards.iosco.cde.version1.quantity.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.Measure;
import cdm.base.math.MeasureBase;
import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Security;
import cdm.observable.asset.Observable;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.FixedPrice;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.metafields.ReferenceWithMetaResolvablePriceQuantity;
import cdm.product.template.AveragingStrikeFeature;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionStrike;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.PayoutLeg;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.quantity.functions.CommodityObservablePriceQuantity;
import drr.base.trade.quantity.functions.ETDNotionalFuture;
import drr.base.trade.quantity.functions.ETDNotionalOption;
import drr.standards.iosco.cde.version1.quantity.reports.CommodityOptionNotionalRule;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Notional.NotionalDefault.class)
public abstract class Notional implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityNotional commodityNotional0;
	@Inject protected CommodityObservablePriceQuantity commodityObservablePriceQuantity;
	@Inject protected CommodityOptionNotionalRule commodityOptionNotionalRule;
	@Inject protected ETDNotionalFuture eTDNotionalFuture;
	@Inject protected ETDNotionalOption eTDNotionalOption;

	/**
	* @param payoutLeg 
	* @return measure 
	*/
	public Measure evaluate(PayoutLegWithAuxiliary payoutLeg) {
		Measure.MeasureBuilder measureBuilder = doEvaluate(payoutLeg);
		
		final Measure measure;
		if (measureBuilder == null) {
			measure = null;
		} else {
			measure = measureBuilder.build();
			objectValidator.validate(Measure.class, measure);
		}
		
		return measure;
	}

	protected abstract Measure.MeasureBuilder doEvaluate(PayoutLegWithAuxiliary payoutLeg);

	protected abstract MapperS<BigDecimal> optionMultiplier(PayoutLegWithAuxiliary payoutLeg);

	protected abstract MapperS<? extends Measure> optionNotional(PayoutLegWithAuxiliary payoutLeg);

	protected abstract MapperS<? extends Measure> commodityOptionNotional(PayoutLegWithAuxiliary payoutLeg);

	protected abstract MapperS<? extends Measure> creditDefaultNotional(PayoutLegWithAuxiliary payoutLeg);

	protected abstract MapperS<? extends InterestRatePayout> interestRatePayout(PayoutLegWithAuxiliary payoutLeg);

	protected abstract MapperS<BigDecimal> interestRateMultiplier(PayoutLegWithAuxiliary payoutLeg);

	protected abstract MapperS<? extends Measure> interestRateNotional(PayoutLegWithAuxiliary payoutLeg);

	protected abstract MapperS<BigDecimal> performanceMultiplier(PayoutLegWithAuxiliary payoutLeg);

	protected abstract MapperS<? extends Measure> performanceNotional(PayoutLegWithAuxiliary payoutLeg);

	protected abstract MapperS<? extends Measure> forwardNotional(PayoutLegWithAuxiliary payoutLeg);

	protected abstract MapperS<? extends Measure> fixedPriceNotional(PayoutLegWithAuxiliary payoutLeg);

	protected abstract MapperS<? extends Measure> cashflowNotional(PayoutLegWithAuxiliary payoutLeg);

	protected abstract MapperS<? extends Measure> commodityNotional1(PayoutLegWithAuxiliary payoutLeg);

	protected abstract MapperS<? extends Measure> optionETDNotional(PayoutLegWithAuxiliary payoutLeg);

	protected abstract MapperS<? extends Measure> futureETDNotional(PayoutLegWithAuxiliary payoutLeg);

	public static class NotionalDefault extends Notional {
		@Override
		protected Measure.MeasureBuilder doEvaluate(PayoutLegWithAuxiliary payoutLeg) {
			Measure.MeasureBuilder measure = Measure.builder();
			return assignOutput(measure, payoutLeg);
		}
		
		protected Measure.MeasureBuilder assignOutput(Measure.MeasureBuilder measure, PayoutLegWithAuxiliary payoutLeg) {
			if (exists(MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout())).getOrDefault(false)) {
				if (exists(MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity())).getOrDefault(false)) {
					measure = toBuilder(commodityOptionNotional(payoutLeg).get());
				} else if (MapperS.of(payoutLeg).<Boolean>map("getIsProductETD", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getIsProductETD()).getOrDefault(false)) {
					measure = toBuilder(optionETDNotional(payoutLeg).get());
				} else {
					measure = toBuilder(optionNotional(payoutLeg).get());
				}
			} else if (exists(MapperS.of(payoutLeg).<CreditDefaultPayout>map("getCreditDefaultPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCreditDefaultPayout())).getOrDefault(false)) {
				measure = toBuilder(creditDefaultNotional(payoutLeg).get());
			} else if (exists(MapperS.of(payoutLeg).<InterestRatePayout>map("getInterestRatePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getInterestRatePayout())).getOrDefault(false)) {
				measure = toBuilder(interestRateNotional(payoutLeg).get());
			} else if (exists(MapperS.of(payoutLeg).<PerformancePayout>map("getPerformancePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getPerformancePayout())).getOrDefault(false)) {
				measure = toBuilder(performanceNotional(payoutLeg).get());
			} else if (exists(MapperS.of(payoutLeg).<FixedPricePayout>map("getFixedPricePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getFixedPricePayout())).getOrDefault(false)) {
				measure = toBuilder(fixedPriceNotional(payoutLeg).get());
			} else if (exists(MapperS.of(payoutLeg).<Cashflow>map("getCashflow", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCashflow())).getOrDefault(false)) {
				measure = toBuilder(cashflowNotional(payoutLeg).get());
			} else if (exists(MapperS.of(payoutLeg).<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout())).getOrDefault(false)) {
				measure = toBuilder(commodityNotional1(payoutLeg).get());
			} else if (exists(MapperS.of(payoutLeg).<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout())).getOrDefault(false)) {
				if (MapperS.of(payoutLeg).<Boolean>map("getIsProductETD", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getIsProductETD()).getOrDefault(false)) {
					measure = toBuilder(futureETDNotional(payoutLeg).get());
				} else {
					measure = toBuilder(forwardNotional(payoutLeg).get());
				}
			} else {
				measure = null;
			}
			
			return Optional.ofNullable(measure)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<BigDecimal> optionMultiplier(PayoutLegWithAuxiliary payoutLeg) {
			if (exists(MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier())).andNullSafe(notEqual(MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()).<InstrumentTypeEnum>map("getInstrumentType", security -> security.getInstrumentType()), MapperS.of(InstrumentTypeEnum.DEBT), CardinalityOperator.Any)).getOrDefault(false)) {
				return MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier()).<BigDecimal>map("getValue", measure -> measure.getValue());
			}
			return MapperS.of(BigDecimal.valueOf(1));
		}
		
		@Override
		protected MapperS<? extends Measure> optionNotional(PayoutLegWithAuxiliary payoutLeg) {
			if (exists(MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).getOrDefault(false)) {
				return MapperS.of(Measure.builder()
					.setUnit(MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get())
					.setValue(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule2 -> referenceWithMetaNonNegativeQuantitySchedule2 == null ? null : referenceWithMetaNonNegativeQuantitySchedule2.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), optionMultiplier(payoutLeg)).get())
					.build());
			}
			if (exists(MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule3 -> referenceWithMetaNonNegativeQuantitySchedule3 == null ? null : referenceWithMetaNonNegativeQuantitySchedule3.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
				return MapperS.of(Measure.builder()
					.setUnit(MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice()).<UnitType>map("getUnit", price -> price.getUnit()).get())
					.setValue(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule4 -> referenceWithMetaNonNegativeQuantitySchedule4 == null ? null : referenceWithMetaNonNegativeQuantitySchedule4.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), optionMultiplier(payoutLeg)), MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice()).<BigDecimal>map("getValue", price -> price.getValue())).get())
					.build());
			}
			return MapperS.<Measure>ofNull();
		}
		
		@Override
		protected MapperS<? extends Measure> commodityOptionNotional(PayoutLegWithAuxiliary payoutLeg) {
			final MapperC<? extends MeasureBase> thenArg0;
			if (exists(MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice())).getOrDefault(false)) {
				thenArg0 = MapperC.of(Collections.singletonList(Measure.builder()
					.setUnit(MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice()).<UnitType>map("getUnit", price -> price.getUnit()).get())
					.setValue(commodityOptionNotionalRule.evaluate(MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).get()))
					.build()));
			} else if (exists(MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<AveragingStrikeFeature>map("getAveragingStrikeFeature", optionStrike -> optionStrike.getAveragingStrikeFeature())).getOrDefault(false)) {
				if (exists(MapperS.of(payoutLeg).<PriceSchedule>map("getLastAvailableSpotPrice", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getLastAvailableSpotPrice())).getOrDefault(false)) {
					final ReferenceWithMetaNonNegativeQuantitySchedule referenceWithMetaNonNegativeQuantitySchedule = MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", optionPayout -> optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get();
					thenArg0 = MapperC.of(Collections.singletonList(Measure.builder()
						.setUnit(MapperS.of(payoutLeg).<PriceSchedule>map("getLastAvailableSpotPrice", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getLastAvailableSpotPrice()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).get())
						.setValue(commodityNotional0.evaluate((referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()), MapperS.of(payoutLeg).<PriceSchedule>map("getLastAvailableSpotPrice", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getLastAvailableSpotPrice()).get()))
						.build()));
				} else {
					thenArg0 = MapperS.of(MapperS.of(payoutLeg).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).get()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity())
						.filterItemNullSafe(item -> exists(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).get()).<MeasureBase>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue());
				}
			} else {
				thenArg0 = MapperC.<MeasureBase>ofNull();
			}
			final MapperS<MeasureBase> thenArg1 = MapperS.of(thenArg0.get());
			return thenArg1
				.mapSingleToItem(item -> MapperS.of(Measure.builder()
					.setUnit(item.<UnitType>map("getUnit", measureBase -> measureBase.getUnit()).get())
					.setValue(item.<BigDecimal>map("getValue", measureBase -> measureBase.getValue()).get())
					.build()));
		}
		
		@Override
		protected MapperS<? extends Measure> creditDefaultNotional(PayoutLegWithAuxiliary payoutLeg) {
			final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg = MapperS.of(payoutLeg).<CreditDefaultPayout>map("getCreditDefaultPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCreditDefaultPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", creditDefaultPayout -> creditDefaultPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule());
			return thenArg
				.mapSingleToItem(item -> MapperS.of(Measure.builder()
					.setUnit(item.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get())
					.setValue(item.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get())
					.build()));
		}
		
		@Override
		protected MapperS<? extends InterestRatePayout> interestRatePayout(PayoutLegWithAuxiliary payoutLeg) {
			return MapperS.of(MapperS.of(payoutLeg).<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<InterestRatePayout>map("getInterestRatePayout", _payoutLeg -> _payoutLeg.getInterestRatePayout()).getOrDefault(MapperS.of(payoutLeg).<InterestRatePayout>map("getInterestRatePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getInterestRatePayout()).get()));
		}
		
		@Override
		protected MapperS<BigDecimal> interestRateMultiplier(PayoutLegWithAuxiliary payoutLeg) {
			final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg = interestRatePayout(payoutLeg).<ResolvablePriceQuantity>map("getPriceQuantity", _interestRatePayout -> _interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule());
			return thenArg
				.mapSingleToItem(item -> {
					if (exists(item.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier()).<BigDecimal>map("getValue", measure -> measure.getValue())).getOrDefault(false)) {
						return item.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier()).<BigDecimal>map("getValue", measure -> measure.getValue());
					}
					return MapperS.of(BigDecimal.valueOf(1));
				});
		}
		
		@Override
		protected MapperS<? extends Measure> interestRateNotional(PayoutLegWithAuxiliary payoutLeg) {
			final MapperS<ResolvablePriceQuantity> thenArg = interestRatePayout(payoutLeg).<ResolvablePriceQuantity>map("getPriceQuantity", _interestRatePayout -> _interestRatePayout.getPriceQuantity());
			return thenArg
				.mapSingleToItem(item -> {
					final UnitType ifThenElseResult0;
					if (exists(item.<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule())).getOrDefault(false)) {
						ifThenElseResult0 = item.<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get();
					} else if (exists(item.<ReferenceWithMetaResolvablePriceQuantity>map("getQuantityReference", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantityReference())).getOrDefault(false)) {
						ifThenElseResult0 = item.<ReferenceWithMetaResolvablePriceQuantity>map("getQuantityReference", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantityReference()).<ResolvablePriceQuantity>map("Type coercion", referenceWithMetaResolvablePriceQuantity -> referenceWithMetaResolvablePriceQuantity == null ? null : referenceWithMetaResolvablePriceQuantity.getValue()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get();
					} else {
						ifThenElseResult0 = null;
					}
					BigDecimal ifThenElseResult1 = null;
					if (exists(item.<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule())).getOrDefault(false)) {
						ifThenElseResult1 = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(item.<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule2 -> referenceWithMetaNonNegativeQuantitySchedule2 == null ? null : referenceWithMetaNonNegativeQuantitySchedule2.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), interestRateMultiplier(payoutLeg)).get();
					}
					return MapperS.of(Measure.builder()
						.setUnit(ifThenElseResult0)
						.setValue(ifThenElseResult1)
						.build());
				});
		}
		
		@Override
		protected MapperS<BigDecimal> performanceMultiplier(PayoutLegWithAuxiliary payoutLeg) {
			final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg = MapperS.of(payoutLeg).<PerformancePayout>map("getPerformancePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getPerformancePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", performancePayout -> performancePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule());
			return thenArg
				.mapSingleToItem(item -> {
					if (exists(item.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier()).<BigDecimal>map("getValue", measure -> measure.getValue())).getOrDefault(false)) {
						return item.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier()).<BigDecimal>map("getValue", measure -> measure.getValue());
					}
					return MapperS.of(BigDecimal.valueOf(1));
				});
		}
		
		@Override
		protected MapperS<? extends Measure> performanceNotional(PayoutLegWithAuxiliary payoutLeg) {
			if (exists(MapperS.of(payoutLeg).<PerformancePayout>map("getPerformancePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getPerformancePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", performancePayout -> performancePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).getOrDefault(false)) {
				final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg0 = MapperS.of(payoutLeg).<PerformancePayout>map("getPerformancePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getPerformancePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", performancePayout -> performancePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule());
				return thenArg0
					.mapSingleToItem(item -> MapperS.of(Measure.builder()
						.setUnit(item.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get())
						.setValue(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(item.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), performanceMultiplier(payoutLeg)).get())
						.build()));
			}
			if (exists(MapperS.of(payoutLeg).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).getOrDefault(false)) {
				final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg1 = MapperS.of(payoutLeg).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity());
				final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg2 = thenArg1
					.filterItemNullSafe(item -> exists(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).get());
				final MapperS<FieldWithMetaNonNegativeQuantitySchedule> thenArg3 = MapperS.of(thenArg2.get());
				return thenArg3
					.mapSingleToItem(item -> MapperS.of(Measure.builder()
						.setUnit(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule0 -> fieldWithMetaNonNegativeQuantitySchedule0 == null ? null : fieldWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get())
						.setValue(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule1 -> fieldWithMetaNonNegativeQuantitySchedule1 == null ? null : fieldWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get())
						.build()));
			}
			return MapperS.<Measure>ofNull();
		}
		
		@Override
		protected MapperS<? extends Measure> forwardNotional(PayoutLegWithAuxiliary payoutLeg) {
			if (exists(MapperS.of(payoutLeg).<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<FixedPricePayout>map("getFixedPricePayout", _payoutLeg -> _payoutLeg.getFixedPricePayout())).getOrDefault(false)) {
				final ReferenceWithMetaNonNegativeQuantitySchedule referenceWithMetaNonNegativeQuantitySchedule0 = MapperS.of(payoutLeg).<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get();
				final ReferenceWithMetaPriceSchedule referenceWithMetaPriceSchedule1 = MapperS.of(payoutLeg).<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<FixedPricePayout>map("getFixedPricePayout", _payoutLeg -> _payoutLeg.getFixedPricePayout()).<FixedPrice>map("getFixedPrice", fixedPricePayout -> fixedPricePayout.getFixedPrice()).<ReferenceWithMetaPriceSchedule>map("getPrice", fixedPrice -> fixedPrice.getPrice()).get();
				return MapperS.of(Measure.builder()
					.setUnit(MapperS.of(payoutLeg).<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<FixedPricePayout>map("getFixedPricePayout", _payoutLeg -> _payoutLeg.getFixedPricePayout()).<FixedPrice>map("getFixedPrice", fixedPricePayout -> fixedPricePayout.getFixedPrice()).<ReferenceWithMetaPriceSchedule>map("getPrice", fixedPrice -> fixedPrice.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule0 -> referenceWithMetaPriceSchedule0 == null ? null : referenceWithMetaPriceSchedule0.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).get())
					.setValue(commodityNotional0.evaluate((referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()), (referenceWithMetaPriceSchedule1 == null ? null : referenceWithMetaPriceSchedule1.getValue())))
					.build());
			}
			if (exists(MapperS.of(payoutLeg).<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<CommodityPayout>map("getCommodityPayout", _payoutLeg -> _payoutLeg.getCommodityPayout())).getOrDefault(false)) {
				final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg0 = MapperS.of(commodityObservablePriceQuantity.evaluate(MapperS.of(payoutLeg).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).get(), MapperS.of(payoutLeg).<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<CommodityPayout>map("getCommodityPayout", _payoutLeg -> _payoutLeg.getCommodityPayout()).get())).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity())
					.filterItemNullSafe(item -> exists(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).get());
				final MapperS<FieldWithMetaNonNegativeQuantitySchedule> thenArg1 = MapperS.of(thenArg0.get());
				return thenArg1
					.mapSingleToItem(item -> MapperS.of(Measure.builder()
						.setUnit(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule0 -> fieldWithMetaNonNegativeQuantitySchedule0 == null ? null : fieldWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get())
						.setValue(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule1 -> fieldWithMetaNonNegativeQuantitySchedule1 == null ? null : fieldWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get())
						.build()));
			}
			if (exists(MapperS.of(payoutLeg).<PriceSchedule>map("getLastAvailableSpotPrice", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getLastAvailableSpotPrice())).getOrDefault(false)) {
				final ReferenceWithMetaNonNegativeQuantitySchedule referenceWithMetaNonNegativeQuantitySchedule1 = MapperS.of(payoutLeg).<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get();
				return MapperS.of(Measure.builder()
					.setUnit(MapperS.of(payoutLeg).<PriceSchedule>map("getLastAvailableSpotPrice", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getLastAvailableSpotPrice()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).get())
					.setValue(commodityNotional0.evaluate((referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()), MapperS.of(payoutLeg).<PriceSchedule>map("getLastAvailableSpotPrice", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getLastAvailableSpotPrice()).get()))
					.build());
			}
			if (exists(MapperS.of(payoutLeg).<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule2 -> referenceWithMetaNonNegativeQuantitySchedule2 == null ? null : referenceWithMetaNonNegativeQuantitySchedule2.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).getOrDefault(false)) {
				final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg2 = MapperS.of(payoutLeg).<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule());
				return thenArg2
					.mapSingleToItem(item -> MapperS.of(Measure.builder()
						.setUnit(item.<NonNegativeQuantitySchedule>map("Type coercion", _referenceWithMetaNonNegativeQuantitySchedule0 -> _referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : _referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get())
						.setValue(item.<NonNegativeQuantitySchedule>map("Type coercion", _referenceWithMetaNonNegativeQuantitySchedule1 -> _referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : _referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get())
						.build()));
			}
			if (exists(MapperS.of(payoutLeg).<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule3 -> referenceWithMetaNonNegativeQuantitySchedule3 == null ? null : referenceWithMetaNonNegativeQuantitySchedule3.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
				final MapperS<ResolvablePriceQuantity> thenArg3 = MapperS.of(payoutLeg).<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity());
				return thenArg3
					.mapSingleToItem(item -> {
						final ReferenceWithMetaPriceSchedule referenceWithMetaPriceSchedule = item.<ReferenceWithMetaPriceSchedule>mapC("getPriceSchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getPriceSchedule()).get();
						return MapperS.of(Measure.builder()
							.setUnit(item.<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", _referenceWithMetaNonNegativeQuantitySchedule0 -> _referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : _referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get())
							.setValue(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(item.<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", _referenceWithMetaNonNegativeQuantitySchedule1 -> _referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : _referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), (referenceWithMetaPriceSchedule == null ? MapperS.<PriceSchedule>ofNull() : MapperS.of(referenceWithMetaPriceSchedule.getValue())).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).get())
							.build());
					});
			}
			return MapperS.<Measure>ofNull();
		}
		
		@Override
		protected MapperS<? extends Measure> fixedPriceNotional(PayoutLegWithAuxiliary payoutLeg) {
			final MapperS<FixedPricePayout> thenArg = MapperS.of(payoutLeg).<FixedPricePayout>map("getFixedPricePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getFixedPricePayout());
			return thenArg
				.mapSingleToItem(item -> {
					final ReferenceWithMetaNonNegativeQuantitySchedule referenceWithMetaNonNegativeQuantitySchedule = item.<ResolvablePriceQuantity>map("getPriceQuantity", fixedPricePayout -> fixedPricePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get();
					final ReferenceWithMetaPriceSchedule referenceWithMetaPriceSchedule1 = item.<FixedPrice>map("getFixedPrice", fixedPricePayout -> fixedPricePayout.getFixedPrice()).<ReferenceWithMetaPriceSchedule>map("getPrice", fixedPrice -> fixedPrice.getPrice()).get();
					return MapperS.of(Measure.builder()
						.setUnit(item.<FixedPrice>map("getFixedPrice", fixedPricePayout -> fixedPricePayout.getFixedPrice()).<ReferenceWithMetaPriceSchedule>map("getPrice", fixedPrice -> fixedPrice.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule0 -> referenceWithMetaPriceSchedule0 == null ? null : referenceWithMetaPriceSchedule0.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).get())
						.setValue(commodityNotional0.evaluate((referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()), (referenceWithMetaPriceSchedule1 == null ? null : referenceWithMetaPriceSchedule1.getValue())))
						.build());
				});
		}
		
		@Override
		protected MapperS<? extends Measure> cashflowNotional(PayoutLegWithAuxiliary payoutLeg) {
			final MapperS<NonNegativeQuantity> thenArg = MapperS.of(payoutLeg).<Cashflow>map("getCashflow", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCashflow()).<NonNegativeQuantity>map("getQuantity", cashflow -> cashflow.getQuantity());
			return thenArg
				.mapSingleToItem(item -> MapperS.of(Measure.builder()
					.setUnit(item.<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).get())
					.setValue(item.<BigDecimal>map("getValue", nonNegativeQuantity -> nonNegativeQuantity.getValue()).get())
					.build()));
		}
		
		@Override
		protected MapperS<? extends Measure> commodityNotional1(PayoutLegWithAuxiliary payoutLeg) {
			final MapperC<? extends MeasureBase> thenArg0;
			if (exists(MapperS.of(payoutLeg).<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<FixedPricePayout>map("getFixedPricePayout", _payoutLeg -> _payoutLeg.getFixedPricePayout())).getOrDefault(false)) {
				final ReferenceWithMetaNonNegativeQuantitySchedule referenceWithMetaNonNegativeQuantitySchedule0 = MapperS.of(payoutLeg).<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", commodityPayout -> commodityPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get();
				final ReferenceWithMetaPriceSchedule referenceWithMetaPriceSchedule1 = MapperS.of(payoutLeg).<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<FixedPricePayout>map("getFixedPricePayout", _payoutLeg -> _payoutLeg.getFixedPricePayout()).<FixedPrice>map("getFixedPrice", fixedPricePayout -> fixedPricePayout.getFixedPrice()).<ReferenceWithMetaPriceSchedule>map("getPrice", fixedPrice -> fixedPrice.getPrice()).get();
				thenArg0 = MapperC.of(Collections.singletonList(Measure.builder()
					.setUnit(MapperS.of(payoutLeg).<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<FixedPricePayout>map("getFixedPricePayout", _payoutLeg -> _payoutLeg.getFixedPricePayout()).<FixedPrice>map("getFixedPrice", fixedPricePayout -> fixedPricePayout.getFixedPrice()).<ReferenceWithMetaPriceSchedule>map("getPrice", fixedPrice -> fixedPrice.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule0 -> referenceWithMetaPriceSchedule0 == null ? null : referenceWithMetaPriceSchedule0.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).get())
					.setValue(commodityNotional0.evaluate((referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()), (referenceWithMetaPriceSchedule1 == null ? null : referenceWithMetaPriceSchedule1.getValue())))
					.build()));
			} else if (exists(MapperS.of(payoutLeg).<PriceSchedule>map("getLastAvailableSpotPrice", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getLastAvailableSpotPrice())).getOrDefault(false)) {
				final ReferenceWithMetaNonNegativeQuantitySchedule referenceWithMetaNonNegativeQuantitySchedule1 = MapperS.of(payoutLeg).<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", commodityPayout -> commodityPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get();
				thenArg0 = MapperC.of(Collections.singletonList(Measure.builder()
					.setUnit(MapperS.of(payoutLeg).<PriceSchedule>map("getLastAvailableSpotPrice", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getLastAvailableSpotPrice()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).get())
					.setValue(commodityNotional0.evaluate((referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()), MapperS.of(payoutLeg).<PriceSchedule>map("getLastAvailableSpotPrice", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getLastAvailableSpotPrice()).get()))
					.build()));
			} else {
				thenArg0 = MapperS.of(commodityObservablePriceQuantity.evaluate(MapperS.of(payoutLeg).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).get(), MapperS.of(payoutLeg).<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).get())).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity())
					.filterItemNullSafe(item -> exists(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).get()).<MeasureBase>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue());
			}
			final MapperS<MeasureBase> thenArg1 = MapperS.of(thenArg0.get());
			return thenArg1
				.mapSingleToItem(item -> MapperS.of(Measure.builder()
					.setUnit(item.<UnitType>map("getUnit", measureBase -> measureBase.getUnit()).get())
					.setValue(item.<BigDecimal>map("getValue", measureBase -> measureBase.getValue()).get())
					.build()));
		}
		
		@Override
		protected MapperS<? extends Measure> optionETDNotional(PayoutLegWithAuxiliary payoutLeg) {
			return MapperS.of(eTDNotionalOption.evaluate(MapperS.of(payoutLeg).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).get(), MapperS.of(payoutLeg).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).getMulti()));
		}
		
		@Override
		protected MapperS<? extends Measure> futureETDNotional(PayoutLegWithAuxiliary payoutLeg) {
			return MapperS.of(eTDNotionalFuture.evaluate(MapperS.of(payoutLeg).<TradeLot>map("getTradeLot", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getTradeLot()).getMulti()));
		}
	}
}
