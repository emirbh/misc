package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractServicingNotification;
import fpml.consolidated.loan.validation.AbstractServicingNotificationTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractServicingNotificationValidator;
import fpml.consolidated.loan.validation.exists.AbstractServicingNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractServicingNotification.class)
public class AbstractServicingNotificationMeta implements RosettaMetaData<AbstractServicingNotification> {

	@Override
	public List<Validator<? super AbstractServicingNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractServicingNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractServicingNotification> validator(ValidatorFactory factory) {
		return factory.<AbstractServicingNotification>create(AbstractServicingNotificationValidator.class);
	}

	@Override
	public Validator<? super AbstractServicingNotification> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractServicingNotification>create(AbstractServicingNotificationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractServicingNotification> validator() {
		return new AbstractServicingNotificationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractServicingNotification> typeFormatValidator() {
		return new AbstractServicingNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractServicingNotification, Set<String>> onlyExistsValidator() {
		return new AbstractServicingNotificationOnlyExistsValidator();
	}
}
