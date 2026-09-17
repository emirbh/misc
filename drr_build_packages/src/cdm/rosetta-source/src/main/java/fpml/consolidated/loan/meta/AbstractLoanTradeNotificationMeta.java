package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLoanTradeNotification;
import fpml.consolidated.loan.validation.AbstractLoanTradeNotificationTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractLoanTradeNotificationValidator;
import fpml.consolidated.loan.validation.exists.AbstractLoanTradeNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractLoanTradeNotification.class)
public class AbstractLoanTradeNotificationMeta implements RosettaMetaData<AbstractLoanTradeNotification> {

	@Override
	public List<Validator<? super AbstractLoanTradeNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanTradeNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractLoanTradeNotification> validator(ValidatorFactory factory) {
		return factory.<AbstractLoanTradeNotification>create(AbstractLoanTradeNotificationValidator.class);
	}

	@Override
	public Validator<? super AbstractLoanTradeNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractLoanTradeNotification>create(AbstractLoanTradeNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanTradeNotification> validator() {
		return new AbstractLoanTradeNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanTradeNotification> typeFormatValidator() {
		return new AbstractLoanTradeNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanTradeNotification, Set<String>> onlyExistsValidator() {
		return new AbstractLoanTradeNotificationOnlyExistsValidator();
	}
}
