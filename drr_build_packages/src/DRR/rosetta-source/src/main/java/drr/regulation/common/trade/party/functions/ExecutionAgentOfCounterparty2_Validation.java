package drr.regulation.common.trade.party.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ActionTypeEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExecutionAgentOfCounterparty2_Validation.ExecutionAgentOfCounterparty2_ValidationDefault.class)
public abstract class ExecutionAgentOfCounterparty2_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param executionAgentOfCounterparty1 
	* @param executionAgentOfCounterparty2 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, String executionAgentOfCounterparty1, String executionAgentOfCounterparty2) {
		Boolean result = doEvaluate(actionType, executionAgentOfCounterparty1, executionAgentOfCounterparty2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, String executionAgentOfCounterparty1, String executionAgentOfCounterparty2);

	public static class ExecutionAgentOfCounterparty2_ValidationDefault extends ExecutionAgentOfCounterparty2_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, String executionAgentOfCounterparty1, String executionAgentOfCounterparty2) {
			Boolean result = null;
			return assignOutput(result, actionType, executionAgentOfCounterparty1, executionAgentOfCounterparty2);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, String executionAgentOfCounterparty1, String executionAgentOfCounterparty2) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.TERM), MapperS.of(ActionTypeEnum.PRTO), MapperS.of(ActionTypeEnum.EROR), MapperS.of(ActionTypeEnum.VALU)), MapperS.of(actionType), CardinalityOperator.Any).getOrDefault(false)) {
				if (areEqual(MapperS.of(executionAgentOfCounterparty1), MapperS.of("NOAP"), CardinalityOperator.All).getOrDefault(false)) {
					result = exists(MapperS.of(executionAgentOfCounterparty2)).get();
				} else {
					result = null;
				}
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
