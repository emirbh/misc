package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.TermCurve;
import fpml.consolidated.mktenv.validation.TermCurveTypeFormatValidator;
import fpml.consolidated.mktenv.validation.TermCurveValidator;
import fpml.consolidated.mktenv.validation.exists.TermCurveOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TermCurve.class)
public class TermCurveMeta implements RosettaMetaData<TermCurve> {

	@Override
	public List<Validator<? super TermCurve>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TermCurve, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TermCurve> validator(ValidatorFactory factory) {
		return factory.<TermCurve>create(TermCurveValidator.class);
	}

	@Override
	public Validator<? super TermCurve> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TermCurve>create(TermCurveTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TermCurve> validator() {
		return new TermCurveValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TermCurve> typeFormatValidator() {
		return new TermCurveTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TermCurve, Set<String>> onlyExistsValidator() {
		return new TermCurveOnlyExistsValidator();
	}
}
