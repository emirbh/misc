package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CoalStandardQualitySchedule;
import fpml.consolidated.com.validation.CoalStandardQualityScheduleTypeFormatValidator;
import fpml.consolidated.com.validation.CoalStandardQualityScheduleValidator;
import fpml.consolidated.com.validation.datarule.CoalStandardQualityScheduleChoice;
import fpml.consolidated.com.validation.exists.CoalStandardQualityScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CoalStandardQualitySchedule.class)
public class CoalStandardQualityScheduleMeta implements RosettaMetaData<CoalStandardQualitySchedule> {

	@Override
	public List<Validator<? super CoalStandardQualitySchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CoalStandardQualitySchedule>create(CoalStandardQualityScheduleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CoalStandardQualitySchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CoalStandardQualitySchedule> validator(ValidatorFactory factory) {
		return factory.<CoalStandardQualitySchedule>create(CoalStandardQualityScheduleValidator.class);
	}

	@Override
	public Validator<? super CoalStandardQualitySchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CoalStandardQualitySchedule>create(CoalStandardQualityScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CoalStandardQualitySchedule> validator() {
		return new CoalStandardQualityScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CoalStandardQualitySchedule> typeFormatValidator() {
		return new CoalStandardQualityScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalStandardQualitySchedule, Set<String>> onlyExistsValidator() {
		return new CoalStandardQualityScheduleOnlyExistsValidator();
	}
}
