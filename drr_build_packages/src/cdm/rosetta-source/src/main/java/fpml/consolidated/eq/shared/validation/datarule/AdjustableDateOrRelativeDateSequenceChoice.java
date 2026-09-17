package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.AdjustableDateOrRelativeDateSequence;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("AdjustableDateOrRelativeDateSequenceChoice")
@ImplementedBy(AdjustableDateOrRelativeDateSequenceChoice.Default.class)
public interface AdjustableDateOrRelativeDateSequenceChoice extends Validator<AdjustableDateOrRelativeDateSequence> {
	
	String NAME = "AdjustableDateOrRelativeDateSequenceChoice";
	String DEFINITION = "required choice adjustableDate, relativeDateSequence";
	
	class Default implements AdjustableDateOrRelativeDateSequenceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableDateOrRelativeDateSequence adjustableDateOrRelativeDateSequence) {
			ComparisonResult result = executeDataRule(adjustableDateOrRelativeDateSequence);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableDateOrRelativeDateSequence", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableDateOrRelativeDateSequence", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AdjustableDateOrRelativeDateSequence adjustableDateOrRelativeDateSequence) {
			try {
				return choice(MapperS.of(adjustableDateOrRelativeDateSequence), Arrays.asList("adjustableDate", "relativeDateSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableDateOrRelativeDateSequenceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableDateOrRelativeDateSequence adjustableDateOrRelativeDateSequence) {
			return Collections.emptyList();
		}
	}
}
