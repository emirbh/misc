package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.CommitmentChange;
import fpml.consolidated.loan.validation.CommitmentChangeTypeFormatValidator;
import fpml.consolidated.loan.validation.CommitmentChangeValidator;
import fpml.consolidated.loan.validation.exists.CommitmentChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommitmentChange.class)
public class CommitmentChangeMeta implements RosettaMetaData<CommitmentChange> {

	@Override
	public List<Validator<? super CommitmentChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommitmentChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommitmentChange> validator(ValidatorFactory factory) {
		return factory.<CommitmentChange>create(CommitmentChangeValidator.class);
	}

	@Override
	public Validator<? super CommitmentChange> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommitmentChange>create(CommitmentChangeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommitmentChange> validator() {
		return new CommitmentChangeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommitmentChange> typeFormatValidator() {
		return new CommitmentChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommitmentChange, Set<String>> onlyExistsValidator() {
		return new CommitmentChangeOnlyExistsValidator();
	}
}
