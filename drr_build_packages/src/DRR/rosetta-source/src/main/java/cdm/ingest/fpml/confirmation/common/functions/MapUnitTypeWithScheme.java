package cdm.ingest.fpml.confirmation.common.functions;

import cdm.base.math.CapacityUnitEnum;
import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.UnitType;
import cdm.base.math.WeatherUnitEnum;
import cdm.base.math.metafields.FieldWithMetaCapacityUnitEnum;
import cdm.base.math.metafields.FieldWithMetaFinancialUnitEnum;
import cdm.base.math.metafields.FieldWithMetaWeatherUnitEnum;
import cdm.ingest.fpml.confirmation.other.functions.MapCapacityUnitEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapUnitTypeWithScheme.MapUnitTypeWithSchemeDefault.class)
public abstract class MapUnitTypeWithScheme implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCapacityUnitEnum mapCapacityUnitEnum;
	@Inject protected MapCapacityUnitWithScheme mapCapacityUnitWithScheme;
	@Inject protected MapFinancialUnitWithScheme mapFinancialUnitWithScheme;
	@Inject protected MapWeatherUnitWithScheme mapWeatherUnitWithScheme;

	/**
	* @param value 
	* @param scheme 
	* @return unitType 
	*/
	public UnitType evaluate(String value, String scheme) {
		UnitType.UnitTypeBuilder unitTypeBuilder = doEvaluate(value, scheme);
		
		final UnitType unitType;
		if (unitTypeBuilder == null) {
			unitType = null;
		} else {
			unitType = unitTypeBuilder.build();
			objectValidator.validate(UnitType.class, unitType);
		}
		
		return unitType;
	}

	protected abstract UnitType.UnitTypeBuilder doEvaluate(String value, String scheme);

	protected abstract MapperS<String> financialUnit(String value, String scheme);

	public static class MapUnitTypeWithSchemeDefault extends MapUnitTypeWithScheme {
		@Override
		protected UnitType.UnitTypeBuilder doEvaluate(String value, String scheme) {
			UnitType.UnitTypeBuilder unitType = UnitType.builder();
			return assignOutput(unitType, value, scheme);
		}
		
		protected UnitType.UnitTypeBuilder assignOutput(UnitType.UnitTypeBuilder unitType, String value, String scheme) {
			CapacityUnitEnum ifThenElseResult0 = null;
			if (exists(MapperS.of(mapCapacityUnitEnum.evaluate(value))).getOrDefault(false)) {
				final FieldWithMetaCapacityUnitEnum fieldWithMetaCapacityUnitEnum = mapCapacityUnitWithScheme.evaluate(value, scheme);
				ifThenElseResult0 = fieldWithMetaCapacityUnitEnum == null ? null : fieldWithMetaCapacityUnitEnum.getValue();
			}
			WeatherUnitEnum ifThenElseResult1 = null;
			if (exists(MapperS.of(value).checkedMap("to-enum", WeatherUnitEnum::fromDisplayName, IllegalArgumentException.class)).getOrDefault(false)) {
				final FieldWithMetaWeatherUnitEnum fieldWithMetaWeatherUnitEnum = mapWeatherUnitWithScheme.evaluate(value, scheme);
				ifThenElseResult1 = fieldWithMetaWeatherUnitEnum == null ? null : fieldWithMetaWeatherUnitEnum.getValue();
			}
			FinancialUnitEnum ifThenElseResult2 = null;
			if (exists(financialUnit(value, scheme)).getOrDefault(false)) {
				final FieldWithMetaFinancialUnitEnum fieldWithMetaFinancialUnitEnum = mapFinancialUnitWithScheme.evaluate(financialUnit(value, scheme).get(), scheme);
				ifThenElseResult2 = fieldWithMetaFinancialUnitEnum == null ? null : fieldWithMetaFinancialUnitEnum.getValue();
			}
			unitType = toBuilder(UnitType.builder()
				.setCapacityUnit(ifThenElseResult0)
				.setWeatherUnit(ifThenElseResult1)
				.setFinancialUnit(ifThenElseResult2)
				.build());
			
			return Optional.ofNullable(unitType)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<String> financialUnit(String value, String scheme) {
			FinancialUnitEnum ifThenElseResult = null;
			if (areEqual(MapperS.of(value), MapperS.of("IndexUnits"), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = FinancialUnitEnum.INDEX_UNIT;
			}
			final MapperS<FinancialUnitEnum> thenArg = MapperS.of(MapperS.of(value).checkedMap("to-enum", FinancialUnitEnum::fromDisplayName, IllegalArgumentException.class).getOrDefault(ifThenElseResult));
			return thenArg.map("to-string", FinancialUnitEnum::toDisplayString);
		}
	}
}
