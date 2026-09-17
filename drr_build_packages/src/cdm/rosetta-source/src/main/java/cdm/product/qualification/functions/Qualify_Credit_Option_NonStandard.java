package cdm.product.qualification.functions;

import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Qualify_Credit_Option_NonStandard.Qualify_Credit_Option_NonStandardDefault.class)
public abstract class Qualify_Credit_Option_NonStandard implements RosettaFunction,IQualifyFunctionExtension<EconomicTerms> {
	
	// RosettaFunction dependencies
	//
	@Inject protected OptionPayoutOnlyExists optionPayoutOnlyExists;
	@Inject protected Qualify_AssetClass_Credit qualify_AssetClass_Credit;

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

	public static class Qualify_Credit_Option_NonStandardDefault extends Qualify_Credit_Option_NonStandard {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			is_product = ComparisonResult.ofNullSafe(MapperS.of(optionPayoutOnlyExists.evaluate(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).getMulti()))).andNullSafe(areEqual(MapperS.of(qualify_AssetClass_Credit.evaluate(economicTerms)), MapperS.of(true), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(economicTerms).<Boolean>map("getNonStandardisedTerms", _economicTerms -> _economicTerms.getNonStandardisedTerms()), MapperS.of(true), CardinalityOperator.All)).get();
			
			return is_product;
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
