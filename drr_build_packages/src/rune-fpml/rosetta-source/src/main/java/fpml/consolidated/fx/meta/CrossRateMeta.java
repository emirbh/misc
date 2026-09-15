package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.CrossRate;
import fpml.consolidated.fx.validation.CrossRateTypeFormatValidator;
import fpml.consolidated.fx.validation.CrossRateValidator;
import fpml.consolidated.fx.validation.exists.CrossRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CrossRate.class)
public class CrossRateMeta implements RosettaMetaData<CrossRate> {

	@Override
	public List<Validator<? super CrossRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CrossRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CrossRate> validator(ValidatorFactory factory) {
		return factory.<CrossRate>create(CrossRateValidator.class);
	}

	@Override
	public Validator<? super CrossRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CrossRate>create(CrossRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CrossRate> validator() {
		return new CrossRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CrossRate> typeFormatValidator() {
		return new CrossRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CrossRate, Set<String>> onlyExistsValidator() {
		return new CrossRateOnlyExistsValidator();
	}
}
