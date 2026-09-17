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
import fpml.consolidated.com.FixedPriceLeg;
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
@RosettaDataRule("FixedPriceLegChoice6")
@ImplementedBy(FixedPriceLegChoice6.Default.class)
public interface FixedPriceLegChoice6 extends Validator<FixedPriceLeg> {
	
	String NAME = "FixedPriceLegChoice6";
	String DEFINITION = "if quantityReference is absent and totalNotionalQuantity is absent and required choice notionalQuantitySchedule, notionalQuantity, settlementPeriodsNotionalQuantity then calculationPeriods exists or calculationDates exists or calculationPeriodsSchedule exists or calculationPeriodsReference exists or calculationPeriodsScheduleReference exists or calculationPeriodsDatesReference exists";
	
	class Default implements FixedPriceLegChoice6 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPriceLeg fixedPriceLeg) {
			ComparisonResult result = executeDataRule(fixedPriceLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FixedPriceLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FixedPriceLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FixedPriceLeg fixedPriceLeg) {
			try {
				if (notExists(MapperS.of(fixedPriceLeg).<QuantityReference>map("getQuantityReference", _fixedPriceLeg -> _fixedPriceLeg.getQuantityReference())).andNullSafe(notExists(MapperS.of(fixedPriceLeg).<BigDecimal>map("getTotalNotionalQuantity", _fixedPriceLeg -> _fixedPriceLeg.getTotalNotionalQuantity()))).andNullSafe(choice(MapperS.of(fixedPriceLeg), Arrays.asList("notionalQuantitySchedule", "notionalQuantity", "settlementPeriodsNotionalQuantity"), ChoiceRuleValidationMethod.REQUIRED)).getOrDefault(false)) {
					return exists(MapperS.of(fixedPriceLeg).<AdjustableDates>map("getCalculationPeriods", _fixedPriceLeg -> _fixedPriceLeg.getCalculationPeriods())).orNullSafe(exists(MapperS.of(fixedPriceLeg).<AdjustableDates>map("getCalculationDates", _fixedPriceLeg -> _fixedPriceLeg.getCalculationDates()))).orNullSafe(exists(MapperS.of(fixedPriceLeg).<CommodityCalculationPeriodsSchedule>map("getCalculationPeriodsSchedule", _fixedPriceLeg -> _fixedPriceLeg.getCalculationPeriodsSchedule()))).orNullSafe(exists(MapperS.of(fixedPriceLeg).<CalculationPeriodsReference>map("getCalculationPeriodsReference", _fixedPriceLeg -> _fixedPriceLeg.getCalculationPeriodsReference()))).orNullSafe(exists(MapperS.of(fixedPriceLeg).<CalculationPeriodsScheduleReference>map("getCalculationPeriodsScheduleReference", _fixedPriceLeg -> _fixedPriceLeg.getCalculationPeriodsScheduleReference()))).orNullSafe(exists(MapperS.of(fixedPriceLeg).<CalculationPeriodsDatesReference>map("getCalculationPeriodsDatesReference", _fixedPriceLeg -> _fixedPriceLeg.getCalculationPeriodsDatesReference())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FixedPriceLegChoice6 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPriceLeg fixedPriceLeg) {
			return Collections.emptyList();
		}
	}
}
