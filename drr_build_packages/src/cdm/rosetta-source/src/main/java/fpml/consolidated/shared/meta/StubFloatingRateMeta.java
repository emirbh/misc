package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.StubFloatingRate;
import fpml.consolidated.shared.validation.StubFloatingRateTypeFormatValidator;
import fpml.consolidated.shared.validation.StubFloatingRateValidator;
import fpml.consolidated.shared.validation.exists.StubFloatingRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=StubFloatingRate.class)
public class StubFloatingRateMeta implements RosettaMetaData<StubFloatingRate> {

	@Override
	public List<Validator<? super StubFloatingRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StubFloatingRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super StubFloatingRate> validator(ValidatorFactory factory) {
		return factory.<StubFloatingRate>create(StubFloatingRateValidator.class);
	}

	@Override
	public Validator<? super StubFloatingRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<StubFloatingRate>create(StubFloatingRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super StubFloatingRate> validator() {
		return new StubFloatingRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super StubFloatingRate> typeFormatValidator() {
		return new StubFloatingRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StubFloatingRate, Set<String>> onlyExistsValidator() {
		return new StubFloatingRateOnlyExistsValidator();
	}
}
