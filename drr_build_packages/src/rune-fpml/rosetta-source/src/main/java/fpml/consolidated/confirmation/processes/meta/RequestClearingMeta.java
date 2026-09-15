package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.RequestClearing;
import fpml.consolidated.confirmation.processes.validation.RequestClearingTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.RequestClearingValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.RequestClearingChoice;
import fpml.consolidated.confirmation.processes.validation.exists.RequestClearingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestClearing.class)
public class RequestClearingMeta implements RosettaMetaData<RequestClearing> {

	@Override
	public List<Validator<? super RequestClearing>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RequestClearing>create(RequestClearingChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestClearing, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestClearing> validator(ValidatorFactory factory) {
		return factory.<RequestClearing>create(RequestClearingValidator.class);
	}

	@Override
	public Validator<? super RequestClearing> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestClearing>create(RequestClearingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestClearing> validator() {
		return new RequestClearingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestClearing> typeFormatValidator() {
		return new RequestClearingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestClearing, Set<String>> onlyExistsValidator() {
		return new RequestClearingOnlyExistsValidator();
	}
}
