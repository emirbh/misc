package fpml.consolidated.clearing.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.clearing.processes.ClearingEligibility;
import fpml.consolidated.clearing.processes.validation.ClearingEligibilityTypeFormatValidator;
import fpml.consolidated.clearing.processes.validation.ClearingEligibilityValidator;
import fpml.consolidated.clearing.processes.validation.datarule.ClearingEligibilityChoice;
import fpml.consolidated.clearing.processes.validation.exists.ClearingEligibilityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ClearingEligibility.class)
public class ClearingEligibilityMeta implements RosettaMetaData<ClearingEligibility> {

	@Override
	public List<Validator<? super ClearingEligibility>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ClearingEligibility>create(ClearingEligibilityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ClearingEligibility, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingEligibility> validator(ValidatorFactory factory) {
		return factory.<ClearingEligibility>create(ClearingEligibilityValidator.class);
	}

	@Override
	public Validator<? super ClearingEligibility> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingEligibility>create(ClearingEligibilityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingEligibility> validator() {
		return new ClearingEligibilityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingEligibility> typeFormatValidator() {
		return new ClearingEligibilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingEligibility, Set<String>> onlyExistsValidator() {
		return new ClearingEligibilityOnlyExistsValidator();
	}
}
