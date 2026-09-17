package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.ReplacementValueCalculationAgentDeterminationMethod;
import fpml.consolidated.ird.validation.ReplacementValueCalculationAgentDeterminationMethodTypeFormatValidator;
import fpml.consolidated.ird.validation.ReplacementValueCalculationAgentDeterminationMethodValidator;
import fpml.consolidated.ird.validation.exists.ReplacementValueCalculationAgentDeterminationMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReplacementValueCalculationAgentDeterminationMethod.class)
public class ReplacementValueCalculationAgentDeterminationMethodMeta implements RosettaMetaData<ReplacementValueCalculationAgentDeterminationMethod> {

	@Override
	public List<Validator<? super ReplacementValueCalculationAgentDeterminationMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReplacementValueCalculationAgentDeterminationMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReplacementValueCalculationAgentDeterminationMethod> validator(ValidatorFactory factory) {
		return factory.<ReplacementValueCalculationAgentDeterminationMethod>create(ReplacementValueCalculationAgentDeterminationMethodValidator.class);
	}

	@Override
	public Validator<? super ReplacementValueCalculationAgentDeterminationMethod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReplacementValueCalculationAgentDeterminationMethod>create(ReplacementValueCalculationAgentDeterminationMethodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReplacementValueCalculationAgentDeterminationMethod> validator() {
		return new ReplacementValueCalculationAgentDeterminationMethodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReplacementValueCalculationAgentDeterminationMethod> typeFormatValidator() {
		return new ReplacementValueCalculationAgentDeterminationMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReplacementValueCalculationAgentDeterminationMethod, Set<String>> onlyExistsValidator() {
		return new ReplacementValueCalculationAgentDeterminationMethodOnlyExistsValidator();
	}
}
