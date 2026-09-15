package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.AllocationRefused;
import fpml.consolidated.confirmation.processes.validation.AllocationRefusedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.AllocationRefusedValidator;
import fpml.consolidated.confirmation.processes.validation.exists.AllocationRefusedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AllocationRefused.class)
public class AllocationRefusedMeta implements RosettaMetaData<AllocationRefused> {

	@Override
	public List<Validator<? super AllocationRefused>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AllocationRefused, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AllocationRefused> validator(ValidatorFactory factory) {
		return factory.<AllocationRefused>create(AllocationRefusedValidator.class);
	}

	@Override
	public Validator<? super AllocationRefused> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AllocationRefused>create(AllocationRefusedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AllocationRefused> validator() {
		return new AllocationRefusedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AllocationRefused> typeFormatValidator() {
		return new AllocationRefusedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AllocationRefused, Set<String>> onlyExistsValidator() {
		return new AllocationRefusedOnlyExistsValidator();
	}
}
