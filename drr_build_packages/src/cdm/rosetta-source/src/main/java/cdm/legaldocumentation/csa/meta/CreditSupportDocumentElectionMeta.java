package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CreditSupportDocumentElection;
import cdm.legaldocumentation.csa.validation.CreditSupportDocumentElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CreditSupportDocumentElectionValidator;
import cdm.legaldocumentation.csa.validation.datarule.CreditSupportDocumentElectionCreditSupportDocument;
import cdm.legaldocumentation.csa.validation.exists.CreditSupportDocumentElectionOnlyExistsValidator;
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
@RosettaMeta(model=CreditSupportDocumentElection.class)
public class CreditSupportDocumentElectionMeta implements RosettaMetaData<CreditSupportDocumentElection> {

	@Override
	public List<Validator<? super CreditSupportDocumentElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CreditSupportDocumentElection>create(CreditSupportDocumentElectionCreditSupportDocument.class)
		);
	}
	
	@Override
	public List<Function<? super CreditSupportDocumentElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditSupportDocumentElection> validator(ValidatorFactory factory) {
		return factory.<CreditSupportDocumentElection>create(CreditSupportDocumentElectionValidator.class);
	}

	@Override
	public Validator<? super CreditSupportDocumentElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditSupportDocumentElection>create(CreditSupportDocumentElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditSupportDocumentElection> validator() {
		return new CreditSupportDocumentElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditSupportDocumentElection> typeFormatValidator() {
		return new CreditSupportDocumentElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportDocumentElection, Set<String>> onlyExistsValidator() {
		return new CreditSupportDocumentElectionOnlyExistsValidator();
	}
}
