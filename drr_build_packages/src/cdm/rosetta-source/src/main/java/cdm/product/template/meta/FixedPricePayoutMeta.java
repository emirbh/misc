package cdm.product.template.meta;

import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.validation.datarule.PayoutBaseFinalPrincipalAmountExists;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.validation.FixedPricePayoutTypeFormatValidator;
import cdm.product.template.validation.FixedPricePayoutValidator;
import cdm.product.template.validation.datarule.FixedPricePayoutQuantity;
import cdm.product.template.validation.exists.FixedPricePayoutOnlyExistsValidator;
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
@RosettaMeta(model=FixedPricePayout.class)
public class FixedPricePayoutMeta implements RosettaMetaData<FixedPricePayout> {

	@Override
	public List<Validator<? super FixedPricePayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PayoutBase>create(PayoutBaseFinalPrincipalAmountExists.class),
			factory.<FixedPricePayout>create(FixedPricePayoutQuantity.class)
		);
	}
	
	@Override
	public List<Function<? super FixedPricePayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FixedPricePayout> validator(ValidatorFactory factory) {
		return factory.<FixedPricePayout>create(FixedPricePayoutValidator.class);
	}

	@Override
	public Validator<? super FixedPricePayout> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FixedPricePayout>create(FixedPricePayoutTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FixedPricePayout> validator() {
		return new FixedPricePayoutValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FixedPricePayout> typeFormatValidator() {
		return new FixedPricePayoutTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedPricePayout, Set<String>> onlyExistsValidator() {
		return new FixedPricePayoutOnlyExistsValidator();
	}
}
