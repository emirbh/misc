package cdm.base.math.meta;

import cdm.base.math.MeasureSchedule;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.QuantitySchedule;
import cdm.base.math.validation.NonNegativeQuantityScheduleTypeFormatValidator;
import cdm.base.math.validation.NonNegativeQuantityScheduleValidator;
import cdm.base.math.validation.datarule.MeasureScheduleValueExists;
import cdm.base.math.validation.datarule.NonNegativeQuantityScheduleNonNegativeQuantity_datedValue;
import cdm.base.math.validation.datarule.NonNegativeQuantityScheduleNonNegativeQuantity_value;
import cdm.base.math.validation.datarule.QuantityScheduleQuantity_multiplier;
import cdm.base.math.validation.datarule.QuantityScheduleUnitOfAmountExists;
import cdm.base.math.validation.exists.NonNegativeQuantityScheduleOnlyExistsValidator;
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
@RosettaMeta(model=NonNegativeQuantitySchedule.class)
public class NonNegativeQuantityScheduleMeta implements RosettaMetaData<NonNegativeQuantitySchedule> {

	@Override
	public List<Validator<? super NonNegativeQuantitySchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MeasureSchedule>create(MeasureScheduleValueExists.class),
			factory.<QuantitySchedule>create(QuantityScheduleQuantity_multiplier.class),
			factory.<QuantitySchedule>create(QuantityScheduleUnitOfAmountExists.class),
			factory.<NonNegativeQuantitySchedule>create(NonNegativeQuantityScheduleNonNegativeQuantity_value.class),
			factory.<NonNegativeQuantitySchedule>create(NonNegativeQuantityScheduleNonNegativeQuantity_datedValue.class)
		);
	}
	
	@Override
	public List<Function<? super NonNegativeQuantitySchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonNegativeQuantitySchedule> validator(ValidatorFactory factory) {
		return factory.<NonNegativeQuantitySchedule>create(NonNegativeQuantityScheduleValidator.class);
	}

	@Override
	public Validator<? super NonNegativeQuantitySchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonNegativeQuantitySchedule>create(NonNegativeQuantityScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonNegativeQuantitySchedule> validator() {
		return new NonNegativeQuantityScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonNegativeQuantitySchedule> typeFormatValidator() {
		return new NonNegativeQuantityScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonNegativeQuantitySchedule, Set<String>> onlyExistsValidator() {
		return new NonNegativeQuantityScheduleOnlyExistsValidator();
	}
}
