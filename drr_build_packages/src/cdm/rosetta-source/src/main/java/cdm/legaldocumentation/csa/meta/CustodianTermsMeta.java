package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CustodianTerms;
import cdm.legaldocumentation.csa.validation.CustodianTermsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CustodianTermsValidator;
import cdm.legaldocumentation.csa.validation.exists.CustodianTermsOnlyExistsValidator;
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
@RosettaMeta(model=CustodianTerms.class)
public class CustodianTermsMeta implements RosettaMetaData<CustodianTerms> {

	@Override
	public List<Validator<? super CustodianTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CustodianTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustodianTerms> validator(ValidatorFactory factory) {
		return factory.<CustodianTerms>create(CustodianTermsValidator.class);
	}

	@Override
	public Validator<? super CustodianTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CustodianTerms>create(CustodianTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CustodianTerms> validator() {
		return new CustodianTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CustodianTerms> typeFormatValidator() {
		return new CustodianTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustodianTerms, Set<String>> onlyExistsValidator() {
		return new CustodianTermsOnlyExistsValidator();
	}
}
