package fpml.consolidated.clearing.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.clearing.processes.RequestClearingEligibility;
import fpml.consolidated.clearing.processes.validation.RequestClearingEligibilityTypeFormatValidator;
import fpml.consolidated.clearing.processes.validation.RequestClearingEligibilityValidator;
import fpml.consolidated.clearing.processes.validation.datarule.RequestClearingEligibilityChoice;
import fpml.consolidated.clearing.processes.validation.exists.RequestClearingEligibilityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestClearingEligibility.class)
public class RequestClearingEligibilityMeta implements RosettaMetaData<RequestClearingEligibility> {

	@Override
	public List<Validator<? super RequestClearingEligibility>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RequestClearingEligibility>create(RequestClearingEligibilityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestClearingEligibility, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestClearingEligibility> validator(ValidatorFactory factory) {
		return factory.<RequestClearingEligibility>create(RequestClearingEligibilityValidator.class);
	}

	@Override
	public Validator<? super RequestClearingEligibility> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestClearingEligibility>create(RequestClearingEligibilityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestClearingEligibility> validator() {
		return new RequestClearingEligibilityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestClearingEligibility> typeFormatValidator() {
		return new RequestClearingEligibilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestClearingEligibility, Set<String>> onlyExistsValidator() {
		return new RequestClearingEligibilityOnlyExistsValidator();
	}
}
