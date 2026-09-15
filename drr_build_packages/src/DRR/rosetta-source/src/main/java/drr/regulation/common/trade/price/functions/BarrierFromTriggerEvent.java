package drr.regulation.common.trade.price.functions;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.event.FeaturePayment;
import cdm.observable.event.Trigger;
import cdm.observable.event.TriggerEvent;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.price.functions.DefaultPercentageToDecimal;
import drr.base.trade.price.functions.NotationFromPrice;
import drr.base.trade.price.functions.PriceFormatFromNotation;
import drr.regulation.common.trade.price.BarrierPrice;
import drr.standards.iso.functions.ConvertNonISOToISOCurrency;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(BarrierFromTriggerEvent.BarrierFromTriggerEventDefault.class)
public abstract class BarrierFromTriggerEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ConvertNonISOToISOCurrency convertNonISOToISOCurrency;
	@Inject protected DefaultPercentageToDecimal defaultPercentageToDecimal;
	@Inject protected NotationFromPrice notationFromPrice;
	@Inject protected PriceFormatFromNotation priceFormatFromNotation;

	/**
	* @param triggerEvent 
	* @return barrier 
	*/
	public BarrierPrice evaluate(TriggerEvent triggerEvent) {
		BarrierPrice.BarrierPriceBuilder barrierBuilder = doEvaluate(triggerEvent);
		
		final BarrierPrice barrier;
		if (barrierBuilder == null) {
			barrier = null;
		} else {
			barrier = barrierBuilder.build();
			objectValidator.validate(BarrierPrice.class, barrier);
		}
		
		return barrier;
	}

	protected abstract BarrierPrice.BarrierPriceBuilder doEvaluate(TriggerEvent triggerEvent);

	public static class BarrierFromTriggerEventDefault extends BarrierFromTriggerEvent {
		@Override
		protected BarrierPrice.BarrierPriceBuilder doEvaluate(TriggerEvent triggerEvent) {
			BarrierPrice.BarrierPriceBuilder barrier = BarrierPrice.builder();
			return assignOutput(barrier, triggerEvent);
		}
		
		protected BarrierPrice.BarrierPriceBuilder assignOutput(BarrierPrice.BarrierPriceBuilder barrier, TriggerEvent triggerEvent) {
			barrier = toBuilder(MapperS.of(triggerEvent)
				.mapSingleToItem(item -> MapperS.of(BarrierPrice.builder()
					.setPrice(MapperS.of(item.<Trigger>map("getTrigger", _triggerEvent -> _triggerEvent.getTrigger()).<PriceSchedule>mapC("getLevel", trigger -> trigger.getLevel()).get())
						.mapSingleToItem(_item -> MapperS.of(priceFormatFromNotation.evaluate(_item.<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()).get(), defaultPercentageToDecimal.evaluate(notationFromPrice.evaluate(_item.get()), false)))).get())
					.setNotation(MapperS.of(item.<Trigger>map("getTrigger", _triggerEvent -> _triggerEvent.getTrigger()).<PriceSchedule>mapC("getLevel", trigger -> trigger.getLevel()).get())
						.mapSingleToItem(_item -> MapperS.of(defaultPercentageToDecimal.evaluate(notationFromPrice.evaluate(_item.get()), false))).get())
					.setCurrency(item.<FeaturePayment>map("getFeaturePayment", _triggerEvent -> _triggerEvent.getFeaturePayment()).<FieldWithMetaString>map("getCurrency", featurePayment -> featurePayment.getCurrency())
						.mapSingleToItem(_item -> {
							final FieldWithMetaString fieldWithMetaString = _item.get();
							return MapperS.of(convertNonISOToISOCurrency.evaluate((fieldWithMetaString == null ? null : fieldWithMetaString.getValue())));
						}).get())
					.build())).get());
			
			return Optional.ofNullable(barrier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
