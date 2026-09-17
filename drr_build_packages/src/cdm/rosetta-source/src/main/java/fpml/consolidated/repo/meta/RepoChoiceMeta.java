package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.RepoChoice;
import fpml.consolidated.repo.validation.RepoChoiceTypeFormatValidator;
import fpml.consolidated.repo.validation.RepoChoiceValidator;
import fpml.consolidated.repo.validation.datarule.RepoChoiceChoice;
import fpml.consolidated.repo.validation.exists.RepoChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RepoChoice.class)
public class RepoChoiceMeta implements RosettaMetaData<RepoChoice> {

	@Override
	public List<Validator<? super RepoChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RepoChoice>create(RepoChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RepoChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RepoChoice> validator(ValidatorFactory factory) {
		return factory.<RepoChoice>create(RepoChoiceValidator.class);
	}

	@Override
	public Validator<? super RepoChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RepoChoice>create(RepoChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RepoChoice> validator() {
		return new RepoChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RepoChoice> typeFormatValidator() {
		return new RepoChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RepoChoice, Set<String>> onlyExistsValidator() {
		return new RepoChoiceOnlyExistsValidator();
	}
}
