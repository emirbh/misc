package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ExecutionRetracted;
import fpml.consolidated.confirmation.processes.validation.ExecutionRetractedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ExecutionRetractedValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.ExecutionRetractedChoice;
import fpml.consolidated.confirmation.processes.validation.exists.ExecutionRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExecutionRetracted.class)
public class ExecutionRetractedMeta implements RosettaMetaData<ExecutionRetracted> {

	@Override
	public List<Validator<? super ExecutionRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ExecutionRetracted>create(ExecutionRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExecutionRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExecutionRetracted> validator(ValidatorFactory factory) {
		return factory.<ExecutionRetracted>create(ExecutionRetractedValidator.class);
	}

	@Override
	public Validator<? super ExecutionRetracted> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExecutionRetracted>create(ExecutionRetractedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionRetracted> validator() {
		return new ExecutionRetractedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionRetracted> typeFormatValidator() {
		return new ExecutionRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionRetracted, Set<String>> onlyExistsValidator() {
		return new ExecutionRetractedOnlyExistsValidator();
	}
}
