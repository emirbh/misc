package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.RequestExecution;
import fpml.consolidated.confirmation.processes.validation.RequestExecutionTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.RequestExecutionValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.RequestExecutionChoice;
import fpml.consolidated.confirmation.processes.validation.exists.RequestExecutionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestExecution.class)
public class RequestExecutionMeta implements RosettaMetaData<RequestExecution> {

	@Override
	public List<Validator<? super RequestExecution>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RequestExecution>create(RequestExecutionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestExecution, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestExecution> validator(ValidatorFactory factory) {
		return factory.<RequestExecution>create(RequestExecutionValidator.class);
	}

	@Override
	public Validator<? super RequestExecution> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestExecution>create(RequestExecutionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestExecution> validator() {
		return new RequestExecutionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestExecution> typeFormatValidator() {
		return new RequestExecutionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestExecution, Set<String>> onlyExistsValidator() {
		return new RequestExecutionOnlyExistsValidator();
	}
}
