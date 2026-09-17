package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LcAdjustment;
import fpml.consolidated.loan.validation.LcAdjustmentTypeFormatValidator;
import fpml.consolidated.loan.validation.LcAdjustmentValidator;
import fpml.consolidated.loan.validation.exists.LcAdjustmentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LcAdjustment.class)
public class LcAdjustmentMeta implements RosettaMetaData<LcAdjustment> {

	@Override
	public List<Validator<? super LcAdjustment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcAdjustment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LcAdjustment> validator(ValidatorFactory factory) {
		return factory.<LcAdjustment>create(LcAdjustmentValidator.class);
	}

	@Override
	public Validator<? super LcAdjustment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LcAdjustment>create(LcAdjustmentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LcAdjustment> validator() {
		return new LcAdjustmentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LcAdjustment> typeFormatValidator() {
		return new LcAdjustmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcAdjustment, Set<String>> onlyExistsValidator() {
		return new LcAdjustmentOnlyExistsValidator();
	}
}
