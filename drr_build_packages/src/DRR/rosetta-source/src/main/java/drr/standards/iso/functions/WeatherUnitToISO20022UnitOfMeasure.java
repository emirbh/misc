package drr.standards.iso.functions;

import cdm.base.math.WeatherUnitEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(WeatherUnitToISO20022UnitOfMeasure.WeatherUnitToISO20022UnitOfMeasureDefault.class)
public abstract class WeatherUnitToISO20022UnitOfMeasure implements RosettaFunction {

	/**
	* @param weatherUnit 
	* @return result 
	*/
	public String evaluate(WeatherUnitEnum weatherUnit) {
		String result = doEvaluate(weatherUnit);
		
		return result;
	}

	protected abstract String doEvaluate(WeatherUnitEnum weatherUnit);

	public static class WeatherUnitToISO20022UnitOfMeasureDefault extends WeatherUnitToISO20022UnitOfMeasure {
		@Override
		protected String doEvaluate(WeatherUnitEnum weatherUnit) {
			String result = null;
			return assignOutput(result, weatherUnit);
		}
		
		protected String assignOutput(String result, WeatherUnitEnum weatherUnit) {
			if (areEqual(MapperS.of(weatherUnit), MapperS.of(WeatherUnitEnum.CDD), CardinalityOperator.All).getOrDefault(false)) {
				result = "CDDA";
			} else if (areEqual(MapperS.of(weatherUnit), MapperS.of(WeatherUnitEnum.CPD), CardinalityOperator.All).getOrDefault(false)) {
				result = "CPDA";
			} else if (areEqual(MapperS.of(weatherUnit), MapperS.of(WeatherUnitEnum.HDD), CardinalityOperator.All).getOrDefault(false)) {
				result = "HDDA";
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
