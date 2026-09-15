package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.AllocationApproved;
import fpml.consolidated.confirmation.processes.validation.AllocationApprovedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.AllocationApprovedValidator;
import fpml.consolidated.confirmation.processes.validation.exists.AllocationApprovedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AllocationApproved.class)
public class AllocationApprovedMeta implements RosettaMetaData<AllocationApproved> {

	@Override
	public List<Validator<? super AllocationApproved>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AllocationApproved, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AllocationApproved> validator(ValidatorFactory factory) {
		return factory.<AllocationApproved>create(AllocationApprovedValidator.class);
	}

	@Override
	public Validator<? super AllocationApproved> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AllocationApproved>create(AllocationApprovedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AllocationApproved> validator() {
		return new AllocationApprovedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AllocationApproved> typeFormatValidator() {
		return new AllocationApprovedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AllocationApproved, Set<String>> onlyExistsValidator() {
		return new AllocationApprovedOnlyExistsValidator();
	}
}
