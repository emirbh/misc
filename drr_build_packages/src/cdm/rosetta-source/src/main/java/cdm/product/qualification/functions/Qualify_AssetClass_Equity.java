package cdm.product.qualification.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.InterestRatePayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Qualify_AssetClass_Equity.Qualify_AssetClass_EquityDefault.class)
public abstract class Qualify_AssetClass_Equity implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected OptionPayoutOnlyExists optionPayoutOnlyExists;
	@Inject protected ProductDeepPathUtil productDeepPathUtil;
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;
	@Inject protected Qualify_UnderlierObservable_Equity qualify_UnderlierObservable_Equity;
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

	protected abstract MapperS<? extends Underlier> optionUnderlier(EconomicTerms economicTerms);

	protected abstract MapperS<? extends Underlier> settlementUnderlier(EconomicTerms economicTerms);

	public static class Qualify_AssetClass_EquityDefault extends Qualify_AssetClass_Equity {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			final ReferenceWithMetaObservable referenceWithMetaObservable0 = optionUnderlier(economicTerms).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).get();
			final ComparisonResult ifThenElseResult0;
			if (exists(optionUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct())).getOrDefault(false)) {
				ifThenElseResult0 = areEqual(MapperS.of(qualify_AssetClass_Equity.evaluate(optionUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).get())), MapperS.of(true), CardinalityOperator.All);
			} else {
				ifThenElseResult0 = ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			final ReferenceWithMetaObservable referenceWithMetaObservable1 = settlementUnderlier(economicTerms).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).get();
			final ComparisonResult ifThenElseResult1;
			if (exists(settlementUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product))).getOrDefault(false)) {
				ifThenElseResult1 = areEqual(MapperS.of(qualify_AssetClass_Equity.evaluate(settlementUnderlier(economicTerms).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).get())), MapperS.of(true), CardinalityOperator.All);
			} else {
				ifThenElseResult1 = ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			is_product = exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout())).andNullSafe(areEqual(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable())
				.mapItem(item -> {
					final ReferenceWithMetaObservable referenceWithMetaObservable = item.get();
					return MapperS.of(qualify_UnderlierObservable_Equity.evaluate((referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue())));
				}), MapperS.of(true), CardinalityOperator.All)).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(optionPayoutOnlyExists.evaluate(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).getMulti()))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_UnderlierObservable_Equity.evaluate((referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue())))).orNullSafe(ifThenElseResult0))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(settlementPayoutOnlyExists.evaluate(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).getMulti()))).orNullSafe(exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout())).andNullSafe(exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_UnderlierObservable_Equity.evaluate((referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue())))).orNullSafe(ifThenElseResult1))).get();
			
			return is_product;
		}
		
		@Override
		protected MapperS<? extends Underlier> optionUnderlier(EconomicTerms economicTerms) {
			return MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier());
		}
		
		@Override
		protected MapperS<? extends Underlier> settlementUnderlier(EconomicTerms economicTerms) {
			return MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier());
		}
	}
}
