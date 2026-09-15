package fpml.consolidated.repo.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.RelativePriceChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RelativePriceChoiceChoice")
@ImplementedBy(RelativePriceChoiceChoice.Default.class)
public interface RelativePriceChoiceChoice extends Validator<RelativePriceChoice> {
	
	String NAME = "RelativePriceChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements RelativePriceChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelativePriceChoice relativePriceChoice) {
			ComparisonResult result = executeDataRule(relativePriceChoice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RelativePriceChoice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RelativePriceChoice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RelativePriceChoice relativePriceChoice) {
			try {
				return choice(MapperS.of(relativePriceChoice), Arrays.asList("bond", "convertibleBond", "equity"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RelativePriceChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelativePriceChoice relativePriceChoice) {
			return Collections.emptyList();
		}
	}
}
