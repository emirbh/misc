package drr.base.trade.functions;

import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ProductForEvent.ProductForEventDefault.class)
public abstract class ProductForEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected PositionForEvent positionForEvent;
	@Inject protected ProductForPosition productForPosition;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return product 
	*/
	public NonTransferableProduct evaluate(ReportableEventBase reportableEvent) {
		NonTransferableProduct.NonTransferableProductBuilder productBuilder = doEvaluate(reportableEvent);
		
		final NonTransferableProduct product;
		if (productBuilder == null) {
			product = null;
		} else {
			product = productBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, product);
		}
		
		return product;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(ReportableEventBase reportableEvent);

	public static class ProductForEventDefault extends ProductForEvent {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(ReportableEventBase reportableEvent) {
			NonTransferableProduct.NonTransferableProductBuilder product = NonTransferableProduct.builder();
			return assignOutput(product, reportableEvent);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder product, ReportableEventBase reportableEvent) {
			if (exists(MapperS.of(tradeForEvent.evaluate(reportableEvent))).getOrDefault(false)) {
				product = toBuilder(productForTrade.evaluate(tradeForEvent.evaluate(reportableEvent)));
			} else if (exists(MapperS.of(positionForEvent.evaluate(reportableEvent))).getOrDefault(false)) {
				product = toBuilder(productForPosition.evaluate(positionForEvent.evaluate(reportableEvent)));
			} else {
				product = null;
			}
			
			return Optional.ofNullable(product)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
