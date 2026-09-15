package drr.base.qualification.product.functions;

import cdm.product.qualification.functions.Qualify_ForeignExchange_NDS;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Swap;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;


@ImplementedBy(IsFXSwap.IsFXSwapDefault.class)
public abstract class IsFXSwap implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected Qualify_ForeignExchange_NDS qualify_ForeignExchange_NDS;
	@Inject protected Qualify_ForeignExchange_Swap qualify_ForeignExchange_Swap;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsFXSwapDefault extends IsFXSwap {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Swap.evaluate(economicTermsForProduct.evaluate(product)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDS.evaluate(economicTermsForProduct.evaluate(product))))).get();
			
			return result;
		}
	}
}
