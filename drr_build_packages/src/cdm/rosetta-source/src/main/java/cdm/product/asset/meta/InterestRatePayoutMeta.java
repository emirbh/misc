package cdm.product.asset.meta;

import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.validation.InterestRatePayoutTypeFormatValidator;
import cdm.product.asset.validation.InterestRatePayoutValidator;
import cdm.product.asset.validation.datarule.InterestRatePayoutCalculationPeriodDatesFirstCompoundingPeriodEndDate;
import cdm.product.asset.validation.datarule.InterestRatePayoutCashSettlementTerms;
import cdm.product.asset.validation.datarule.InterestRatePayoutFpML_ird_23;
import cdm.product.asset.validation.datarule.InterestRatePayoutFpML_ird_24;
import cdm.product.asset.validation.datarule.InterestRatePayoutFpML_ird_29;
import cdm.product.asset.validation.datarule.InterestRatePayoutFpML_ird_6;
import cdm.product.asset.validation.datarule.InterestRatePayoutFpML_ird_7_1;
import cdm.product.asset.validation.datarule.InterestRatePayoutFpML_ird_7_2;
import cdm.product.asset.validation.datarule.InterestRatePayoutFpML_ird_9;
import cdm.product.asset.validation.datarule.InterestRatePayoutFutureValueNotional;
import cdm.product.asset.validation.datarule.InterestRatePayoutInitialStubFinalStub;
import cdm.product.asset.validation.datarule.InterestRatePayoutInterestRatePayoutChoice;
import cdm.product.asset.validation.datarule.InterestRatePayoutQuantity;
import cdm.product.asset.validation.datarule.InterestRatePayoutRateSpecification;
import cdm.product.asset.validation.datarule.InterestRatePayoutTerminationDate;
import cdm.product.asset.validation.exists.InterestRatePayoutOnlyExistsValidator;
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
@RosettaMeta(model=InterestRatePayout.class)
public class InterestRatePayoutMeta implements RosettaMetaData<InterestRatePayout> {

	@Override
	public List<Validator<? super InterestRatePayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PayoutBase>create(PayoutBaseFinalPrincipalAmountExists.class),
			factory.<InterestRatePayout>create(InterestRatePayoutQuantity.class),
			factory.<InterestRatePayout>create(InterestRatePayoutInterestRatePayoutChoice.class),
			factory.<InterestRatePayout>create(InterestRatePayoutFutureValueNotional.class),
			factory.<InterestRatePayout>create(InterestRatePayoutTerminationDate.class),
			factory.<InterestRatePayout>create(InterestRatePayoutRateSpecification.class),
			factory.<InterestRatePayout>create(InterestRatePayoutFpML_ird_6.class),
			factory.<InterestRatePayout>create(InterestRatePayoutFpML_ird_23.class),
			factory.<InterestRatePayout>create(InterestRatePayoutFpML_ird_24.class),
			factory.<InterestRatePayout>create(InterestRatePayoutInitialStubFinalStub.class),
			factory.<InterestRatePayout>create(InterestRatePayoutCashSettlementTerms.class),
			factory.<InterestRatePayout>create(InterestRatePayoutFpML_ird_7_1.class),
			factory.<InterestRatePayout>create(InterestRatePayoutFpML_ird_7_2.class),
			factory.<InterestRatePayout>create(InterestRatePayoutFpML_ird_9.class),
			factory.<InterestRatePayout>create(InterestRatePayoutFpML_ird_29.class),
			factory.<InterestRatePayout>create(InterestRatePayoutCalculationPeriodDatesFirstCompoundingPeriodEndDate.class)
		);
	}
	
	@Override
	public List<Function<? super InterestRatePayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestRatePayout> validator(ValidatorFactory factory) {
		return factory.<InterestRatePayout>create(InterestRatePayoutValidator.class);
	}

	@Override
	public Validator<? super InterestRatePayout> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestRatePayout>create(InterestRatePayoutTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestRatePayout> validator() {
		return new InterestRatePayoutValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestRatePayout> typeFormatValidator() {
		return new InterestRatePayoutTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestRatePayout, Set<String>> onlyExistsValidator() {
		return new InterestRatePayoutOnlyExistsValidator();
	}
}
