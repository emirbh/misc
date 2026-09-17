package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.RateAdjustment;
import fpml.consolidated.loan.validation.RateAdjustmentTypeFormatValidator;
import fpml.consolidated.loan.validation.RateAdjustmentValidator;
import fpml.consolidated.loan.validation.exists.RateAdjustmentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RateAdjustment.class)
public class RateAdjustmentMeta implements RosettaMetaData<RateAdjustment> {

	@Override
	public List<Validator<? super RateAdjustment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RateAdjustment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RateAdjustment> validator(ValidatorFactory factory) {
		return factory.<RateAdjustment>create(RateAdjustmentValidator.class);
	}

	@Override
	public Validator<? super RateAdjustment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RateAdjustment>create(RateAdjustmentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RateAdjustment> validator() {
		return new RateAdjustmentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RateAdjustment> typeFormatValidator() {
		return new RateAdjustmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RateAdjustment, Set<String>> onlyExistsValidator() {
		return new RateAdjustmentOnlyExistsValidator();
	}
}
