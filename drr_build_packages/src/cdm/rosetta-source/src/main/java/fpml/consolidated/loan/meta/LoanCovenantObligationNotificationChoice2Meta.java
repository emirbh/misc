package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationNotificationChoice2;
import fpml.consolidated.loan.validation.LoanCovenantObligationNotificationChoice2TypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationNotificationChoice2Validator;
import fpml.consolidated.loan.validation.datarule.LoanCovenantObligationNotificationChoice2Choice;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationNotificationChoice2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationNotificationChoice2.class)
public class LoanCovenantObligationNotificationChoice2Meta implements RosettaMetaData<LoanCovenantObligationNotificationChoice2> {

	@Override
	public List<Validator<? super LoanCovenantObligationNotificationChoice2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanCovenantObligationNotificationChoice2>create(LoanCovenantObligationNotificationChoice2Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationNotificationChoice2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationNotificationChoice2> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationNotificationChoice2>create(LoanCovenantObligationNotificationChoice2Validator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationNotificationChoice2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationNotificationChoice2>create(LoanCovenantObligationNotificationChoice2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationNotificationChoice2> validator() {
		return new LoanCovenantObligationNotificationChoice2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationNotificationChoice2> typeFormatValidator() {
		return new LoanCovenantObligationNotificationChoice2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationNotificationChoice2, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationNotificationChoice2OnlyExistsValidator();
	}
}
