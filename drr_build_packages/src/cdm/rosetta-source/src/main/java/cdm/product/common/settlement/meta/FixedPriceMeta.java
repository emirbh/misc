package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.FixedPrice;
import cdm.product.common.settlement.validation.FixedPriceTypeFormatValidator;
import cdm.product.common.settlement.validation.FixedPriceValidator;
import cdm.product.common.settlement.validation.datarule.FixedPriceNonNegativePrice_amount;
import cdm.product.common.settlement.validation.datarule.FixedPriceNonNegativePrice_datedValue;
import cdm.product.common.settlement.validation.exists.FixedPriceOnlyExistsValidator;
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
@RosettaMeta(model=FixedPrice.class)
public class FixedPriceMeta implements RosettaMetaData<FixedPrice> {

	@Override
	public List<Validator<? super FixedPrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FixedPrice>create(FixedPriceNonNegativePrice_amount.class),
			factory.<FixedPrice>create(FixedPriceNonNegativePrice_datedValue.class)
		);
	}
	
	@Override
	public List<Function<? super FixedPrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FixedPrice> validator(ValidatorFactory factory) {
		return factory.<FixedPrice>create(FixedPriceValidator.class);
	}

	@Override
	public Validator<? super FixedPrice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FixedPrice>create(FixedPriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FixedPrice> validator() {
		return new FixedPriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FixedPrice> typeFormatValidator() {
		return new FixedPriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedPrice, Set<String>> onlyExistsValidator() {
		return new FixedPriceOnlyExistsValidator();
	}
}
