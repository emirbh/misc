package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxRateObservable;
import fpml.consolidated.fx.accruals.validation.FxRateObservableTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxRateObservableValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxRateObservableChoice;
import fpml.consolidated.fx.accruals.validation.exists.FxRateObservableOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxRateObservable.class)
public class FxRateObservableMeta implements RosettaMetaData<FxRateObservable> {

	@Override
	public List<Validator<? super FxRateObservable>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxRateObservable>create(FxRateObservableChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxRateObservable, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxRateObservable> validator(ValidatorFactory factory) {
		return factory.<FxRateObservable>create(FxRateObservableValidator.class);
	}

	@Override
	public Validator<? super FxRateObservable> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxRateObservable>create(FxRateObservableTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxRateObservable> validator() {
		return new FxRateObservableValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxRateObservable> typeFormatValidator() {
		return new FxRateObservableTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxRateObservable, Set<String>> onlyExistsValidator() {
		return new FxRateObservableOnlyExistsValidator();
	}
}
