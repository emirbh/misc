package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.NonNegativeStep;
import fpml.consolidated.shared.validation.NonNegativeStepTypeFormatValidator;
import fpml.consolidated.shared.validation.NonNegativeStepValidator;
import fpml.consolidated.shared.validation.exists.NonNegativeStepOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NonNegativeStep.class)
public class NonNegativeStepMeta implements RosettaMetaData<NonNegativeStep> {

	@Override
	public List<Validator<? super NonNegativeStep>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonNegativeStep, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonNegativeStep> validator(ValidatorFactory factory) {
		return factory.<NonNegativeStep>create(NonNegativeStepValidator.class);
	}

	@Override
	public Validator<? super NonNegativeStep> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonNegativeStep>create(NonNegativeStepTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonNegativeStep> validator() {
		return new NonNegativeStepValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonNegativeStep> typeFormatValidator() {
		return new NonNegativeStepTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonNegativeStep, Set<String>> onlyExistsValidator() {
		return new NonNegativeStepOnlyExistsValidator();
	}
}
