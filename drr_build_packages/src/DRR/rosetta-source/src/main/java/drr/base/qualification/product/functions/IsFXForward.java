package drr.base.qualification.product.functions;

import cdm.product.qualification.functions.Qualify_ForeignExchange_NDF;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Spot_Forward;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsFXForward.IsFXForwardDefault.class)
public abstract class IsFXForward implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsProductETD isProductETD;
	@Inject protected Qualify_ForeignExchange_NDF qualify_ForeignExchange_NDF;
	@Inject protected Qualify_ForeignExchange_Spot_Forward qualify_ForeignExchange_Spot_Forward;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsFXForwardDefault extends IsFXForward {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = areEqual(MapperS.of(qualify_ForeignExchange_Spot_Forward.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(qualify_ForeignExchange_NDF.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(isProductETD.evaluate(product)), MapperS.of(false), CardinalityOperator.All)).get();
			
			return result;
		}
	}
}
