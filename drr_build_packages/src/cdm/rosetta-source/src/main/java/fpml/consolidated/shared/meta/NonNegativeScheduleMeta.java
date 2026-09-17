package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.NonNegativeSchedule;
import fpml.consolidated.shared.validation.NonNegativeScheduleTypeFormatValidator;
import fpml.consolidated.shared.validation.NonNegativeScheduleValidator;
import fpml.consolidated.shared.validation.exists.NonNegativeScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NonNegativeSchedule.class)
public class NonNegativeScheduleMeta implements RosettaMetaData<NonNegativeSchedule> {

	@Override
	public List<Validator<? super NonNegativeSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonNegativeSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonNegativeSchedule> validator(ValidatorFactory factory) {
		return factory.<NonNegativeSchedule>create(NonNegativeScheduleValidator.class);
	}

	@Override
	public Validator<? super NonNegativeSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonNegativeSchedule>create(NonNegativeScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonNegativeSchedule> validator() {
		return new NonNegativeScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonNegativeSchedule> typeFormatValidator() {
		return new NonNegativeScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonNegativeSchedule, Set<String>> onlyExistsValidator() {
		return new NonNegativeScheduleOnlyExistsValidator();
	}
}
