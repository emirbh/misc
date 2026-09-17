package fpml.consolidated.repo.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.Repo;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RepoChoice2")
@ImplementedBy(RepoChoice2.Default.class)
public interface RepoChoice2 extends Validator<Repo> {
	
	String NAME = "RepoChoice2";
	String DEFINITION = "optional choice noticePeriod, partyNoticePeriod";
	
	class Default implements RepoChoice2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Repo repo) {
			ComparisonResult result = executeDataRule(repo);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Repo", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Repo", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Repo repo) {
			try {
				return choice(MapperS.of(repo), Arrays.asList("noticePeriod", "partyNoticePeriod"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RepoChoice2 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Repo repo) {
			return Collections.emptyList();
		}
	}
}
