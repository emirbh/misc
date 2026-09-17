package cdm.observable.asset.meta;

import cdm.base.math.MeasureSchedule;
import cdm.base.math.validation.datarule.MeasureScheduleValueExists;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.validation.PriceScheduleTypeFormatValidator;
import cdm.observable.asset.validation.PriceScheduleValidator;
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
import cdm.observable.asset.validation.exists.PriceScheduleOnlyExistsValidator;
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
@RosettaMeta(model=PriceSchedule.class)
public class PriceScheduleMeta implements RosettaMetaData<PriceSchedule> {

	@Override
	public List<Validator<? super PriceSchedule>> dataRules(ValidatorFactory factory) {
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
			factory.<PriceSchedule>create(PriceScheduleAccruedInterest.class)
		);
	}
	
	@Override
	public List<Function<? super PriceSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PriceSchedule> validator(ValidatorFactory factory) {
		return factory.<PriceSchedule>create(PriceScheduleValidator.class);
	}

	@Override
	public Validator<? super PriceSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PriceSchedule>create(PriceScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PriceSchedule> validator() {
		return new PriceScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PriceSchedule> typeFormatValidator() {
		return new PriceScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PriceSchedule, Set<String>> onlyExistsValidator() {
		return new PriceScheduleOnlyExistsValidator();
	}
}
