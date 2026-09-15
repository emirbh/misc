package drr.regulation.common.functions;

import cdm.product.qualification.functions.Qualify_BaseProduct_EquitySwap;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Index;
import cdm.product.qualification.functions.Qualify_EquityForward_PriceReturnBasicPerformance_SingleIndex;
import cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_PriceReturnBasicPerformance_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_TotalReturnBasicPerformance_Index;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_FixedFixed;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCommodityForward_SingleIndex;
import drr.base.qualification.product.functions.IsCommodityOption_SingleIndex;
import drr.base.qualification.product.functions.IsCommoditySwap_SingleIndex;
import drr.base.qualification.product.functions.IsCommoditySwaption;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import javax.inject.Inject;


@ImplementedBy(IsUnderlyingAssetTypeIndex.IsUnderlyingAssetTypeIndexDefault.class)
public abstract class IsUnderlyingAssetTypeIndex implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCommodityForward_SingleIndex isCommodityForward_SingleIndex;
	@Inject protected IsCommodityOption_SingleIndex isCommodityOption_SingleIndex;
	@Inject protected IsCommoditySwap_SingleIndex isCommoditySwap_SingleIndex;
	@Inject protected IsCommoditySwaption isCommoditySwaption;
	@Inject protected IsCreditTotalReturnSwap isCreditTotalReturnSwap;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_BaseProduct_EquitySwap qualify_BaseProduct_EquitySwap;
	@Inject protected Qualify_CreditDefaultSwap_Index qualify_CreditDefaultSwap_Index;
	@Inject protected Qualify_EquityForward_PriceReturnBasicPerformance_SingleIndex qualify_EquityForward_PriceReturnBasicPerformance_SingleIndex;
	@Inject protected Qualify_EquityOption_PriceReturnBasicPerformance_Index qualify_EquityOption_PriceReturnBasicPerformance_Index;
	@Inject protected Qualify_EquitySwap_ParameterReturnDividend_Index qualify_EquitySwap_ParameterReturnDividend_Index;
	@Inject protected Qualify_EquitySwap_ParameterReturnVariance_Index qualify_EquitySwap_ParameterReturnVariance_Index;
	@Inject protected Qualify_EquitySwap_ParameterReturnVolatility_Index qualify_EquitySwap_ParameterReturnVolatility_Index;
	@Inject protected Qualify_EquitySwap_PriceReturnBasicPerformance_Index qualify_EquitySwap_PriceReturnBasicPerformance_Index;
	@Inject protected Qualify_EquitySwap_TotalReturnBasicPerformance_Index qualify_EquitySwap_TotalReturnBasicPerformance_Index;
	@Inject protected Qualify_InterestRate_IRSwap_FixedFixed qualify_InterestRate_IRSwap_FixedFixed;

	/**
	* @param reportableEvent 
	* @return result 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean result = doEvaluate(reportableEvent);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent);

	public static class IsUnderlyingAssetTypeIndexDefault extends IsUnderlyingAssetTypeIndex {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean result = null;
			return assignOutput(result, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean result, ReportableEventBase reportableEvent) {
			result = ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Index.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCreditTotalReturnSwap.evaluate(product(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_IRSwap_FixedFixed.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwap_SingleIndex.evaluate(product(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommodityForward_SingleIndex.evaluate(product(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommodityOption_SingleIndex.evaluate(product(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommoditySwaption.evaluate(product(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquitySwap_ParameterReturnDividend_Index.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquitySwap_ParameterReturnVariance_Index.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquitySwap_ParameterReturnVolatility_Index.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquitySwap_TotalReturnBasicPerformance_Index.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquitySwap_PriceReturnBasicPerformance_Index.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquityForward_PriceReturnBasicPerformance_SingleIndex.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_EquitySwap.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_EquityOption_PriceReturnBasicPerformance_Index.evaluate(economicTerms(reportableEvent).get())))).get();
			
			return result;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent) {
			return MapperS.of(productForEvent.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent) {
			return MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get()));
		}
	}
}
