package cdm.product.asset.meta;

import cdm.product.asset.ReturnTermsBase;
import cdm.product.asset.VarianceReturnTerms;
import cdm.product.asset.validation.VarianceReturnTermsTypeFormatValidator;
import cdm.product.asset.validation.VarianceReturnTermsValidator;
import cdm.product.asset.validation.datarule.ReturnTermsBaseInitialLevelOrInitialLevelSource;
import cdm.product.asset.validation.datarule.ReturnTermsBasePositiveExpectedN;
import cdm.product.asset.validation.datarule.VarianceReturnTermsNonNegativeStrikePrice;
import cdm.product.asset.validation.datarule.VarianceReturnTermsPositive_VegaNotionalAmount;
import cdm.product.asset.validation.datarule.VarianceReturnTermsReferenceContract;
import cdm.product.asset.validation.datarule.VarianceReturnTermsStrikePriceMustExist;
import cdm.product.asset.validation.datarule.VarianceReturnTermsUnderlierMustBeListedDerivative;
import cdm.product.asset.validation.exists.VarianceReturnTermsOnlyExistsValidator;
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
@RosettaMeta(model=VarianceReturnTerms.class)
public class VarianceReturnTermsMeta implements RosettaMetaData<VarianceReturnTerms> {

	@Override
	public List<Validator<? super VarianceReturnTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReturnTermsBase>create(ReturnTermsBaseInitialLevelOrInitialLevelSource.class),
			factory.<ReturnTermsBase>create(ReturnTermsBasePositiveExpectedN.class),
			factory.<VarianceReturnTerms>create(VarianceReturnTermsPositive_VegaNotionalAmount.class),
			factory.<VarianceReturnTerms>create(VarianceReturnTermsUnderlierMustBeListedDerivative.class),
			factory.<VarianceReturnTerms>create(VarianceReturnTermsReferenceContract.class),
			factory.<VarianceReturnTerms>create(VarianceReturnTermsStrikePriceMustExist.class),
			factory.<VarianceReturnTerms>create(VarianceReturnTermsNonNegativeStrikePrice.class)
		);
	}
	
	@Override
	public List<Function<? super VarianceReturnTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VarianceReturnTerms> validator(ValidatorFactory factory) {
		return factory.<VarianceReturnTerms>create(VarianceReturnTermsValidator.class);
	}

	@Override
	public Validator<? super VarianceReturnTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VarianceReturnTerms>create(VarianceReturnTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VarianceReturnTerms> validator() {
		return new VarianceReturnTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VarianceReturnTerms> typeFormatValidator() {
		return new VarianceReturnTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VarianceReturnTerms, Set<String>> onlyExistsValidator() {
		return new VarianceReturnTermsOnlyExistsValidator();
	}
}
