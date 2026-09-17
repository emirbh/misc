package cdm.base.math.meta;

import cdm.base.math.MeasureSchedule;
import cdm.base.math.QuantitySchedule;
import cdm.base.math.validation.QuantityScheduleTypeFormatValidator;
import cdm.base.math.validation.QuantityScheduleValidator;
import cdm.base.math.validation.datarule.MeasureScheduleValueExists;
import cdm.base.math.validation.datarule.QuantityScheduleQuantity_multiplier;
import cdm.base.math.validation.datarule.QuantityScheduleUnitOfAmountExists;
import cdm.base.math.validation.exists.QuantityScheduleOnlyExistsValidator;
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
@RosettaMeta(model=QuantitySchedule.class)
public class QuantityScheduleMeta implements RosettaMetaData<QuantitySchedule> {

	@Override
	public List<Validator<? super QuantitySchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MeasureSchedule>create(MeasureScheduleValueExists.class),
			factory.<QuantitySchedule>create(QuantityScheduleQuantity_multiplier.class),
			factory.<QuantitySchedule>create(QuantityScheduleUnitOfAmountExists.class)
		);
	}
	
	@Override
	public List<Function<? super QuantitySchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super QuantitySchedule> validator(ValidatorFactory factory) {
		return factory.<QuantitySchedule>create(QuantityScheduleValidator.class);
	}

	@Override
	public Validator<? super QuantitySchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<QuantitySchedule>create(QuantityScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super QuantitySchedule> validator() {
		return new QuantityScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super QuantitySchedule> typeFormatValidator() {
		return new QuantityScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QuantitySchedule, Set<String>> onlyExistsValidator() {
		return new QuantityScheduleOnlyExistsValidator();
	}
}
