package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationTaskType;
import fpml.consolidated.loan.validation.LoanCovenantObligationTaskTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationTaskTypeValidator;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationTaskTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationTaskType.class)
public class LoanCovenantObligationTaskTypeMeta implements RosettaMetaData<LoanCovenantObligationTaskType> {

	@Override
	public List<Validator<? super LoanCovenantObligationTaskType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationTaskType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationTaskType> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationTaskType>create(LoanCovenantObligationTaskTypeValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationTaskType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationTaskType>create(LoanCovenantObligationTaskTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationTaskType> validator() {
		return new LoanCovenantObligationTaskTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationTaskType> typeFormatValidator() {
		return new LoanCovenantObligationTaskTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationTaskType, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationTaskTypeOnlyExistsValidator();
	}
}
