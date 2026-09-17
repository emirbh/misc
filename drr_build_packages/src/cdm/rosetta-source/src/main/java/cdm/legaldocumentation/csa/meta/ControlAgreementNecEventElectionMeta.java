package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ControlAgreementNecEventElection;
import cdm.legaldocumentation.csa.validation.ControlAgreementNecEventElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ControlAgreementNecEventElectionValidator;
import cdm.legaldocumentation.csa.validation.exists.ControlAgreementNecEventElectionOnlyExistsValidator;
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
@RosettaMeta(model=ControlAgreementNecEventElection.class)
public class ControlAgreementNecEventElectionMeta implements RosettaMetaData<ControlAgreementNecEventElection> {

	@Override
	public List<Validator<? super ControlAgreementNecEventElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ControlAgreementNecEventElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ControlAgreementNecEventElection> validator(ValidatorFactory factory) {
		return factory.<ControlAgreementNecEventElection>create(ControlAgreementNecEventElectionValidator.class);
	}

	@Override
	public Validator<? super ControlAgreementNecEventElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ControlAgreementNecEventElection>create(ControlAgreementNecEventElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ControlAgreementNecEventElection> validator() {
		return new ControlAgreementNecEventElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ControlAgreementNecEventElection> typeFormatValidator() {
		return new ControlAgreementNecEventElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ControlAgreementNecEventElection, Set<String>> onlyExistsValidator() {
		return new ControlAgreementNecEventElectionOnlyExistsValidator();
	}
}
