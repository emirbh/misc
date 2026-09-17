package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetBarrier;
import fpml.consolidated.fx.targets.validation.FxTargetBarrierTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetBarrierValidator;
import fpml.consolidated.fx.targets.validation.exists.FxTargetBarrierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetBarrier.class)
public class FxTargetBarrierMeta implements RosettaMetaData<FxTargetBarrier> {

	@Override
	public List<Validator<? super FxTargetBarrier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetBarrier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetBarrier> validator(ValidatorFactory factory) {
		return factory.<FxTargetBarrier>create(FxTargetBarrierValidator.class);
	}

	@Override
	public Validator<? super FxTargetBarrier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetBarrier>create(FxTargetBarrierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetBarrier> validator() {
		return new FxTargetBarrierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetBarrier> typeFormatValidator() {
		return new FxTargetBarrierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetBarrier, Set<String>> onlyExistsValidator() {
		return new FxTargetBarrierOnlyExistsValidator();
	}
}
