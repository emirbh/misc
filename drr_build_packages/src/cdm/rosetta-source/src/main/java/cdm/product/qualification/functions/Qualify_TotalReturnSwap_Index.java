package cdm.product.qualification.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.util.IndexDeepPathUtil;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Qualify_TotalReturnSwap_Index.Qualify_TotalReturnSwap_IndexDefault.class)
public abstract class Qualify_TotalReturnSwap_Index implements RosettaFunction,IQualifyFunctionExtension<EconomicTerms> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IndexDeepPathUtil indexDeepPathUtil;
	@Inject protected PerformancePayoutAndInterestRatePayoutOnlyExists performancePayoutAndInterestRatePayoutOnlyExists;
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

	protected abstract MapperS<? extends Underlier> performanceUnderlier(EconomicTerms economicTerms);

	public static class Qualify_TotalReturnSwap_IndexDefault extends Qualify_TotalReturnSwap_Index {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			final ComparisonResult ifThenElseResult;
			if (exists(performanceUnderlier(economicTerms)).getOrDefault(false)) {
				ifThenElseResult = areEqual(performanceUnderlier(economicTerms).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<AssetClassEnum>map("chooseAssetClass", index -> indexDeepPathUtil.chooseAssetClass(index)), MapperS.of(AssetClassEnum.CREDIT), CardinalityOperator.All);
			} else {
				ifThenElseResult = ComparisonResult.ofEmpty();
			}
			is_product = areEqual(MapperS.of(qualify_AssetClass_Credit.evaluate(economicTerms)), MapperS.of(true), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(performancePayoutAndInterestRatePayoutOnlyExists.evaluate(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).getMulti()))).andNullSafe(ifThenElseResult)).get();
			
			return is_product;
		}
		
		@Override
		protected MapperS<? extends Underlier> performanceUnderlier(EconomicTerms economicTerms) {
			return MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier());
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
