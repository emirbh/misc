package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ExerciseFeeSchedule;
import fpml.consolidated.shared.validation.ExerciseFeeScheduleTypeFormatValidator;
import fpml.consolidated.shared.validation.ExerciseFeeScheduleValidator;
import fpml.consolidated.shared.validation.datarule.ExerciseFeeScheduleChoice;
import fpml.consolidated.shared.validation.exists.ExerciseFeeScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExerciseFeeSchedule.class)
public class ExerciseFeeScheduleMeta implements RosettaMetaData<ExerciseFeeSchedule> {

	@Override
	public List<Validator<? super ExerciseFeeSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ExerciseFeeSchedule>create(ExerciseFeeScheduleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExerciseFeeSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExerciseFeeSchedule> validator(ValidatorFactory factory) {
		return factory.<ExerciseFeeSchedule>create(ExerciseFeeScheduleValidator.class);
	}

	@Override
	public Validator<? super ExerciseFeeSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExerciseFeeSchedule>create(ExerciseFeeScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExerciseFeeSchedule> validator() {
		return new ExerciseFeeScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExerciseFeeSchedule> typeFormatValidator() {
		return new ExerciseFeeScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExerciseFeeSchedule, Set<String>> onlyExistsValidator() {
		return new ExerciseFeeScheduleOnlyExistsValidator();
	}
}
