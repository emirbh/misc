package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualStrike;
import fpml.consolidated.fx.accruals.validation.FxAccrualStrikeTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualStrikeValidator;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualStrike.class)
public class FxAccrualStrikeMeta implements RosettaMetaData<FxAccrualStrike> {

	@Override
	public List<Validator<? super FxAccrualStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualStrike> validator(ValidatorFactory factory) {
		return factory.<FxAccrualStrike>create(FxAccrualStrikeValidator.class);
	}

	@Override
	public Validator<? super FxAccrualStrike> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualStrike>create(FxAccrualStrikeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualStrike> validator() {
		return new FxAccrualStrikeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualStrike> typeFormatValidator() {
		return new FxAccrualStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualStrike, Set<String>> onlyExistsValidator() {
		return new FxAccrualStrikeOnlyExistsValidator();
	}
}
