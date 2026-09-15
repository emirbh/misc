package drr.regulation.common.functions;

import cdm.base.datetime.PeriodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.FrequencyPeriodEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FloatingReferencePeriod.FloatingReferencePeriodDefault.class)
public abstract class FloatingReferencePeriod implements RosettaFunction {

	/**
	* @param period 
	* @return result 
	*/
	public FrequencyPeriodEnum evaluate(PeriodEnum period) {
		FrequencyPeriodEnum result = doEvaluate(period);
		
		return result;
	}

	protected abstract FrequencyPeriodEnum doEvaluate(PeriodEnum period);

	public static class FloatingReferencePeriodDefault extends FloatingReferencePeriod {
		@Override
		protected FrequencyPeriodEnum doEvaluate(PeriodEnum period) {
			FrequencyPeriodEnum result = null;
			return assignOutput(result, period);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum result, PeriodEnum period) {
			if (areEqual(MapperS.of(period), MapperS.of(PeriodEnum.D), CardinalityOperator.All).getOrDefault(false)) {
				result = FrequencyPeriodEnum.DAIL;
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodEnum.W), CardinalityOperator.All).getOrDefault(false)) {
				result = FrequencyPeriodEnum.WEEK;
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodEnum.M), CardinalityOperator.All).getOrDefault(false)) {
				result = FrequencyPeriodEnum.MNTH;
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodEnum.Y), CardinalityOperator.All).getOrDefault(false)) {
				result = FrequencyPeriodEnum.YEAR;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
