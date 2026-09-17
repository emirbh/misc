package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ConfirmationDisputed;
import fpml.consolidated.confirmation.processes.validation.ConfirmationDisputedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ConfirmationDisputedValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.ConfirmationDisputedChoice;
import fpml.consolidated.confirmation.processes.validation.exists.ConfirmationDisputedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ConfirmationDisputed.class)
public class ConfirmationDisputedMeta implements RosettaMetaData<ConfirmationDisputed> {

	@Override
	public List<Validator<? super ConfirmationDisputed>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ConfirmationDisputed>create(ConfirmationDisputedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ConfirmationDisputed, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConfirmationDisputed> validator(ValidatorFactory factory) {
		return factory.<ConfirmationDisputed>create(ConfirmationDisputedValidator.class);
	}

	@Override
	public Validator<? super ConfirmationDisputed> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ConfirmationDisputed>create(ConfirmationDisputedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ConfirmationDisputed> validator() {
		return new ConfirmationDisputedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ConfirmationDisputed> typeFormatValidator() {
		return new ConfirmationDisputedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConfirmationDisputed, Set<String>> onlyExistsValidator() {
		return new ConfirmationDisputedOnlyExistsValidator();
	}
}
