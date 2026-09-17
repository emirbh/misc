package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DocumentVoteDecisionType;
import fpml.consolidated.loan.validation.DocumentVoteDecisionTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.DocumentVoteDecisionTypeValidator;
import fpml.consolidated.loan.validation.exists.DocumentVoteDecisionTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DocumentVoteDecisionType.class)
public class DocumentVoteDecisionTypeMeta implements RosettaMetaData<DocumentVoteDecisionType> {

	@Override
	public List<Validator<? super DocumentVoteDecisionType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DocumentVoteDecisionType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DocumentVoteDecisionType> validator(ValidatorFactory factory) {
		return factory.<DocumentVoteDecisionType>create(DocumentVoteDecisionTypeValidator.class);
	}

	@Override
	public Validator<? super DocumentVoteDecisionType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DocumentVoteDecisionType>create(DocumentVoteDecisionTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DocumentVoteDecisionType> validator() {
		return new DocumentVoteDecisionTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DocumentVoteDecisionType> typeFormatValidator() {
		return new DocumentVoteDecisionTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DocumentVoteDecisionType, Set<String>> onlyExistsValidator() {
		return new DocumentVoteDecisionTypeOnlyExistsValidator();
	}
}
