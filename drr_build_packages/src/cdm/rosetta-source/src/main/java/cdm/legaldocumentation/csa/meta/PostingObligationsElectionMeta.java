package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.PostingObligationsElection;
import cdm.legaldocumentation.csa.validation.PostingObligationsElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.PostingObligationsElectionValidator;
import cdm.legaldocumentation.csa.validation.datarule.PostingObligationsElectionAsPermitted;
import cdm.legaldocumentation.csa.validation.datarule.PostingObligationsElectionConsistentParty;
import cdm.legaldocumentation.csa.validation.datarule.PostingObligationsElectionEligibleCollateral;
import cdm.legaldocumentation.csa.validation.exists.PostingObligationsElectionOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=PostingObligationsElection.class)
public class PostingObligationsElectionMeta implements RosettaMetaData<PostingObligationsElection> {

	@Override
	public List<Validator<? super PostingObligationsElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PostingObligationsElection>create(PostingObligationsElectionAsPermitted.class),
			factory.<PostingObligationsElection>create(PostingObligationsElectionEligibleCollateral.class),
			factory.<PostingObligationsElection>create(PostingObligationsElectionConsistentParty.class)
		);
	}
	
	@Override
	public List<Function<? super PostingObligationsElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PostingObligationsElection> validator(ValidatorFactory factory) {
		return factory.<PostingObligationsElection>create(PostingObligationsElectionValidator.class);
	}

	@Override
	public Validator<? super PostingObligationsElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PostingObligationsElection>create(PostingObligationsElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PostingObligationsElection> validator() {
		return new PostingObligationsElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PostingObligationsElection> typeFormatValidator() {
		return new PostingObligationsElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PostingObligationsElection, Set<String>> onlyExistsValidator() {
		return new PostingObligationsElectionOnlyExistsValidator();
	}
}
