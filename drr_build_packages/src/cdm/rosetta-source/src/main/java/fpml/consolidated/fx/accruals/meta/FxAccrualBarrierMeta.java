package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualBarrier;
import fpml.consolidated.fx.accruals.validation.FxAccrualBarrierTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualBarrierValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualBarrierChoice;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualBarrierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualBarrier.class)
public class FxAccrualBarrierMeta implements RosettaMetaData<FxAccrualBarrier> {

	@Override
	public List<Validator<? super FxAccrualBarrier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxAccrualBarrier>create(FxAccrualBarrierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualBarrier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualBarrier> validator(ValidatorFactory factory) {
		return factory.<FxAccrualBarrier>create(FxAccrualBarrierValidator.class);
	}

	@Override
	public Validator<? super FxAccrualBarrier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualBarrier>create(FxAccrualBarrierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualBarrier> validator() {
		return new FxAccrualBarrierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualBarrier> typeFormatValidator() {
		return new FxAccrualBarrierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualBarrier, Set<String>> onlyExistsValidator() {
		return new FxAccrualBarrierOnlyExistsValidator();
	}
}
