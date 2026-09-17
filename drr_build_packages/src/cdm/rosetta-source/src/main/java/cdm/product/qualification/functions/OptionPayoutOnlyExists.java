package cdm.product.qualification.functions;

import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OptionPayoutOnlyExists.OptionPayoutOnlyExistsDefault.class)
public abstract class OptionPayoutOnlyExists implements RosettaFunction {

	/**
	* @param payouts 
	* @return result 
	*/
	public Boolean evaluate(List<? extends Payout> payouts) {
		Boolean result = doEvaluate(payouts);
		
		return result;
	}

	protected abstract Boolean doEvaluate(List<? extends Payout> payouts);

	public static class OptionPayoutOnlyExistsDefault extends OptionPayoutOnlyExists {
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
				.mapItem(item -> exists(item.<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout())).asMapper());
			result = areEqual(thenArg, MapperS.of(MapperS.of(true).getOrDefault(false)), CardinalityOperator.All).asMapper().get();
			
			return result;
		}
	}
}
