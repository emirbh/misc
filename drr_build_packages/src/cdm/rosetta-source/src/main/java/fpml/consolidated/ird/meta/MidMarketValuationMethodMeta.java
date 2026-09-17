package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.MidMarketValuationMethod;
import fpml.consolidated.ird.validation.MidMarketValuationMethodTypeFormatValidator;
import fpml.consolidated.ird.validation.MidMarketValuationMethodValidator;
import fpml.consolidated.ird.validation.exists.MidMarketValuationMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MidMarketValuationMethod.class)
public class MidMarketValuationMethodMeta implements RosettaMetaData<MidMarketValuationMethod> {

	@Override
	public List<Validator<? super MidMarketValuationMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MidMarketValuationMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MidMarketValuationMethod> validator(ValidatorFactory factory) {
		return factory.<MidMarketValuationMethod>create(MidMarketValuationMethodValidator.class);
	}

	@Override
	public Validator<? super MidMarketValuationMethod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MidMarketValuationMethod>create(MidMarketValuationMethodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MidMarketValuationMethod> validator() {
		return new MidMarketValuationMethodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MidMarketValuationMethod> typeFormatValidator() {
		return new MidMarketValuationMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MidMarketValuationMethod, Set<String>> onlyExistsValidator() {
		return new MidMarketValuationMethodOnlyExistsValidator();
	}
}
