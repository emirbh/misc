package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAverageRate;
import fpml.consolidated.fx.accruals.FxRateObservable;
import fpml.consolidated.fx.accruals.validation.FxAverageRateTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAverageRateValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxRateObservableChoice;
import fpml.consolidated.fx.accruals.validation.exists.FxAverageRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAverageRate.class)
public class FxAverageRateMeta implements RosettaMetaData<FxAverageRate> {

	@Override
	public List<Validator<? super FxAverageRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxRateObservable>create(FxRateObservableChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAverageRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAverageRate> validator(ValidatorFactory factory) {
		return factory.<FxAverageRate>create(FxAverageRateValidator.class);
	}

	@Override
	public Validator<? super FxAverageRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAverageRate>create(FxAverageRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAverageRate> validator() {
		return new FxAverageRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAverageRate> typeFormatValidator() {
		return new FxAverageRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAverageRate, Set<String>> onlyExistsValidator() {
		return new FxAverageRateOnlyExistsValidator();
	}
}
