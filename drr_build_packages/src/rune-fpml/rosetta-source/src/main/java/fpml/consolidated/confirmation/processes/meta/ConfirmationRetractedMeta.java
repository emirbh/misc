package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ConfirmationRetracted;
import fpml.consolidated.confirmation.processes.validation.ConfirmationRetractedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ConfirmationRetractedValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.ConfirmationRetractedChoice;
import fpml.consolidated.confirmation.processes.validation.exists.ConfirmationRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ConfirmationRetracted.class)
public class ConfirmationRetractedMeta implements RosettaMetaData<ConfirmationRetracted> {

	@Override
	public List<Validator<? super ConfirmationRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ConfirmationRetracted>create(ConfirmationRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ConfirmationRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConfirmationRetracted> validator(ValidatorFactory factory) {
		return factory.<ConfirmationRetracted>create(ConfirmationRetractedValidator.class);
	}

	@Override
	public Validator<? super ConfirmationRetracted> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ConfirmationRetracted>create(ConfirmationRetractedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ConfirmationRetracted> validator() {
		return new ConfirmationRetractedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ConfirmationRetracted> typeFormatValidator() {
		return new ConfirmationRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConfirmationRetracted, Set<String>> onlyExistsValidator() {
		return new ConfirmationRetractedOnlyExistsValidator();
	}
}
