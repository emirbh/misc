package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.OptionNumericStrike;
import fpml.consolidated.option.shared.OptionStrike;
import fpml.consolidated.option.shared.validation.OptionStrikeTypeFormatValidator;
import fpml.consolidated.option.shared.validation.OptionStrikeValidator;
import fpml.consolidated.option.shared.validation.datarule.OptionNumericStrikeChoice;
import fpml.consolidated.option.shared.validation.exists.OptionStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OptionStrike.class)
public class OptionStrikeMeta implements RosettaMetaData<OptionStrike> {

	@Override
	public List<Validator<? super OptionStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OptionNumericStrike>create(OptionNumericStrikeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OptionStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionStrike> validator(ValidatorFactory factory) {
		return factory.<OptionStrike>create(OptionStrikeValidator.class);
	}

	@Override
	public Validator<? super OptionStrike> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionStrike>create(OptionStrikeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionStrike> validator() {
		return new OptionStrikeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionStrike> typeFormatValidator() {
		return new OptionStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionStrike, Set<String>> onlyExistsValidator() {
		return new OptionStrikeOnlyExistsValidator();
	}
}
