package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.RequestExecutionRetracted;
import fpml.consolidated.confirmation.processes.validation.RequestExecutionRetractedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.RequestExecutionRetractedValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.RequestExecutionRetractedChoice;
import fpml.consolidated.confirmation.processes.validation.exists.RequestExecutionRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestExecutionRetracted.class)
public class RequestExecutionRetractedMeta implements RosettaMetaData<RequestExecutionRetracted> {

	@Override
	public List<Validator<? super RequestExecutionRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RequestExecutionRetracted>create(RequestExecutionRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestExecutionRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestExecutionRetracted> validator(ValidatorFactory factory) {
		return factory.<RequestExecutionRetracted>create(RequestExecutionRetractedValidator.class);
	}

	@Override
	public Validator<? super RequestExecutionRetracted> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestExecutionRetracted>create(RequestExecutionRetractedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestExecutionRetracted> validator() {
		return new RequestExecutionRetractedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestExecutionRetracted> typeFormatValidator() {
		return new RequestExecutionRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestExecutionRetracted, Set<String>> onlyExistsValidator() {
		return new RequestExecutionRetractedOnlyExistsValidator();
	}
}
