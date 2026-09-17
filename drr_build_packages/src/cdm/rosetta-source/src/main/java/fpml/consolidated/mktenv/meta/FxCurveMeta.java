package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.FxCurve;
import fpml.consolidated.mktenv.validation.FxCurveTypeFormatValidator;
import fpml.consolidated.mktenv.validation.FxCurveValidator;
import fpml.consolidated.mktenv.validation.exists.FxCurveOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxCurve.class)
public class FxCurveMeta implements RosettaMetaData<FxCurve> {

	@Override
	public List<Validator<? super FxCurve>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxCurve, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxCurve> validator(ValidatorFactory factory) {
		return factory.<FxCurve>create(FxCurveValidator.class);
	}

	@Override
	public Validator<? super FxCurve> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxCurve>create(FxCurveTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxCurve> validator() {
		return new FxCurveValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxCurve> typeFormatValidator() {
		return new FxCurveTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxCurve, Set<String>> onlyExistsValidator() {
		return new FxCurveOnlyExistsValidator();
	}
}
