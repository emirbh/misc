package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Counterparty2IdentifierType_01_Validation.Counterparty2IdentifierType_01_ValidationDefault.class)
public abstract class Counterparty2IdentifierType_01_Validation implements RosettaFunction {

	/**
	* @param counterparty2IdentifierType 
	* @return result 
	*/
	public Boolean evaluate(Boolean counterparty2IdentifierType) {
		Boolean result = doEvaluate(counterparty2IdentifierType);
		
		return result;
	}

	protected abstract Boolean doEvaluate(Boolean counterparty2IdentifierType);

	public static class Counterparty2IdentifierType_01_ValidationDefault extends Counterparty2IdentifierType_01_Validation {
		@Override
		protected Boolean doEvaluate(Boolean counterparty2IdentifierType) {
			Boolean result = null;
			return assignOutput(result, counterparty2IdentifierType);
		}
		
		protected Boolean assignOutput(Boolean result, Boolean counterparty2IdentifierType) {
			result = areEqual(MapperS.of(counterparty2IdentifierType), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(counterparty2IdentifierType), MapperS.of(false), CardinalityOperator.All)).get();
			
			return result;
		}
	}
}
