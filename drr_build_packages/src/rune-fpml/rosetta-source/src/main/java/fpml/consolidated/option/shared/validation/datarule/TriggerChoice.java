package fpml.consolidated.option.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.Trigger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("TriggerChoice")
@ImplementedBy(TriggerChoice.Default.class)
public interface TriggerChoice extends Validator<Trigger> {
	
	String NAME = "TriggerChoice";
	String DEFINITION = "optional choice level, levelPercentage, creditEvents, creditEventsReference";
	
	class Default implements TriggerChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trigger trigger) {
			ComparisonResult result = executeDataRule(trigger);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Trigger", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Trigger", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Trigger trigger) {
			try {
				return choice(MapperS.of(trigger), Arrays.asList("level", "levelPercentage", "creditEvents", "creditEventsReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TriggerChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Trigger trigger) {
			return Collections.emptyList();
		}
	}
}
