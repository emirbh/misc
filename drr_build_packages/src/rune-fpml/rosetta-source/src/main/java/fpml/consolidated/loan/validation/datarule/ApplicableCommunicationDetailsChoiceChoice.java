package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ApplicableCommunicationDetailsChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ApplicableCommunicationDetailsChoiceChoice")
@ImplementedBy(ApplicableCommunicationDetailsChoiceChoice.Default.class)
public interface ApplicableCommunicationDetailsChoiceChoice extends Validator<ApplicableCommunicationDetailsChoice> {
	
	String NAME = "ApplicableCommunicationDetailsChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements ApplicableCommunicationDetailsChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApplicableCommunicationDetailsChoice applicableCommunicationDetailsChoice) {
			ComparisonResult result = executeDataRule(applicableCommunicationDetailsChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ApplicableCommunicationDetailsChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ApplicableCommunicationDetailsChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ApplicableCommunicationDetailsChoice applicableCommunicationDetailsChoice) {
			try {
				return choice(MapperS.of(applicableCommunicationDetailsChoice), Arrays.asList("relatedPerson", "relatedBusinessUnit"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ApplicableCommunicationDetailsChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApplicableCommunicationDetailsChoice applicableCommunicationDetailsChoice) {
			return Collections.emptyList();
		}
	}
}
