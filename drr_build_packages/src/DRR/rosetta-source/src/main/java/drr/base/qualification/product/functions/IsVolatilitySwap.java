package drr.base.qualification.product.functions;

import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_SingleName;
import cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnVolatility;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsVolatilitySwap.IsVolatilitySwapDefault.class)
public abstract class IsVolatilitySwap implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected Qualify_EquitySwap_ParameterReturnVolatility_Basket qualify_EquitySwap_ParameterReturnVolatility_Basket;
	@Inject protected Qualify_EquitySwap_ParameterReturnVolatility_Index qualify_EquitySwap_ParameterReturnVolatility_Index;
	@Inject protected Qualify_EquitySwap_ParameterReturnVolatility_SingleName qualify_EquitySwap_ParameterReturnVolatility_SingleName;
	@Inject protected Qualify_ForeignExchange_ParameterReturnVolatility qualify_ForeignExchange_ParameterReturnVolatility;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsVolatilitySwapDefault extends IsVolatilitySwap {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = areEqual(MapperS.of(qualify_EquitySwap_ParameterReturnVolatility_SingleName.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(qualify_EquitySwap_ParameterReturnVolatility_Index.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(qualify_EquitySwap_ParameterReturnVolatility_Basket.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(qualify_ForeignExchange_ParameterReturnVolatility.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All)).get();
			
			return result;
		}
	}
}
