package fpml.consolidated.recordkeeping.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.ESMAIndexIdentification;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ESMAIndexIdentificationChoice")
@ImplementedBy(ESMAIndexIdentificationChoice.Default.class)
public interface ESMAIndexIdentificationChoice extends Validator<ESMAIndexIdentification> {
	
	String NAME = "ESMAIndexIdentificationChoice";
	String DEFINITION = "one-of";
	
	class Default implements ESMAIndexIdentificationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAIndexIdentification eSMAIndexIdentification) {
			ComparisonResult result = executeDataRule(eSMAIndexIdentification);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAIndexIdentification", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ESMAIndexIdentification", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ESMAIndexIdentification eSMAIndexIdentification) {
			try {
				return choice(MapperS.of(eSMAIndexIdentification), Arrays.asList("code", "name"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ESMAIndexIdentificationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAIndexIdentification eSMAIndexIdentification) {
			return Collections.emptyList();
		}
	}
}
