package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FacilityNotificationChoice1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FacilityNotificationChoice1Choice")
@ImplementedBy(FacilityNotificationChoice1Choice.Default.class)
public interface FacilityNotificationChoice1Choice extends Validator<FacilityNotificationChoice1> {
	
	String NAME = "FacilityNotificationChoice1Choice";
	String DEFINITION = "one-of";
	
	class Default implements FacilityNotificationChoice1Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityNotificationChoice1 facilityNotificationChoice1) {
			ComparisonResult result = executeDataRule(facilityNotificationChoice1);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityNotificationChoice1", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityNotificationChoice1", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FacilityNotificationChoice1 facilityNotificationChoice1) {
			try {
				return choice(MapperS.of(facilityNotificationChoice1), Arrays.asList("letterOfCreditIdentifier", "letterOfCreditSummary", "letterOfCredit"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FacilityNotificationChoice1Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityNotificationChoice1 facilityNotificationChoice1) {
			return Collections.emptyList();
		}
	}
}
