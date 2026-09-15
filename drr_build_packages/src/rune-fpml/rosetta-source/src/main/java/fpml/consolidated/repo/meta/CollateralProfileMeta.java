package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.CollateralProfile;
import fpml.consolidated.repo.validation.CollateralProfileTypeFormatValidator;
import fpml.consolidated.repo.validation.CollateralProfileValidator;
import fpml.consolidated.repo.validation.exists.CollateralProfileOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CollateralProfile.class)
public class CollateralProfileMeta implements RosettaMetaData<CollateralProfile> {

	@Override
	public List<Validator<? super CollateralProfile>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralProfile, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralProfile> validator(ValidatorFactory factory) {
		return factory.<CollateralProfile>create(CollateralProfileValidator.class);
	}

	@Override
	public Validator<? super CollateralProfile> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralProfile>create(CollateralProfileTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralProfile> validator() {
		return new CollateralProfileValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralProfile> typeFormatValidator() {
		return new CollateralProfileTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralProfile, Set<String>> onlyExistsValidator() {
		return new CollateralProfileOnlyExistsValidator();
	}
}
