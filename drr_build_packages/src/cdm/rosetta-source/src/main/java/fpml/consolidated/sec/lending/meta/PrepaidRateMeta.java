package fpml.consolidated.sec.lending.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.sec.lending.PrepaidRate;
import fpml.consolidated.sec.lending.validation.PrepaidRateTypeFormatValidator;
import fpml.consolidated.sec.lending.validation.PrepaidRateValidator;
import fpml.consolidated.sec.lending.validation.datarule.PrepaidRateChoice;
import fpml.consolidated.sec.lending.validation.exists.PrepaidRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PrepaidRate.class)
public class PrepaidRateMeta implements RosettaMetaData<PrepaidRate> {

	@Override
	public List<Validator<? super PrepaidRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PrepaidRate>create(PrepaidRateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PrepaidRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PrepaidRate> validator(ValidatorFactory factory) {
		return factory.<PrepaidRate>create(PrepaidRateValidator.class);
	}

	@Override
	public Validator<? super PrepaidRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PrepaidRate>create(PrepaidRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PrepaidRate> validator() {
		return new PrepaidRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PrepaidRate> typeFormatValidator() {
		return new PrepaidRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrepaidRate, Set<String>> onlyExistsValidator() {
		return new PrepaidRateOnlyExistsValidator();
	}
}
