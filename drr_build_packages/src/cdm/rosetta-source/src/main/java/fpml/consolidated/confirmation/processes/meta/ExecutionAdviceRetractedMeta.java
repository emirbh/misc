package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ExecutionAdviceRetracted;
import fpml.consolidated.confirmation.processes.validation.ExecutionAdviceRetractedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ExecutionAdviceRetractedValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.ExecutionAdviceRetractedChoice;
import fpml.consolidated.confirmation.processes.validation.exists.ExecutionAdviceRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExecutionAdviceRetracted.class)
public class ExecutionAdviceRetractedMeta implements RosettaMetaData<ExecutionAdviceRetracted> {

	@Override
	public List<Validator<? super ExecutionAdviceRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ExecutionAdviceRetracted>create(ExecutionAdviceRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExecutionAdviceRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExecutionAdviceRetracted> validator(ValidatorFactory factory) {
		return factory.<ExecutionAdviceRetracted>create(ExecutionAdviceRetractedValidator.class);
	}

	@Override
	public Validator<? super ExecutionAdviceRetracted> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExecutionAdviceRetracted>create(ExecutionAdviceRetractedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionAdviceRetracted> validator() {
		return new ExecutionAdviceRetractedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionAdviceRetracted> typeFormatValidator() {
		return new ExecutionAdviceRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionAdviceRetracted, Set<String>> onlyExistsValidator() {
		return new ExecutionAdviceRetractedOnlyExistsValidator();
	}
}
