package fpml.consolidated.asset.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Underlyer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("UnderlyerChoice")
@ImplementedBy(UnderlyerChoice.Default.class)
public interface UnderlyerChoice extends Validator<Underlyer> {
	
	String NAME = "UnderlyerChoice";
	String DEFINITION = "one-of";
	
	class Default implements UnderlyerChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Underlyer underlyer) {
			ComparisonResult result = executeDataRule(underlyer);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Underlyer", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Underlyer", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Underlyer underlyer) {
			try {
				return choice(MapperS.of(underlyer), Arrays.asList("singleUnderlyer", "basket"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements UnderlyerChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Underlyer underlyer) {
			return Collections.emptyList();
		}
	}
}
