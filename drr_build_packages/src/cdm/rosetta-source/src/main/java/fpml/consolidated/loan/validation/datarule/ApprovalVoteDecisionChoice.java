package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ApprovalVoteDecision;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ApprovalVoteDecisionChoice")
@ImplementedBy(ApprovalVoteDecisionChoice.Default.class)
public interface ApprovalVoteDecisionChoice extends Validator<ApprovalVoteDecision> {
	
	String NAME = "ApprovalVoteDecisionChoice";
	String DEFINITION = "optional choice documentVoteDecision, description";
	
	class Default implements ApprovalVoteDecisionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApprovalVoteDecision approvalVoteDecision) {
			ComparisonResult result = executeDataRule(approvalVoteDecision);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ApprovalVoteDecision", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ApprovalVoteDecision", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ApprovalVoteDecision approvalVoteDecision) {
			try {
				return choice(MapperS.of(approvalVoteDecision), Arrays.asList("documentVoteDecision", "description"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ApprovalVoteDecisionChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApprovalVoteDecision approvalVoteDecision) {
			return Collections.emptyList();
		}
	}
}
