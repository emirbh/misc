package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CalculationPeriodsDatesReference;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CalculationPeriodsScheduleReference;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.FloatingPriceLeg;
import fpml.consolidated.com.QuantityReference;
import fpml.consolidated.shared.AdjustableDates;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FloatingPriceLegChoice5")
@ImplementedBy(FloatingPriceLegChoice5.Default.class)
public interface FloatingPriceLegChoice5 extends Validator<FloatingPriceLeg> {
	
	String NAME = "FloatingPriceLegChoice5";
	String DEFINITION = "if quantityReference is absent and totalNotionalQuantity is absent and required choice notionalQuantitySchedule, notionalQuantity, settlementPeriodsNotionalQuantity then calculationPeriods exists or calculationDates exists or calculationPeriodsSchedule exists or calculationPeriodsReference exists or calculationPeriodsScheduleReference exists or calculationPeriodsDatesReference exists";
	
	class Default implements FloatingPriceLegChoice5 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingPriceLeg floatingPriceLeg) {
			ComparisonResult result = executeDataRule(floatingPriceLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingPriceLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingPriceLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FloatingPriceLeg floatingPriceLeg) {
			try {
				if (notExists(MapperS.of(floatingPriceLeg).<QuantityReference>map("getQuantityReference", _floatingPriceLeg -> _floatingPriceLeg.getQuantityReference())).andNullSafe(notExists(MapperS.of(floatingPriceLeg).<BigDecimal>map("getTotalNotionalQuantity", _floatingPriceLeg -> _floatingPriceLeg.getTotalNotionalQuantity()))).andNullSafe(choice(MapperS.of(floatingPriceLeg), Arrays.asList("notionalQuantitySchedule", "notionalQuantity", "settlementPeriodsNotionalQuantity"), ChoiceRuleValidationMethod.REQUIRED)).getOrDefault(false)) {
					return exists(MapperS.of(floatingPriceLeg).<AdjustableDates>map("getCalculationPeriods", _floatingPriceLeg -> _floatingPriceLeg.getCalculationPeriods())).orNullSafe(exists(MapperS.of(floatingPriceLeg).<AdjustableDates>map("getCalculationDates", _floatingPriceLeg -> _floatingPriceLeg.getCalculationDates()))).orNullSafe(exists(MapperS.of(floatingPriceLeg).<CommodityCalculationPeriodsSchedule>map("getCalculationPeriodsSchedule", _floatingPriceLeg -> _floatingPriceLeg.getCalculationPeriodsSchedule()))).orNullSafe(exists(MapperS.of(floatingPriceLeg).<CalculationPeriodsReference>map("getCalculationPeriodsReference", _floatingPriceLeg -> _floatingPriceLeg.getCalculationPeriodsReference()))).orNullSafe(exists(MapperS.of(floatingPriceLeg).<CalculationPeriodsScheduleReference>map("getCalculationPeriodsScheduleReference", _floatingPriceLeg -> _floatingPriceLeg.getCalculationPeriodsScheduleReference()))).orNullSafe(exists(MapperS.of(floatingPriceLeg).<CalculationPeriodsDatesReference>map("getCalculationPeriodsDatesReference", _floatingPriceLeg -> _floatingPriceLeg.getCalculationPeriodsDatesReference())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FloatingPriceLegChoice5 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingPriceLeg floatingPriceLeg) {
			return Collections.emptyList();
		}
	}
}
