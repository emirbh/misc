package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ConfirmationRetracted;
import fpml.consolidated.confirmation.processes.RequestConfirmationRetracted;
import fpml.consolidated.confirmation.processes.validation.RequestConfirmationRetractedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.RequestConfirmationRetractedValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.ConfirmationRetractedChoice;
import fpml.consolidated.confirmation.processes.validation.exists.RequestConfirmationRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestConfirmationRetracted.class)
public class RequestConfirmationRetractedMeta implements RosettaMetaData<RequestConfirmationRetracted> {

	@Override
	public List<Validator<? super RequestConfirmationRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ConfirmationRetracted>create(ConfirmationRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestConfirmationRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestConfirmationRetracted> validator(ValidatorFactory factory) {
		return factory.<RequestConfirmationRetracted>create(RequestConfirmationRetractedValidator.class);
	}

	@Override
	public Validator<? super RequestConfirmationRetracted> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestConfirmationRetracted>create(RequestConfirmationRetractedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestConfirmationRetracted> validator() {
		return new RequestConfirmationRetractedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestConfirmationRetracted> typeFormatValidator() {
		return new RequestConfirmationRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestConfirmationRetracted, Set<String>> onlyExistsValidator() {
		return new RequestConfirmationRetractedOnlyExistsValidator();
	}
}
