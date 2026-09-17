package fpml.consolidated.generic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.EquityStrike;
import fpml.consolidated.eq.shared.validation.datarule.EquityStrikeChoice;
import fpml.consolidated.generic.GenericOptionStrike;
import fpml.consolidated.generic.validation.GenericOptionStrikeTypeFormatValidator;
import fpml.consolidated.generic.validation.GenericOptionStrikeValidator;
import fpml.consolidated.generic.validation.exists.GenericOptionStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GenericOptionStrike.class)
public class GenericOptionStrikeMeta implements RosettaMetaData<GenericOptionStrike> {

	@Override
	public List<Validator<? super GenericOptionStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EquityStrike>create(EquityStrikeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super GenericOptionStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericOptionStrike> validator(ValidatorFactory factory) {
		return factory.<GenericOptionStrike>create(GenericOptionStrikeValidator.class);
	}

	@Override
	public Validator<? super GenericOptionStrike> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericOptionStrike>create(GenericOptionStrikeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericOptionStrike> validator() {
		return new GenericOptionStrikeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericOptionStrike> typeFormatValidator() {
		return new GenericOptionStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericOptionStrike, Set<String>> onlyExistsValidator() {
		return new GenericOptionStrikeOnlyExistsValidator();
	}
}
