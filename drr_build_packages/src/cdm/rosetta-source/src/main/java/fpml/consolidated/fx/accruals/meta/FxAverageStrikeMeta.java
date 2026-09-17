package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAverageStrike;
import fpml.consolidated.fx.accruals.FxRateObservable;
import fpml.consolidated.fx.accruals.validation.FxAverageStrikeTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAverageStrikeValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxRateObservableChoice;
import fpml.consolidated.fx.accruals.validation.exists.FxAverageStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAverageStrike.class)
public class FxAverageStrikeMeta implements RosettaMetaData<FxAverageStrike> {

	@Override
	public List<Validator<? super FxAverageStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxRateObservable>create(FxRateObservableChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAverageStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAverageStrike> validator(ValidatorFactory factory) {
		return factory.<FxAverageStrike>create(FxAverageStrikeValidator.class);
	}

	@Override
	public Validator<? super FxAverageStrike> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAverageStrike>create(FxAverageStrikeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAverageStrike> validator() {
		return new FxAverageStrikeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAverageStrike> typeFormatValidator() {
		return new FxAverageStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAverageStrike, Set<String>> onlyExistsValidator() {
		return new FxAverageStrikeOnlyExistsValidator();
	}
}
