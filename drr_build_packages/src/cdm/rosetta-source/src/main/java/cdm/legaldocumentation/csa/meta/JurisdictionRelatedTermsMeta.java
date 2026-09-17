package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.JurisdictionRelatedTerms;
import cdm.legaldocumentation.csa.validation.JurisdictionRelatedTermsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.JurisdictionRelatedTermsValidator;
import cdm.legaldocumentation.csa.validation.exists.JurisdictionRelatedTermsOnlyExistsValidator;
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
@RosettaMeta(model=JurisdictionRelatedTerms.class)
public class JurisdictionRelatedTermsMeta implements RosettaMetaData<JurisdictionRelatedTerms> {

	@Override
	public List<Validator<? super JurisdictionRelatedTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super JurisdictionRelatedTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super JurisdictionRelatedTerms> validator(ValidatorFactory factory) {
		return factory.<JurisdictionRelatedTerms>create(JurisdictionRelatedTermsValidator.class);
	}

	@Override
	public Validator<? super JurisdictionRelatedTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<JurisdictionRelatedTerms>create(JurisdictionRelatedTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super JurisdictionRelatedTerms> validator() {
		return new JurisdictionRelatedTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super JurisdictionRelatedTerms> typeFormatValidator() {
		return new JurisdictionRelatedTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super JurisdictionRelatedTerms, Set<String>> onlyExistsValidator() {
		return new JurisdictionRelatedTermsOnlyExistsValidator();
	}
}
