package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.RepoLegBase;
import fpml.consolidated.repo.validation.RepoLegBaseTypeFormatValidator;
import fpml.consolidated.repo.validation.RepoLegBaseValidator;
import fpml.consolidated.repo.validation.exists.RepoLegBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RepoLegBase.class)
public class RepoLegBaseMeta implements RosettaMetaData<RepoLegBase> {

	@Override
	public List<Validator<? super RepoLegBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RepoLegBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RepoLegBase> validator(ValidatorFactory factory) {
		return factory.<RepoLegBase>create(RepoLegBaseValidator.class);
	}

	@Override
	public Validator<? super RepoLegBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RepoLegBase>create(RepoLegBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RepoLegBase> validator() {
		return new RepoLegBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RepoLegBase> typeFormatValidator() {
		return new RepoLegBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RepoLegBase, Set<String>> onlyExistsValidator() {
		return new RepoLegBaseOnlyExistsValidator();
	}
}
