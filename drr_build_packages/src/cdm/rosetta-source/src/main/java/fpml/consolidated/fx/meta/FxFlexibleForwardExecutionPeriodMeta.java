package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxFlexibleForwardExecutionPeriod;
import fpml.consolidated.fx.validation.FxFlexibleForwardExecutionPeriodTypeFormatValidator;
import fpml.consolidated.fx.validation.FxFlexibleForwardExecutionPeriodValidator;
import fpml.consolidated.fx.validation.exists.FxFlexibleForwardExecutionPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxFlexibleForwardExecutionPeriod.class)
public class FxFlexibleForwardExecutionPeriodMeta implements RosettaMetaData<FxFlexibleForwardExecutionPeriod> {

	@Override
	public List<Validator<? super FxFlexibleForwardExecutionPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxFlexibleForwardExecutionPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxFlexibleForwardExecutionPeriod> validator(ValidatorFactory factory) {
		return factory.<FxFlexibleForwardExecutionPeriod>create(FxFlexibleForwardExecutionPeriodValidator.class);
	}

	@Override
	public Validator<? super FxFlexibleForwardExecutionPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxFlexibleForwardExecutionPeriod>create(FxFlexibleForwardExecutionPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxFlexibleForwardExecutionPeriod> validator() {
		return new FxFlexibleForwardExecutionPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxFlexibleForwardExecutionPeriod> typeFormatValidator() {
		return new FxFlexibleForwardExecutionPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFlexibleForwardExecutionPeriod, Set<String>> onlyExistsValidator() {
		return new FxFlexibleForwardExecutionPeriodOnlyExistsValidator();
	}
}
