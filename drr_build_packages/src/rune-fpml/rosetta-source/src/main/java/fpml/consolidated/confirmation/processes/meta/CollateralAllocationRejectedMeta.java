package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.CollateralAllocationRejected;
import fpml.consolidated.confirmation.processes.validation.CollateralAllocationRejectedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.CollateralAllocationRejectedValidator;
import fpml.consolidated.confirmation.processes.validation.exists.CollateralAllocationRejectedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CollateralAllocationRejected.class)
public class CollateralAllocationRejectedMeta implements RosettaMetaData<CollateralAllocationRejected> {

	@Override
	public List<Validator<? super CollateralAllocationRejected>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralAllocationRejected, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralAllocationRejected> validator(ValidatorFactory factory) {
		return factory.<CollateralAllocationRejected>create(CollateralAllocationRejectedValidator.class);
	}

	@Override
	public Validator<? super CollateralAllocationRejected> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralAllocationRejected>create(CollateralAllocationRejectedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralAllocationRejected> validator() {
		return new CollateralAllocationRejectedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralAllocationRejected> typeFormatValidator() {
		return new CollateralAllocationRejectedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralAllocationRejected, Set<String>> onlyExistsValidator() {
		return new CollateralAllocationRejectedOnlyExistsValidator();
	}
}
