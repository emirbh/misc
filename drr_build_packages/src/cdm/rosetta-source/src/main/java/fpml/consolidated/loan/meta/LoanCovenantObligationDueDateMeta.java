package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationDueDate;
import fpml.consolidated.loan.validation.LoanCovenantObligationDueDateTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationDueDateValidator;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationDueDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationDueDate.class)
public class LoanCovenantObligationDueDateMeta implements RosettaMetaData<LoanCovenantObligationDueDate> {

	@Override
	public List<Validator<? super LoanCovenantObligationDueDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationDueDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationDueDate> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationDueDate>create(LoanCovenantObligationDueDateValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationDueDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationDueDate>create(LoanCovenantObligationDueDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationDueDate> validator() {
		return new LoanCovenantObligationDueDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationDueDate> typeFormatValidator() {
		return new LoanCovenantObligationDueDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationDueDate, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationDueDateOnlyExistsValidator();
	}
}
