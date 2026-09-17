package cdm.observable.asset.meta;

import cdm.base.math.MeasureSchedule;
import cdm.base.math.validation.datarule.MeasureScheduleValueExists;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.validation.PriceTypeFormatValidator;
import cdm.observable.asset.validation.PriceValidator;
import cdm.observable.asset.validation.datarule.PriceAmountOnlyExists;
import cdm.observable.asset.validation.datarule.PriceScheduleAccruedInterest;
import cdm.observable.asset.validation.datarule.PriceScheduleArithmeticOperator;
import cdm.observable.asset.validation.datarule.PriceScheduleCashPrice;
import cdm.observable.asset.validation.datarule.PriceScheduleChoice;
import cdm.observable.asset.validation.datarule.PriceScheduleCurrencyUnitForInterestRate;
import cdm.observable.asset.validation.datarule.PriceScheduleForwardPoint;
import cdm.observable.asset.validation.datarule.PriceSchedulePositiveAssetPrice;
import cdm.observable.asset.validation.datarule.PriceSchedulePositiveCashPrice;
import cdm.observable.asset.validation.datarule.PriceSchedulePositiveSpotRate;
import cdm.observable.asset.validation.datarule.PriceScheduleSpreadPrice;
import cdm.observable.asset.validation.datarule.PriceScheduleUnitOfAmountExists;
import cdm.observable.asset.validation.exists.PriceOnlyExistsValidator;
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
@RosettaMeta(model=Price.class)
public class PriceMeta implements RosettaMetaData<Price> {

	@Override
	public List<Validator<? super Price>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MeasureSchedule>create(MeasureScheduleValueExists.class),
			factory.<PriceSchedule>create(PriceScheduleUnitOfAmountExists.class),
			factory.<PriceSchedule>create(PriceSchedulePositiveAssetPrice.class),
			factory.<PriceSchedule>create(PriceSchedulePositiveSpotRate.class),
			factory.<PriceSchedule>create(PriceSchedulePositiveCashPrice.class),
			factory.<PriceSchedule>create(PriceScheduleCurrencyUnitForInterestRate.class),
			factory.<PriceSchedule>create(PriceScheduleChoice.class),
			factory.<PriceSchedule>create(PriceScheduleCashPrice.class),
			factory.<PriceSchedule>create(PriceScheduleArithmeticOperator.class),
			factory.<PriceSchedule>create(PriceScheduleSpreadPrice.class),
			factory.<PriceSchedule>create(PriceScheduleForwardPoint.class),
			factory.<PriceSchedule>create(PriceScheduleAccruedInterest.class),
			factory.<Price>create(PriceAmountOnlyExists.class)
		);
	}
	
	@Override
	public List<Function<? super Price, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Price> validator(ValidatorFactory factory) {
		return factory.<Price>create(PriceValidator.class);
	}

	@Override
	public Validator<? super Price> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Price>create(PriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Price> validator() {
		return new PriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Price> typeFormatValidator() {
		return new PriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Price, Set<String>> onlyExistsValidator() {
		return new PriceOnlyExistsValidator();
	}
}
