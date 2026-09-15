package drr.regulation.jfsa.rewrite.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.FrequencyPeriodEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ReferencePeriodMultiplier_Validation.ReferencePeriodMultiplier_ValidationDefault.class)
public abstract class ReferencePeriodMultiplier_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param frequencyPeriod 
	* @param multiplier 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, FrequencyPeriodEnum frequencyPeriod, Integer multiplier) {
		Boolean result = doEvaluate(actionType, frequencyPeriod, multiplier);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, FrequencyPeriodEnum frequencyPeriod, Integer multiplier);

	public static class ReferencePeriodMultiplier_ValidationDefault extends ReferencePeriodMultiplier_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, FrequencyPeriodEnum frequencyPeriod, Integer multiplier) {
			Boolean result = null;
			return assignOutput(result, actionType, frequencyPeriod, multiplier);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, FrequencyPeriodEnum frequencyPeriod, Integer multiplier) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).andNullSafe(areEqual(MapperC.<FrequencyPeriodEnum>of(MapperS.of(FrequencyPeriodEnum.YEAR), MapperS.of(FrequencyPeriodEnum.MNTH), MapperS.of(FrequencyPeriodEnum.WEEK), MapperS.of(FrequencyPeriodEnum.DAIL)), MapperS.of(frequencyPeriod), CardinalityOperator.Any)).getOrDefault(false)) {
				result = exists(MapperS.of(multiplier)).andNullSafe(greaterThanEquals(MapperS.of(multiplier), MapperS.of(0), CardinalityOperator.All)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
