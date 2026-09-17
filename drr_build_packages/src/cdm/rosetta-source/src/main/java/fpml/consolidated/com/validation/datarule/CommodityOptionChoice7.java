package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.CommodityBarrier;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.CommodityForward;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityNotionalQuantitySchedule;
import fpml.consolidated.com.CommodityOption;
import fpml.consolidated.com.CommodityPhysicalExercise;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.com.CommoditySettlementPeriodsNotionalQuantity;
import fpml.consolidated.com.QuantityReference;
import fpml.consolidated.com.WeatherCalculationPeriods;
import fpml.consolidated.com.WeatherIndex;
import fpml.consolidated.com.WeatherLegCalculation;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityOptionChoice7")
@ImplementedBy(CommodityOptionChoice7.Default.class)
public interface CommodityOptionChoice7 extends Validator<CommodityOption> {
	
	String NAME = "CommodityOptionChoice7";
	String DEFINITION = "if weatherCalculationPeriods exists then effectiveDate exists and weatherNotionalAmount exists and weatherIndexStrikeLevel exists and calculation exists and notionalQuantitySchedule is absent and notionalQuantity is absent and settlementPeriodsNotionalQuantity is absent and quantityReference is absent and commodityForward is absent and commodity is absent and terminationDate is absent and calculationPeriodsSchedule is absent and calculationPeriods is absent and pricingDates is absent and averagingMethod is absent and barrier is absent and totalNotionalQuantity is absent and physicalExercise is absent";
	
	class Default implements CommodityOptionChoice7 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityOption commodityOption) {
			ComparisonResult result = executeDataRule(commodityOption);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityOption", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityOption", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityOption commodityOption) {
			try {
				if (exists(MapperS.of(commodityOption).<WeatherCalculationPeriods>map("getWeatherCalculationPeriods", _commodityOption -> _commodityOption.getWeatherCalculationPeriods())).getOrDefault(false)) {
					return exists(MapperS.of(commodityOption).<AdjustableOrRelativeDate>map("getEffectiveDate", _commodityOption -> _commodityOption.getEffectiveDate())).andNullSafe(exists(MapperS.of(commodityOption).<NonNegativeMoney>map("getWeatherNotionalAmount", _commodityOption -> _commodityOption.getWeatherNotionalAmount()))).andNullSafe(exists(MapperS.of(commodityOption).<WeatherIndex>map("getWeatherIndexStrikeLevel", _commodityOption -> _commodityOption.getWeatherIndexStrikeLevel()))).andNullSafe(exists(MapperS.of(commodityOption).<WeatherLegCalculation>map("getCalculation", _commodityOption -> _commodityOption.getCalculation()))).andNullSafe(notExists(MapperS.of(commodityOption).<CommodityNotionalQuantitySchedule>map("getNotionalQuantitySchedule", _commodityOption -> _commodityOption.getNotionalQuantitySchedule()))).andNullSafe(notExists(MapperS.of(commodityOption).<CommodityNotionalQuantity>map("getNotionalQuantity", _commodityOption -> _commodityOption.getNotionalQuantity()))).andNullSafe(notExists(MapperS.of(commodityOption).<CommoditySettlementPeriodsNotionalQuantity>mapC("getSettlementPeriodsNotionalQuantity", _commodityOption -> _commodityOption.getSettlementPeriodsNotionalQuantity()))).andNullSafe(notExists(MapperS.of(commodityOption).<QuantityReference>map("getQuantityReference", _commodityOption -> _commodityOption.getQuantityReference()))).andNullSafe(notExists(MapperS.of(commodityOption).<CommodityForward>map("getCommodityForward", _commodityOption -> _commodityOption.getCommodityForward()))).andNullSafe(notExists(MapperS.of(commodityOption).<Commodity>map("getCommodity", _commodityOption -> _commodityOption.getCommodity()))).andNullSafe(notExists(MapperS.of(commodityOption).<AdjustableOrRelativeDate>map("getTerminationDate", _commodityOption -> _commodityOption.getTerminationDate()))).andNullSafe(notExists(MapperS.of(commodityOption).<CommodityCalculationPeriodsSchedule>map("getCalculationPeriodsSchedule", _commodityOption -> _commodityOption.getCalculationPeriodsSchedule()))).andNullSafe(notExists(MapperS.of(commodityOption).<AdjustableDates>map("getCalculationPeriods", _commodityOption -> _commodityOption.getCalculationPeriods()))).andNullSafe(notExists(MapperS.of(commodityOption).<CommodityPricingDates>map("getPricingDates", _commodityOption -> _commodityOption.getPricingDates()))).andNullSafe(notExists(MapperS.of(commodityOption).<AveragingMethodEnum>map("getAveragingMethod", _commodityOption -> _commodityOption.getAveragingMethod()))).andNullSafe(notExists(MapperS.of(commodityOption).<CommodityBarrier>map("getBarrier", _commodityOption -> _commodityOption.getBarrier()))).andNullSafe(notExists(MapperS.of(commodityOption).<BigDecimal>map("getTotalNotionalQuantity", _commodityOption -> _commodityOption.getTotalNotionalQuantity()))).andNullSafe(notExists(MapperS.of(commodityOption).<CommodityPhysicalExercise>map("getPhysicalExercise", _commodityOption -> _commodityOption.getPhysicalExercise())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityOptionChoice7 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityOption commodityOption) {
			return Collections.emptyList();
		}
	}
}
