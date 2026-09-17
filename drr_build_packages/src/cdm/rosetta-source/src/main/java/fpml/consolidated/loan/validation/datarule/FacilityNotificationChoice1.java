package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FacilityNotification;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FacilityNotificationChoice1")
@ImplementedBy(FacilityNotificationChoice1.Default.class)
public interface FacilityNotificationChoice1 extends Validator<FacilityNotification> {
	
	String NAME = "FacilityNotificationChoice1";
	String DEFINITION = "required choice facilityIdentifier, facilitySummary";
	
	class Default implements FacilityNotificationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityNotification facilityNotification) {
			ComparisonResult result = executeDataRule(facilityNotification);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityNotification", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityNotification", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FacilityNotification facilityNotification) {
			try {
				return choice(MapperS.of(facilityNotification), Arrays.asList("facilityIdentifier", "facilitySummary"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FacilityNotificationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityNotification facilityNotification) {
			return Collections.emptyList();
		}
	}
}
