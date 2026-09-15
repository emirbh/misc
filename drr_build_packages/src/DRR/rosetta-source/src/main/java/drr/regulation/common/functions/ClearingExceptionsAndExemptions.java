package drr.regulation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.ClearingExceptionReasonEnum;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ClearingExceptionsAndExemptions.ClearingExceptionsAndExemptionsDefault.class)
public abstract class ClearingExceptionsAndExemptions implements RosettaFunction {

	/**
	* @param clearingExceptionReason 
	* @return result 
	*/
	public ClearingExceptionsAndExemptionsEnum evaluate(ClearingExceptionReasonEnum clearingExceptionReason) {
		ClearingExceptionsAndExemptionsEnum result = doEvaluate(clearingExceptionReason);
		
		return result;
	}

	protected abstract ClearingExceptionsAndExemptionsEnum doEvaluate(ClearingExceptionReasonEnum clearingExceptionReason);

	public static class ClearingExceptionsAndExemptionsDefault extends ClearingExceptionsAndExemptions {
		@Override
		protected ClearingExceptionsAndExemptionsEnum doEvaluate(ClearingExceptionReasonEnum clearingExceptionReason) {
			ClearingExceptionsAndExemptionsEnum result = null;
			return assignOutput(result, clearingExceptionReason);
		}
		
		protected ClearingExceptionsAndExemptionsEnum assignOutput(ClearingExceptionsAndExemptionsEnum result, ClearingExceptionReasonEnum clearingExceptionReason) {
			if (areEqual(MapperS.of(clearingExceptionReason), MapperS.of(ClearingExceptionReasonEnum.END_USER), CardinalityOperator.All).getOrDefault(false)) {
				result = ClearingExceptionsAndExemptionsEnum.ENDU;
			} else if (areEqual(MapperS.of(clearingExceptionReason), MapperS.of(ClearingExceptionReasonEnum.INTER_AFFILIATE), CardinalityOperator.All).getOrDefault(false)) {
				result = ClearingExceptionsAndExemptionsEnum.AFFL;
			} else if (areEqual(MapperS.of(clearingExceptionReason), MapperS.of(ClearingExceptionReasonEnum.SMALL_BANK), CardinalityOperator.All).getOrDefault(false)) {
				result = ClearingExceptionsAndExemptionsEnum.SMBK;
			} else if (areEqual(MapperS.of(clearingExceptionReason), MapperS.of(ClearingExceptionReasonEnum.COOPERATIVE), CardinalityOperator.All).getOrDefault(false)) {
				result = ClearingExceptionsAndExemptionsEnum.COOP;
			} else if (areEqual(MapperS.of(clearingExceptionReason), MapperS.of(ClearingExceptionReasonEnum.NO_ACTION_LETTER), CardinalityOperator.All).getOrDefault(false)) {
				result = ClearingExceptionsAndExemptionsEnum.NOAL;
			} else if (areEqual(MapperS.of(clearingExceptionReason), MapperS.of(ClearingExceptionReasonEnum.EXCEPTION), CardinalityOperator.All).getOrDefault(false)) {
				result = ClearingExceptionsAndExemptionsEnum.OTHR;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
