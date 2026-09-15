package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.RequestConfirmation;
import fpml.consolidated.confirmation.processes.validation.RequestConfirmationTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.RequestConfirmationValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.RequestConfirmationChoice;
import fpml.consolidated.confirmation.processes.validation.exists.RequestConfirmationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestConfirmation.class)
public class RequestConfirmationMeta implements RosettaMetaData<RequestConfirmation> {

	@Override
	public List<Validator<? super RequestConfirmation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RequestConfirmation>create(RequestConfirmationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestConfirmation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestConfirmation> validator(ValidatorFactory factory) {
		return factory.<RequestConfirmation>create(RequestConfirmationValidator.class);
	}

	@Override
	public Validator<? super RequestConfirmation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestConfirmation>create(RequestConfirmationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestConfirmation> validator() {
		return new RequestConfirmationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestConfirmation> typeFormatValidator() {
		return new RequestConfirmationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestConfirmation, Set<String>> onlyExistsValidator() {
		return new RequestConfirmationOnlyExistsValidator();
	}
}
