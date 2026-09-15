package fpml.consolidated.generic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.generic.GenericResetFrequency;
import fpml.consolidated.generic.validation.GenericResetFrequencyTypeFormatValidator;
import fpml.consolidated.generic.validation.GenericResetFrequencyValidator;
import fpml.consolidated.generic.validation.exists.GenericResetFrequencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GenericResetFrequency.class)
public class GenericResetFrequencyMeta implements RosettaMetaData<GenericResetFrequency> {

	@Override
	public List<Validator<? super GenericResetFrequency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericResetFrequency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericResetFrequency> validator(ValidatorFactory factory) {
		return factory.<GenericResetFrequency>create(GenericResetFrequencyValidator.class);
	}

	@Override
	public Validator<? super GenericResetFrequency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericResetFrequency>create(GenericResetFrequencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericResetFrequency> validator() {
		return new GenericResetFrequencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericResetFrequency> typeFormatValidator() {
		return new GenericResetFrequencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericResetFrequency, Set<String>> onlyExistsValidator() {
		return new GenericResetFrequencyOnlyExistsValidator();
	}
}
