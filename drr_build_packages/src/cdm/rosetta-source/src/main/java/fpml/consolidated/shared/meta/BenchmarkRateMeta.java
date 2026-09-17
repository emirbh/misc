package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BenchmarkRate;
import fpml.consolidated.shared.validation.BenchmarkRateTypeFormatValidator;
import fpml.consolidated.shared.validation.BenchmarkRateValidator;
import fpml.consolidated.shared.validation.exists.BenchmarkRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BenchmarkRate.class)
public class BenchmarkRateMeta implements RosettaMetaData<BenchmarkRate> {

	@Override
	public List<Validator<? super BenchmarkRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BenchmarkRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BenchmarkRate> validator(ValidatorFactory factory) {
		return factory.<BenchmarkRate>create(BenchmarkRateValidator.class);
	}

	@Override
	public Validator<? super BenchmarkRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BenchmarkRate>create(BenchmarkRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BenchmarkRate> validator() {
		return new BenchmarkRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BenchmarkRate> typeFormatValidator() {
		return new BenchmarkRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BenchmarkRate, Set<String>> onlyExistsValidator() {
		return new BenchmarkRateOnlyExistsValidator();
	}
}
