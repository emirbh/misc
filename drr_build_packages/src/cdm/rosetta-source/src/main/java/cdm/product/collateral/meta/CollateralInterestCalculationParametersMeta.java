package cdm.product.collateral.meta;

import cdm.product.collateral.CollateralInterestCalculationParameters;
import cdm.product.collateral.validation.CollateralInterestCalculationParametersTypeFormatValidator;
import cdm.product.collateral.validation.CollateralInterestCalculationParametersValidator;
import cdm.product.collateral.validation.datarule.CollateralInterestCalculationParametersCompoundingBC1;
import cdm.product.collateral.validation.datarule.CollateralInterestCalculationParametersCompoundingBC2;
import cdm.product.collateral.validation.datarule.CollateralInterestCalculationParametersDCF;
import cdm.product.collateral.validation.datarule.CollateralInterestCalculationParametersInterestRate;
import cdm.product.collateral.validation.exists.CollateralInterestCalculationParametersOnlyExistsValidator;
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
@RosettaMeta(model=CollateralInterestCalculationParameters.class)
public class CollateralInterestCalculationParametersMeta implements RosettaMetaData<CollateralInterestCalculationParameters> {

	@Override
	public List<Validator<? super CollateralInterestCalculationParameters>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CollateralInterestCalculationParameters>create(CollateralInterestCalculationParametersInterestRate.class),
			factory.<CollateralInterestCalculationParameters>create(CollateralInterestCalculationParametersDCF.class),
			factory.<CollateralInterestCalculationParameters>create(CollateralInterestCalculationParametersCompoundingBC1.class),
			factory.<CollateralInterestCalculationParameters>create(CollateralInterestCalculationParametersCompoundingBC2.class)
		);
	}
	
	@Override
	public List<Function<? super CollateralInterestCalculationParameters, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralInterestCalculationParameters> validator(ValidatorFactory factory) {
		return factory.<CollateralInterestCalculationParameters>create(CollateralInterestCalculationParametersValidator.class);
	}

	@Override
	public Validator<? super CollateralInterestCalculationParameters> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralInterestCalculationParameters>create(CollateralInterestCalculationParametersTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralInterestCalculationParameters> validator() {
		return new CollateralInterestCalculationParametersValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralInterestCalculationParameters> typeFormatValidator() {
		return new CollateralInterestCalculationParametersTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralInterestCalculationParameters, Set<String>> onlyExistsValidator() {
		return new CollateralInterestCalculationParametersOnlyExistsValidator();
	}
}
