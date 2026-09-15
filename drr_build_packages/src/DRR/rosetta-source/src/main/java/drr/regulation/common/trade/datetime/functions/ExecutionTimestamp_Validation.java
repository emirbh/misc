package drr.regulation.common.trade.datetime.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearedEnum;
import java.time.ZonedDateTime;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExecutionTimestamp_Validation.ExecutionTimestamp_ValidationDefault.class)
public abstract class ExecutionTimestamp_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param cleared 
	* @param clearingTimestamp 
	* @param executionTimestamp 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, ClearedEnum cleared, ZonedDateTime clearingTimestamp, ZonedDateTime executionTimestamp) {
		Boolean result = doEvaluate(actionType, cleared, clearingTimestamp, executionTimestamp);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, ClearedEnum cleared, ZonedDateTime clearingTimestamp, ZonedDateTime executionTimestamp);

	public static class ExecutionTimestamp_ValidationDefault extends ExecutionTimestamp_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, ClearedEnum cleared, ZonedDateTime clearingTimestamp, ZonedDateTime executionTimestamp) {
			Boolean result = null;
			return assignOutput(result, actionType, cleared, clearingTimestamp, executionTimestamp);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, ClearedEnum cleared, ZonedDateTime clearingTimestamp, ZonedDateTime executionTimestamp) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(actionType), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(cleared), MapperS.of(ClearedEnum.Y), CardinalityOperator.All)).getOrDefault(false)) {
				result = areEqual(MapperS.of(executionTimestamp), MapperS.of(clearingTimestamp), CardinalityOperator.All).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
