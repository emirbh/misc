package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanNotificationAcknowledgement;
import fpml.consolidated.loan.validation.LoanNotificationAcknowledgementTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanNotificationAcknowledgementValidator;
import fpml.consolidated.loan.validation.datarule.LoanNotificationAcknowledgementChoice;
import fpml.consolidated.loan.validation.exists.LoanNotificationAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanNotificationAcknowledgement.class)
public class LoanNotificationAcknowledgementMeta implements RosettaMetaData<LoanNotificationAcknowledgement> {

	@Override
	public List<Validator<? super LoanNotificationAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanNotificationAcknowledgement>create(LoanNotificationAcknowledgementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanNotificationAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanNotificationAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<LoanNotificationAcknowledgement>create(LoanNotificationAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super LoanNotificationAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanNotificationAcknowledgement>create(LoanNotificationAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanNotificationAcknowledgement> validator() {
		return new LoanNotificationAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanNotificationAcknowledgement> typeFormatValidator() {
		return new LoanNotificationAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanNotificationAcknowledgement, Set<String>> onlyExistsValidator() {
		return new LoanNotificationAcknowledgementOnlyExistsValidator();
	}
}
