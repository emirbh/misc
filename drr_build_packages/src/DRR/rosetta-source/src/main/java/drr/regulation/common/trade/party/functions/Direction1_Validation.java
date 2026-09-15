package drr.regulation.common.trade.party.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.Direction2Enum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Direction1_Validation.Direction1_ValidationDefault.class)
public abstract class Direction1_Validation implements RosettaFunction {

	/**
	* @param direction1 
	* @param direction2Leg1 
	* @param direction2Leg2 
	* @return result 
	*/
	public Boolean evaluate(Direction1Enum direction1, Direction2Enum direction2Leg1, Direction2Enum direction2Leg2) {
		Boolean result = doEvaluate(direction1, direction2Leg1, direction2Leg2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(Direction1Enum direction1, Direction2Enum direction2Leg1, Direction2Enum direction2Leg2);

	public static class Direction1_ValidationDefault extends Direction1_Validation {
		@Override
		protected Boolean doEvaluate(Direction1Enum direction1, Direction2Enum direction2Leg1, Direction2Enum direction2Leg2) {
			Boolean result = null;
			return assignOutput(result, direction1, direction2Leg1, direction2Leg2);
		}
		
		protected Boolean assignOutput(Boolean result, Direction1Enum direction1, Direction2Enum direction2Leg1, Direction2Enum direction2Leg2) {
			if (notExists(MapperS.of(direction2Leg1)).andNullSafe(notExists(MapperS.of(direction2Leg2))).getOrDefault(false)) {
				result = exists(MapperS.of(direction1)).get();
			} else if (exists(MapperS.of(direction2Leg1)).orNullSafe(exists(MapperS.of(direction2Leg2))).getOrDefault(false)) {
				result = notExists(MapperS.of(direction1)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
