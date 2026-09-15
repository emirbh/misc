package drr.base.qualification.product.functions;

import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_SingleName;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsDividendSwap.IsDividendSwapDefault.class)
public abstract class IsDividendSwap implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected Qualify_EquitySwap_ParameterReturnDividend_Basket qualify_EquitySwap_ParameterReturnDividend_Basket;
	@Inject protected Qualify_EquitySwap_ParameterReturnDividend_Index qualify_EquitySwap_ParameterReturnDividend_Index;
	@Inject protected Qualify_EquitySwap_ParameterReturnDividend_SingleName qualify_EquitySwap_ParameterReturnDividend_SingleName;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsDividendSwapDefault extends IsDividendSwap {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = areEqual(MapperS.of(qualify_EquitySwap_ParameterReturnDividend_SingleName.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(qualify_EquitySwap_ParameterReturnDividend_Index.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(qualify_EquitySwap_ParameterReturnDividend_Basket.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All)).get();
			
			return result;
		}
	}
}
