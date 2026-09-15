package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanNotificationException;
import fpml.consolidated.loan.validation.LoanNotificationExceptionTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanNotificationExceptionValidator;
import fpml.consolidated.loan.validation.datarule.LoanNotificationExceptionChoice;
import fpml.consolidated.loan.validation.exists.LoanNotificationExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanNotificationException.class)
public class LoanNotificationExceptionMeta implements RosettaMetaData<LoanNotificationException> {

	@Override
	public List<Validator<? super LoanNotificationException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanNotificationException>create(LoanNotificationExceptionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanNotificationException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanNotificationException> validator(ValidatorFactory factory) {
		return factory.<LoanNotificationException>create(LoanNotificationExceptionValidator.class);
	}

	@Override
	public Validator<? super LoanNotificationException> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanNotificationException>create(LoanNotificationExceptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanNotificationException> validator() {
		return new LoanNotificationExceptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanNotificationException> typeFormatValidator() {
		return new LoanNotificationExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanNotificationException, Set<String>> onlyExistsValidator() {
		return new LoanNotificationExceptionOnlyExistsValidator();
	}
}
