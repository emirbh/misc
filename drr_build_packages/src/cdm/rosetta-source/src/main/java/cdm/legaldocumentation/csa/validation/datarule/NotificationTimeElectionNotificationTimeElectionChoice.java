package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.NotificationTimeElection;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("NotificationTimeElectionNotificationTimeElectionChoice")
@ImplementedBy(NotificationTimeElectionNotificationTimeElectionChoice.Default.class)
public interface NotificationTimeElectionNotificationTimeElectionChoice extends Validator<NotificationTimeElection> {
	
	String NAME = "NotificationTimeElectionNotificationTimeElectionChoice";
	String DEFINITION = "required choice notificationTime, customNotification";
	
	class Default implements NotificationTimeElectionNotificationTimeElectionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotificationTimeElection notificationTimeElection) {
			ComparisonResult result = executeDataRule(notificationTimeElection);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NotificationTimeElection", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "NotificationTimeElection", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(NotificationTimeElection notificationTimeElection) {
			try {
				return choice(MapperS.of(notificationTimeElection), Arrays.asList("notificationTime", "customNotification"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NotificationTimeElectionNotificationTimeElectionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotificationTimeElection notificationTimeElection) {
			return Collections.emptyList();
		}
	}
}
