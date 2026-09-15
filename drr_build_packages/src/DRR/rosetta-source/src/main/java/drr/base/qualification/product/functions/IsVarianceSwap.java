package drr.base.qualification.product.functions;

import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDispersion;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_SingleName;
import cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnVariance;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsVarianceSwap.IsVarianceSwapDefault.class)
public abstract class IsVarianceSwap implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected Qualify_EquitySwap_ParameterReturnDispersion qualify_EquitySwap_ParameterReturnDispersion;
	@Inject protected Qualify_EquitySwap_ParameterReturnVariance_Basket qualify_EquitySwap_ParameterReturnVariance_Basket;
	@Inject protected Qualify_EquitySwap_ParameterReturnVariance_Index qualify_EquitySwap_ParameterReturnVariance_Index;
	@Inject protected Qualify_EquitySwap_ParameterReturnVariance_SingleName qualify_EquitySwap_ParameterReturnVariance_SingleName;
	@Inject protected Qualify_ForeignExchange_ParameterReturnVariance qualify_ForeignExchange_ParameterReturnVariance;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsVarianceSwapDefault extends IsVarianceSwap {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = areEqual(MapperS.of(qualify_EquitySwap_ParameterReturnVariance_SingleName.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(qualify_EquitySwap_ParameterReturnVariance_Index.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(qualify_EquitySwap_ParameterReturnVariance_Basket.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(qualify_EquitySwap_ParameterReturnDispersion.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(qualify_ForeignExchange_ParameterReturnVariance.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All)).get();
			
			return result;
		}
	}
}
