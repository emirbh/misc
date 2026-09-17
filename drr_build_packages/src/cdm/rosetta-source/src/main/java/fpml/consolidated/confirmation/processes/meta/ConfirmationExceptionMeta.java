package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ConfirmationException;
import fpml.consolidated.confirmation.processes.validation.ConfirmationExceptionTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ConfirmationExceptionValidator;
import fpml.consolidated.confirmation.processes.validation.exists.ConfirmationExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ConfirmationException.class)
public class ConfirmationExceptionMeta implements RosettaMetaData<ConfirmationException> {

	@Override
	public List<Validator<? super ConfirmationException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ConfirmationException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConfirmationException> validator(ValidatorFactory factory) {
		return factory.<ConfirmationException>create(ConfirmationExceptionValidator.class);
	}

	@Override
	public Validator<? super ConfirmationException> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ConfirmationException>create(ConfirmationExceptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ConfirmationException> validator() {
		return new ConfirmationExceptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ConfirmationException> typeFormatValidator() {
		return new ConfirmationExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConfirmationException, Set<String>> onlyExistsValidator() {
		return new ConfirmationExceptionOnlyExistsValidator();
	}
}
