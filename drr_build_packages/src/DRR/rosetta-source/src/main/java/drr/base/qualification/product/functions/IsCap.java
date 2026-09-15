package drr.base.qualification.product.functions;

import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.qualification.functions.Qualify_InterestRate_CapFloor;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.StrikeSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsCap.IsCapDefault.class)
public abstract class IsCap implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected Qualify_InterestRate_CapFloor qualify_InterestRate_CapFloor;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsCapDefault extends IsCap {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			result = areEqual(MapperS.of(qualify_InterestRate_CapFloor.evaluate(economicTermsForProduct.evaluate(product))), MapperS.of(true), CardinalityOperator.All).andNullSafe(exists(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<StrikeSchedule>map("getCapRateSchedule", floatingRateSpecification -> floatingRateSpecification.getCapRateSchedule()))).get();
			
			return result;
		}
	}
}
