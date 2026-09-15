package drr.standards.iso.functions;

import cdm.base.math.CapacityUnitEnum;
import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.UnitType;
import cdm.base.math.WeatherUnitEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnitToISO20022UnitOfMeasure.UnitToISO20022UnitOfMeasureDefault.class)
public abstract class UnitToISO20022UnitOfMeasure implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CapacityUnitToISO20022UnitOfMeasure capacityUnitToISO20022UnitOfMeasure;
	@Inject protected FinancialUnitToISO20022UnitOfMeasure financialUnitToISO20022UnitOfMeasure;
	@Inject protected WeatherUnitToISO20022UnitOfMeasure weatherUnitToISO20022UnitOfMeasure;

	/**
	* @param unit 
	* @return unitOfMeasure 
	*/
	public String evaluate(UnitType unit) {
		String unitOfMeasure = doEvaluate(unit);
		
		return unitOfMeasure;
	}

	protected abstract String doEvaluate(UnitType unit);

	public static class UnitToISO20022UnitOfMeasureDefault extends UnitToISO20022UnitOfMeasure {
		@Override
		protected String doEvaluate(UnitType unit) {
			String unitOfMeasure = null;
			return assignOutput(unitOfMeasure, unit);
		}
		
		protected String assignOutput(String unitOfMeasure, UnitType unit) {
			unitOfMeasure = MapperS.of(unit)
				.mapSingleToItem(item -> {
					if (exists(item.<CapacityUnitEnum>map("getCapacityUnit", unitType -> unitType.getCapacityUnit())).getOrDefault(false)) {
						return MapperS.of(capacityUnitToISO20022UnitOfMeasure.evaluate(item.<CapacityUnitEnum>map("getCapacityUnit", unitType -> unitType.getCapacityUnit()).get()));
					}
					if (exists(item.<WeatherUnitEnum>map("getWeatherUnit", unitType -> unitType.getWeatherUnit())).getOrDefault(false)) {
						return MapperS.of(weatherUnitToISO20022UnitOfMeasure.evaluate(item.<WeatherUnitEnum>map("getWeatherUnit", unitType -> unitType.getWeatherUnit()).get()));
					}
					if (exists(item.<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
						return MapperS.of(financialUnitToISO20022UnitOfMeasure.evaluate(item.<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()).get()));
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return unitOfMeasure;
		}
	}
}
