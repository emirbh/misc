package cdm.product.qualification.functions;

import cdm.product.asset.InterestRatePayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Qualify_Equity_Swap_NonStandard.Qualify_Equity_Swap_NonStandardDefault.class)
public abstract class Qualify_Equity_Swap_NonStandard implements RosettaFunction,IQualifyFunctionExtension<EconomicTerms> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PerformancePayoutAndInterestRatePayoutOnlyExists performancePayoutAndInterestRatePayoutOnlyExists;
	@Inject protected Qualify_BaseProduct_EquitySwap qualify_BaseProduct_EquitySwap;

	/**
	* @param economicTerms 
	* @return is_product 
	*/
	@Override
	public Boolean evaluate(EconomicTerms economicTerms) {
		Boolean is_product = doEvaluate(economicTerms);
		
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);

	public static class Qualify_Equity_Swap_NonStandardDefault extends Qualify_Equity_Swap_NonStandard {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			is_product = areEqual(MapperS.of(qualify_BaseProduct_EquitySwap.evaluate(economicTerms)), MapperS.of(true), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(performancePayoutAndInterestRatePayoutOnlyExists.evaluate(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).getMulti()))).andNullSafe(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).resultCount()), MapperS.of(1), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).resultCount()), MapperS.of(1), CardinalityOperator.All))).andNullSafe(areEqual(MapperS.of(economicTerms).<Boolean>map("getNonStandardisedTerms", _economicTerms -> _economicTerms.getNonStandardisedTerms()), MapperS.of(true), CardinalityOperator.All)).get();
			
			return is_product;
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
