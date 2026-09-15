package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.RequestConsent;
import fpml.consolidated.confirmation.processes.validation.RequestConsentTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.RequestConsentValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.RequestConsentChoice;
import fpml.consolidated.confirmation.processes.validation.exists.RequestConsentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestConsent.class)
public class RequestConsentMeta implements RosettaMetaData<RequestConsent> {

	@Override
	public List<Validator<? super RequestConsent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RequestConsent>create(RequestConsentChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestConsent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestConsent> validator(ValidatorFactory factory) {
		return factory.<RequestConsent>create(RequestConsentValidator.class);
	}

	@Override
	public Validator<? super RequestConsent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestConsent>create(RequestConsentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestConsent> validator() {
		return new RequestConsentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestConsent> typeFormatValidator() {
		return new RequestConsentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestConsent, Set<String>> onlyExistsValidator() {
		return new RequestConsentOnlyExistsValidator();
	}
}
