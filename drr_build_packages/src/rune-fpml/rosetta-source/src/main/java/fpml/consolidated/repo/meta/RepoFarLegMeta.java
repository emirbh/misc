package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.RepoFarLeg;
import fpml.consolidated.repo.validation.RepoFarLegTypeFormatValidator;
import fpml.consolidated.repo.validation.RepoFarLegValidator;
import fpml.consolidated.repo.validation.datarule.RepoFarLegChoice;
import fpml.consolidated.repo.validation.exists.RepoFarLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RepoFarLeg.class)
public class RepoFarLegMeta implements RosettaMetaData<RepoFarLeg> {

	@Override
	public List<Validator<? super RepoFarLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RepoFarLeg>create(RepoFarLegChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RepoFarLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RepoFarLeg> validator(ValidatorFactory factory) {
		return factory.<RepoFarLeg>create(RepoFarLegValidator.class);
	}

	@Override
	public Validator<? super RepoFarLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RepoFarLeg>create(RepoFarLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RepoFarLeg> validator() {
		return new RepoFarLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RepoFarLeg> typeFormatValidator() {
		return new RepoFarLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RepoFarLeg, Set<String>> onlyExistsValidator() {
		return new RepoFarLegOnlyExistsValidator();
	}
}
