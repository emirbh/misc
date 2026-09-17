package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.ServiceNotificationException;
import fpml.consolidated.msg.validation.ServiceNotificationExceptionTypeFormatValidator;
import fpml.consolidated.msg.validation.ServiceNotificationExceptionValidator;
import fpml.consolidated.msg.validation.exists.ServiceNotificationExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ServiceNotificationException.class)
public class ServiceNotificationExceptionMeta implements RosettaMetaData<ServiceNotificationException> {

	@Override
	public List<Validator<? super ServiceNotificationException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ServiceNotificationException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ServiceNotificationException> validator(ValidatorFactory factory) {
		return factory.<ServiceNotificationException>create(ServiceNotificationExceptionValidator.class);
	}

	@Override
	public Validator<? super ServiceNotificationException> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ServiceNotificationException>create(ServiceNotificationExceptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ServiceNotificationException> validator() {
		return new ServiceNotificationExceptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ServiceNotificationException> typeFormatValidator() {
		return new ServiceNotificationExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ServiceNotificationException, Set<String>> onlyExistsValidator() {
		return new ServiceNotificationExceptionOnlyExistsValidator();
	}
}
