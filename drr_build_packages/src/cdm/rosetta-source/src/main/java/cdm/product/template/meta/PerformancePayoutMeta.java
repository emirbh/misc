package cdm.product.template.meta;

import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.validation.datarule.PayoutBaseFinalPrincipalAmountExists;
import cdm.product.template.PerformancePayout;
import cdm.product.template.validation.PerformancePayoutTypeFormatValidator;
import cdm.product.template.validation.PerformancePayoutValidator;
import cdm.product.template.validation.datarule.PerformancePayoutCorrelationUnderlierOnlyBasket;
import cdm.product.template.validation.datarule.PerformancePayoutEquitySpecificAttributes;
import cdm.product.template.validation.datarule.PerformancePayoutNoSharePriceDividendAdjustmentForeignExchange;
import cdm.product.template.validation.datarule.PerformancePayoutNoSharePriceDividendAdjustmentIndex;
import cdm.product.template.validation.datarule.PerformancePayoutPortfolioOrStraightReturn;
import cdm.product.template.validation.datarule.PerformancePayoutPortfolioReturnIsMultipleReturns;
import cdm.product.template.validation.datarule.PerformancePayoutQuantity;
import cdm.product.template.validation.datarule.PerformancePayoutUnderlier;
import cdm.product.template.validation.datarule.PerformancePayoutUnderlierOfPortfolioIsBasket;
import cdm.product.template.validation.exists.PerformancePayoutOnlyExistsValidator;
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
@RosettaMeta(model=PerformancePayout.class)
public class PerformancePayoutMeta implements RosettaMetaData<PerformancePayout> {

	@Override
	public List<Validator<? super PerformancePayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PayoutBase>create(PayoutBaseFinalPrincipalAmountExists.class),
			factory.<PerformancePayout>create(PerformancePayoutUnderlier.class),
			factory.<PerformancePayout>create(PerformancePayoutPortfolioOrStraightReturn.class),
			factory.<PerformancePayout>create(PerformancePayoutPortfolioReturnIsMultipleReturns.class),
			factory.<PerformancePayout>create(PerformancePayoutUnderlierOfPortfolioIsBasket.class),
			factory.<PerformancePayout>create(PerformancePayoutQuantity.class),
			factory.<PerformancePayout>create(PerformancePayoutNoSharePriceDividendAdjustmentIndex.class),
			factory.<PerformancePayout>create(PerformancePayoutNoSharePriceDividendAdjustmentForeignExchange.class),
			factory.<PerformancePayout>create(PerformancePayoutCorrelationUnderlierOnlyBasket.class),
			factory.<PerformancePayout>create(PerformancePayoutEquitySpecificAttributes.class)
		);
	}
	
	@Override
	public List<Function<? super PerformancePayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PerformancePayout> validator(ValidatorFactory factory) {
		return factory.<PerformancePayout>create(PerformancePayoutValidator.class);
	}

	@Override
	public Validator<? super PerformancePayout> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PerformancePayout>create(PerformancePayoutTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PerformancePayout> validator() {
		return new PerformancePayoutValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PerformancePayout> typeFormatValidator() {
		return new PerformancePayoutTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PerformancePayout, Set<String>> onlyExistsValidator() {
		return new PerformancePayoutOnlyExistsValidator();
	}
}
