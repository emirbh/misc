package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ProcessAgent;
import cdm.legaldocumentation.csa.validation.ProcessAgentTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ProcessAgentValidator;
import cdm.legaldocumentation.csa.validation.exists.ProcessAgentOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=ProcessAgent.class)
public class ProcessAgentMeta implements RosettaMetaData<ProcessAgent> {

	@Override
	public List<Validator<? super ProcessAgent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProcessAgent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ProcessAgent> validator(ValidatorFactory factory) {
		return factory.<ProcessAgent>create(ProcessAgentValidator.class);
	}

	@Override
	public Validator<? super ProcessAgent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ProcessAgent>create(ProcessAgentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ProcessAgent> validator() {
		return new ProcessAgentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ProcessAgent> typeFormatValidator() {
		return new ProcessAgentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProcessAgent, Set<String>> onlyExistsValidator() {
		return new ProcessAgentOnlyExistsValidator();
	}
}
