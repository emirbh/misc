package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.ParametricAdjustmentPoint;
import fpml.consolidated.mktenv.validation.ParametricAdjustmentPointTypeFormatValidator;
import fpml.consolidated.mktenv.validation.ParametricAdjustmentPointValidator;
import fpml.consolidated.mktenv.validation.exists.ParametricAdjustmentPointOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ParametricAdjustmentPoint.class)
public class ParametricAdjustmentPointMeta implements RosettaMetaData<ParametricAdjustmentPoint> {

	@Override
	public List<Validator<? super ParametricAdjustmentPoint>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ParametricAdjustmentPoint, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ParametricAdjustmentPoint> validator(ValidatorFactory factory) {
		return factory.<ParametricAdjustmentPoint>create(ParametricAdjustmentPointValidator.class);
	}

	@Override
	public Validator<? super ParametricAdjustmentPoint> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ParametricAdjustmentPoint>create(ParametricAdjustmentPointTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ParametricAdjustmentPoint> validator() {
		return new ParametricAdjustmentPointValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ParametricAdjustmentPoint> typeFormatValidator() {
		return new ParametricAdjustmentPointTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ParametricAdjustmentPoint, Set<String>> onlyExistsValidator() {
		return new ParametricAdjustmentPointOnlyExistsValidator();
	}
}
