package drr.base.qualification.product.functions;

import cdm.event.common.Trade;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Index;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_IndexTranche;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForTrade;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsCreditDefaultSwapIndex.IsCreditDefaultSwapIndexDefault.class)
public abstract class IsCreditDefaultSwapIndex implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected Qualify_CreditDefaultSwap_Index qualify_CreditDefaultSwap_Index;
	@Inject protected Qualify_CreditDefaultSwap_IndexTranche qualify_CreditDefaultSwap_IndexTranche;

	/**
	* @param trade 
	* @return result 
	*/
	public Boolean evaluate(Trade trade) {
		Boolean result = doEvaluate(trade);
		
		return result;
	}

	protected abstract Boolean doEvaluate(Trade trade);

	public static class IsCreditDefaultSwapIndexDefault extends IsCreditDefaultSwapIndex {
		@Override
		protected Boolean doEvaluate(Trade trade) {
			Boolean result = null;
			return assignOutput(result, trade);
		}
		
		protected Boolean assignOutput(Boolean result, Trade trade) {
			result = areEqual(MapperS.of(qualify_CreditDefaultSwap_Index.evaluate(economicTermsForProduct.evaluate(productForTrade.evaluate(trade)))), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTermsForProduct.evaluate(productForTrade.evaluate(trade)))), MapperS.of(true), CardinalityOperator.All)).get();
			
			return result;
		}
	}
}
