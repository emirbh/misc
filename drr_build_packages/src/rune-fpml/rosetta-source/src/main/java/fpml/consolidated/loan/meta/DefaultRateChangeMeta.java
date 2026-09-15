package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DefaultRateChange;
import fpml.consolidated.loan.validation.DefaultRateChangeTypeFormatValidator;
import fpml.consolidated.loan.validation.DefaultRateChangeValidator;
import fpml.consolidated.loan.validation.exists.DefaultRateChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DefaultRateChange.class)
public class DefaultRateChangeMeta implements RosettaMetaData<DefaultRateChange> {

	@Override
	public List<Validator<? super DefaultRateChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DefaultRateChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DefaultRateChange> validator(ValidatorFactory factory) {
		return factory.<DefaultRateChange>create(DefaultRateChangeValidator.class);
	}

	@Override
	public Validator<? super DefaultRateChange> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DefaultRateChange>create(DefaultRateChangeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DefaultRateChange> validator() {
		return new DefaultRateChangeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DefaultRateChange> typeFormatValidator() {
		return new DefaultRateChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DefaultRateChange, Set<String>> onlyExistsValidator() {
		return new DefaultRateChangeOnlyExistsValidator();
	}
}
