package fpml.consolidated.generic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.generic.GenericFrequency;
import fpml.consolidated.generic.validation.GenericFrequencyTypeFormatValidator;
import fpml.consolidated.generic.validation.GenericFrequencyValidator;
import fpml.consolidated.generic.validation.datarule.GenericFrequencyChoice;
import fpml.consolidated.generic.validation.exists.GenericFrequencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GenericFrequency.class)
public class GenericFrequencyMeta implements RosettaMetaData<GenericFrequency> {

	@Override
	public List<Validator<? super GenericFrequency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<GenericFrequency>create(GenericFrequencyChoice.class)
		);
	}
	
	@Override
	public List<Function<? super GenericFrequency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericFrequency> validator(ValidatorFactory factory) {
		return factory.<GenericFrequency>create(GenericFrequencyValidator.class);
	}

	@Override
	public Validator<? super GenericFrequency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericFrequency>create(GenericFrequencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericFrequency> validator() {
		return new GenericFrequencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericFrequency> typeFormatValidator() {
		return new GenericFrequencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericFrequency, Set<String>> onlyExistsValidator() {
		return new GenericFrequencyOnlyExistsValidator();
	}
}
