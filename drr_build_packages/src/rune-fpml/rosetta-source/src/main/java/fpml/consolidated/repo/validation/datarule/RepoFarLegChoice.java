package fpml.consolidated.repo.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.repo.RepoFarLeg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RepoFarLegChoice")
@ImplementedBy(RepoFarLegChoice.Default.class)
public interface RepoFarLegChoice extends Validator<RepoFarLeg> {
	
	String NAME = "RepoFarLegChoice";
	String DEFINITION = "required choice settlementAmount, settlementCurrency";
	
	class Default implements RepoFarLegChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepoFarLeg repoFarLeg) {
			ComparisonResult result = executeDataRule(repoFarLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RepoFarLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RepoFarLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RepoFarLeg repoFarLeg) {
			try {
				return choice(MapperS.of(repoFarLeg), Arrays.asList("settlementAmount", "settlementCurrency"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RepoFarLegChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepoFarLeg repoFarLeg) {
			return Collections.emptyList();
		}
	}
}
