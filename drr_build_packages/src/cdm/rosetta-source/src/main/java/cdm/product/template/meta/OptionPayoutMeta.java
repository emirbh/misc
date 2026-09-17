package cdm.product.template.meta;

import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.validation.datarule.PayoutBaseFinalPrincipalAmountExists;
import cdm.product.template.OptionPayout;
import cdm.product.template.validation.OptionPayoutTypeFormatValidator;
import cdm.product.template.validation.OptionPayoutValidator;
import cdm.product.template.validation.datarule.OptionPayoutClearedPhysicalSettlementExists;
import cdm.product.template.validation.datarule.OptionPayoutDeliveryCapacity;
import cdm.product.template.validation.datarule.OptionPayoutOptionStylePresent;
import cdm.product.template.validation.datarule.OptionPayoutOptionTypePresent;
import cdm.product.template.validation.datarule.OptionPayoutPriceTimeIntervalQuantity;
import cdm.product.template.validation.exists.OptionPayoutOnlyExistsValidator;
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
@RosettaMeta(model=OptionPayout.class)
public class OptionPayoutMeta implements RosettaMetaData<OptionPayout> {

	@Override
	public List<Validator<? super OptionPayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PayoutBase>create(PayoutBaseFinalPrincipalAmountExists.class),
			factory.<OptionPayout>create(OptionPayoutClearedPhysicalSettlementExists.class),
			factory.<OptionPayout>create(OptionPayoutDeliveryCapacity.class),
			factory.<OptionPayout>create(OptionPayoutPriceTimeIntervalQuantity.class),
			factory.<OptionPayout>create(OptionPayoutOptionStylePresent.class),
			factory.<OptionPayout>create(OptionPayoutOptionTypePresent.class)
		);
	}
	
	@Override
	public List<Function<? super OptionPayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionPayout> validator(ValidatorFactory factory) {
		return factory.<OptionPayout>create(OptionPayoutValidator.class);
	}

	@Override
	public Validator<? super OptionPayout> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionPayout>create(OptionPayoutTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionPayout> validator() {
		return new OptionPayoutValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionPayout> typeFormatValidator() {
		return new OptionPayoutTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionPayout, Set<String>> onlyExistsValidator() {
		return new OptionPayoutOnlyExistsValidator();
	}
}
