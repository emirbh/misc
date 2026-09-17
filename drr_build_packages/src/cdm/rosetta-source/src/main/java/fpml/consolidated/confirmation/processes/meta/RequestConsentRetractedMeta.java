package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.RequestConsentRetracted;
import fpml.consolidated.confirmation.processes.validation.RequestConsentRetractedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.RequestConsentRetractedValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.RequestConsentRetractedChoice;
import fpml.consolidated.confirmation.processes.validation.exists.RequestConsentRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestConsentRetracted.class)
public class RequestConsentRetractedMeta implements RosettaMetaData<RequestConsentRetracted> {

	@Override
	public List<Validator<? super RequestConsentRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RequestConsentRetracted>create(RequestConsentRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestConsentRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestConsentRetracted> validator(ValidatorFactory factory) {
		return factory.<RequestConsentRetracted>create(RequestConsentRetractedValidator.class);
	}

	@Override
	public Validator<? super RequestConsentRetracted> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestConsentRetracted>create(RequestConsentRetractedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestConsentRetracted> validator() {
		return new RequestConsentRetractedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestConsentRetracted> typeFormatValidator() {
		return new RequestConsentRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestConsentRetracted, Set<String>> onlyExistsValidator() {
		return new RequestConsentRetractedOnlyExistsValidator();
	}
}
