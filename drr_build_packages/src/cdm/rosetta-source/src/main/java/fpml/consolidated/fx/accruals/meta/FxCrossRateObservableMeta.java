package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxCrossRateObservable;
import fpml.consolidated.fx.accruals.validation.FxCrossRateObservableTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxCrossRateObservableValidator;
import fpml.consolidated.fx.accruals.validation.exists.FxCrossRateObservableOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxCrossRateObservable.class)
public class FxCrossRateObservableMeta implements RosettaMetaData<FxCrossRateObservable> {

	@Override
	public List<Validator<? super FxCrossRateObservable>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxCrossRateObservable, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxCrossRateObservable> validator(ValidatorFactory factory) {
		return factory.<FxCrossRateObservable>create(FxCrossRateObservableValidator.class);
	}

	@Override
	public Validator<? super FxCrossRateObservable> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxCrossRateObservable>create(FxCrossRateObservableTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxCrossRateObservable> validator() {
		return new FxCrossRateObservableValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxCrossRateObservable> typeFormatValidator() {
		return new FxCrossRateObservableTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxCrossRateObservable, Set<String>> onlyExistsValidator() {
		return new FxCrossRateObservableOnlyExistsValidator();
	}
}
