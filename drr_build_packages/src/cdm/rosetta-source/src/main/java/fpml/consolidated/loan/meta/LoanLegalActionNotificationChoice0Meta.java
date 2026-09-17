package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionNotificationChoice0;
import fpml.consolidated.loan.validation.LoanLegalActionNotificationChoice0TypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionNotificationChoice0Validator;
import fpml.consolidated.loan.validation.datarule.LoanLegalActionNotificationChoice0Choice;
import fpml.consolidated.loan.validation.exists.LoanLegalActionNotificationChoice0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionNotificationChoice0.class)
public class LoanLegalActionNotificationChoice0Meta implements RosettaMetaData<LoanLegalActionNotificationChoice0> {

	@Override
	public List<Validator<? super LoanLegalActionNotificationChoice0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanLegalActionNotificationChoice0>create(LoanLegalActionNotificationChoice0Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionNotificationChoice0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionNotificationChoice0> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionNotificationChoice0>create(LoanLegalActionNotificationChoice0Validator.class);
	}

	@Override
	public Validator<? super LoanLegalActionNotificationChoice0> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionNotificationChoice0>create(LoanLegalActionNotificationChoice0TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionNotificationChoice0> validator() {
		return new LoanLegalActionNotificationChoice0Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionNotificationChoice0> typeFormatValidator() {
		return new LoanLegalActionNotificationChoice0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionNotificationChoice0, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionNotificationChoice0OnlyExistsValidator();
	}
}
