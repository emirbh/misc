package drr.base.qualification.product.functions;

import cdm.product.qualification.functions.Qualify_Equity_OtherOption;
import cdm.product.qualification.functions.Qualify_Equity_Swap_NonStandard;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsEquityOther.IsEquityOtherDefault.class)
public abstract class IsEquityOther implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected Qualify_Equity_OtherOption qualify_Equity_OtherOption;
	@Inject protected Qualify_Equity_Swap_NonStandard qualify_Equity_Swap_NonStandard;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsEquityOtherDefault extends IsEquityOther {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = areEqual(MapperS.of(qualify_Equity_OtherOption.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(qualify_Equity_Swap_NonStandard.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All)).get();
			
			return result;
		}
	}
}
