package drr.base.qualification.product.functions;

import cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_Basket;
import cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_Index;
import cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_SingleName;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsEquityOption.IsEquityOptionDefault.class)
public abstract class IsEquityOption implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected Qualify_EquityOption_PriceReturnBasicPerformance_Basket qualify_EquityOption_PriceReturnBasicPerformance_Basket;
	@Inject protected Qualify_EquityOption_PriceReturnBasicPerformance_Index qualify_EquityOption_PriceReturnBasicPerformance_Index;
	@Inject protected Qualify_EquityOption_PriceReturnBasicPerformance_SingleName qualify_EquityOption_PriceReturnBasicPerformance_SingleName;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsEquityOptionDefault extends IsEquityOption {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = areEqual(MapperS.of(qualify_EquityOption_PriceReturnBasicPerformance_SingleName.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(qualify_EquityOption_PriceReturnBasicPerformance_Index.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(qualify_EquityOption_PriceReturnBasicPerformance_Basket.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All)).get();
			
			return result;
		}
	}
}
