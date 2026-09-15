package fpml.consolidated.bond.option.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.bond.option.BondOptionStrike;
import fpml.consolidated.bond.option.validation.BondOptionStrikeTypeFormatValidator;
import fpml.consolidated.bond.option.validation.BondOptionStrikeValidator;
import fpml.consolidated.bond.option.validation.datarule.BondOptionStrikeChoice;
import fpml.consolidated.bond.option.validation.exists.BondOptionStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BondOptionStrike.class)
public class BondOptionStrikeMeta implements RosettaMetaData<BondOptionStrike> {

	@Override
	public List<Validator<? super BondOptionStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<BondOptionStrike>create(BondOptionStrikeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super BondOptionStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BondOptionStrike> validator(ValidatorFactory factory) {
		return factory.<BondOptionStrike>create(BondOptionStrikeValidator.class);
	}

	@Override
	public Validator<? super BondOptionStrike> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BondOptionStrike>create(BondOptionStrikeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BondOptionStrike> validator() {
		return new BondOptionStrikeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BondOptionStrike> typeFormatValidator() {
		return new BondOptionStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BondOptionStrike, Set<String>> onlyExistsValidator() {
		return new BondOptionStrikeOnlyExistsValidator();
	}
}
