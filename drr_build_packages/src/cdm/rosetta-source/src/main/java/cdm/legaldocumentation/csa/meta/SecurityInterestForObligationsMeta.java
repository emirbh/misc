package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.SecurityInterestForObligations;
import cdm.legaldocumentation.csa.validation.SecurityInterestForObligationsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.SecurityInterestForObligationsValidator;
import cdm.legaldocumentation.csa.validation.exists.SecurityInterestForObligationsOnlyExistsValidator;
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
@RosettaMeta(model=SecurityInterestForObligations.class)
public class SecurityInterestForObligationsMeta implements RosettaMetaData<SecurityInterestForObligations> {

	@Override
	public List<Validator<? super SecurityInterestForObligations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecurityInterestForObligations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecurityInterestForObligations> validator(ValidatorFactory factory) {
		return factory.<SecurityInterestForObligations>create(SecurityInterestForObligationsValidator.class);
	}

	@Override
	public Validator<? super SecurityInterestForObligations> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecurityInterestForObligations>create(SecurityInterestForObligationsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecurityInterestForObligations> validator() {
		return new SecurityInterestForObligationsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SecurityInterestForObligations> typeFormatValidator() {
		return new SecurityInterestForObligationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecurityInterestForObligations, Set<String>> onlyExistsValidator() {
		return new SecurityInterestForObligationsOnlyExistsValidator();
	}
}
