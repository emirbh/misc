package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionNotificationChoiceChoice2;
import fpml.consolidated.loan.validation.LoanLegalActionNotificationChoiceChoice2TypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionNotificationChoiceChoice2Validator;
import fpml.consolidated.loan.validation.datarule.LoanLegalActionNotificationChoiceChoice2Choice;
import fpml.consolidated.loan.validation.exists.LoanLegalActionNotificationChoiceChoice2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionNotificationChoiceChoice2.class)
public class LoanLegalActionNotificationChoiceChoice2Meta implements RosettaMetaData<LoanLegalActionNotificationChoiceChoice2> {

	@Override
	public List<Validator<? super LoanLegalActionNotificationChoiceChoice2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanLegalActionNotificationChoiceChoice2>create(LoanLegalActionNotificationChoiceChoice2Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionNotificationChoiceChoice2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionNotificationChoiceChoice2> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionNotificationChoiceChoice2>create(LoanLegalActionNotificationChoiceChoice2Validator.class);
	}

	@Override
	public Validator<? super LoanLegalActionNotificationChoiceChoice2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionNotificationChoiceChoice2>create(LoanLegalActionNotificationChoiceChoice2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionNotificationChoiceChoice2> validator() {
		return new LoanLegalActionNotificationChoiceChoice2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionNotificationChoiceChoice2> typeFormatValidator() {
		return new LoanLegalActionNotificationChoiceChoice2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionNotificationChoiceChoice2, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionNotificationChoiceChoice2OnlyExistsValidator();
	}
}
