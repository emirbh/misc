package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.CalculationAgentDetermination;
import fpml.consolidated.fx.validation.CalculationAgentDeterminationTypeFormatValidator;
import fpml.consolidated.fx.validation.CalculationAgentDeterminationValidator;
import fpml.consolidated.fx.validation.exists.CalculationAgentDeterminationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CalculationAgentDetermination.class)
public class CalculationAgentDeterminationMeta implements RosettaMetaData<CalculationAgentDetermination> {

	@Override
	public List<Validator<? super CalculationAgentDetermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationAgentDetermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationAgentDetermination> validator(ValidatorFactory factory) {
		return factory.<CalculationAgentDetermination>create(CalculationAgentDeterminationValidator.class);
	}

	@Override
	public Validator<? super CalculationAgentDetermination> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationAgentDetermination>create(CalculationAgentDeterminationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationAgentDetermination> validator() {
		return new CalculationAgentDeterminationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationAgentDetermination> typeFormatValidator() {
		return new CalculationAgentDeterminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationAgentDetermination, Set<String>> onlyExistsValidator() {
		return new CalculationAgentDeterminationOnlyExistsValidator();
	}
}
