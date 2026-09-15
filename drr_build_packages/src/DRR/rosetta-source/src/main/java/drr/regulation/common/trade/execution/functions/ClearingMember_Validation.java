package drr.regulation.common.trade.execution.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearedEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ClearingMember_Validation.ClearingMember_ValidationDefault.class)
public abstract class ClearingMember_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param cleared 
	* @param centralCounterparty 
	* @param clearingMember 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, ClearedEnum cleared, String centralCounterparty, String clearingMember) {
		Boolean result = doEvaluate(actionType, cleared, centralCounterparty, clearingMember);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, ClearedEnum cleared, String centralCounterparty, String clearingMember);

	public static class ClearingMember_ValidationDefault extends ClearingMember_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, ClearedEnum cleared, String centralCounterparty, String clearingMember) {
			Boolean result = null;
			return assignOutput(result, actionType, cleared, centralCounterparty, clearingMember);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, ClearedEnum cleared, String centralCounterparty, String clearingMember) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(cleared), MapperS.of(ClearedEnum.Y), CardinalityOperator.All)).getOrDefault(false)) {
				result = exists(MapperS.of(clearingMember)).andNullSafe(notEqual(MapperS.of(centralCounterparty), MapperS.of(clearingMember), CardinalityOperator.Any)).get();
			} else if (areEqual(MapperS.of(cleared), MapperS.of(ClearedEnum.N), CardinalityOperator.All).getOrDefault(false)) {
				result = notExists(MapperS.of(clearingMember)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
