package drr.base.qualification.product.functions;

import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsCommoditySwapFixedFloat.IsCommoditySwapFixedFloatDefault.class)
public abstract class IsCommoditySwapFixedFloat implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsCommoditySwapFixedFloatDefault extends IsCommoditySwapFixedFloat {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = areEqual(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All).get();
			
			return result;
		}
	}
}
