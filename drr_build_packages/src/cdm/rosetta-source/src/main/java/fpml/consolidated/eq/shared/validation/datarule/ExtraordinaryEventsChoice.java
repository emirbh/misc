package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.ExtraordinaryEvents;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ExtraordinaryEventsChoice")
@ImplementedBy(ExtraordinaryEventsChoice.Default.class)
public interface ExtraordinaryEventsChoice extends Validator<ExtraordinaryEvents> {
	
	String NAME = "ExtraordinaryEventsChoice";
	String DEFINITION = "optional choice additionalDisruptionEvents, failureToDeliver";
	
	class Default implements ExtraordinaryEventsChoice {
	
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
				return choice(MapperS.of(extraordinaryEvents), Arrays.asList("additionalDisruptionEvents", "failureToDeliver"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExtraordinaryEventsChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExtraordinaryEvents extraordinaryEvents) {
			return Collections.emptyList();
		}
	}
}
