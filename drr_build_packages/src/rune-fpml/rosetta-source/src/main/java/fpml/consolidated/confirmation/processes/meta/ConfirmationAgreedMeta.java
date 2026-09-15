package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ConfirmationAgreed;
import fpml.consolidated.confirmation.processes.validation.ConfirmationAgreedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ConfirmationAgreedValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.ConfirmationAgreedChoice;
import fpml.consolidated.confirmation.processes.validation.exists.ConfirmationAgreedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ConfirmationAgreed.class)
public class ConfirmationAgreedMeta implements RosettaMetaData<ConfirmationAgreed> {

	@Override
	public List<Validator<? super ConfirmationAgreed>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ConfirmationAgreed>create(ConfirmationAgreedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ConfirmationAgreed, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConfirmationAgreed> validator(ValidatorFactory factory) {
		return factory.<ConfirmationAgreed>create(ConfirmationAgreedValidator.class);
	}

	@Override
	public Validator<? super ConfirmationAgreed> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ConfirmationAgreed>create(ConfirmationAgreedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ConfirmationAgreed> validator() {
		return new ConfirmationAgreedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ConfirmationAgreed> typeFormatValidator() {
		return new ConfirmationAgreedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConfirmationAgreed, Set<String>> onlyExistsValidator() {
		return new ConfirmationAgreedOnlyExistsValidator();
	}
}
