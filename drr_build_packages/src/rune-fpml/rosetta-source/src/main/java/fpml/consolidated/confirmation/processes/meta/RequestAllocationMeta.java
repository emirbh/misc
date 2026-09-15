package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.RequestAllocation;
import fpml.consolidated.confirmation.processes.validation.RequestAllocationTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.RequestAllocationValidator;
import fpml.consolidated.confirmation.processes.validation.exists.RequestAllocationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestAllocation.class)
public class RequestAllocationMeta implements RosettaMetaData<RequestAllocation> {

	@Override
	public List<Validator<? super RequestAllocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestAllocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestAllocation> validator(ValidatorFactory factory) {
		return factory.<RequestAllocation>create(RequestAllocationValidator.class);
	}

	@Override
	public Validator<? super RequestAllocation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestAllocation>create(RequestAllocationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestAllocation> validator() {
		return new RequestAllocationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestAllocation> typeFormatValidator() {
		return new RequestAllocationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestAllocation, Set<String>> onlyExistsValidator() {
		return new RequestAllocationOnlyExistsValidator();
	}
}
