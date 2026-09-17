package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.CreditOptionStrike;
import fpml.consolidated.cd.validation.CreditOptionStrikeTypeFormatValidator;
import fpml.consolidated.cd.validation.CreditOptionStrikeValidator;
import fpml.consolidated.cd.validation.datarule.CreditOptionStrikeChoice;
import fpml.consolidated.cd.validation.exists.CreditOptionStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditOptionStrike.class)
public class CreditOptionStrikeMeta implements RosettaMetaData<CreditOptionStrike> {

	@Override
	public List<Validator<? super CreditOptionStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CreditOptionStrike>create(CreditOptionStrikeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CreditOptionStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditOptionStrike> validator(ValidatorFactory factory) {
		return factory.<CreditOptionStrike>create(CreditOptionStrikeValidator.class);
	}

	@Override
	public Validator<? super CreditOptionStrike> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditOptionStrike>create(CreditOptionStrikeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditOptionStrike> validator() {
		return new CreditOptionStrikeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditOptionStrike> typeFormatValidator() {
		return new CreditOptionStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditOptionStrike, Set<String>> onlyExistsValidator() {
		return new CreditOptionStrikeOnlyExistsValidator();
	}
}
