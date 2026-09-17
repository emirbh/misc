package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CustodianElection;
import cdm.legaldocumentation.csa.validation.CustodianElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CustodianElectionValidator;
import cdm.legaldocumentation.csa.validation.datarule.CustodianElectionAdditionalLanguage;
import cdm.legaldocumentation.csa.validation.datarule.CustodianElectionNamedEntity;
import cdm.legaldocumentation.csa.validation.exists.CustodianElectionOnlyExistsValidator;
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
@RosettaMeta(model=CustodianElection.class)
public class CustodianElectionMeta implements RosettaMetaData<CustodianElection> {

	@Override
	public List<Validator<? super CustodianElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CustodianElection>create(CustodianElectionNamedEntity.class),
			factory.<CustodianElection>create(CustodianElectionAdditionalLanguage.class)
		);
	}
	
	@Override
	public List<Function<? super CustodianElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustodianElection> validator(ValidatorFactory factory) {
		return factory.<CustodianElection>create(CustodianElectionValidator.class);
	}

	@Override
	public Validator<? super CustodianElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CustodianElection>create(CustodianElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CustodianElection> validator() {
		return new CustodianElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CustodianElection> typeFormatValidator() {
		return new CustodianElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustodianElection, Set<String>> onlyExistsValidator() {
		return new CustodianElectionOnlyExistsValidator();
	}
}
