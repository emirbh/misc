package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionNotificationChoiceChoice0;
import fpml.consolidated.loan.validation.LoanLegalActionNotificationChoiceChoice0TypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionNotificationChoiceChoice0Validator;
import fpml.consolidated.loan.validation.datarule.LoanLegalActionNotificationChoiceChoice0Choice;
import fpml.consolidated.loan.validation.exists.LoanLegalActionNotificationChoiceChoice0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionNotificationChoiceChoice0.class)
public class LoanLegalActionNotificationChoiceChoice0Meta implements RosettaMetaData<LoanLegalActionNotificationChoiceChoice0> {

	@Override
	public List<Validator<? super LoanLegalActionNotificationChoiceChoice0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanLegalActionNotificationChoiceChoice0>create(LoanLegalActionNotificationChoiceChoice0Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionNotificationChoiceChoice0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionNotificationChoiceChoice0> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionNotificationChoiceChoice0>create(LoanLegalActionNotificationChoiceChoice0Validator.class);
	}

	@Override
	public Validator<? super LoanLegalActionNotificationChoiceChoice0> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionNotificationChoiceChoice0>create(LoanLegalActionNotificationChoiceChoice0TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionNotificationChoiceChoice0> validator() {
		return new LoanLegalActionNotificationChoiceChoice0Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionNotificationChoiceChoice0> typeFormatValidator() {
		return new LoanLegalActionNotificationChoiceChoice0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionNotificationChoiceChoice0, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionNotificationChoiceChoice0OnlyExistsValidator();
	}
}
