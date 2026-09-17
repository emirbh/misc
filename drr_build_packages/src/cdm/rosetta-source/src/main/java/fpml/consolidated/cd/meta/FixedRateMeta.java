package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.FixedRate;
import fpml.consolidated.cd.validation.FixedRateTypeFormatValidator;
import fpml.consolidated.cd.validation.FixedRateValidator;
import fpml.consolidated.cd.validation.exists.FixedRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FixedRate.class)
public class FixedRateMeta implements RosettaMetaData<FixedRate> {

	@Override
	public List<Validator<? super FixedRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FixedRate> validator(ValidatorFactory factory) {
		return factory.<FixedRate>create(FixedRateValidator.class);
	}

	@Override
	public Validator<? super FixedRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FixedRate>create(FixedRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FixedRate> validator() {
		return new FixedRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FixedRate> typeFormatValidator() {
		return new FixedRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedRate, Set<String>> onlyExistsValidator() {
		return new FixedRateOnlyExistsValidator();
	}
}
