package fpml.consolidated.bond.option.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.bond.option.ReferenceSwapCurve;
import fpml.consolidated.bond.option.validation.ReferenceSwapCurveTypeFormatValidator;
import fpml.consolidated.bond.option.validation.ReferenceSwapCurveValidator;
import fpml.consolidated.bond.option.validation.exists.ReferenceSwapCurveOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReferenceSwapCurve.class)
public class ReferenceSwapCurveMeta implements RosettaMetaData<ReferenceSwapCurve> {

	@Override
	public List<Validator<? super ReferenceSwapCurve>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReferenceSwapCurve, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReferenceSwapCurve> validator(ValidatorFactory factory) {
		return factory.<ReferenceSwapCurve>create(ReferenceSwapCurveValidator.class);
	}

	@Override
	public Validator<? super ReferenceSwapCurve> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReferenceSwapCurve>create(ReferenceSwapCurveTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReferenceSwapCurve> validator() {
		return new ReferenceSwapCurveValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReferenceSwapCurve> typeFormatValidator() {
		return new ReferenceSwapCurveTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceSwapCurve, Set<String>> onlyExistsValidator() {
		return new ReferenceSwapCurveOnlyExistsValidator();
	}
}
