package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationTask;
import fpml.consolidated.loan.validation.LoanCovenantObligationTaskTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationTaskValidator;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationTaskOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationTask.class)
public class LoanCovenantObligationTaskMeta implements RosettaMetaData<LoanCovenantObligationTask> {

	@Override
	public List<Validator<? super LoanCovenantObligationTask>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationTask, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationTask> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationTask>create(LoanCovenantObligationTaskValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationTask> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationTask>create(LoanCovenantObligationTaskTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationTask> validator() {
		return new LoanCovenantObligationTaskValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationTask> typeFormatValidator() {
		return new LoanCovenantObligationTaskTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationTask, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationTaskOnlyExistsValidator();
	}
}
