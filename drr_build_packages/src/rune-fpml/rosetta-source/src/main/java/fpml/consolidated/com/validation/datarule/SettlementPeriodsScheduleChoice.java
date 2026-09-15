package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.SettlementPeriodsSchedule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("SettlementPeriodsScheduleChoice")
@ImplementedBy(SettlementPeriodsScheduleChoice.Default.class)
public interface SettlementPeriodsScheduleChoice extends Validator<SettlementPeriodsSchedule> {
	
	String NAME = "SettlementPeriodsScheduleChoice";
	String DEFINITION = "required choice deliveryPeriodsReference, deliveryPeriodsScheduleReference";
	
	class Default implements SettlementPeriodsScheduleChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodsSchedule settlementPeriodsSchedule) {
			ComparisonResult result = executeDataRule(settlementPeriodsSchedule);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPeriodsSchedule", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPeriodsSchedule", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(SettlementPeriodsSchedule settlementPeriodsSchedule) {
			try {
				return choice(MapperS.of(settlementPeriodsSchedule), Arrays.asList("deliveryPeriodsReference", "deliveryPeriodsScheduleReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementPeriodsScheduleChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodsSchedule settlementPeriodsSchedule) {
			return Collections.emptyList();
		}
	}
}
