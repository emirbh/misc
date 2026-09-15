package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradeNotification;
import fpml.consolidated.loan.validation.LoanTradeNotificationTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradeNotificationValidator;
import fpml.consolidated.loan.validation.datarule.LoanTradeNotificationChoice0;
import fpml.consolidated.loan.validation.datarule.LoanTradeNotificationChoice1;
import fpml.consolidated.loan.validation.datarule.LoanTradeNotificationChoice2;
import fpml.consolidated.loan.validation.datarule.LoanTradeNotificationChoice3;
import fpml.consolidated.loan.validation.exists.LoanTradeNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradeNotification.class)
public class LoanTradeNotificationMeta implements RosettaMetaData<LoanTradeNotification> {

	@Override
	public List<Validator<? super LoanTradeNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanTradeNotification>create(LoanTradeNotificationChoice0.class),
			factory.<LoanTradeNotification>create(LoanTradeNotificationChoice1.class),
			factory.<LoanTradeNotification>create(LoanTradeNotificationChoice2.class),
			factory.<LoanTradeNotification>create(LoanTradeNotificationChoice3.class)
		);
	}
	
	@Override
	public List<Function<? super LoanTradeNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradeNotification> validator(ValidatorFactory factory) {
		return factory.<LoanTradeNotification>create(LoanTradeNotificationValidator.class);
	}

	@Override
	public Validator<? super LoanTradeNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradeNotification>create(LoanTradeNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeNotification> validator() {
		return new LoanTradeNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeNotification> typeFormatValidator() {
		return new LoanTradeNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeNotification, Set<String>> onlyExistsValidator() {
		return new LoanTradeNotificationOnlyExistsValidator();
	}
}
