package drr.regulation.common.trade.party.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ActionTypeEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Beneficiary1_Validation.Beneficiary1_ValidationDefault.class)
public abstract class Beneficiary1_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param beneficiary1 
	* @param counterparty1 
	* @param reportingEntity 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, String beneficiary1, String counterparty1, String reportingEntity) {
		Boolean result = doEvaluate(actionType, beneficiary1, counterparty1, reportingEntity);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, String beneficiary1, String counterparty1, String reportingEntity);

	public static class Beneficiary1_ValidationDefault extends Beneficiary1_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, String beneficiary1, String counterparty1, String reportingEntity) {
			Boolean result = null;
			return assignOutput(result, actionType, beneficiary1, counterparty1, reportingEntity);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, String beneficiary1, String counterparty1, String reportingEntity) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).getOrDefault(false)) {
				result = notEqual(MapperS.of(beneficiary1), MapperS.of(counterparty1), CardinalityOperator.Any).andNullSafe(notEqual(MapperS.of(beneficiary1), MapperS.of(reportingEntity), CardinalityOperator.Any)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
