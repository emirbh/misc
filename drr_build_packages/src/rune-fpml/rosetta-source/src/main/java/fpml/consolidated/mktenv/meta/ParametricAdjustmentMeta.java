package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.ParametricAdjustment;
import fpml.consolidated.mktenv.validation.ParametricAdjustmentTypeFormatValidator;
import fpml.consolidated.mktenv.validation.ParametricAdjustmentValidator;
import fpml.consolidated.mktenv.validation.exists.ParametricAdjustmentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ParametricAdjustment.class)
public class ParametricAdjustmentMeta implements RosettaMetaData<ParametricAdjustment> {

	@Override
	public List<Validator<? super ParametricAdjustment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ParametricAdjustment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ParametricAdjustment> validator(ValidatorFactory factory) {
		return factory.<ParametricAdjustment>create(ParametricAdjustmentValidator.class);
	}

	@Override
	public Validator<? super ParametricAdjustment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ParametricAdjustment>create(ParametricAdjustmentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ParametricAdjustment> validator() {
		return new ParametricAdjustmentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ParametricAdjustment> typeFormatValidator() {
		return new ParametricAdjustmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ParametricAdjustment, Set<String>> onlyExistsValidator() {
		return new ParametricAdjustmentOnlyExistsValidator();
	}
}
