package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ApprovalVotes;
import fpml.consolidated.loan.validation.ApprovalVotesTypeFormatValidator;
import fpml.consolidated.loan.validation.ApprovalVotesValidator;
import fpml.consolidated.loan.validation.exists.ApprovalVotesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ApprovalVotes.class)
public class ApprovalVotesMeta implements RosettaMetaData<ApprovalVotes> {

	@Override
	public List<Validator<? super ApprovalVotes>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ApprovalVotes, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ApprovalVotes> validator(ValidatorFactory factory) {
		return factory.<ApprovalVotes>create(ApprovalVotesValidator.class);
	}

	@Override
	public Validator<? super ApprovalVotes> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ApprovalVotes>create(ApprovalVotesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ApprovalVotes> validator() {
		return new ApprovalVotesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ApprovalVotes> typeFormatValidator() {
		return new ApprovalVotesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApprovalVotes, Set<String>> onlyExistsValidator() {
		return new ApprovalVotesOnlyExistsValidator();
	}
}
