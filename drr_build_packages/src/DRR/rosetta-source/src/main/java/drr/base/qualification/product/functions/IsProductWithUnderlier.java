package drr.base.qualification.product.functions;

import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsProductWithUnderlier.IsProductWithUnderlierDefault.class)
public abstract class IsProductWithUnderlier implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;

	/**
	* @param product 
	* @return productWithUnderlier 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean productWithUnderlier = doEvaluate(product);
		
		return productWithUnderlier;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	protected abstract MapperC<? extends Payout> payout(NonTransferableProduct product);

	public static class IsProductWithUnderlierDefault extends IsProductWithUnderlier {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean productWithUnderlier = null;
			return assignOutput(productWithUnderlier, product);
		}
		
		protected Boolean assignOutput(Boolean productWithUnderlier, NonTransferableProduct product) {
			productWithUnderlier = exists(payout(product).<OptionPayout>map("getOptionPayout", _payout -> _payout.getOptionPayout())).orNullSafe(exists(payout(product).<SettlementPayout>map("getSettlementPayout", _payout -> _payout.getSettlementPayout()))).get();
			
			return productWithUnderlier;
		}
		
		@Override
		protected MapperC<? extends Payout> payout(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout());
		}
	}
}
