package drr.base.trade.functions;

import cdm.event.position.CounterpartyPosition;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(ProductForPosition.ProductForPositionDefault.class)
public abstract class ProductForPosition implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param position 
	* @return product 
	*/
	public NonTransferableProduct evaluate(CounterpartyPosition position) {
		NonTransferableProduct.NonTransferableProductBuilder productBuilder = doEvaluate(position);
		
		final NonTransferableProduct product;
		if (productBuilder == null) {
			product = null;
		} else {
			product = productBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, product);
		}
		
		return product;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CounterpartyPosition position);

	public static class ProductForPositionDefault extends ProductForPosition {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(CounterpartyPosition position) {
			NonTransferableProduct.NonTransferableProductBuilder product = NonTransferableProduct.builder();
			return assignOutput(product, position);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder product, CounterpartyPosition position) {
			product = toBuilder(MapperS.of(position).<TradableProduct>map("getPositionBase", counterpartyPosition -> counterpartyPosition.getPositionBase()).<NonTransferableProduct>map("getProduct", tradableProduct -> tradableProduct.getProduct()).get());
			
			return Optional.ofNullable(product)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
