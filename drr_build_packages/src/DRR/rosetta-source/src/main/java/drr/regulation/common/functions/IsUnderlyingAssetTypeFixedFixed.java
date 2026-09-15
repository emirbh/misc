package drr.regulation.common.functions;

import cdm.product.qualification.functions.Qualify_InterestRate_CrossCurrency_FixedFixed;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_FixedFixed;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import javax.inject.Inject;


@ImplementedBy(IsUnderlyingAssetTypeFixedFixed.IsUnderlyingAssetTypeFixedFixedDefault.class)
public abstract class IsUnderlyingAssetTypeFixedFixed implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_InterestRate_CrossCurrency_FixedFixed qualify_InterestRate_CrossCurrency_FixedFixed;
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

	public static class IsUnderlyingAssetTypeFixedFixedDefault extends IsUnderlyingAssetTypeFixedFixed {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean result = null;
			return assignOutput(result, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean result, ReportableEventBase reportableEvent) {
			result = ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_CrossCurrency_FixedFixed.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_IRSwap_FixedFixed.evaluate(economicTerms(reportableEvent).get())))).get();
			
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
