package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.RegimeTerms;
import cdm.legaldocumentation.csa.validation.RegimeTermsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.RegimeTermsValidator;
import cdm.legaldocumentation.csa.validation.exists.RegimeTermsOnlyExistsValidator;
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
@RosettaMeta(model=RegimeTerms.class)
public class RegimeTermsMeta implements RosettaMetaData<RegimeTerms> {

	@Override
	public List<Validator<? super RegimeTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegimeTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegimeTerms> validator(ValidatorFactory factory) {
		return factory.<RegimeTerms>create(RegimeTermsValidator.class);
	}

	@Override
	public Validator<? super RegimeTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegimeTerms>create(RegimeTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegimeTerms> validator() {
		return new RegimeTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegimeTerms> typeFormatValidator() {
		return new RegimeTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegimeTerms, Set<String>> onlyExistsValidator() {
		return new RegimeTermsOnlyExistsValidator();
	}
}
