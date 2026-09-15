package drr.base.qualification.product.functions;

import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;


@ImplementedBy(IsFXProduct.IsFXProductDefault.class)
public abstract class IsFXProduct implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsFXForward isFXForward;
	@Inject protected IsFXOption isFXOption;
	@Inject protected IsFXSwap isFXSwap;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsFXProductDefault extends IsFXProduct {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = ComparisonResult.ofNullSafe(MapperS.of(isFXForward.evaluate(product))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXOption.evaluate(product)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXSwap.evaluate(product)))).get();
			
			return result;
		}
	}
}
