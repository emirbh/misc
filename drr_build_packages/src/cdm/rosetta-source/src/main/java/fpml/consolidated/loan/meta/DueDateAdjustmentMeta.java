package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DueDateAdjustment;
import fpml.consolidated.loan.validation.DueDateAdjustmentTypeFormatValidator;
import fpml.consolidated.loan.validation.DueDateAdjustmentValidator;
import fpml.consolidated.loan.validation.exists.DueDateAdjustmentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DueDateAdjustment.class)
public class DueDateAdjustmentMeta implements RosettaMetaData<DueDateAdjustment> {

	@Override
	public List<Validator<? super DueDateAdjustment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DueDateAdjustment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DueDateAdjustment> validator(ValidatorFactory factory) {
		return factory.<DueDateAdjustment>create(DueDateAdjustmentValidator.class);
	}

	@Override
	public Validator<? super DueDateAdjustment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DueDateAdjustment>create(DueDateAdjustmentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DueDateAdjustment> validator() {
		return new DueDateAdjustmentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DueDateAdjustment> typeFormatValidator() {
		return new DueDateAdjustmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DueDateAdjustment, Set<String>> onlyExistsValidator() {
		return new DueDateAdjustmentOnlyExistsValidator();
	}
}
