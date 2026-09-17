package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.Repo;
import fpml.consolidated.repo.validation.RepoTypeFormatValidator;
import fpml.consolidated.repo.validation.RepoValidator;
import fpml.consolidated.repo.validation.datarule.RepoChoice0;
import fpml.consolidated.repo.validation.datarule.RepoChoice1;
import fpml.consolidated.repo.validation.datarule.RepoChoice2;
import fpml.consolidated.repo.validation.datarule.RepoChoice3;
import fpml.consolidated.repo.validation.exists.RepoOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Repo.class)
public class RepoMeta implements RosettaMetaData<Repo> {

	@Override
	public List<Validator<? super Repo>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Repo>create(RepoChoice0.class),
			factory.<Repo>create(RepoChoice1.class),
			factory.<Repo>create(RepoChoice2.class),
			factory.<Repo>create(RepoChoice3.class)
		);
	}
	
	@Override
	public List<Function<? super Repo, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Repo> validator(ValidatorFactory factory) {
		return factory.<Repo>create(RepoValidator.class);
	}

	@Override
	public Validator<? super Repo> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Repo>create(RepoTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Repo> validator() {
		return new RepoValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Repo> typeFormatValidator() {
		return new RepoTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Repo, Set<String>> onlyExistsValidator() {
		return new RepoOnlyExistsValidator();
	}
}
