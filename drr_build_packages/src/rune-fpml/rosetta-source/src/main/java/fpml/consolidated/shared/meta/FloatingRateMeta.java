package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.FloatingRate;
import fpml.consolidated.shared.validation.FloatingRateTypeFormatValidator;
import fpml.consolidated.shared.validation.FloatingRateValidator;
import fpml.consolidated.shared.validation.exists.FloatingRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FloatingRate.class)
public class FloatingRateMeta implements RosettaMetaData<FloatingRate> {

	@Override
	public List<Validator<? super FloatingRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingRate> validator(ValidatorFactory factory) {
		return factory.<FloatingRate>create(FloatingRateValidator.class);
	}

	@Override
	public Validator<? super FloatingRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingRate>create(FloatingRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRate> validator() {
		return new FloatingRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRate> typeFormatValidator() {
		return new FloatingRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRate, Set<String>> onlyExistsValidator() {
		return new FloatingRateOnlyExistsValidator();
	}
}
