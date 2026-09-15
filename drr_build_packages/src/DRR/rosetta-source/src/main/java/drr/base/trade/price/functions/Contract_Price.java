package drr.base.trade.price.functions;

import cdm.event.common.Trade;
import cdm.event.position.CounterpartyPosition;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.product.template.TradableProduct;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.PositionForEvent;
import drr.base.trade.functions.TradeForEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Contract_Price.Contract_PriceDefault.class)
public abstract class Contract_Price implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected PositionForEvent positionForEvent;
	@Inject protected SingleTradeLot singleTradeLot;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return prices 
	*/
	public List<? extends PriceSchedule> evaluate(ReportableEventBase reportableEvent) {
		List<PriceSchedule.PriceScheduleBuilder> pricesBuilder = doEvaluate(reportableEvent);
		
		final List<? extends PriceSchedule> prices;
		if (pricesBuilder == null) {
			prices = null;
		} else {
			prices = pricesBuilder.stream().map(PriceSchedule::build).collect(Collectors.toList());
			objectValidator.validate(PriceSchedule.class, prices);
		}
		
		return prices;
	}

	protected abstract List<PriceSchedule.PriceScheduleBuilder> doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends Trade> trade(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends CounterpartyPosition> position(ReportableEventBase reportableEvent);

	public static class Contract_PriceDefault extends Contract_Price {
		@Override
		protected List<PriceSchedule.PriceScheduleBuilder> doEvaluate(ReportableEventBase reportableEvent) {
			List<PriceSchedule.PriceScheduleBuilder> prices = new ArrayList<>();
			return assignOutput(prices, reportableEvent);
		}
		
		protected List<PriceSchedule.PriceScheduleBuilder> assignOutput(List<PriceSchedule.PriceScheduleBuilder> prices, ReportableEventBase reportableEvent) {
			if (exists(trade(reportableEvent)).getOrDefault(false)) {
				prices.addAll(toBuilder(MapperS.of(singleTradeLot.evaluate(trade(reportableEvent).get())).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()).getMulti()));
			} else if (exists(position(reportableEvent)).getOrDefault(false)) {
				prices.addAll(toBuilder(MapperS.of(position(reportableEvent).<TradableProduct>map("getPositionBase", counterpartyPosition -> counterpartyPosition.getPositionBase()).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()).getMulti()));
			} else {
				prices.addAll(toBuilder(Collections.<PriceSchedule>emptyList()));
			}
			
			return Optional.ofNullable(prices)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Trade> trade(ReportableEventBase reportableEvent) {
			return MapperS.of(tradeForEvent.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperS<? extends CounterpartyPosition> position(ReportableEventBase reportableEvent) {
			return MapperS.of(positionForEvent.evaluate(reportableEvent));
		}
	}
}
