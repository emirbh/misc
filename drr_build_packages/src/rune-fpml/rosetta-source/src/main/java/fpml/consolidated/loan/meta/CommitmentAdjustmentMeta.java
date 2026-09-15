package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.CommitmentAdjustment;
import fpml.consolidated.loan.validation.CommitmentAdjustmentTypeFormatValidator;
import fpml.consolidated.loan.validation.CommitmentAdjustmentValidator;
import fpml.consolidated.loan.validation.exists.CommitmentAdjustmentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommitmentAdjustment.class)
public class CommitmentAdjustmentMeta implements RosettaMetaData<CommitmentAdjustment> {

	@Override
	public List<Validator<? super CommitmentAdjustment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommitmentAdjustment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommitmentAdjustment> validator(ValidatorFactory factory) {
		return factory.<CommitmentAdjustment>create(CommitmentAdjustmentValidator.class);
	}

	@Override
	public Validator<? super CommitmentAdjustment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommitmentAdjustment>create(CommitmentAdjustmentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommitmentAdjustment> validator() {
		return new CommitmentAdjustmentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommitmentAdjustment> typeFormatValidator() {
		return new CommitmentAdjustmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommitmentAdjustment, Set<String>> onlyExistsValidator() {
		return new CommitmentAdjustmentOnlyExistsValidator();
	}
}
