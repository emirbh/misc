package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.EvergreenOption;
import fpml.consolidated.loan.validation.EvergreenOptionTypeFormatValidator;
import fpml.consolidated.loan.validation.EvergreenOptionValidator;
import fpml.consolidated.loan.validation.exists.EvergreenOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EvergreenOption.class)
public class EvergreenOptionMeta implements RosettaMetaData<EvergreenOption> {

	@Override
	public List<Validator<? super EvergreenOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EvergreenOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EvergreenOption> validator(ValidatorFactory factory) {
		return factory.<EvergreenOption>create(EvergreenOptionValidator.class);
	}

	@Override
	public Validator<? super EvergreenOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EvergreenOption>create(EvergreenOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EvergreenOption> validator() {
		return new EvergreenOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EvergreenOption> typeFormatValidator() {
		return new EvergreenOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EvergreenOption, Set<String>> onlyExistsValidator() {
		return new EvergreenOptionOnlyExistsValidator();
	}
}
