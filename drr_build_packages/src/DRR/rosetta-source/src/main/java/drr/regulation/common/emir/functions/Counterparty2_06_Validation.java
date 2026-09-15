package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Counterparty2_06_Validation.Counterparty2_06_ValidationDefault.class)
public abstract class Counterparty2_06_Validation implements RosettaFunction {

	/**
	* @param counterparty2IdentifierType 
	* @param counterparty2 
	* @return result 
	*/
	public Boolean evaluate(Boolean counterparty2IdentifierType, String counterparty2) {
		Boolean result = doEvaluate(counterparty2IdentifierType, counterparty2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(Boolean counterparty2IdentifierType, String counterparty2);

	public static class Counterparty2_06_ValidationDefault extends Counterparty2_06_Validation {
		@Override
		protected Boolean doEvaluate(Boolean counterparty2IdentifierType, String counterparty2) {
			Boolean result = null;
			return assignOutput(result, counterparty2IdentifierType, counterparty2);
		}
		
		protected Boolean assignOutput(Boolean result, Boolean counterparty2IdentifierType, String counterparty2) {
			if (areEqual(MapperS.of(counterparty2IdentifierType), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				result = exists(MapperS.of(counterparty2)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
