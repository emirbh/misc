package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxTouch;
import fpml.consolidated.fx.validation.FxTouchTypeFormatValidator;
import fpml.consolidated.fx.validation.FxTouchValidator;
import fpml.consolidated.fx.validation.datarule.FxTouchChoice;
import fpml.consolidated.fx.validation.exists.FxTouchOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTouch.class)
public class FxTouchMeta implements RosettaMetaData<FxTouch> {

	@Override
	public List<Validator<? super FxTouch>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxTouch>create(FxTouchChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTouch, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTouch> validator(ValidatorFactory factory) {
		return factory.<FxTouch>create(FxTouchValidator.class);
	}

	@Override
	public Validator<? super FxTouch> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTouch>create(FxTouchTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTouch> validator() {
		return new FxTouchValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTouch> typeFormatValidator() {
		return new FxTouchTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTouch, Set<String>> onlyExistsValidator() {
		return new FxTouchOnlyExistsValidator();
	}
}
