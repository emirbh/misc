package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.SinglePartyOption;
import fpml.consolidated.ird.validation.SinglePartyOptionTypeFormatValidator;
import fpml.consolidated.ird.validation.SinglePartyOptionValidator;
import fpml.consolidated.ird.validation.exists.SinglePartyOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SinglePartyOption.class)
public class SinglePartyOptionMeta implements RosettaMetaData<SinglePartyOption> {

	@Override
	public List<Validator<? super SinglePartyOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SinglePartyOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SinglePartyOption> validator(ValidatorFactory factory) {
		return factory.<SinglePartyOption>create(SinglePartyOptionValidator.class);
	}

	@Override
	public Validator<? super SinglePartyOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SinglePartyOption>create(SinglePartyOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SinglePartyOption> validator() {
		return new SinglePartyOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SinglePartyOption> typeFormatValidator() {
		return new SinglePartyOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SinglePartyOption, Set<String>> onlyExistsValidator() {
		return new SinglePartyOptionOnlyExistsValidator();
	}
}
