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

@ImplementedBy(ClearingTimestamp_Validation.ClearingTimestamp_ValidationDefault.class)
public abstract class ClearingTimestamp_Validation implements RosettaFunction {

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

	public static class ClearingTimestamp_ValidationDefault extends ClearingTimestamp_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, ClearedEnum cleared, ZonedDateTime clearingTimestamp, ZonedDateTime executionTimestamp) {
			Boolean result = null;
			return assignOutput(result, actionType, cleared, clearingTimestamp, executionTimestamp);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, ClearedEnum cleared, ZonedDateTime clearingTimestamp, ZonedDateTime executionTimestamp) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(cleared), MapperS.of(ClearedEnum.Y), CardinalityOperator.All)).getOrDefault(false)) {
				result = exists(MapperS.of(clearingTimestamp)).get();
			} else if (areEqual(MapperS.of(actionType), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(cleared), MapperS.of(ClearedEnum.Y), CardinalityOperator.All)).getOrDefault(false)) {
				result = exists(MapperS.of(clearingTimestamp)).andNullSafe(areEqual(MapperS.of(executionTimestamp), MapperS.of(clearingTimestamp), CardinalityOperator.All)).get();
			} else if (areEqual(MapperS.of(cleared), MapperS.of(ClearedEnum.N), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(cleared), MapperS.of(ClearedEnum.I), CardinalityOperator.All)).getOrDefault(false)) {
				result = notExists(MapperS.of(clearingTimestamp)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
