package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.EnvironmentalProductComplaincePeriod;
import fpml.consolidated.com.validation.EnvironmentalProductComplaincePeriodTypeFormatValidator;
import fpml.consolidated.com.validation.EnvironmentalProductComplaincePeriodValidator;
import fpml.consolidated.com.validation.exists.EnvironmentalProductComplaincePeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EnvironmentalProductComplaincePeriod.class)
public class EnvironmentalProductComplaincePeriodMeta implements RosettaMetaData<EnvironmentalProductComplaincePeriod> {

	@Override
	public List<Validator<? super EnvironmentalProductComplaincePeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnvironmentalProductComplaincePeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnvironmentalProductComplaincePeriod> validator(ValidatorFactory factory) {
		return factory.<EnvironmentalProductComplaincePeriod>create(EnvironmentalProductComplaincePeriodValidator.class);
	}

	@Override
	public Validator<? super EnvironmentalProductComplaincePeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnvironmentalProductComplaincePeriod>create(EnvironmentalProductComplaincePeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalProductComplaincePeriod> validator() {
		return new EnvironmentalProductComplaincePeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalProductComplaincePeriod> typeFormatValidator() {
		return new EnvironmentalProductComplaincePeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnvironmentalProductComplaincePeriod, Set<String>> onlyExistsValidator() {
		return new EnvironmentalProductComplaincePeriodOnlyExistsValidator();
	}
}
