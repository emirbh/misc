package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AccruingPikOption;
import fpml.consolidated.loan.validation.AccruingPikOptionTypeFormatValidator;
import fpml.consolidated.loan.validation.AccruingPikOptionValidator;
import fpml.consolidated.loan.validation.exists.AccruingPikOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AccruingPikOption.class)
public class AccruingPikOptionMeta implements RosettaMetaData<AccruingPikOption> {

	@Override
	public List<Validator<? super AccruingPikOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingPikOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AccruingPikOption> validator(ValidatorFactory factory) {
		return factory.<AccruingPikOption>create(AccruingPikOptionValidator.class);
	}

	@Override
	public Validator<? super AccruingPikOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AccruingPikOption>create(AccruingPikOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AccruingPikOption> validator() {
		return new AccruingPikOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AccruingPikOption> typeFormatValidator() {
		return new AccruingPikOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingPikOption, Set<String>> onlyExistsValidator() {
		return new AccruingPikOptionOnlyExistsValidator();
	}
}
