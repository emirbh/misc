package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.EquityStrike;
import fpml.consolidated.eq.shared.validation.EquityStrikeTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.EquityStrikeValidator;
import fpml.consolidated.eq.shared.validation.datarule.EquityStrikeChoice;
import fpml.consolidated.eq.shared.validation.exists.EquityStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EquityStrike.class)
public class EquityStrikeMeta implements RosettaMetaData<EquityStrike> {

	@Override
	public List<Validator<? super EquityStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EquityStrike>create(EquityStrikeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EquityStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityStrike> validator(ValidatorFactory factory) {
		return factory.<EquityStrike>create(EquityStrikeValidator.class);
	}

	@Override
	public Validator<? super EquityStrike> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityStrike>create(EquityStrikeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityStrike> validator() {
		return new EquityStrikeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityStrike> typeFormatValidator() {
		return new EquityStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityStrike, Set<String>> onlyExistsValidator() {
		return new EquityStrikeOnlyExistsValidator();
	}
}
