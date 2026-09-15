package drr.regulation.common.trade.price.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonContractType;
import drr.standards.iso.ActionTypeEnum;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OptionPremiumAmount_Validation.OptionPremiumAmount_ValidationDefault.class)
public abstract class OptionPremiumAmount_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param contractType 
	* @param optionPremiumAmount 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, CommonContractType contractType, BigDecimal optionPremiumAmount) {
		Boolean result = doEvaluate(actionType, contractType, optionPremiumAmount);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, CommonContractType contractType, BigDecimal optionPremiumAmount);

	public static class OptionPremiumAmount_ValidationDefault extends OptionPremiumAmount_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, CommonContractType contractType, BigDecimal optionPremiumAmount) {
			Boolean result = null;
			return assignOutput(result, actionType, contractType, optionPremiumAmount);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, CommonContractType contractType, BigDecimal optionPremiumAmount) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<CommonContractType>of(MapperS.of(CommonContractType.OPTN), MapperS.of(CommonContractType.SWPT)), MapperS.of(contractType), CardinalityOperator.Any)).getOrDefault(false)) {
				result = exists(MapperS.of(optionPremiumAmount)).andNullSafe(greaterThanEquals(MapperS.of(optionPremiumAmount), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
