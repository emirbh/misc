package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAveragingProcess;
import fpml.consolidated.fx.accruals.FxRateObservable;
import fpml.consolidated.fx.accruals.validation.FxAveragingProcessTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAveragingProcessValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxRateObservableChoice;
import fpml.consolidated.fx.accruals.validation.exists.FxAveragingProcessOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAveragingProcess.class)
public class FxAveragingProcessMeta implements RosettaMetaData<FxAveragingProcess> {

	@Override
	public List<Validator<? super FxAveragingProcess>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxRateObservable>create(FxRateObservableChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAveragingProcess, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAveragingProcess> validator(ValidatorFactory factory) {
		return factory.<FxAveragingProcess>create(FxAveragingProcessValidator.class);
	}

	@Override
	public Validator<? super FxAveragingProcess> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAveragingProcess>create(FxAveragingProcessTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAveragingProcess> validator() {
		return new FxAveragingProcessValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAveragingProcess> typeFormatValidator() {
		return new FxAveragingProcessTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAveragingProcess, Set<String>> onlyExistsValidator() {
		return new FxAveragingProcessOnlyExistsValidator();
	}
}
