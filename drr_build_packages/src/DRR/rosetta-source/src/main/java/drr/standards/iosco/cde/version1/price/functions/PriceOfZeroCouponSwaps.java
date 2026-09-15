package drr.standards.iosco.cde.version1.price.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.TradableProductForEvent;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PriceOfZeroCouponSwaps.PriceOfZeroCouponSwapsDefault.class)
public abstract class PriceOfZeroCouponSwaps implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected TradableProductForEvent tradableProductForEvent;

	/**
	* @param reportableEvent 
	* @return knownAmountPrice 
	*/
	public PriceSchedule evaluate(ReportableEventBase reportableEvent) {
		PriceSchedule.PriceScheduleBuilder knownAmountPriceBuilder = doEvaluate(reportableEvent);
		
		final PriceSchedule knownAmountPrice;
		if (knownAmountPriceBuilder == null) {
			knownAmountPrice = null;
		} else {
			knownAmountPrice = knownAmountPriceBuilder.build();
			objectValidator.validate(PriceSchedule.class, knownAmountPrice);
		}
		
		return knownAmountPrice;
	}

	protected abstract PriceSchedule.PriceScheduleBuilder doEvaluate(ReportableEventBase reportableEvent);

	public static class PriceOfZeroCouponSwapsDefault extends PriceOfZeroCouponSwaps {
		@Override
		protected PriceSchedule.PriceScheduleBuilder doEvaluate(ReportableEventBase reportableEvent) {
			PriceSchedule.PriceScheduleBuilder knownAmountPrice = PriceSchedule.builder();
			return assignOutput(knownAmountPrice, reportableEvent);
		}
		
		protected PriceSchedule.PriceScheduleBuilder assignOutput(PriceSchedule.PriceScheduleBuilder knownAmountPrice, ReportableEventBase reportableEvent) {
			final MapperC<PriceQuantity> thenArg0 = MapperS.of(tradableProductForEvent.evaluate(reportableEvent))
				.mapSingleToList(item -> item.<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()));
			final MapperC<PriceQuantity> thenArg1 = thenArg0
				.filterItemNullSafe(item -> notExists(item.<FieldWithMetaObservable>map("getObservable", priceQuantity -> priceQuantity.getObservable())).get());
			final MapperListOfLists<FieldWithMetaNonNegativeQuantitySchedule> thenArg2 = thenArg1
				.mapItemToList(item -> item.<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()));
			final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg3 = thenArg2
				.flattenList();
			final MapperS<FieldWithMetaNonNegativeQuantitySchedule> thenArg4 = MapperS.of(thenArg3.get());
			knownAmountPrice = toBuilder(thenArg4
				.mapSingleToItem(item -> MapperS.of(PriceSchedule.builder()
					.setPriceType(PriceTypeEnum.CASH_PRICE)
					.setUnit(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule0 -> fieldWithMetaNonNegativeQuantitySchedule0 == null ? null : fieldWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get())
					.setValue(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule1 -> fieldWithMetaNonNegativeQuantitySchedule1 == null ? null : fieldWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get())
					.build())).get());
			
			return Optional.ofNullable(knownAmountPrice)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
