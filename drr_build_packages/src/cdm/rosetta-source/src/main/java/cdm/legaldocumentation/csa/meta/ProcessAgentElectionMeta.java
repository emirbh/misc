package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ProcessAgentElection;
import cdm.legaldocumentation.csa.validation.ProcessAgentElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ProcessAgentElectionValidator;
import cdm.legaldocumentation.csa.validation.datarule.ProcessAgentElectionApplicable;
import cdm.legaldocumentation.csa.validation.datarule.ProcessAgentElectionNotApplicable;
import cdm.legaldocumentation.csa.validation.exists.ProcessAgentElectionOnlyExistsValidator;
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
@RosettaMeta(model=ProcessAgentElection.class)
public class ProcessAgentElectionMeta implements RosettaMetaData<ProcessAgentElection> {

	@Override
	public List<Validator<? super ProcessAgentElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ProcessAgentElection>create(ProcessAgentElectionApplicable.class),
			factory.<ProcessAgentElection>create(ProcessAgentElectionNotApplicable.class)
		);
	}
	
	@Override
	public List<Function<? super ProcessAgentElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ProcessAgentElection> validator(ValidatorFactory factory) {
		return factory.<ProcessAgentElection>create(ProcessAgentElectionValidator.class);
	}

	@Override
	public Validator<? super ProcessAgentElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ProcessAgentElection>create(ProcessAgentElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ProcessAgentElection> validator() {
		return new ProcessAgentElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ProcessAgentElection> typeFormatValidator() {
		return new ProcessAgentElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProcessAgentElection, Set<String>> onlyExistsValidator() {
		return new ProcessAgentElectionOnlyExistsValidator();
	}
}
