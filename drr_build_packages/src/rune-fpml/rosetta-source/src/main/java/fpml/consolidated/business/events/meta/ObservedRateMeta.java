package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ObservedRate;
import fpml.consolidated.business.events.validation.ObservedRateTypeFormatValidator;
import fpml.consolidated.business.events.validation.ObservedRateValidator;
import fpml.consolidated.business.events.validation.exists.ObservedRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ObservedRate.class)
public class ObservedRateMeta implements RosettaMetaData<ObservedRate> {

	@Override
	public List<Validator<? super ObservedRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObservedRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObservedRate> validator(ValidatorFactory factory) {
		return factory.<ObservedRate>create(ObservedRateValidator.class);
	}

	@Override
	public Validator<? super ObservedRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ObservedRate>create(ObservedRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ObservedRate> validator() {
		return new ObservedRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ObservedRate> typeFormatValidator() {
		return new ObservedRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObservedRate, Set<String>> onlyExistsValidator() {
		return new ObservedRateOnlyExistsValidator();
	}
}
