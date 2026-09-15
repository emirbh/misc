package drr.base.qualification.product.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.qualification.functions.Qualify_UnderlierObservable_Equity;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;


@ImplementedBy(IsEquityForward.IsEquityForwardDefault.class)
public abstract class IsEquityForward implements RosettaFunction {
	
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

	public static class IsEquityForwardDefault extends IsEquityForward {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			final ReferenceWithMetaObservable referenceWithMetaObservable = MapperS.of(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).get();
			result = qualify_UnderlierObservable_Equity.evaluate((referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()));
			
			return result;
		}
	}
}
