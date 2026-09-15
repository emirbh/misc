package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ExecutionAcknowledgement;
import fpml.consolidated.confirmation.processes.validation.ExecutionAcknowledgementTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ExecutionAcknowledgementValidator;
import fpml.consolidated.confirmation.processes.validation.exists.ExecutionAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExecutionAcknowledgement.class)
public class ExecutionAcknowledgementMeta implements RosettaMetaData<ExecutionAcknowledgement> {

	@Override
	public List<Validator<? super ExecutionAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExecutionAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExecutionAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<ExecutionAcknowledgement>create(ExecutionAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super ExecutionAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExecutionAcknowledgement>create(ExecutionAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionAcknowledgement> validator() {
		return new ExecutionAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionAcknowledgement> typeFormatValidator() {
		return new ExecutionAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionAcknowledgement, Set<String>> onlyExistsValidator() {
		return new ExecutionAcknowledgementOnlyExistsValidator();
	}
}
