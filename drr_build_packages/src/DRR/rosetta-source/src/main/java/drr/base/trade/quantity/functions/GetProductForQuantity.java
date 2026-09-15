package drr.base.trade.quantity.functions;

import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.BeforeTradeForEvent;
import drr.base.trade.functions.TradableProductForEvent;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetProductForQuantity.GetProductForQuantityDefault.class)
public abstract class GetProductForQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected BeforeTradeForEvent beforeTradeForEvent;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected TradableProductForEvent tradableProductForEvent;

	/**
	* @param reportableEvent 
	* @return product 
	*/
	public TradableProduct evaluate(ReportableEventBase reportableEvent) {
		TradableProduct.TradableProductBuilder productBuilder = doEvaluate(reportableEvent);
		
		final TradableProduct product;
		if (productBuilder == null) {
			product = null;
		} else {
			product = productBuilder.build();
			objectValidator.validate(TradableProduct.class, product);
		}
		
		return product;
	}

	protected abstract TradableProduct.TradableProductBuilder doEvaluate(ReportableEventBase reportableEvent);

	public static class GetProductForQuantityDefault extends GetProductForQuantity {
		@Override
		protected TradableProduct.TradableProductBuilder doEvaluate(ReportableEventBase reportableEvent) {
			TradableProduct.TradableProductBuilder product = TradableProduct.builder();
			return assignOutput(product, reportableEvent);
		}
		
		protected TradableProduct.TradableProductBuilder assignOutput(TradableProduct.TradableProductBuilder product, ReportableEventBase reportableEvent) {
			final Boolean _boolean = isActionTypeTERM.evaluate(reportableEvent);
			if ((_boolean == null ? false : _boolean)) {
				product = toBuilder(beforeTradeForEvent.evaluate(reportableEvent));
			} else {
				product = toBuilder(tradableProductForEvent.evaluate(reportableEvent));
			}
			
			return Optional.ofNullable(product)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
