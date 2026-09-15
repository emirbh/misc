package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ConfirmationAcknowledgement;
import fpml.consolidated.confirmation.processes.validation.ConfirmationAcknowledgementTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ConfirmationAcknowledgementValidator;
import fpml.consolidated.confirmation.processes.validation.exists.ConfirmationAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ConfirmationAcknowledgement.class)
public class ConfirmationAcknowledgementMeta implements RosettaMetaData<ConfirmationAcknowledgement> {

	@Override
	public List<Validator<? super ConfirmationAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ConfirmationAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConfirmationAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<ConfirmationAcknowledgement>create(ConfirmationAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super ConfirmationAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ConfirmationAcknowledgement>create(ConfirmationAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ConfirmationAcknowledgement> validator() {
		return new ConfirmationAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ConfirmationAcknowledgement> typeFormatValidator() {
		return new ConfirmationAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConfirmationAcknowledgement, Set<String>> onlyExistsValidator() {
		return new ConfirmationAcknowledgementOnlyExistsValidator();
	}
}
