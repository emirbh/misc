package cdm.product.qualification.functions;

import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Qualify_BaseProduct_EquityForward.Qualify_BaseProduct_EquityForwardDefault.class)
public abstract class Qualify_BaseProduct_EquityForward implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;
	@Inject protected SettlementPayoutOnlyExists settlementPayoutOnlyExists;

	/**
	* @param economicTerms 
	* @return is_product 
	*/
	public Boolean evaluate(EconomicTerms economicTerms) {
		Boolean is_product = doEvaluate(economicTerms);
		
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);

	public static class Qualify_BaseProduct_EquityForwardDefault extends Qualify_BaseProduct_EquityForward {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			is_product = areEqual(MapperS.of(qualify_AssetClass_Equity.evaluate(economicTerms)), MapperS.of(true), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(settlementPayoutOnlyExists.evaluate(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).getMulti())))).andNullSafe(notExists(MapperS.of(economicTerms).<Boolean>map("getNonStandardisedTerms", _economicTerms -> _economicTerms.getNonStandardisedTerms())).orNullSafe(areEqual(MapperS.of(economicTerms).<Boolean>map("getNonStandardisedTerms", _economicTerms -> _economicTerms.getNonStandardisedTerms()), MapperS.of(false), CardinalityOperator.All))).get();
			
			return is_product;
		}
	}
}
