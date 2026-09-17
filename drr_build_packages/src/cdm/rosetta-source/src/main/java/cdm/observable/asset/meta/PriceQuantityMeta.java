package cdm.observable.asset.meta;

import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.validation.PriceQuantityTypeFormatValidator;
import cdm.observable.asset.validation.PriceQuantityValidator;
import cdm.observable.asset.validation.datarule.PriceQuantityArithmeticOperator;
import cdm.observable.asset.validation.datarule.PriceQuantityInterestRateObservable;
import cdm.observable.asset.validation.datarule.PriceQuantityNonCurrencyQuantities;
import cdm.observable.asset.validation.exists.PriceQuantityOnlyExistsValidator;
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
@RosettaMeta(model=PriceQuantity.class)
public class PriceQuantityMeta implements RosettaMetaData<PriceQuantity> {

	@Override
	public List<Validator<? super PriceQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PriceQuantity>create(PriceQuantityNonCurrencyQuantities.class),
			factory.<PriceQuantity>create(PriceQuantityArithmeticOperator.class),
			factory.<PriceQuantity>create(PriceQuantityInterestRateObservable.class)
		);
	}
	
	@Override
	public List<Function<? super PriceQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PriceQuantity> validator(ValidatorFactory factory) {
		return factory.<PriceQuantity>create(PriceQuantityValidator.class);
	}

	@Override
	public Validator<? super PriceQuantity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PriceQuantity>create(PriceQuantityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PriceQuantity> validator() {
		return new PriceQuantityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PriceQuantity> typeFormatValidator() {
		return new PriceQuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PriceQuantity, Set<String>> onlyExistsValidator() {
		return new PriceQuantityOnlyExistsValidator();
	}
}
