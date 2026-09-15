package drr.regulation.csa.rewrite.trade.functions;

import cdm.product.common.settlement.PayoutBase;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PayoutMatches.PayoutMatchesDefault.class)
public abstract class PayoutMatches implements RosettaFunction {

	/**
	* @param payout1 
	* @param payout2 
	* @return matches 
	*/
	public Boolean evaluate(PayoutBase payout1, PayoutBase payout2) {
		Boolean matches = doEvaluate(payout1, payout2);
		
		return matches;
	}

	protected abstract Boolean doEvaluate(PayoutBase payout1, PayoutBase payout2);

	public static class PayoutMatchesDefault extends PayoutMatches {
		@Override
		protected Boolean doEvaluate(PayoutBase payout1, PayoutBase payout2) {
			Boolean matches = null;
			return assignOutput(matches, payout1, payout2);
		}
		
		protected Boolean assignOutput(Boolean matches, PayoutBase payout1, PayoutBase payout2) {
			matches = exists(MapperS.of(payout1)).andNullSafe(exists(MapperS.of(payout2))).andNullSafe(areEqual(MapperS.of(payout1), MapperS.of(payout2), CardinalityOperator.All)).orNullSafe(notExists(MapperS.of(payout1)).andNullSafe(notExists(MapperS.of(payout2)))).get();
			
			return matches;
		}
	}
}
