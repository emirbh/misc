package drr.standards.iosco.uti.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ActionTypeEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UniqueTransactionIdentifier_Validation.UniqueTransactionIdentifier_ValidationDefault.class)
public abstract class UniqueTransactionIdentifier_Validation implements RosettaFunction {

	/**
	* @param uniqueTransactionIdentifier 
	* @param uniqueTransactionIdentifierProprietary 
	* @param priorUTI 
	* @param priorUTIProprietary 
	* @param actionType 
	* @return result 
	*/
	public Boolean evaluate(String uniqueTransactionIdentifier, String uniqueTransactionIdentifierProprietary, String priorUTI, String priorUTIProprietary, ActionTypeEnum actionType) {
		Boolean result = doEvaluate(uniqueTransactionIdentifier, uniqueTransactionIdentifierProprietary, priorUTI, priorUTIProprietary, actionType);
		
		return result;
	}

	protected abstract Boolean doEvaluate(String uniqueTransactionIdentifier, String uniqueTransactionIdentifierProprietary, String priorUTI, String priorUTIProprietary, ActionTypeEnum actionType);

	public static class UniqueTransactionIdentifier_ValidationDefault extends UniqueTransactionIdentifier_Validation {
		@Override
		protected Boolean doEvaluate(String uniqueTransactionIdentifier, String uniqueTransactionIdentifierProprietary, String priorUTI, String priorUTIProprietary, ActionTypeEnum actionType) {
			Boolean result = null;
			return assignOutput(result, uniqueTransactionIdentifier, uniqueTransactionIdentifierProprietary, priorUTI, priorUTIProprietary, actionType);
		}
		
		protected Boolean assignOutput(Boolean result, String uniqueTransactionIdentifier, String uniqueTransactionIdentifierProprietary, String priorUTI, String priorUTIProprietary, ActionTypeEnum actionType) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).getOrDefault(false)) {
				final ComparisonResult ifThenElseResult;
				if (areEqual(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(actionType), CardinalityOperator.All).andNullSafe(exists(MapperS.of(uniqueTransactionIdentifierProprietary))).getOrDefault(false)) {
					ifThenElseResult = notExists(MapperS.of(uniqueTransactionIdentifier));
				} else {
					ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				result = notEqual(MapperS.of(uniqueTransactionIdentifier), MapperS.of(priorUTI), CardinalityOperator.Any).andNullSafe(notEqual(MapperS.of(uniqueTransactionIdentifierProprietary), MapperS.of(priorUTIProprietary), CardinalityOperator.Any)).andNullSafe(ifThenElseResult).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
