package fpml.consolidated.credit.event.notification.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.credit.event.notification.CreditEventNotification;
import fpml.consolidated.credit.event.notification.validation.CreditEventNotificationTypeFormatValidator;
import fpml.consolidated.credit.event.notification.validation.CreditEventNotificationValidator;
import fpml.consolidated.credit.event.notification.validation.exists.CreditEventNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditEventNotification.class)
public class CreditEventNotificationMeta implements RosettaMetaData<CreditEventNotification> {

	@Override
	public List<Validator<? super CreditEventNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditEventNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditEventNotification> validator(ValidatorFactory factory) {
		return factory.<CreditEventNotification>create(CreditEventNotificationValidator.class);
	}

	@Override
	public Validator<? super CreditEventNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditEventNotification>create(CreditEventNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditEventNotification> validator() {
		return new CreditEventNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditEventNotification> typeFormatValidator() {
		return new CreditEventNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditEventNotification, Set<String>> onlyExistsValidator() {
		return new CreditEventNotificationOnlyExistsValidator();
	}
}
