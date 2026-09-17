package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.DeterminationRolesAndTerms;
import cdm.legaldocumentation.transaction.additionalterms.validation.DeterminationRolesAndTermsTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.DeterminationRolesAndTermsValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.datarule.DeterminationRolesAndTermsDisputingPartyCannotHaveOriginalRole;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.DeterminationRolesAndTermsOnlyExistsValidator;
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
@RosettaMeta(model=DeterminationRolesAndTerms.class)
public class DeterminationRolesAndTermsMeta implements RosettaMetaData<DeterminationRolesAndTerms> {

	@Override
	public List<Validator<? super DeterminationRolesAndTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DeterminationRolesAndTerms>create(DeterminationRolesAndTermsDisputingPartyCannotHaveOriginalRole.class)
		);
	}
	
	@Override
	public List<Function<? super DeterminationRolesAndTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DeterminationRolesAndTerms> validator(ValidatorFactory factory) {
		return factory.<DeterminationRolesAndTerms>create(DeterminationRolesAndTermsValidator.class);
	}

	@Override
	public Validator<? super DeterminationRolesAndTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DeterminationRolesAndTerms>create(DeterminationRolesAndTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DeterminationRolesAndTerms> validator() {
		return new DeterminationRolesAndTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DeterminationRolesAndTerms> typeFormatValidator() {
		return new DeterminationRolesAndTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeterminationRolesAndTerms, Set<String>> onlyExistsValidator() {
		return new DeterminationRolesAndTermsOnlyExistsValidator();
	}
}
