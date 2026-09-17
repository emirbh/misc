package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.CalculationAgent;
import fpml.consolidated.shared.validation.CalculationAgentTypeFormatValidator;
import fpml.consolidated.shared.validation.CalculationAgentValidator;
import fpml.consolidated.shared.validation.datarule.CalculationAgentChoice;
import fpml.consolidated.shared.validation.exists.CalculationAgentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CalculationAgent.class)
public class CalculationAgentMeta implements RosettaMetaData<CalculationAgent> {

	@Override
	public List<Validator<? super CalculationAgent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CalculationAgent>create(CalculationAgentChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationAgent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationAgent> validator(ValidatorFactory factory) {
		return factory.<CalculationAgent>create(CalculationAgentValidator.class);
	}

	@Override
	public Validator<? super CalculationAgent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationAgent>create(CalculationAgentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationAgent> validator() {
		return new CalculationAgentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationAgent> typeFormatValidator() {
		return new CalculationAgentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationAgent, Set<String>> onlyExistsValidator() {
		return new CalculationAgentOnlyExistsValidator();
	}
}
