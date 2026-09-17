package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CreditSupportProviderElection;
import cdm.legaldocumentation.csa.validation.CreditSupportProviderElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CreditSupportProviderElectionValidator;
import cdm.legaldocumentation.csa.validation.datarule.CreditSupportProviderElectionCreditSupportProvider;
import cdm.legaldocumentation.csa.validation.exists.CreditSupportProviderElectionOnlyExistsValidator;
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
@RosettaMeta(model=CreditSupportProviderElection.class)
public class CreditSupportProviderElectionMeta implements RosettaMetaData<CreditSupportProviderElection> {

	@Override
	public List<Validator<? super CreditSupportProviderElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CreditSupportProviderElection>create(CreditSupportProviderElectionCreditSupportProvider.class)
		);
	}
	
	@Override
	public List<Function<? super CreditSupportProviderElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditSupportProviderElection> validator(ValidatorFactory factory) {
		return factory.<CreditSupportProviderElection>create(CreditSupportProviderElectionValidator.class);
	}

	@Override
	public Validator<? super CreditSupportProviderElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditSupportProviderElection>create(CreditSupportProviderElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditSupportProviderElection> validator() {
		return new CreditSupportProviderElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditSupportProviderElection> typeFormatValidator() {
		return new CreditSupportProviderElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportProviderElection, Set<String>> onlyExistsValidator() {
		return new CreditSupportProviderElectionOnlyExistsValidator();
	}
}
