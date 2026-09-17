package cdm.product.template.meta;

import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.validation.datarule.PayoutBaseFinalPrincipalAmountExists;
import cdm.product.template.SettlementPayout;
import cdm.product.template.validation.SettlementPayoutTypeFormatValidator;
import cdm.product.template.validation.SettlementPayoutValidator;
import cdm.product.template.validation.datarule.SettlementPayoutBasket;
import cdm.product.template.validation.datarule.SettlementPayoutDeliveryCapacity;
import cdm.product.template.validation.datarule.SettlementPayoutIndex;
import cdm.product.template.validation.datarule.SettlementPayoutPriceTimeIntervalQuantity;
import cdm.product.template.validation.datarule.SettlementPayoutSettlementTerms;
import cdm.product.template.validation.datarule.SettlementPayoutUnderlier;
import cdm.product.template.validation.exists.SettlementPayoutOnlyExistsValidator;
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
@RosettaMeta(model=SettlementPayout.class)
public class SettlementPayoutMeta implements RosettaMetaData<SettlementPayout> {

	@Override
	public List<Validator<? super SettlementPayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PayoutBase>create(PayoutBaseFinalPrincipalAmountExists.class),
			factory.<SettlementPayout>create(SettlementPayoutUnderlier.class),
			factory.<SettlementPayout>create(SettlementPayoutBasket.class),
			factory.<SettlementPayout>create(SettlementPayoutIndex.class),
			factory.<SettlementPayout>create(SettlementPayoutSettlementTerms.class),
			factory.<SettlementPayout>create(SettlementPayoutDeliveryCapacity.class),
			factory.<SettlementPayout>create(SettlementPayoutPriceTimeIntervalQuantity.class)
		);
	}
	
	@Override
	public List<Function<? super SettlementPayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementPayout> validator(ValidatorFactory factory) {
		return factory.<SettlementPayout>create(SettlementPayoutValidator.class);
	}

	@Override
	public Validator<? super SettlementPayout> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementPayout>create(SettlementPayoutTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPayout> validator() {
		return new SettlementPayoutValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPayout> typeFormatValidator() {
		return new SettlementPayoutTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPayout, Set<String>> onlyExistsValidator() {
		return new SettlementPayoutOnlyExistsValidator();
	}
}
