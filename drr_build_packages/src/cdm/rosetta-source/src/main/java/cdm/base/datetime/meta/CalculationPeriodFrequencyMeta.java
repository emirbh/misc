package cdm.base.datetime.meta;

import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.Frequency;
import cdm.base.datetime.validation.CalculationPeriodFrequencyTypeFormatValidator;
import cdm.base.datetime.validation.CalculationPeriodFrequencyValidator;
import cdm.base.datetime.validation.datarule.CalculationPeriodFrequencyFpML_ird_57;
import cdm.base.datetime.validation.datarule.CalculationPeriodFrequencyFpML_ird_58;
import cdm.base.datetime.validation.datarule.CalculationPeriodFrequencyFpML_ird_60;
import cdm.base.datetime.validation.datarule.FrequencyPositivePeriodMultiplier;
import cdm.base.datetime.validation.datarule.FrequencyTermPeriod;
import cdm.base.datetime.validation.exists.CalculationPeriodFrequencyOnlyExistsValidator;
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
@RosettaMeta(model=CalculationPeriodFrequency.class)
public class CalculationPeriodFrequencyMeta implements RosettaMetaData<CalculationPeriodFrequency> {

	@Override
	public List<Validator<? super CalculationPeriodFrequency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Frequency>create(FrequencyTermPeriod.class),
			factory.<Frequency>create(FrequencyPositivePeriodMultiplier.class),
			factory.<CalculationPeriodFrequency>create(CalculationPeriodFrequencyFpML_ird_57.class),
			factory.<CalculationPeriodFrequency>create(CalculationPeriodFrequencyFpML_ird_58.class),
			factory.<CalculationPeriodFrequency>create(CalculationPeriodFrequencyFpML_ird_60.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriodFrequency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationPeriodFrequency> validator(ValidatorFactory factory) {
		return factory.<CalculationPeriodFrequency>create(CalculationPeriodFrequencyValidator.class);
	}

	@Override
	public Validator<? super CalculationPeriodFrequency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationPeriodFrequency>create(CalculationPeriodFrequencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriodFrequency> validator() {
		return new CalculationPeriodFrequencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationPeriodFrequency> typeFormatValidator() {
		return new CalculationPeriodFrequencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriodFrequency, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodFrequencyOnlyExistsValidator();
	}
}
