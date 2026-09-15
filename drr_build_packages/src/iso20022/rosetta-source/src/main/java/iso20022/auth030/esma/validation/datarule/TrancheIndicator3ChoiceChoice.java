package iso20022.auth030.esma.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.TrancheIndicator3Choice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TrancheIndicator3ChoiceChoice")
@ImplementedBy(TrancheIndicator3ChoiceChoice.Default.class)
public interface TrancheIndicator3ChoiceChoice extends Validator<TrancheIndicator3Choice> {
	
	String NAME = "TrancheIndicator3ChoiceChoice";
	String DEFINITION = "one-of";
	
	class Default implements TrancheIndicator3ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TrancheIndicator3Choice trancheIndicator3Choice) {
			ComparisonResult result = executeDataRule(trancheIndicator3Choice);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TrancheIndicator3Choice", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TrancheIndicator3Choice", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(TrancheIndicator3Choice trancheIndicator3Choice) {
			try {
				return choice(MapperS.of(trancheIndicator3Choice), Arrays.asList("trnchd", "utrnchd"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TrancheIndicator3ChoiceChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, TrancheIndicator3Choice trancheIndicator3Choice) {
			return Collections.emptyList();
		}
	}
}
