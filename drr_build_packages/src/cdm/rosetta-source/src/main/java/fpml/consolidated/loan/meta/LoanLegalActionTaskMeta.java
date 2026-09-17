package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionTask;
import fpml.consolidated.loan.validation.LoanLegalActionTaskTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionTaskValidator;
import fpml.consolidated.loan.validation.exists.LoanLegalActionTaskOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionTask.class)
public class LoanLegalActionTaskMeta implements RosettaMetaData<LoanLegalActionTask> {

	@Override
	public List<Validator<? super LoanLegalActionTask>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionTask, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionTask> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionTask>create(LoanLegalActionTaskValidator.class);
	}

	@Override
	public Validator<? super LoanLegalActionTask> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionTask>create(LoanLegalActionTaskTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionTask> validator() {
		return new LoanLegalActionTaskValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionTask> typeFormatValidator() {
		return new LoanLegalActionTaskTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionTask, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionTaskOnlyExistsValidator();
	}
}
