package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.CrossCurrencyMethod;
import fpml.consolidated.ird.validation.CrossCurrencyMethodTypeFormatValidator;
import fpml.consolidated.ird.validation.CrossCurrencyMethodValidator;
import fpml.consolidated.ird.validation.exists.CrossCurrencyMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CrossCurrencyMethod.class)
public class CrossCurrencyMethodMeta implements RosettaMetaData<CrossCurrencyMethod> {

	@Override
	public List<Validator<? super CrossCurrencyMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CrossCurrencyMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CrossCurrencyMethod> validator(ValidatorFactory factory) {
		return factory.<CrossCurrencyMethod>create(CrossCurrencyMethodValidator.class);
	}

	@Override
	public Validator<? super CrossCurrencyMethod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CrossCurrencyMethod>create(CrossCurrencyMethodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CrossCurrencyMethod> validator() {
		return new CrossCurrencyMethodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CrossCurrencyMethod> typeFormatValidator() {
		return new CrossCurrencyMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CrossCurrencyMethod, Set<String>> onlyExistsValidator() {
		return new CrossCurrencyMethodOnlyExistsValidator();
	}
}
