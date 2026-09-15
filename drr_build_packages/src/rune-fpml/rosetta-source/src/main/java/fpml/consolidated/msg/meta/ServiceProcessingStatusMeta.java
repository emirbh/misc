package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.ServiceProcessingStatus;
import fpml.consolidated.msg.validation.ServiceProcessingStatusTypeFormatValidator;
import fpml.consolidated.msg.validation.ServiceProcessingStatusValidator;
import fpml.consolidated.msg.validation.exists.ServiceProcessingStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ServiceProcessingStatus.class)
public class ServiceProcessingStatusMeta implements RosettaMetaData<ServiceProcessingStatus> {

	@Override
	public List<Validator<? super ServiceProcessingStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ServiceProcessingStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ServiceProcessingStatus> validator(ValidatorFactory factory) {
		return factory.<ServiceProcessingStatus>create(ServiceProcessingStatusValidator.class);
	}

	@Override
	public Validator<? super ServiceProcessingStatus> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ServiceProcessingStatus>create(ServiceProcessingStatusTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ServiceProcessingStatus> validator() {
		return new ServiceProcessingStatusValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ServiceProcessingStatus> typeFormatValidator() {
		return new ServiceProcessingStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ServiceProcessingStatus, Set<String>> onlyExistsValidator() {
		return new ServiceProcessingStatusOnlyExistsValidator();
	}
}
