package drr.base.trade.functions;

import cdm.event.common.Trade;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(ProductForTrade.ProductForTradeDefault.class)
public abstract class ProductForTrade implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param trade 
	* @return product 
	*/
	public NonTransferableProduct evaluate(Trade trade) {
		NonTransferableProduct.NonTransferableProductBuilder productBuilder = doEvaluate(trade);
		
		final NonTransferableProduct product;
		if (productBuilder == null) {
			product = null;
		} else {
			product = productBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, product);
		}
		
		return product;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(Trade trade);

	public static class ProductForTradeDefault extends ProductForTrade {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(Trade trade) {
			NonTransferableProduct.NonTransferableProductBuilder product = NonTransferableProduct.builder();
			return assignOutput(product, trade);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder product, Trade trade) {
			product = toBuilder(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).get());
			
			return Optional.ofNullable(product)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
