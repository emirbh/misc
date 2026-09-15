package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualForward;
import fpml.consolidated.fx.accruals.validation.FxAccrualForwardTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualForwardValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualForwardChoice0;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualForwardChoice1;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualForwardOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualForward.class)
public class FxAccrualForwardMeta implements RosettaMetaData<FxAccrualForward> {

	@Override
	public List<Validator<? super FxAccrualForward>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxAccrualForward>create(FxAccrualForwardChoice0.class),
			factory.<FxAccrualForward>create(FxAccrualForwardChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualForward, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualForward> validator(ValidatorFactory factory) {
		return factory.<FxAccrualForward>create(FxAccrualForwardValidator.class);
	}

	@Override
	public Validator<? super FxAccrualForward> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualForward>create(FxAccrualForwardTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualForward> validator() {
		return new FxAccrualForwardValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualForward> typeFormatValidator() {
		return new FxAccrualForwardTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualForward, Set<String>> onlyExistsValidator() {
		return new FxAccrualForwardOnlyExistsValidator();
	}
}
