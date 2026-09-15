package drr.standards.iosco.cde.version1.price.reports;

import cdm.base.math.CapacityUnitEnum;
import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.UnitType;
import cdm.base.math.WeatherUnitEnum;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iosco.cde.version1.price.functions.Price;
import drr.standards.iso.functions.CapacityUnitToISO20022UnitOfMeasure;
import drr.standards.iso.functions.FinancialUnitToISO20022UnitOfMeasure;
import drr.standards.iso.functions.WeatherUnitToISO20022UnitOfMeasure;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PriceUnitOfMeasureRule.PriceUnitOfMeasureRuleDefault.class)
public abstract class PriceUnitOfMeasureRule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CapacityUnitToISO20022UnitOfMeasure capacityUnitToISO20022UnitOfMeasure;
	@Inject protected FinancialUnitToISO20022UnitOfMeasure financialUnitToISO20022UnitOfMeasure;
	@Inject protected Price price;
	@Inject protected WeatherUnitToISO20022UnitOfMeasure weatherUnitToISO20022UnitOfMeasure;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class PriceUnitOfMeasureRuleDefault extends PriceUnitOfMeasureRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			final MapperS<PriceSchedule> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(price.evaluate(item.get())));
			output = thenArg
				.mapSingleToItem(item -> {
					if (exists(item.<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).<CapacityUnitEnum>map("getCapacityUnit", unitType -> unitType.getCapacityUnit())).getOrDefault(false)) {
						return MapperS.of(capacityUnitToISO20022UnitOfMeasure.evaluate(item.<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).<CapacityUnitEnum>map("getCapacityUnit", unitType -> unitType.getCapacityUnit()).get()));
					}
					if (exists(item.<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).<WeatherUnitEnum>map("getWeatherUnit", unitType -> unitType.getWeatherUnit())).getOrDefault(false)) {
						return MapperS.of(weatherUnitToISO20022UnitOfMeasure.evaluate(item.<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).<WeatherUnitEnum>map("getWeatherUnit", unitType -> unitType.getWeatherUnit()).get()));
					}
					if (exists(item.<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit())).getOrDefault(false)) {
						return MapperS.of(financialUnitToISO20022UnitOfMeasure.evaluate(item.<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()).get()));
					}
					if (areEqual(item.<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.INTEREST_RATE), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.<String>ofNull();
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
