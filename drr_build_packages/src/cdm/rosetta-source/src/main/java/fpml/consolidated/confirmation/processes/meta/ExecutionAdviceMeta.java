package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ExecutionAdvice;
import fpml.consolidated.confirmation.processes.validation.ExecutionAdviceTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ExecutionAdviceValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.ExecutionAdviceChoice;
import fpml.consolidated.confirmation.processes.validation.exists.ExecutionAdviceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExecutionAdvice.class)
public class ExecutionAdviceMeta implements RosettaMetaData<ExecutionAdvice> {

	@Override
	public List<Validator<? super ExecutionAdvice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ExecutionAdvice>create(ExecutionAdviceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExecutionAdvice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExecutionAdvice> validator(ValidatorFactory factory) {
		return factory.<ExecutionAdvice>create(ExecutionAdviceValidator.class);
	}

	@Override
	public Validator<? super ExecutionAdvice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExecutionAdvice>create(ExecutionAdviceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionAdvice> validator() {
		return new ExecutionAdviceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionAdvice> typeFormatValidator() {
		return new ExecutionAdviceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionAdvice, Set<String>> onlyExistsValidator() {
		return new ExecutionAdviceOnlyExistsValidator();
	}
}
