package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.SecuredPartyRightsEventElection;
import cdm.legaldocumentation.csa.validation.SecuredPartyRightsEventElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.SecuredPartyRightsEventElectionValidator;
import cdm.legaldocumentation.csa.validation.exists.SecuredPartyRightsEventElectionOnlyExistsValidator;
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
@RosettaMeta(model=SecuredPartyRightsEventElection.class)
public class SecuredPartyRightsEventElectionMeta implements RosettaMetaData<SecuredPartyRightsEventElection> {

	@Override
	public List<Validator<? super SecuredPartyRightsEventElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecuredPartyRightsEventElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecuredPartyRightsEventElection> validator(ValidatorFactory factory) {
		return factory.<SecuredPartyRightsEventElection>create(SecuredPartyRightsEventElectionValidator.class);
	}

	@Override
	public Validator<? super SecuredPartyRightsEventElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecuredPartyRightsEventElection>create(SecuredPartyRightsEventElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecuredPartyRightsEventElection> validator() {
		return new SecuredPartyRightsEventElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SecuredPartyRightsEventElection> typeFormatValidator() {
		return new SecuredPartyRightsEventElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecuredPartyRightsEventElection, Set<String>> onlyExistsValidator() {
		return new SecuredPartyRightsEventElectionOnlyExistsValidator();
	}
}
