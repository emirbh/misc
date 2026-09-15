package drr.standards.iso.functions;

import cdm.base.datetime.PeriodExtendedEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iso.FrequencyPeriodEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ConvertPeriodtoISOFrequencyPeriod.ConvertPeriodtoISOFrequencyPeriodDefault.class)
public abstract class ConvertPeriodtoISOFrequencyPeriod implements RosettaFunction {

	/**
	* @param period 
	* @return periodValue 
	*/
	public FrequencyPeriodEnum evaluate(PeriodExtendedEnum period) {
		FrequencyPeriodEnum periodValue = doEvaluate(period);
		
		return periodValue;
	}

	protected abstract FrequencyPeriodEnum doEvaluate(PeriodExtendedEnum period);

	public static class ConvertPeriodtoISOFrequencyPeriodDefault extends ConvertPeriodtoISOFrequencyPeriod {
		@Override
		protected FrequencyPeriodEnum doEvaluate(PeriodExtendedEnum period) {
			FrequencyPeriodEnum periodValue = null;
			return assignOutput(periodValue, period);
		}
		
		protected FrequencyPeriodEnum assignOutput(FrequencyPeriodEnum periodValue, PeriodExtendedEnum period) {
			if (areEqual(MapperS.of(period), MapperS.of(PeriodExtendedEnum.H), CardinalityOperator.All).getOrDefault(false)) {
				periodValue = FrequencyPeriodEnum.HOUL;
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodExtendedEnum.D), CardinalityOperator.All).getOrDefault(false)) {
				periodValue = FrequencyPeriodEnum.DAIL;
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodExtendedEnum.W), CardinalityOperator.All).getOrDefault(false)) {
				periodValue = FrequencyPeriodEnum.WEEK;
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodExtendedEnum.M), CardinalityOperator.All).getOrDefault(false)) {
				periodValue = FrequencyPeriodEnum.MNTH;
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodExtendedEnum.Y), CardinalityOperator.All).getOrDefault(false)) {
				periodValue = FrequencyPeriodEnum.YEAR;
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodExtendedEnum.T), CardinalityOperator.All).getOrDefault(false)) {
				periodValue = FrequencyPeriodEnum.EXPI;
			} else {
				periodValue = null;
			}
			
			return periodValue;
		}
	}
}
