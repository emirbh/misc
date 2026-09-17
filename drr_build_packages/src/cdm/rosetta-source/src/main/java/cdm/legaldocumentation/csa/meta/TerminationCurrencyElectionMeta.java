package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.TerminationCurrencyElection;
import cdm.legaldocumentation.csa.validation.TerminationCurrencyElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.TerminationCurrencyElectionValidator;
import cdm.legaldocumentation.csa.validation.datarule.TerminationCurrencyElectionCurrencyElection;
import cdm.legaldocumentation.csa.validation.exists.TerminationCurrencyElectionOnlyExistsValidator;
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
@RosettaMeta(model=TerminationCurrencyElection.class)
public class TerminationCurrencyElectionMeta implements RosettaMetaData<TerminationCurrencyElection> {

	@Override
	public List<Validator<? super TerminationCurrencyElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TerminationCurrencyElection>create(TerminationCurrencyElectionCurrencyElection.class)
		);
	}
	
	@Override
	public List<Function<? super TerminationCurrencyElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TerminationCurrencyElection> validator(ValidatorFactory factory) {
		return factory.<TerminationCurrencyElection>create(TerminationCurrencyElectionValidator.class);
	}

	@Override
	public Validator<? super TerminationCurrencyElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TerminationCurrencyElection>create(TerminationCurrencyElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TerminationCurrencyElection> validator() {
		return new TerminationCurrencyElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TerminationCurrencyElection> typeFormatValidator() {
		return new TerminationCurrencyElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TerminationCurrencyElection, Set<String>> onlyExistsValidator() {
		return new TerminationCurrencyElectionOnlyExistsValidator();
	}
}
