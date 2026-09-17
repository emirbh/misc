package cdm.product.common.schedule.meta;

import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.validation.CalculationPeriodDatesTypeFormatValidator;
import cdm.product.common.schedule.validation.CalculationPeriodDatesValidator;
import cdm.product.common.schedule.validation.datarule.CalculationPeriodDatesFpML_ird_16;
import cdm.product.common.schedule.validation.datarule.CalculationPeriodDatesFpML_ird_17;
import cdm.product.common.schedule.validation.datarule.CalculationPeriodDatesFpML_ird_18;
import cdm.product.common.schedule.validation.datarule.CalculationPeriodDatesFpML_ird_20;
import cdm.product.common.schedule.validation.datarule.CalculationPeriodDatesFpML_ird_21;
import cdm.product.common.schedule.validation.datarule.CalculationPeriodDatesFpML_ird_22;
import cdm.product.common.schedule.validation.exists.CalculationPeriodDatesOnlyExistsValidator;
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
@RosettaMeta(model=CalculationPeriodDates.class)
public class CalculationPeriodDatesMeta implements RosettaMetaData<CalculationPeriodDates> {

	@Override
	public List<Validator<? super CalculationPeriodDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CalculationPeriodDates>create(CalculationPeriodDatesFpML_ird_16.class),
			factory.<CalculationPeriodDates>create(CalculationPeriodDatesFpML_ird_17.class),
			factory.<CalculationPeriodDates>create(CalculationPeriodDatesFpML_ird_18.class),
			factory.<CalculationPeriodDates>create(CalculationPeriodDatesFpML_ird_20.class),
			factory.<CalculationPeriodDates>create(CalculationPeriodDatesFpML_ird_21.class),
			factory.<CalculationPeriodDates>create(CalculationPeriodDatesFpML_ird_22.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriodDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationPeriodDates> validator(ValidatorFactory factory) {
		return factory.<CalculationPeriodDates>create(CalculationPeriodDatesValidator.class);
	}

	@Override
	public Validator<? super CalculationPeriodDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationPeriodDates>create(CalculationPeriodDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriodDates> validator() {
		return new CalculationPeriodDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriodDates> typeFormatValidator() {
		return new CalculationPeriodDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriodDates, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodDatesOnlyExistsValidator();
	}
}
