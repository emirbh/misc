package drr.regulation.common.functions;

import cdm.base.datetime.PeriodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PeriodCalculation.PeriodCalculationDefault.class)
public abstract class PeriodCalculation implements RosettaFunction {

	/**
	* @param period 
	* @param periodMultiplier 
	* @return result 
	*/
	public Integer evaluate(PeriodEnum period, Integer periodMultiplier) {
		Integer result = doEvaluate(period, periodMultiplier);
		
		return result;
	}

	protected abstract Integer doEvaluate(PeriodEnum period, Integer periodMultiplier);

	public static class PeriodCalculationDefault extends PeriodCalculation {
		@Override
		protected Integer doEvaluate(PeriodEnum period, Integer periodMultiplier) {
			Integer result = null;
			return assignOutput(result, period, periodMultiplier);
		}
		
		protected Integer assignOutput(Integer result, PeriodEnum period, Integer periodMultiplier) {
			if (areEqual(MapperS.of(period), MapperS.of(PeriodEnum.D), CardinalityOperator.All).getOrDefault(false)) {
				result = periodMultiplier;
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodEnum.W), CardinalityOperator.All).getOrDefault(false)) {
				result = MapperMaths.<Integer, Integer, Integer>multiply(MapperS.of(periodMultiplier), MapperS.of(7)).get();
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodEnum.M), CardinalityOperator.All).getOrDefault(false)) {
				result = MapperMaths.<Integer, Integer, Integer>multiply(MapperS.of(periodMultiplier), MapperS.of(30)).get();
			} else if (areEqual(MapperS.of(period), MapperS.of(PeriodEnum.Y), CardinalityOperator.All).getOrDefault(false)) {
				result = MapperMaths.<Integer, Integer, Integer>multiply(MapperS.of(periodMultiplier), MapperS.of(365)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
