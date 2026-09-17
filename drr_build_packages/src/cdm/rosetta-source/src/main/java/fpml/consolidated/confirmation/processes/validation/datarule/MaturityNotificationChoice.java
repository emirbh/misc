package fpml.consolidated.confirmation.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.confirmation.processes.MaturityNotification;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("MaturityNotificationChoice")
@ImplementedBy(MaturityNotificationChoice.Default.class)
public interface MaturityNotificationChoice extends Validator<MaturityNotification> {
	
	String NAME = "MaturityNotificationChoice";
	String DEFINITION = "required choice optionExpiry, tradeMaturity";
	
	class Default implements MaturityNotificationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MaturityNotification maturityNotification) {
			ComparisonResult result = executeDataRule(maturityNotification);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MaturityNotification", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MaturityNotification", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MaturityNotification maturityNotification) {
			try {
				return choice(MapperS.of(maturityNotification), Arrays.asList("optionExpiry", "tradeMaturity"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MaturityNotificationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MaturityNotification maturityNotification) {
			return Collections.emptyList();
		}
	}
}
