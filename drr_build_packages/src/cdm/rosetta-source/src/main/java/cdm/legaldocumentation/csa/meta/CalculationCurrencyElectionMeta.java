package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CalculationCurrencyElection;
import cdm.legaldocumentation.csa.validation.CalculationCurrencyElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CalculationCurrencyElectionValidator;
import cdm.legaldocumentation.csa.validation.datarule.CalculationCurrencyElectionBaseCurrency;
import cdm.legaldocumentation.csa.validation.exists.CalculationCurrencyElectionOnlyExistsValidator;
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
@RosettaMeta(model=CalculationCurrencyElection.class)
public class CalculationCurrencyElectionMeta implements RosettaMetaData<CalculationCurrencyElection> {

	@Override
	public List<Validator<? super CalculationCurrencyElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CalculationCurrencyElection>create(CalculationCurrencyElectionBaseCurrency.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationCurrencyElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationCurrencyElection> validator(ValidatorFactory factory) {
		return factory.<CalculationCurrencyElection>create(CalculationCurrencyElectionValidator.class);
	}

	@Override
	public Validator<? super CalculationCurrencyElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationCurrencyElection>create(CalculationCurrencyElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationCurrencyElection> validator() {
		return new CalculationCurrencyElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationCurrencyElection> typeFormatValidator() {
		return new CalculationCurrencyElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationCurrencyElection, Set<String>> onlyExistsValidator() {
		return new CalculationCurrencyElectionOnlyExistsValidator();
	}
}
