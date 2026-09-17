package cdm.ingest.fpml.confirmation.other.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFrequencyToPeriodMultiplier.MapFrequencyToPeriodMultiplierDefault.class)
public abstract class MapFrequencyToPeriodMultiplier implements RosettaFunction {

	/**
	* @param period 
	* @return periodMultiplier 
	*/
	public Integer evaluate(String period) {
		Integer periodMultiplier = doEvaluate(period);
		
		return periodMultiplier;
	}

	protected abstract Integer doEvaluate(String period);

	public static class MapFrequencyToPeriodMultiplierDefault extends MapFrequencyToPeriodMultiplier {
		@Override
		protected Integer doEvaluate(String period) {
			Integer periodMultiplier = null;
			return assignOutput(periodMultiplier, period);
		}
		
		protected Integer assignOutput(Integer periodMultiplier, String period) {
			if (areEqual(MapperC.<String>of(MapperS.of("PerHour"), MapperS.of("PerCalendarDay"), MapperS.of("PerMonth"), MapperS.of("PerCalculationPeriod"), MapperS.of("PerSettlementPeriod"), MapperS.of("PerCalculationDay")), MapperS.of(period), CardinalityOperator.Any).getOrDefault(false)) {
				periodMultiplier = 1;
			} else {
				periodMultiplier = null;
			}
			
			return periodMultiplier;
		}
	}
}
