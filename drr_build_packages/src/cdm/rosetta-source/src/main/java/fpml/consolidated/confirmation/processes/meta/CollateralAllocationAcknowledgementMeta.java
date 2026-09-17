package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.CollateralAllocationAcknowledgement;
import fpml.consolidated.confirmation.processes.validation.CollateralAllocationAcknowledgementTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.CollateralAllocationAcknowledgementValidator;
import fpml.consolidated.confirmation.processes.validation.exists.CollateralAllocationAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CollateralAllocationAcknowledgement.class)
public class CollateralAllocationAcknowledgementMeta implements RosettaMetaData<CollateralAllocationAcknowledgement> {

	@Override
	public List<Validator<? super CollateralAllocationAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralAllocationAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralAllocationAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<CollateralAllocationAcknowledgement>create(CollateralAllocationAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super CollateralAllocationAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralAllocationAcknowledgement>create(CollateralAllocationAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralAllocationAcknowledgement> validator() {
		return new CollateralAllocationAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralAllocationAcknowledgement> typeFormatValidator() {
		return new CollateralAllocationAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralAllocationAcknowledgement, Set<String>> onlyExistsValidator() {
		return new CollateralAllocationAcknowledgementOnlyExistsValidator();
	}
}
