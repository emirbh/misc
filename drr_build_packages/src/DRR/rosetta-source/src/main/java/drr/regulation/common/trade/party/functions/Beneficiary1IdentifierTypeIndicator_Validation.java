package drr.regulation.common.trade.party.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ActionTypeEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Beneficiary1IdentifierTypeIndicator_Validation.Beneficiary1IdentifierTypeIndicator_ValidationDefault.class)
public abstract class Beneficiary1IdentifierTypeIndicator_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param beneficiary1 
	* @param beneficiary1IdentifierTypeIndicator 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, String beneficiary1, Boolean beneficiary1IdentifierTypeIndicator) {
		Boolean result = doEvaluate(actionType, beneficiary1, beneficiary1IdentifierTypeIndicator);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, String beneficiary1, Boolean beneficiary1IdentifierTypeIndicator);

	public static class Beneficiary1IdentifierTypeIndicator_ValidationDefault extends Beneficiary1IdentifierTypeIndicator_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, String beneficiary1, Boolean beneficiary1IdentifierTypeIndicator) {
			Boolean result = null;
			return assignOutput(result, actionType, beneficiary1, beneficiary1IdentifierTypeIndicator);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, String beneficiary1, Boolean beneficiary1IdentifierTypeIndicator) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(exists(MapperS.of(beneficiary1))).getOrDefault(false)) {
				result = exists(MapperS.of(beneficiary1IdentifierTypeIndicator)).get();
			} else {
				result = notExists(MapperS.of(beneficiary1IdentifierTypeIndicator)).get();
			}
			
			return result;
		}
	}
}
