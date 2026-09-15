package drr.base.qualification.product.functions;

import cdm.product.qualification.functions.Qualify_InterestRate_Option_DebtOption;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsInterestRateDebtOption.IsInterestRateDebtOptionDefault.class)
public abstract class IsInterestRateDebtOption implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected Qualify_InterestRate_Option_DebtOption qualify_InterestRate_Option_DebtOption;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsInterestRateDebtOptionDefault extends IsInterestRateDebtOption {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = areEqual(MapperS.of(qualify_InterestRate_Option_DebtOption.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All).get();
			
			return result;
		}
	}
}
