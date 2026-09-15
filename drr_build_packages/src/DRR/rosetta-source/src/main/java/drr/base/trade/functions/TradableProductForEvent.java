package drr.base.trade.functions;

import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(TradableProductForEvent.TradableProductForEventDefault.class)
public abstract class TradableProductForEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected PositionForEvent positionForEvent;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return tradableProduct 
	*/
	public TradableProduct evaluate(ReportableEventBase reportableEvent) {
		TradableProduct.TradableProductBuilder tradableProductBuilder = doEvaluate(reportableEvent);
		
		final TradableProduct tradableProduct;
		if (tradableProductBuilder == null) {
			tradableProduct = null;
		} else {
			tradableProduct = tradableProductBuilder.build();
			objectValidator.validate(TradableProduct.class, tradableProduct);
		}
		
		return tradableProduct;
	}

	protected abstract TradableProduct.TradableProductBuilder doEvaluate(ReportableEventBase reportableEvent);

	public static class TradableProductForEventDefault extends TradableProductForEvent {
		@Override
		protected TradableProduct.TradableProductBuilder doEvaluate(ReportableEventBase reportableEvent) {
			TradableProduct.TradableProductBuilder tradableProduct = TradableProduct.builder();
			return assignOutput(tradableProduct, reportableEvent);
		}
		
		protected TradableProduct.TradableProductBuilder assignOutput(TradableProduct.TradableProductBuilder tradableProduct, ReportableEventBase reportableEvent) {
			if (exists(MapperS.of(tradeForEvent.evaluate(reportableEvent))).getOrDefault(false)) {
				tradableProduct = toBuilder(tradeForEvent.evaluate(reportableEvent));
			} else if (exists(MapperS.of(positionForEvent.evaluate(reportableEvent))).getOrDefault(false)) {
				tradableProduct = toBuilder(MapperS.of(positionForEvent.evaluate(reportableEvent)).<TradableProduct>map("getPositionBase", counterpartyPosition -> counterpartyPosition.getPositionBase()).get());
			} else {
				tradableProduct = null;
			}
			
			return Optional.ofNullable(tradableProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
