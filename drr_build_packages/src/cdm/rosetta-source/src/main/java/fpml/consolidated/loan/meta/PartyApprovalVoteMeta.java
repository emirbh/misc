package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.PartyApprovalVote;
import fpml.consolidated.loan.validation.PartyApprovalVoteTypeFormatValidator;
import fpml.consolidated.loan.validation.PartyApprovalVoteValidator;
import fpml.consolidated.loan.validation.exists.PartyApprovalVoteOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PartyApprovalVote.class)
public class PartyApprovalVoteMeta implements RosettaMetaData<PartyApprovalVote> {

	@Override
	public List<Validator<? super PartyApprovalVote>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyApprovalVote, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyApprovalVote> validator(ValidatorFactory factory) {
		return factory.<PartyApprovalVote>create(PartyApprovalVoteValidator.class);
	}

	@Override
	public Validator<? super PartyApprovalVote> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyApprovalVote>create(PartyApprovalVoteTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyApprovalVote> validator() {
		return new PartyApprovalVoteValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyApprovalVote> typeFormatValidator() {
		return new PartyApprovalVoteTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyApprovalVote, Set<String>> onlyExistsValidator() {
		return new PartyApprovalVoteOnlyExistsValidator();
	}
}
