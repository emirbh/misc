package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationNotificationChoice0;
import fpml.consolidated.loan.validation.LoanCovenantObligationNotificationChoice0TypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationNotificationChoice0Validator;
import fpml.consolidated.loan.validation.datarule.LoanCovenantObligationNotificationChoice0Choice;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationNotificationChoice0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationNotificationChoice0.class)
public class LoanCovenantObligationNotificationChoice0Meta implements RosettaMetaData<LoanCovenantObligationNotificationChoice0> {

	@Override
	public List<Validator<? super LoanCovenantObligationNotificationChoice0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanCovenantObligationNotificationChoice0>create(LoanCovenantObligationNotificationChoice0Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationNotificationChoice0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationNotificationChoice0> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationNotificationChoice0>create(LoanCovenantObligationNotificationChoice0Validator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationNotificationChoice0> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationNotificationChoice0>create(LoanCovenantObligationNotificationChoice0TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationNotificationChoice0> validator() {
		return new LoanCovenantObligationNotificationChoice0Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationNotificationChoice0> typeFormatValidator() {
		return new LoanCovenantObligationNotificationChoice0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationNotificationChoice0, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationNotificationChoice0OnlyExistsValidator();
	}
}
