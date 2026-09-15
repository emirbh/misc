package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LcOption;
import fpml.consolidated.loan.validation.LcOptionTypeFormatValidator;
import fpml.consolidated.loan.validation.LcOptionValidator;
import fpml.consolidated.loan.validation.exists.LcOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LcOption.class)
public class LcOptionMeta implements RosettaMetaData<LcOption> {

	@Override
	public List<Validator<? super LcOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LcOption> validator(ValidatorFactory factory) {
		return factory.<LcOption>create(LcOptionValidator.class);
	}

	@Override
	public Validator<? super LcOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LcOption>create(LcOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LcOption> validator() {
		return new LcOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LcOption> typeFormatValidator() {
		return new LcOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcOption, Set<String>> onlyExistsValidator() {
		return new LcOptionOnlyExistsValidator();
	}
}
