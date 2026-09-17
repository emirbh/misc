package cdm.legaldocumentation.transaction.validation.datarule;

import cdm.legaldocumentation.transaction.ExtraordinaryEvents;
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
@RosettaDataRule("ExtraordinaryEventsExtraordinaryEventsChoice")
@ImplementedBy(ExtraordinaryEventsExtraordinaryEventsChoice.Default.class)
public interface ExtraordinaryEventsExtraordinaryEventsChoice extends Validator<ExtraordinaryEvents> {
	
	String NAME = "ExtraordinaryEventsExtraordinaryEventsChoice";
	String DEFINITION = "required choice additionalDisruptionEvents, failureToDeliver";
	
	class Default implements ExtraordinaryEventsExtraordinaryEventsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExtraordinaryEvents extraordinaryEvents) {
			ComparisonResult result = executeDataRule(extraordinaryEvents);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExtraordinaryEvents", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExtraordinaryEvents", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ExtraordinaryEvents extraordinaryEvents) {
			try {
				return choice(MapperS.of(extraordinaryEvents), Arrays.asList("additionalDisruptionEvents", "failureToDeliver"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExtraordinaryEventsExtraordinaryEventsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExtraordinaryEvents extraordinaryEvents) {
			return Collections.emptyList();
		}
	}
}
