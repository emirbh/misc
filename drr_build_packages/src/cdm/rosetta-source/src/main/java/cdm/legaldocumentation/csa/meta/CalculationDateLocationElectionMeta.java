package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CalculationDateLocationElection;
import cdm.legaldocumentation.csa.validation.CalculationDateLocationElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CalculationDateLocationElectionValidator;
import cdm.legaldocumentation.csa.validation.datarule.CalculationDateLocationElectionChoice;
import cdm.legaldocumentation.csa.validation.exists.CalculationDateLocationElectionOnlyExistsValidator;
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
@RosettaMeta(model=CalculationDateLocationElection.class)
public class CalculationDateLocationElectionMeta implements RosettaMetaData<CalculationDateLocationElection> {

	@Override
	public List<Validator<? super CalculationDateLocationElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CalculationDateLocationElection>create(CalculationDateLocationElectionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationDateLocationElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationDateLocationElection> validator(ValidatorFactory factory) {
		return factory.<CalculationDateLocationElection>create(CalculationDateLocationElectionValidator.class);
	}

	@Override
	public Validator<? super CalculationDateLocationElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationDateLocationElection>create(CalculationDateLocationElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationDateLocationElection> validator() {
		return new CalculationDateLocationElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationDateLocationElection> typeFormatValidator() {
		return new CalculationDateLocationElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationDateLocationElection, Set<String>> onlyExistsValidator() {
		return new CalculationDateLocationElectionOnlyExistsValidator();
	}
}
