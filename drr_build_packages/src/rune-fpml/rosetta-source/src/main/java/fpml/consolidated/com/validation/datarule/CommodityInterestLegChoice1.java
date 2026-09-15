package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityInterestLeg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityInterestLegChoice1")
@ImplementedBy(CommodityInterestLegChoice1.Default.class)
public interface CommodityInterestLegChoice1 extends Validator<CommodityInterestLeg> {
	
	String NAME = "CommodityInterestLegChoice1";
	String DEFINITION = "optional choice calculationDates, calculationPeriods, calculationPeriodsSchedule, calculationPeriodsReference, calculationPeriodsScheduleReference, calculationPeriodsDatesReference";
	
	class Default implements CommodityInterestLegChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityInterestLeg commodityInterestLeg) {
			ComparisonResult result = executeDataRule(commodityInterestLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityInterestLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityInterestLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityInterestLeg commodityInterestLeg) {
			try {
				return choice(MapperS.of(commodityInterestLeg), Arrays.asList("calculationDates", "calculationPeriods", "calculationPeriodsSchedule", "calculationPeriodsReference", "calculationPeriodsScheduleReference", "calculationPeriodsDatesReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityInterestLegChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityInterestLeg commodityInterestLeg) {
			return Collections.emptyList();
		}
	}
}
