package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityStrikeSchedule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CommodityStrikeScheduleChoice")
@ImplementedBy(CommodityStrikeScheduleChoice.Default.class)
public interface CommodityStrikeScheduleChoice extends Validator<CommodityStrikeSchedule> {
	
	String NAME = "CommodityStrikeScheduleChoice";
	String DEFINITION = "optional choice calculationPeriodsReference, calculationPeriodsScheduleReference, calculationPeriodsDatesReference";
	
	class Default implements CommodityStrikeScheduleChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityStrikeSchedule commodityStrikeSchedule) {
			ComparisonResult result = executeDataRule(commodityStrikeSchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityStrikeSchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityStrikeSchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CommodityStrikeSchedule commodityStrikeSchedule) {
			try {
				return choice(MapperS.of(commodityStrikeSchedule), Arrays.asList("calculationPeriodsReference", "calculationPeriodsScheduleReference", "calculationPeriodsDatesReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityStrikeScheduleChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityStrikeSchedule commodityStrikeSchedule) {
			return Collections.emptyList();
		}
	}
}
