package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Step;
import fpml.consolidated.shared.validation.StepTypeFormatValidator;
import fpml.consolidated.shared.validation.StepValidator;
import fpml.consolidated.shared.validation.exists.StepOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Step.class)
public class StepMeta implements RosettaMetaData<Step> {

	@Override
	public List<Validator<? super Step>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Step, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Step> validator(ValidatorFactory factory) {
		return factory.<Step>create(StepValidator.class);
	}

	@Override
	public Validator<? super Step> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Step>create(StepTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Step> validator() {
		return new StepValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Step> typeFormatValidator() {
		return new StepTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Step, Set<String>> onlyExistsValidator() {
		return new StepOnlyExistsValidator();
	}
}
