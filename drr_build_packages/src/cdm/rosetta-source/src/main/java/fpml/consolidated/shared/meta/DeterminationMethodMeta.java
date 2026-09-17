package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.validation.DeterminationMethodTypeFormatValidator;
import fpml.consolidated.shared.validation.DeterminationMethodValidator;
import fpml.consolidated.shared.validation.exists.DeterminationMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DeterminationMethod.class)
public class DeterminationMethodMeta implements RosettaMetaData<DeterminationMethod> {

	@Override
	public List<Validator<? super DeterminationMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DeterminationMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DeterminationMethod> validator(ValidatorFactory factory) {
		return factory.<DeterminationMethod>create(DeterminationMethodValidator.class);
	}

	@Override
	public Validator<? super DeterminationMethod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DeterminationMethod>create(DeterminationMethodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DeterminationMethod> validator() {
		return new DeterminationMethodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DeterminationMethod> typeFormatValidator() {
		return new DeterminationMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeterminationMethod, Set<String>> onlyExistsValidator() {
		return new DeterminationMethodOnlyExistsValidator();
	}
}
