package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.ServiceStatus;
import fpml.consolidated.msg.validation.ServiceStatusTypeFormatValidator;
import fpml.consolidated.msg.validation.ServiceStatusValidator;
import fpml.consolidated.msg.validation.exists.ServiceStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ServiceStatus.class)
public class ServiceStatusMeta implements RosettaMetaData<ServiceStatus> {

	@Override
	public List<Validator<? super ServiceStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ServiceStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ServiceStatus> validator(ValidatorFactory factory) {
		return factory.<ServiceStatus>create(ServiceStatusValidator.class);
	}

	@Override
	public Validator<? super ServiceStatus> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ServiceStatus>create(ServiceStatusTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ServiceStatus> validator() {
		return new ServiceStatusValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ServiceStatus> typeFormatValidator() {
		return new ServiceStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ServiceStatus, Set<String>> onlyExistsValidator() {
		return new ServiceStatusOnlyExistsValidator();
	}
}
