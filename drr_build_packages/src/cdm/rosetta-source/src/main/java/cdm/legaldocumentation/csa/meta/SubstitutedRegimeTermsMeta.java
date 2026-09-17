package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.SubstitutedRegimeTerms;
import cdm.legaldocumentation.csa.validation.SubstitutedRegimeTermsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.SubstitutedRegimeTermsValidator;
import cdm.legaldocumentation.csa.validation.exists.SubstitutedRegimeTermsOnlyExistsValidator;
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
@RosettaMeta(model=SubstitutedRegimeTerms.class)
public class SubstitutedRegimeTermsMeta implements RosettaMetaData<SubstitutedRegimeTerms> {

	@Override
	public List<Validator<? super SubstitutedRegimeTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SubstitutedRegimeTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SubstitutedRegimeTerms> validator(ValidatorFactory factory) {
		return factory.<SubstitutedRegimeTerms>create(SubstitutedRegimeTermsValidator.class);
	}

	@Override
	public Validator<? super SubstitutedRegimeTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SubstitutedRegimeTerms>create(SubstitutedRegimeTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SubstitutedRegimeTerms> validator() {
		return new SubstitutedRegimeTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SubstitutedRegimeTerms> typeFormatValidator() {
		return new SubstitutedRegimeTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SubstitutedRegimeTerms, Set<String>> onlyExistsValidator() {
		return new SubstitutedRegimeTermsOnlyExistsValidator();
	}
}
