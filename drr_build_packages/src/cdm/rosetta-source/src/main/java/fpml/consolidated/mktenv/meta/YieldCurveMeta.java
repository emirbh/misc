package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.YieldCurve;
import fpml.consolidated.mktenv.validation.YieldCurveTypeFormatValidator;
import fpml.consolidated.mktenv.validation.YieldCurveValidator;
import fpml.consolidated.mktenv.validation.exists.YieldCurveOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=YieldCurve.class)
public class YieldCurveMeta implements RosettaMetaData<YieldCurve> {

	@Override
	public List<Validator<? super YieldCurve>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super YieldCurve, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super YieldCurve> validator(ValidatorFactory factory) {
		return factory.<YieldCurve>create(YieldCurveValidator.class);
	}

	@Override
	public Validator<? super YieldCurve> typeFormatValidator(ValidatorFactory factory) {
		return factory.<YieldCurve>create(YieldCurveTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super YieldCurve> validator() {
		return new YieldCurveValidator();
	}

	@Deprecated
	@Override
	public Validator<? super YieldCurve> typeFormatValidator() {
		return new YieldCurveTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super YieldCurve, Set<String>> onlyExistsValidator() {
		return new YieldCurveOnlyExistsValidator();
	}
}
