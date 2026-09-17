package cdm.observable.asset.meta;

import cdm.base.math.MeasureSchedule;
import cdm.base.math.Quantity;
import cdm.base.math.QuantitySchedule;
import cdm.base.math.validation.datarule.MeasureScheduleValueExists;
import cdm.base.math.validation.datarule.QuantityAmountOnlyExists;
import cdm.base.math.validation.datarule.QuantityScheduleQuantity_multiplier;
import cdm.base.math.validation.datarule.QuantityScheduleUnitOfAmountExists;
import cdm.observable.asset.Money;
import cdm.observable.asset.validation.MoneyTypeFormatValidator;
import cdm.observable.asset.validation.MoneyValidator;
import cdm.observable.asset.validation.datarule.MoneyCurrencyUnitExists;
import cdm.observable.asset.validation.exists.MoneyOnlyExistsValidator;
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
@RosettaMeta(model=Money.class)
public class MoneyMeta implements RosettaMetaData<Money> {

	@Override
	public List<Validator<? super Money>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MeasureSchedule>create(MeasureScheduleValueExists.class),
			factory.<QuantitySchedule>create(QuantityScheduleQuantity_multiplier.class),
			factory.<QuantitySchedule>create(QuantityScheduleUnitOfAmountExists.class),
			factory.<Quantity>create(QuantityAmountOnlyExists.class),
			factory.<Money>create(MoneyCurrencyUnitExists.class)
		);
	}
	
	@Override
	public List<Function<? super Money, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Money> validator(ValidatorFactory factory) {
		return factory.<Money>create(MoneyValidator.class);
	}

	@Override
	public Validator<? super Money> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Money>create(MoneyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Money> validator() {
		return new MoneyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Money> typeFormatValidator() {
		return new MoneyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Money, Set<String>> onlyExistsValidator() {
		return new MoneyOnlyExistsValidator();
	}
}
