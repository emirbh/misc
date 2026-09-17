package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.EnvironmentalProductApplicableLaw;
import fpml.consolidated.com.validation.EnvironmentalProductApplicableLawTypeFormatValidator;
import fpml.consolidated.com.validation.EnvironmentalProductApplicableLawValidator;
import fpml.consolidated.com.validation.exists.EnvironmentalProductApplicableLawOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EnvironmentalProductApplicableLaw.class)
public class EnvironmentalProductApplicableLawMeta implements RosettaMetaData<EnvironmentalProductApplicableLaw> {

	@Override
	public List<Validator<? super EnvironmentalProductApplicableLaw>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnvironmentalProductApplicableLaw, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnvironmentalProductApplicableLaw> validator(ValidatorFactory factory) {
		return factory.<EnvironmentalProductApplicableLaw>create(EnvironmentalProductApplicableLawValidator.class);
	}

	@Override
	public Validator<? super EnvironmentalProductApplicableLaw> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnvironmentalProductApplicableLaw>create(EnvironmentalProductApplicableLawTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalProductApplicableLaw> validator() {
		return new EnvironmentalProductApplicableLawValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalProductApplicableLaw> typeFormatValidator() {
		return new EnvironmentalProductApplicableLawTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnvironmentalProductApplicableLaw, Set<String>> onlyExistsValidator() {
		return new EnvironmentalProductApplicableLawOnlyExistsValidator();
	}
}
