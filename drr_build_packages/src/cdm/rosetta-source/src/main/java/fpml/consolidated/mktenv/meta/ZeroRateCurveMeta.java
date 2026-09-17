package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.ZeroRateCurve;
import fpml.consolidated.mktenv.validation.ZeroRateCurveTypeFormatValidator;
import fpml.consolidated.mktenv.validation.ZeroRateCurveValidator;
import fpml.consolidated.mktenv.validation.exists.ZeroRateCurveOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ZeroRateCurve.class)
public class ZeroRateCurveMeta implements RosettaMetaData<ZeroRateCurve> {

	@Override
	public List<Validator<? super ZeroRateCurve>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ZeroRateCurve, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ZeroRateCurve> validator(ValidatorFactory factory) {
		return factory.<ZeroRateCurve>create(ZeroRateCurveValidator.class);
	}

	@Override
	public Validator<? super ZeroRateCurve> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ZeroRateCurve>create(ZeroRateCurveTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ZeroRateCurve> validator() {
		return new ZeroRateCurveValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ZeroRateCurve> typeFormatValidator() {
		return new ZeroRateCurveTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ZeroRateCurve, Set<String>> onlyExistsValidator() {
		return new ZeroRateCurveOnlyExistsValidator();
	}
}
