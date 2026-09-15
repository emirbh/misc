package fpml.consolidated.msg.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.ServiceNotification;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ServiceNotificationChoice")
@ImplementedBy(ServiceNotificationChoice.Default.class)
public interface ServiceNotificationChoice extends Validator<ServiceNotification> {
	
	String NAME = "ServiceNotificationChoice";
	String DEFINITION = "optional choice status, processingStatus, advisory";
	
	class Default implements ServiceNotificationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ServiceNotification serviceNotification) {
			ComparisonResult result = executeDataRule(serviceNotification);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ServiceNotification", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ServiceNotification", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ServiceNotification serviceNotification) {
			try {
				return choice(MapperS.of(serviceNotification), Arrays.asList("status", "processingStatus", "advisory"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ServiceNotificationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ServiceNotification serviceNotification) {
			return Collections.emptyList();
		}
	}
}
