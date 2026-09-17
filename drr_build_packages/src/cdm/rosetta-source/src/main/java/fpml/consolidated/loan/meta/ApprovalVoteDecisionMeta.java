package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ApprovalVoteDecision;
import fpml.consolidated.loan.validation.ApprovalVoteDecisionTypeFormatValidator;
import fpml.consolidated.loan.validation.ApprovalVoteDecisionValidator;
import fpml.consolidated.loan.validation.datarule.ApprovalVoteDecisionChoice;
import fpml.consolidated.loan.validation.exists.ApprovalVoteDecisionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ApprovalVoteDecision.class)
public class ApprovalVoteDecisionMeta implements RosettaMetaData<ApprovalVoteDecision> {

	@Override
	public List<Validator<? super ApprovalVoteDecision>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ApprovalVoteDecision>create(ApprovalVoteDecisionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ApprovalVoteDecision, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ApprovalVoteDecision> validator(ValidatorFactory factory) {
		return factory.<ApprovalVoteDecision>create(ApprovalVoteDecisionValidator.class);
	}

	@Override
	public Validator<? super ApprovalVoteDecision> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ApprovalVoteDecision>create(ApprovalVoteDecisionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ApprovalVoteDecision> validator() {
		return new ApprovalVoteDecisionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ApprovalVoteDecision> typeFormatValidator() {
		return new ApprovalVoteDecisionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApprovalVoteDecision, Set<String>> onlyExistsValidator() {
		return new ApprovalVoteDecisionOnlyExistsValidator();
	}
}
