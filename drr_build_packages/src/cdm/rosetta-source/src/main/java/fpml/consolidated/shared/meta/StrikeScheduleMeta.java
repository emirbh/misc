package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.StrikeSchedule;
import fpml.consolidated.shared.validation.StrikeScheduleTypeFormatValidator;
import fpml.consolidated.shared.validation.StrikeScheduleValidator;
import fpml.consolidated.shared.validation.exists.StrikeScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=StrikeSchedule.class)
public class StrikeScheduleMeta implements RosettaMetaData<StrikeSchedule> {

	@Override
	public List<Validator<? super StrikeSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StrikeSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super StrikeSchedule> validator(ValidatorFactory factory) {
		return factory.<StrikeSchedule>create(StrikeScheduleValidator.class);
	}

	@Override
	public Validator<? super StrikeSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<StrikeSchedule>create(StrikeScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super StrikeSchedule> validator() {
		return new StrikeScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super StrikeSchedule> typeFormatValidator() {
		return new StrikeScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StrikeSchedule, Set<String>> onlyExistsValidator() {
		return new StrikeScheduleOnlyExistsValidator();
	}
}
