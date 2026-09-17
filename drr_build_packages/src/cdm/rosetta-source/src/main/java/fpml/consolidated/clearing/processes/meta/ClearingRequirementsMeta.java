package fpml.consolidated.clearing.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.clearing.processes.ClearingRequirements;
import fpml.consolidated.clearing.processes.validation.ClearingRequirementsTypeFormatValidator;
import fpml.consolidated.clearing.processes.validation.ClearingRequirementsValidator;
import fpml.consolidated.clearing.processes.validation.exists.ClearingRequirementsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ClearingRequirements.class)
public class ClearingRequirementsMeta implements RosettaMetaData<ClearingRequirements> {

	@Override
	public List<Validator<? super ClearingRequirements>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingRequirements, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingRequirements> validator(ValidatorFactory factory) {
		return factory.<ClearingRequirements>create(ClearingRequirementsValidator.class);
	}

	@Override
	public Validator<? super ClearingRequirements> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingRequirements>create(ClearingRequirementsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingRequirements> validator() {
		return new ClearingRequirementsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingRequirements> typeFormatValidator() {
		return new ClearingRequirementsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingRequirements, Set<String>> onlyExistsValidator() {
		return new ClearingRequirementsOnlyExistsValidator();
	}
}
