package drr.base.qualification.product.functions;

import cdm.product.asset.CommodityPayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsSingleCommodityPayoutProduct.IsSingleCommodityPayoutProductDefault.class)
public abstract class IsSingleCommodityPayoutProduct implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;

	/**
	* @param product 
	* @return result 
	*/
	public Boolean evaluate(NonTransferableProduct product) {
		Boolean result = doEvaluate(product);
		
		return result;
	}

	protected abstract Boolean doEvaluate(NonTransferableProduct product);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product);

	public static class IsSingleCommodityPayoutProductDefault extends IsSingleCommodityPayoutProduct {
		@Override
		protected Boolean doEvaluate(NonTransferableProduct product) {
			Boolean result = null;
			return assignOutput(result, product);
		}
		
		protected Boolean assignOutput(Boolean result, NonTransferableProduct product) {
			final MapperC<Payout> thenArg = economicTerms(product).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout());
			result = areEqual(MapperS.of(thenArg.resultCount()), MapperS.of(1), CardinalityOperator.All).andNullSafe(exists(thenArg.<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()))).asMapper().get();
			
			return result;
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product) {
			return MapperS.of(economicTermsForProduct.evaluate(product));
		}
	}
}
