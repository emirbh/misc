package cdm.product.asset.meta;

import cdm.product.asset.ValuationTerms;
import cdm.product.asset.validation.ValuationTermsTypeFormatValidator;
import cdm.product.asset.validation.ValuationTermsValidator;
import cdm.product.asset.validation.datarule.ValuationTermsPositiveNumberOfValuationDates;
import cdm.product.asset.validation.exists.ValuationTermsOnlyExistsValidator;
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
@RosettaMeta(model=ValuationTerms.class)
public class ValuationTermsMeta implements RosettaMetaData<ValuationTerms> {

	@Override
	public List<Validator<? super ValuationTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ValuationTerms>create(ValuationTermsPositiveNumberOfValuationDates.class)
		);
	}
	
	@Override
	public List<Function<? super ValuationTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationTerms> validator(ValidatorFactory factory) {
		return factory.<ValuationTerms>create(ValuationTermsValidator.class);
	}

	@Override
	public Validator<? super ValuationTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuationTerms>create(ValuationTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuationTerms> validator() {
		return new ValuationTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuationTerms> typeFormatValidator() {
		return new ValuationTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationTerms, Set<String>> onlyExistsValidator() {
		return new ValuationTermsOnlyExistsValidator();
	}
}
