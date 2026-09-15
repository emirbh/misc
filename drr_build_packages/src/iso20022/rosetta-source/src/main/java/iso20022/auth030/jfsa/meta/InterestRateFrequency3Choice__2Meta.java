package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.InterestRateFrequency3Choice__2;
import iso20022.auth030.jfsa.validation.InterestRateFrequency3Choice__2TypeFormatValidator;
import iso20022.auth030.jfsa.validation.InterestRateFrequency3Choice__2Validator;
import iso20022.auth030.jfsa.validation.exists.InterestRateFrequency3Choice__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InterestRateFrequency3Choice__2.class)
public class InterestRateFrequency3Choice__2Meta implements RosettaMetaData<InterestRateFrequency3Choice__2> {

	@Override
	public List<Validator<? super InterestRateFrequency3Choice__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestRateFrequency3Choice__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestRateFrequency3Choice__2> validator(ValidatorFactory factory) {
		return factory.<InterestRateFrequency3Choice__2>create(InterestRateFrequency3Choice__2Validator.class);
	}

	@Override
	public Validator<? super InterestRateFrequency3Choice__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestRateFrequency3Choice__2>create(InterestRateFrequency3Choice__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestRateFrequency3Choice__2> validator() {
		return new InterestRateFrequency3Choice__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestRateFrequency3Choice__2> typeFormatValidator() {
		return new InterestRateFrequency3Choice__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestRateFrequency3Choice__2, Set<String>> onlyExistsValidator() {
		return new InterestRateFrequency3Choice__2OnlyExistsValidator();
	}
}
