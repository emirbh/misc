package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.RequestAllocationRetracted;
import fpml.consolidated.confirmation.processes.validation.RequestAllocationRetractedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.RequestAllocationRetractedValidator;
import fpml.consolidated.confirmation.processes.validation.exists.RequestAllocationRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestAllocationRetracted.class)
public class RequestAllocationRetractedMeta implements RosettaMetaData<RequestAllocationRetracted> {

	@Override
	public List<Validator<? super RequestAllocationRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestAllocationRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestAllocationRetracted> validator(ValidatorFactory factory) {
		return factory.<RequestAllocationRetracted>create(RequestAllocationRetractedValidator.class);
	}

	@Override
	public Validator<? super RequestAllocationRetracted> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestAllocationRetracted>create(RequestAllocationRetractedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestAllocationRetracted> validator() {
		return new RequestAllocationRetractedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestAllocationRetracted> typeFormatValidator() {
		return new RequestAllocationRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestAllocationRetracted, Set<String>> onlyExistsValidator() {
		return new RequestAllocationRetractedOnlyExistsValidator();
	}
}
