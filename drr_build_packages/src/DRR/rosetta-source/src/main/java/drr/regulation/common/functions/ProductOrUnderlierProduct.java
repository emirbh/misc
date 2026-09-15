package drr.regulation.common.functions;

import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsProductWithUnderlier;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(ProductOrUnderlierProduct.ProductOrUnderlierProductDefault.class)
public abstract class ProductOrUnderlierProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected IsProductWithUnderlier isProductWithUnderlier;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param product 
	* @return productOrUnderlierProduct 
	*/
	public NonTransferableProduct evaluate(NonTransferableProduct product) {
		NonTransferableProduct.NonTransferableProductBuilder productOrUnderlierProductBuilder = doEvaluate(product);
		
		final NonTransferableProduct productOrUnderlierProduct;
		if (productOrUnderlierProductBuilder == null) {
			productOrUnderlierProduct = null;
		} else {
			productOrUnderlierProduct = productOrUnderlierProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, productOrUnderlierProduct);
		}
		
		return productOrUnderlierProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(NonTransferableProduct product);

	public static class ProductOrUnderlierProductDefault extends ProductOrUnderlierProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(NonTransferableProduct product) {
			NonTransferableProduct.NonTransferableProductBuilder productOrUnderlierProduct = NonTransferableProduct.builder();
			return assignOutput(productOrUnderlierProduct, product);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder productOrUnderlierProduct, NonTransferableProduct product) {
			final Boolean _boolean = isProductWithUnderlier.evaluate(product);
			if ((_boolean == null ? false : _boolean)) {
				productOrUnderlierProduct = toBuilder(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get());
			} else {
				productOrUnderlierProduct = toBuilder(product);
			}
			
			return Optional.ofNullable(productOrUnderlierProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
