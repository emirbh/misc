package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.StartingDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("StartingDateChoice")
@ImplementedBy(StartingDateChoice.Default.class)
public interface StartingDateChoice extends Validator<StartingDate> {
	
	String NAME = "StartingDateChoice";
	String DEFINITION = "one-of";
	
	class Default implements StartingDateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, StartingDate startingDate) {
			ComparisonResult result = executeDataRule(startingDate);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StartingDate", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "StartingDate", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(StartingDate startingDate) {
			try {
				return choice(MapperS.of(startingDate), Arrays.asList("dateRelativeTo", "adjustableDate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StartingDateChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, StartingDate startingDate) {
			return Collections.emptyList();
		}
	}
}
