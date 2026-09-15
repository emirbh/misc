package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.CommodityExercise;
import fpml.consolidated.com.CommodityForward;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityNotionalQuantitySchedule;
import fpml.consolidated.com.CommodityOption;
import fpml.consolidated.com.CommodityPhysicalExercise;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.com.CommoditySettlementPeriodsNotionalQuantity;
import fpml.consolidated.com.QuantityReference;
import fpml.consolidated.com.WeatherIndex;
import fpml.consolidated.com.WeatherIndexData;
import fpml.consolidated.com.WeatherLegCalculation;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityOptionChoice2")
@ImplementedBy(CommodityOptionChoice2.Default.class)
public interface CommodityOptionChoice2 extends Validator<CommodityOption> {
	
	String NAME = "CommodityOptionChoice2";
	String DEFINITION = "if strikePricePerUnit exists then commodity exists and physicalExercise is absent and weatherNotionalAmount is absent and weatherIndexStrikeLevel is absent and calculation is absent and weatherIndexData is absent and commodityForward is absent and weatherCalculationPeriodsReference is absent and optional choice calculationPeriodsSchedule, calculationPeriods and if calculationPeriodsSchedule exists then optional choice totalNotionalQuantity, quantityReference and if quantityReference exists then exercise exists and pricingDates exists or notionalQuantitySchedule is absent and notionalQuantity is absent and settlementPeriodsNotionalQuantity is absent and if totalNotionalQuantity is absent and quantityReference is absent then exercise exists and pricingDates exists and (notionalQuantity exists or notionalQuantitySchedule exists or settlementPeriodsNotionalQuantity exists) and if calculationPeriods exists then optional choice totalNotionalQuantity, quantityReference and if quantityReference exists then exercise exists and pricingDates exists or notionalQuantitySchedule is absent and notionalQuantity is absent and settlementPeriodsNotionalQuantity is absent and if totalNotionalQuantity is absent and quantityReference is absent then exercise exists and pricingDates exists and (notionalQuantity exists or notionalQuantitySchedule exists or settlementPeriodsNotionalQuantity exists) and if calculationPeriodsSchedule is absent and calculationPeriods is absent then optional choice totalNotionalQuantity, quantityReference and if quantityReference exists then exercise exists and pricingDates is absent and averagingMethod is absent or notionalQuantitySchedule is absent and notionalQuantity is absent and settlementPeriodsNotionalQuantity is absent and if totalNotionalQuantity is absent and quantityReference is absent then exercise exists and pricingDates is absent and averagingMethod is absent and (notionalQuantity exists or notionalQuantitySchedule exists or settlementPeriodsNotionalQuantity exists)";
	
