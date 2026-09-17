package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.OptionNumericStrike;
import fpml.consolidated.option.shared.validation.OptionNumericStrikeTypeFormatValidator;
import fpml.consolidated.option.shared.validation.OptionNumericStrikeValidator;
import fpml.consolidated.option.shared.validation.datarule.OptionNumericStrikeChoice;
import fpml.consolidated.option.shared.validation.exists.OptionNumericStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OptionNumericStrike.class)
public class OptionNumericStrikeMeta implements RosettaMetaData<OptionNumericStrike> {

	@Override
	public List<Validator<? super OptionNumericStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OptionNumericStrike>create(OptionNumericStrikeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OptionNumericStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionNumericStrike> validator(ValidatorFactory factory) {
		return factory.<OptionNumericStrike>create(OptionNumericStrikeValidator.class);
	}

	@Override
	public Validator<? super OptionNumericStrike> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionNumericStrike>create(OptionNumericStrikeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionNumericStrike> validator() {
		return new OptionNumericStrikeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionNumericStrike> typeFormatValidator() {
		return new OptionNumericStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionNumericStrike, Set<String>> onlyExistsValidator() {
		return new OptionNumericStrikeOnlyExistsValidator();
	}
}
