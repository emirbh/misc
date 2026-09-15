package drr.regulation.common.trade.party.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.Direction2Enum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Direction2Leg2_Validation.Direction2Leg2_ValidationDefault.class)
public abstract class Direction2Leg2_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param direction1 
	* @param direction2Leg1 
	* @param direction2Leg2 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, Direction1Enum direction1, Direction2Enum direction2Leg1, Direction2Enum direction2Leg2) {
		Boolean result = doEvaluate(actionType, direction1, direction2Leg1, direction2Leg2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, Direction1Enum direction1, Direction2Enum direction2Leg1, Direction2Enum direction2Leg2);

	public static class Direction2Leg2_ValidationDefault extends Direction2Leg2_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, Direction1Enum direction1, Direction2Enum direction2Leg1, Direction2Enum direction2Leg2) {
			Boolean result = null;
			return assignOutput(result, actionType, direction1, direction2Leg1, direction2Leg2);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, Direction1Enum direction1, Direction2Enum direction2Leg1, Direction2Enum direction2Leg2) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(exists(MapperS.of(direction2Leg1))).getOrDefault(false)) {
				result = exists(MapperS.of(direction2Leg2)).andNullSafe(notEqual(MapperS.of(direction2Leg1), MapperS.of(direction2Leg2), CardinalityOperator.Any)).get();
			} else if (notExists(MapperS.of(direction1)).andNullSafe(notExists(MapperS.of(direction2Leg1))).getOrDefault(false)) {
				result = notExists(MapperS.of(direction2Leg2)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