	class Default implements CommodityOptionChoice2 {
	
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
				if (exists(MapperS.of(commodityOption).<NonNegativeMoney>map("getStrikePricePerUnit", _commodityOption -> _commodityOption.getStrikePricePerUnit())).getOrDefault(false)) {
					final ComparisonResult ifThenElseResult8;
					if (exists(MapperS.of(commodityOption).<CommodityCalculationPeriodsSchedule>map("getCalculationPeriodsSchedule", _commodityOption -> _commodityOption.getCalculationPeriodsSchedule())).getOrDefault(false)) {
						final ComparisonResult ifThenElseResult7;
						if (exists(MapperS.of(commodityOption).<QuantityReference>map("getQuantityReference", _commodityOption -> _commodityOption.getQuantityReference())).getOrDefault(false)) {
							final ComparisonResult ifThenElseResult6;
							if (notExists(MapperS.of(commodityOption).<BigDecimal>map("getTotalNotionalQuantity", _commodityOption -> _commodityOption.getTotalNotionalQuantity())).andNullSafe(notExists(MapperS.of(commodityOption).<QuantityReference>map("getQuantityReference", _commodityOption -> _commodityOption.getQuantityReference()))).getOrDefault(false)) {
								final ComparisonResult ifThenElseResult5;
								if (exists(MapperS.of(commodityOption).<AdjustableDates>map("getCalculationPeriods", _commodityOption -> _commodityOption.getCalculationPeriods())).getOrDefault(false)) {
									final ComparisonResult ifThenElseResult4;
									if (exists(MapperS.of(commodityOption).<QuantityReference>map("getQuantityReference", _commodityOption -> _commodityOption.getQuantityReference())).getOrDefault(false)) {
										final ComparisonResult ifThenElseResult3;
										if (notExists(MapperS.of(commodityOption).<BigDecimal>map("getTotalNotionalQuantity", _commodityOption -> _commodityOption.getTotalNotionalQuantity())).andNullSafe(notExists(MapperS.of(commodityOption).<QuantityReference>map("getQuantityReference", _commodityOption -> _commodityOption.getQuantityReference()))).getOrDefault(false)) {
											final ComparisonResult ifThenElseResult2;
											if (notExists(MapperS.of(commodityOption).<CommodityCalculationPeriodsSchedule>map("getCalculationPeriodsSchedule", _commodityOption -> _commodityOption.getCalculationPeriodsSchedule())).andNullSafe(notExists(MapperS.of(commodityOption).<AdjustableDates>map("getCalculationPeriods", _commodityOption -> _commodityOption.getCalculationPeriods()))).getOrDefault(false)) {
												final ComparisonResult ifThenElseResult1;
												if (exists(MapperS.of(commodityOption).<QuantityReference>map("getQuantityReference", _commodityOption -> _commodityOption.getQuantityReference())).getOrDefault(false)) {
													final ComparisonResult ifThenElseResult0;
													if (notExists(MapperS.of(commodityOption).<BigDecimal>map("getTotalNotionalQuantity", _commodityOption -> _commodityOption.getTotalNotionalQuantity())).andNullSafe(notExists(MapperS.of(commodityOption).<QuantityReference>map("getQuantityReference", _commodityOption -> _commodityOption.getQuantityReference()))).getOrDefault(false)) {
														ifThenElseResult0 = exists(MapperS.of(commodityOption).<CommodityExercise>map("getExercise", _commodityOption -> _commodityOption.getExercise())).andNullSafe(notExists(MapperS.of(commodityOption).<CommodityPricingDates>map("getPricingDates", _commodityOption -> _commodityOption.getPricingDates()))).andNullSafe(notExists(MapperS.of(commodityOption).<AveragingMethodEnum>map("getAveragingMethod", _commodityOption -> _commodityOption.getAveragingMethod()))).andNullSafe(exists(MapperS.of(commodityOption).<CommodityNotionalQuantity>map("getNotionalQuantity", _commodityOption -> _commodityOption.getNotionalQuantity())).orNullSafe(exists(MapperS.of(commodityOption).<CommodityNotionalQuantitySchedule>map("getNotionalQuantitySchedule", _commodityOption -> _commodityOption.getNotionalQuantitySchedule()))).orNullSafe(exists(MapperS.of(commodityOption).<CommoditySettlementPeriodsNotionalQuantity>mapC("getSettlementPeriodsNotionalQuantity", _commodityOption -> _commodityOption.getSettlementPeriodsNotionalQuantity()))));
													} else {
														ifThenElseResult0 = ComparisonResult.ofEmpty();
													}
													ifThenElseResult1 = exists(MapperS.of(commodityOption).<CommodityExercise>map("getExercise", _commodityOption -> _commodityOption.getExercise())).andNullSafe(notExists(MapperS.of(commodityOption).<CommodityPricingDates>map("getPricingDates", _commodityOption -> _commodityOption.getPricingDates()))).andNullSafe(notExists(MapperS.of(commodityOption).<AveragingMethodEnum>map("getAveragingMethod", _commodityOption -> _commodityOption.getAveragingMethod()))).orNullSafe(notExists(MapperS.of(commodityOption).<CommodityNotionalQuantitySchedule>map("getNotionalQuantitySchedule", _commodityOption -> _commodityOption.getNotionalQuantitySchedule())).andNullSafe(notExists(MapperS.of(commodityOption).<CommodityNotionalQuantity>map("getNotionalQuantity", _commodityOption -> _commodityOption.getNotionalQuantity()))).andNullSafe(notExists(MapperS.of(commodityOption).<CommoditySettlementPeriodsNotionalQuantity>mapC("getSettlementPeriodsNotionalQuantity", _commodityOption -> _commodityOption.getSettlementPeriodsNotionalQuantity()))).andNullSafe(ifThenElseResult0));
												} else {
													ifThenElseResult1 = ComparisonResult.ofEmpty();
												}
												ifThenElseResult2 = choice(MapperS.of(commodityOption), Arrays.asList("totalNotionalQuantity", "quantityReference"), ChoiceRuleValidationMethod.OPTIONAL).andNullSafe(ifThenElseResult1);
											} else {
												ifThenElseResult2 = ComparisonResult.ofEmpty();
											}
											ifThenElseResult3 = exists(MapperS.of(commodityOption).<CommodityExercise>map("getExercise", _commodityOption -> _commodityOption.getExercise())).andNullSafe(exists(MapperS.of(commodityOption).<CommodityPricingDates>map("getPricingDates", _commodityOption -> _commodityOption.getPricingDates()))).andNullSafe(exists(MapperS.of(commodityOption).<CommodityNotionalQuantity>map("getNotionalQuantity", _commodityOption -> _commodityOption.getNotionalQuantity())).orNullSafe(exists(MapperS.of(commodityOption).<CommodityNotionalQuantitySchedule>map("getNotionalQuantitySchedule", _commodityOption -> _commodityOption.getNotionalQuantitySchedule()))).orNullSafe(exists(MapperS.of(commodityOption).<CommoditySettlementPeriodsNotionalQuantity>mapC("getSettlementPeriodsNotionalQuantity", _commodityOption -> _commodityOption.getSettlementPeriodsNotionalQuantity())))).andNullSafe(ifThenElseResult2);
										} else {
											ifThenElseResult3 = ComparisonResult.ofEmpty();
										}
										ifThenElseResult4 = exists(MapperS.of(commodityOption).<CommodityExercise>map("getExercise", _commodityOption -> _commodityOption.getExercise())).andNullSafe(exists(MapperS.of(commodityOption).<CommodityPricingDates>map("getPricingDates", _commodityOption -> _commodityOption.getPricingDates()))).orNullSafe(notExists(MapperS.of(commodityOption).<CommodityNotionalQuantitySchedule>map("getNotionalQuantitySchedule", _commodityOption -> _commodityOption.getNotionalQuantitySchedule())).andNullSafe(notExists(MapperS.of(commodityOption).<CommodityNotionalQuantity>map("getNotionalQuantity", _commodityOption -> _commodityOption.getNotionalQuantity()))).andNullSafe(notExists(MapperS.of(commodityOption).<CommoditySettlementPeriodsNotionalQuantity>mapC("getSettlementPeriodsNotionalQuantity", _commodityOption -> _commodityOption.getSettlementPeriodsNotionalQuantity()))).andNullSafe(ifThenElseResult3));
									} else {
										ifThenElseResult4 = ComparisonResult.ofEmpty();
									}
									ifThenElseResult5 = choice(MapperS.of(commodityOption), Arrays.asList("totalNotionalQuantity", "quantityReference"), ChoiceRuleValidationMethod.OPTIONAL).andNullSafe(ifThenElseResult4);
								} else {
									ifThenElseResult5 = ComparisonResult.ofEmpty();
								}
								ifThenElseResult6 = exists(MapperS.of(commodityOption).<CommodityExercise>map("getExercise", _commodityOption -> _commodityOption.getExercise())).andNullSafe(exists(MapperS.of(commodityOption).<CommodityPricingDates>map("getPricingDates", _commodityOption -> _commodityOption.getPricingDates()))).andNullSafe(exists(MapperS.of(commodityOption).<CommodityNotionalQuantity>map("getNotionalQuantity", _commodityOption -> _commodityOption.getNotionalQuantity())).orNullSafe(exists(MapperS.of(commodityOption).<CommodityNotionalQuantitySchedule>map("getNotionalQuantitySchedule", _commodityOption -> _commodityOption.getNotionalQuantitySchedule()))).orNullSafe(exists(MapperS.of(commodityOption).<CommoditySettlementPeriodsNotionalQuantity>mapC("getSettlementPeriodsNotionalQuantity", _commodityOption -> _commodityOption.getSettlementPeriodsNotionalQuantity())))).andNullSafe(ifThenElseResult5);
							} else {
								ifThenElseResult6 = ComparisonResult.ofEmpty();
							}
							ifThenElseResult7 = exists(MapperS.of(commodityOption).<CommodityExercise>map("getExercise", _commodityOption -> _commodityOption.getExercise())).andNullSafe(exists(MapperS.of(commodityOption).<CommodityPricingDates>map("getPricingDates", _commodityOption -> _commodityOption.getPricingDates()))).orNullSafe(notExists(MapperS.of(commodityOption).<CommodityNotionalQuantitySchedule>map("getNotionalQuantitySchedule", _commodityOption -> _commodityOption.getNotionalQuantitySchedule())).andNullSafe(notExists(MapperS.of(commodityOption).<CommodityNotionalQuantity>map("getNotionalQuantity", _commodityOption -> _commodityOption.getNotionalQuantity()))).andNullSafe(notExists(MapperS.of(commodityOption).<CommoditySettlementPeriodsNotionalQuantity>mapC("getSettlementPeriodsNotionalQuantity", _commodityOption -> _commodityOption.getSettlementPeriodsNotionalQuantity()))).andNullSafe(ifThenElseResult6));
						} else {
							ifThenElseResult7 = ComparisonResult.ofEmpty();
						}
						ifThenElseResult8 = choice(MapperS.of(commodityOption), Arrays.asList("totalNotionalQuantity", "quantityReference"), ChoiceRuleValidationMethod.OPTIONAL).andNullSafe(ifThenElseResult7);
					} else {
						ifThenElseResult8 = ComparisonResult.ofEmpty();
					}
					return exists(MapperS.of(commodityOption).<Commodity>map("getCommodity", _commodityOption -> _commodityOption.getCommodity())).andNullSafe(notExists(MapperS.of(commodityOption).<CommodityPhysicalExercise>map("getPhysicalExercise", _commodityOption -> _commodityOption.getPhysicalExercise()))).andNullSafe(notExists(MapperS.of(commodityOption).<NonNegativeMoney>map("getWeatherNotionalAmount", _commodityOption -> _commodityOption.getWeatherNotionalAmount()))).andNullSafe(notExists(MapperS.of(commodityOption).<WeatherIndex>map("getWeatherIndexStrikeLevel", _commodityOption -> _commodityOption.getWeatherIndexStrikeLevel()))).andNullSafe(notExists(MapperS.of(commodityOption).<WeatherLegCalculation>map("getCalculation", _commodityOption -> _commodityOption.getCalculation()))).andNullSafe(notExists(MapperS.of(commodityOption).<WeatherIndexData>map("getWeatherIndexData", _commodityOption -> _commodityOption.getWeatherIndexData()))).andNullSafe(notExists(MapperS.of(commodityOption).<CommodityForward>map("getCommodityForward", _commodityOption -> _commodityOption.getCommodityForward()))).andNullSafe(notExists(MapperS.of(commodityOption).<CalculationPeriodsReference>map("getWeatherCalculationPeriodsReference", _commodityOption -> _commodityOption.getWeatherCalculationPeriodsReference()))).andNullSafe(choice(MapperS.of(commodityOption), Arrays.asList("calculationPeriodsSchedule", "calculationPeriods"), ChoiceRuleValidationMethod.OPTIONAL)).andNullSafe(ifThenElseResult8);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityOptionChoice2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityOption commodityOption) {
			return Collections.emptyList();
		}
	}
}
