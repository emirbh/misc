package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.RequestClearingRetracted;
import fpml.consolidated.confirmation.processes.validation.RequestClearingRetractedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.RequestClearingRetractedValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.RequestClearingRetractedChoice;
import fpml.consolidated.confirmation.processes.validation.exists.RequestClearingRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestClearingRetracted.class)
public class RequestClearingRetractedMeta implements RosettaMetaData<RequestClearingRetracted> {

	@Override
	public List<Validator<? super RequestClearingRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RequestClearingRetracted>create(RequestClearingRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestClearingRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestClearingRetracted> validator(ValidatorFactory factory) {
		return factory.<RequestClearingRetracted>create(RequestClearingRetractedValidator.class);
	}

	@Override
	public Validator<? super RequestClearingRetracted> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestClearingRetracted>create(RequestClearingRetractedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestClearingRetracted> validator() {
		return new RequestClearingRetractedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestClearingRetracted> typeFormatValidator() {
		return new RequestClearingRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestClearingRetracted, Set<String>> onlyExistsValidator() {
		return new RequestClearingRetractedOnlyExistsValidator();
	}
}
