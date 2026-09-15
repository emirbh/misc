package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.AllocationAcknowledgement;
import fpml.consolidated.confirmation.processes.validation.AllocationAcknowledgementTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.AllocationAcknowledgementValidator;
import fpml.consolidated.confirmation.processes.validation.exists.AllocationAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AllocationAcknowledgement.class)
public class AllocationAcknowledgementMeta implements RosettaMetaData<AllocationAcknowledgement> {

	@Override
	public List<Validator<? super AllocationAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AllocationAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AllocationAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<AllocationAcknowledgement>create(AllocationAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super AllocationAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AllocationAcknowledgement>create(AllocationAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AllocationAcknowledgement> validator() {
		return new AllocationAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AllocationAcknowledgement> typeFormatValidator() {
		return new AllocationAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AllocationAcknowledgement, Set<String>> onlyExistsValidator() {
		return new AllocationAcknowledgementOnlyExistsValidator();
	}
}
