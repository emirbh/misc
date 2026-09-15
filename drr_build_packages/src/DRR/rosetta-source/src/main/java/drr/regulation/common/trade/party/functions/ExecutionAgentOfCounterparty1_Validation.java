package drr.regulation.common.trade.party.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ActionTypeEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExecutionAgentOfCounterparty1_Validation.ExecutionAgentOfCounterparty1_ValidationDefault.class)
public abstract class ExecutionAgentOfCounterparty1_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param counterparty1 
	* @param counterparty2 
	* @param executionAgentOfCounterparty1 
	* @param executionAgentOfCounterparty2 
	* @param reportingEntity 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, String counterparty1, String counterparty2, String executionAgentOfCounterparty1, String executionAgentOfCounterparty2, String reportingEntity) {
		Boolean result = doEvaluate(actionType, counterparty1, counterparty2, executionAgentOfCounterparty1, executionAgentOfCounterparty2, reportingEntity);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, String counterparty1, String counterparty2, String executionAgentOfCounterparty1, String executionAgentOfCounterparty2, String reportingEntity);

	public static class ExecutionAgentOfCounterparty1_ValidationDefault extends ExecutionAgentOfCounterparty1_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, String counterparty1, String counterparty2, String executionAgentOfCounterparty1, String executionAgentOfCounterparty2, String reportingEntity) {
			Boolean result = null;
			return assignOutput(result, actionType, counterparty1, counterparty2, executionAgentOfCounterparty1, executionAgentOfCounterparty2, reportingEntity);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, String counterparty1, String counterparty2, String executionAgentOfCounterparty1, String executionAgentOfCounterparty2, String reportingEntity) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI), MapperS.of(ActionTypeEnum.TERM), MapperS.of(ActionTypeEnum.PRTO), MapperS.of(ActionTypeEnum.EROR), MapperS.of(ActionTypeEnum.VALU)), MapperS.of(actionType), CardinalityOperator.Any).getOrDefault(false)) {
				final ComparisonResult ifThenElseResult;
				if (areEqual(MapperS.of(executionAgentOfCounterparty1), MapperS.of("NOAP"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult = exists(MapperS.of(executionAgentOfCounterparty2));
				} else {
					ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				result = notEqual(MapperS.of(executionAgentOfCounterparty1), MapperS.of(counterparty1), CardinalityOperator.Any).andNullSafe(notEqual(MapperS.of(executionAgentOfCounterparty1), MapperS.of(counterparty2), CardinalityOperator.Any)).andNullSafe(notEqual(MapperS.of(executionAgentOfCounterparty1), MapperS.of(reportingEntity), CardinalityOperator.Any)).andNullSafe(ifThenElseResult).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
