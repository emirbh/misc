package cdm.base.math.meta;

import cdm.base.math.MeasureSchedule;
import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.Quantity;
import cdm.base.math.QuantitySchedule;
import cdm.base.math.validation.NonNegativeQuantityTypeFormatValidator;
import cdm.base.math.validation.NonNegativeQuantityValidator;
import cdm.base.math.validation.datarule.MeasureScheduleValueExists;
import cdm.base.math.validation.datarule.NonNegativeQuantityNonNegativeQuantity_amount;
import cdm.base.math.validation.datarule.QuantityAmountOnlyExists;
import cdm.base.math.validation.datarule.QuantityScheduleQuantity_multiplier;
import cdm.base.math.validation.datarule.QuantityScheduleUnitOfAmountExists;
import cdm.base.math.validation.exists.NonNegativeQuantityOnlyExistsValidator;
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
@RosettaMeta(model=NonNegativeQuantity.class)
public class NonNegativeQuantityMeta implements RosettaMetaData<NonNegativeQuantity> {

	@Override
	public List<Validator<? super NonNegativeQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MeasureSchedule>create(MeasureScheduleValueExists.class),
			factory.<QuantitySchedule>create(QuantityScheduleQuantity_multiplier.class),
			factory.<QuantitySchedule>create(QuantityScheduleUnitOfAmountExists.class),
			factory.<Quantity>create(QuantityAmountOnlyExists.class),
			factory.<NonNegativeQuantity>create(NonNegativeQuantityNonNegativeQuantity_amount.class)
		);
	}
	
	@Override
	public List<Function<? super NonNegativeQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonNegativeQuantity> validator(ValidatorFactory factory) {
		return factory.<NonNegativeQuantity>create(NonNegativeQuantityValidator.class);
	}

	@Override
	public Validator<? super NonNegativeQuantity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonNegativeQuantity>create(NonNegativeQuantityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonNegativeQuantity> validator() {
		return new NonNegativeQuantityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonNegativeQuantity> typeFormatValidator() {
		return new NonNegativeQuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonNegativeQuantity, Set<String>> onlyExistsValidator() {
		return new NonNegativeQuantityOnlyExistsValidator();
	}
}
