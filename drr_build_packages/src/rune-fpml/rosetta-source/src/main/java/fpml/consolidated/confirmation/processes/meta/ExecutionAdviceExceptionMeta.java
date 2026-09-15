package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ExecutionAdviceException;
import fpml.consolidated.confirmation.processes.validation.ExecutionAdviceExceptionTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ExecutionAdviceExceptionValidator;
import fpml.consolidated.confirmation.processes.validation.exists.ExecutionAdviceExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExecutionAdviceException.class)
public class ExecutionAdviceExceptionMeta implements RosettaMetaData<ExecutionAdviceException> {

	@Override
	public List<Validator<? super ExecutionAdviceException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExecutionAdviceException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExecutionAdviceException> validator(ValidatorFactory factory) {
		return factory.<ExecutionAdviceException>create(ExecutionAdviceExceptionValidator.class);
	}

	@Override
	public Validator<? super ExecutionAdviceException> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExecutionAdviceException>create(ExecutionAdviceExceptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionAdviceException> validator() {
		return new ExecutionAdviceExceptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionAdviceException> typeFormatValidator() {
		return new ExecutionAdviceExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionAdviceException, Set<String>> onlyExistsValidator() {
		return new ExecutionAdviceExceptionOnlyExistsValidator();
	}
}
