package drr.base.qualification.product.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.qualification.functions.Qualify_UnderlierObservable_Equity;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsEquity.IsEquityDefault.class)
public abstract class IsEquity implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected Qualify_UnderlierObservable_Equity qualify_UnderlierObservable_Equity;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	public static class IsEquityDefault extends IsEquity {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			final ReferenceWithMetaObservable referenceWithMetaObservable0 = MapperS.of(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).get();
			final ReferenceWithMetaObservable referenceWithMetaObservable1 = MapperS.of(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).get();
			final ReferenceWithMetaObservable referenceWithMetaObservable2 = MapperS.of(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).get();
			result = areEqual(MapperS.of(qualify_UnderlierObservable_Equity.evaluate((referenceWithMetaObservable0 == null ? null : referenceWithMetaObservable0.getValue()))), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(qualify_UnderlierObservable_Equity.evaluate((referenceWithMetaObservable1 == null ? null : referenceWithMetaObservable1.getValue()))), MapperS.of(true), CardinalityOperator.All)).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_UnderlierObservable_Equity.evaluate((referenceWithMetaObservable2 == null ? null : referenceWithMetaObservable2.getValue()))))).get();
			
			return result;
		}
	}
}
