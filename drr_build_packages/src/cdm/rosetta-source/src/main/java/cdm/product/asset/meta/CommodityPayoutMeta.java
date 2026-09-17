package cdm.product.asset.meta;

import cdm.product.asset.CommodityPayout;
import cdm.product.asset.validation.CommodityPayoutTypeFormatValidator;
import cdm.product.asset.validation.CommodityPayoutValidator;
import cdm.product.asset.validation.datarule.CommodityPayoutCalculationPeriod;
import cdm.product.asset.validation.datarule.CommodityPayoutCommodityUnderlier;
import cdm.product.asset.validation.datarule.CommodityPayoutDeliveryCapacity;
import cdm.product.asset.validation.datarule.CommodityPayoutPriceTimeIntervalQuantity;
import cdm.product.asset.validation.datarule.CommodityPayoutQuantity;
import cdm.product.asset.validation.exists.CommodityPayoutOnlyExistsValidator;
import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.validation.datarule.PayoutBaseFinalPrincipalAmountExists;
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
@RosettaMeta(model=CommodityPayout.class)
public class CommodityPayoutMeta implements RosettaMetaData<CommodityPayout> {

	@Override
	public List<Validator<? super CommodityPayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PayoutBase>create(PayoutBaseFinalPrincipalAmountExists.class),
			factory.<CommodityPayout>create(CommodityPayoutQuantity.class),
			factory.<CommodityPayout>create(CommodityPayoutCalculationPeriod.class),
			factory.<CommodityPayout>create(CommodityPayoutCommodityUnderlier.class),
			factory.<CommodityPayout>create(CommodityPayoutDeliveryCapacity.class),
			factory.<CommodityPayout>create(CommodityPayoutPriceTimeIntervalQuantity.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityPayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityPayout> validator(ValidatorFactory factory) {
		return factory.<CommodityPayout>create(CommodityPayoutValidator.class);
	}

	@Override
	public Validator<? super CommodityPayout> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityPayout>create(CommodityPayoutTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPayout> validator() {
		return new CommodityPayoutValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPayout> typeFormatValidator() {
		return new CommodityPayoutTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPayout, Set<String>> onlyExistsValidator() {
		return new CommodityPayoutOnlyExistsValidator();
	}
}
