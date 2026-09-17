package cdm.product.qualification.functions;

import cdm.product.asset.CreditDefaultPayout;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CreditDefaultPayoutOnlyExists.CreditDefaultPayoutOnlyExistsDefault.class)
public abstract class CreditDefaultPayoutOnlyExists implements RosettaFunction {

	/**
	* @param payouts 
	* @return result 
	*/
	public Boolean evaluate(List<? extends Payout> payouts) {
		Boolean result = doEvaluate(payouts);
		
		return result;
	}

	protected abstract Boolean doEvaluate(List<? extends Payout> payouts);

	public static class CreditDefaultPayoutOnlyExistsDefault extends CreditDefaultPayoutOnlyExists {
		@Override
		protected Boolean doEvaluate(List<? extends Payout> payouts) {
			if (payouts == null) {
				payouts = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, payouts);
		}
		
		protected Boolean assignOutput(Boolean result, List<? extends Payout> payouts) {
			final MapperC<Boolean> thenArg = MapperC.<Payout>of(payouts)
				.mapItem(item -> exists(item.<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout())).asMapper());
			result = areEqual(thenArg, MapperS.of(MapperS.of(true).getOrDefault(false)), CardinalityOperator.All).asMapper().get();
			
			return result;
		}
	}
}
