package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ConfirmationStatus;
import fpml.consolidated.confirmation.processes.validation.ConfirmationStatusTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ConfirmationStatusValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.ConfirmationStatusChoice;
import fpml.consolidated.confirmation.processes.validation.exists.ConfirmationStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ConfirmationStatus.class)
public class ConfirmationStatusMeta implements RosettaMetaData<ConfirmationStatus> {

	@Override
	public List<Validator<? super ConfirmationStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ConfirmationStatus>create(ConfirmationStatusChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ConfirmationStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConfirmationStatus> validator(ValidatorFactory factory) {
		return factory.<ConfirmationStatus>create(ConfirmationStatusValidator.class);
	}

	@Override
	public Validator<? super ConfirmationStatus> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ConfirmationStatus>create(ConfirmationStatusTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ConfirmationStatus> validator() {
		return new ConfirmationStatusValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ConfirmationStatus> typeFormatValidator() {
		return new ConfirmationStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConfirmationStatus, Set<String>> onlyExistsValidator() {
		return new ConfirmationStatusOnlyExistsValidator();
	}
}
