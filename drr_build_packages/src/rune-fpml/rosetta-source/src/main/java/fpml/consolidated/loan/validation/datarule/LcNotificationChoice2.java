package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LcNotification;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LcNotificationChoice2")
@ImplementedBy(LcNotificationChoice2.Default.class)
public interface LcNotificationChoice2 extends Validator<LcNotification> {
	
	String NAME = "LcNotificationChoice2";
	String DEFINITION = "required choice letterOfCreditIdentifier, letterOfCreditSummary, letterOfCredit";
	
	class Default implements LcNotificationChoice2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LcNotification lcNotification) {
			ComparisonResult result = executeDataRule(lcNotification);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LcNotification", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LcNotification", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LcNotification lcNotification) {
			try {
				return choice(MapperS.of(lcNotification), Arrays.asList("letterOfCreditIdentifier", "letterOfCreditSummary", "letterOfCredit"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LcNotificationChoice2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LcNotification lcNotification) {
			return Collections.emptyList();
		}
	}
}
