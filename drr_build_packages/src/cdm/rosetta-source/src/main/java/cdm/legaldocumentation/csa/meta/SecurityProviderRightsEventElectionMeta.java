package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.SecurityProviderRightsEventElection;
import cdm.legaldocumentation.csa.validation.SecurityProviderRightsEventElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.SecurityProviderRightsEventElectionValidator;
import cdm.legaldocumentation.csa.validation.exists.SecurityProviderRightsEventElectionOnlyExistsValidator;
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
@RosettaMeta(model=SecurityProviderRightsEventElection.class)
public class SecurityProviderRightsEventElectionMeta implements RosettaMetaData<SecurityProviderRightsEventElection> {

	@Override
	public List<Validator<? super SecurityProviderRightsEventElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecurityProviderRightsEventElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecurityProviderRightsEventElection> validator(ValidatorFactory factory) {
		return factory.<SecurityProviderRightsEventElection>create(SecurityProviderRightsEventElectionValidator.class);
	}

	@Override
	public Validator<? super SecurityProviderRightsEventElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecurityProviderRightsEventElection>create(SecurityProviderRightsEventElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecurityProviderRightsEventElection> validator() {
		return new SecurityProviderRightsEventElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SecurityProviderRightsEventElection> typeFormatValidator() {
		return new SecurityProviderRightsEventElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecurityProviderRightsEventElection, Set<String>> onlyExistsValidator() {
		return new SecurityProviderRightsEventElectionOnlyExistsValidator();
	}
}
