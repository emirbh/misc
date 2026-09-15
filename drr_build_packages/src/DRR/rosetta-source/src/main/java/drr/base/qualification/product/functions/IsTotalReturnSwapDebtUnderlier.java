package drr.base.qualification.product.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Loan;
import cdm.base.staticdata.asset.common.Security;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.qualification.functions.PerformancePayoutAndInterestRatePayoutOnlyExists;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsTotalReturnSwapDebtUnderlier.IsTotalReturnSwapDebtUnderlierDefault.class)
public abstract class IsTotalReturnSwapDebtUnderlier implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected PerformancePayoutAndInterestRatePayoutOnlyExists performancePayoutAndInterestRatePayoutOnlyExists;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	protected abstract MapperS<? extends Underlier> performanceUnderlier(NonTransferableProduct product);

	public static class IsTotalReturnSwapDebtUnderlierDefault extends IsTotalReturnSwapDebtUnderlier {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			final ComparisonResult ifThenElseResult;
			if (exists(performanceUnderlier(product)).getOrDefault(false)) {
				ifThenElseResult = ComparisonResult.ofNullSafe(performanceUnderlier(product).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument())
					.mapSingleToItem(item -> exists(item.<Loan>map("getLoan", instrument -> instrument.getLoan())).orNullSafe(areEqual(item.<Security>map("getSecurity", instrument -> instrument.getSecurity()).<InstrumentTypeEnum>map("getInstrumentType", security -> security.getInstrumentType()), MapperS.of(InstrumentTypeEnum.DEBT), CardinalityOperator.All)).asMapper()));
			} else {
				ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
			}
			result = ComparisonResult.ofNullSafe(MapperS.of(performancePayoutAndInterestRatePayoutOnlyExists.evaluate(MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).getMulti()))).andNullSafe(ifThenElseResult).get();
			
			return result;
		}
		
		@Override
		protected MapperS<? extends Underlier> performanceUnderlier(NonTransferableProduct product) {
			return MapperS.of(MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier());
		}
	}
}
