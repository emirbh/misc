package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CustodianRiskElection;
import cdm.legaldocumentation.csa.validation.CustodianRiskElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CustodianRiskElectionValidator;
import cdm.legaldocumentation.csa.validation.datarule.CustodianRiskElectionSpecified;
import cdm.legaldocumentation.csa.validation.exists.CustodianRiskElectionOnlyExistsValidator;
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
@RosettaMeta(model=CustodianRiskElection.class)
public class CustodianRiskElectionMeta implements RosettaMetaData<CustodianRiskElection> {

	@Override
	public List<Validator<? super CustodianRiskElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CustodianRiskElection>create(CustodianRiskElectionSpecified.class)
		);
	}
	
	@Override
	public List<Function<? super CustodianRiskElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustodianRiskElection> validator(ValidatorFactory factory) {
		return factory.<CustodianRiskElection>create(CustodianRiskElectionValidator.class);
	}

	@Override
	public Validator<? super CustodianRiskElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CustodianRiskElection>create(CustodianRiskElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CustodianRiskElection> validator() {
		return new CustodianRiskElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CustodianRiskElection> typeFormatValidator() {
		return new CustodianRiskElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustodianRiskElection, Set<String>> onlyExistsValidator() {
		return new CustodianRiskElectionOnlyExistsValidator();
	}
}
