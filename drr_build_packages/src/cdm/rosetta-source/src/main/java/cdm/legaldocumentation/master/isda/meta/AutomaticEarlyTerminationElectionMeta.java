package cdm.legaldocumentation.master.isda.meta;

import cdm.legaldocumentation.master.isda.AutomaticEarlyTerminationElection;
import cdm.legaldocumentation.master.isda.validation.AutomaticEarlyTerminationElectionTypeFormatValidator;
import cdm.legaldocumentation.master.isda.validation.AutomaticEarlyTerminationElectionValidator;
import cdm.legaldocumentation.master.isda.validation.exists.AutomaticEarlyTerminationElectionOnlyExistsValidator;
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
@RosettaMeta(model=AutomaticEarlyTerminationElection.class)
public class AutomaticEarlyTerminationElectionMeta implements RosettaMetaData<AutomaticEarlyTerminationElection> {

	@Override
	public List<Validator<? super AutomaticEarlyTerminationElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AutomaticEarlyTerminationElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AutomaticEarlyTerminationElection> validator(ValidatorFactory factory) {
		return factory.<AutomaticEarlyTerminationElection>create(AutomaticEarlyTerminationElectionValidator.class);
	}

	@Override
	public Validator<? super AutomaticEarlyTerminationElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AutomaticEarlyTerminationElection>create(AutomaticEarlyTerminationElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AutomaticEarlyTerminationElection> validator() {
		return new AutomaticEarlyTerminationElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AutomaticEarlyTerminationElection> typeFormatValidator() {
		return new AutomaticEarlyTerminationElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AutomaticEarlyTerminationElection, Set<String>> onlyExistsValidator() {
		return new AutomaticEarlyTerminationElectionOnlyExistsValidator();
	}
}
