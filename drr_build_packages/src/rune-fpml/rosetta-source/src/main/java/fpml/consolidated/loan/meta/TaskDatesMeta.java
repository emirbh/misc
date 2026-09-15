package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.TaskDates;
import fpml.consolidated.loan.validation.TaskDatesTypeFormatValidator;
import fpml.consolidated.loan.validation.TaskDatesValidator;
import fpml.consolidated.loan.validation.exists.TaskDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TaskDates.class)
public class TaskDatesMeta implements RosettaMetaData<TaskDates> {

	@Override
	public List<Validator<? super TaskDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TaskDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TaskDates> validator(ValidatorFactory factory) {
		return factory.<TaskDates>create(TaskDatesValidator.class);
	}

	@Override
	public Validator<? super TaskDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TaskDates>create(TaskDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TaskDates> validator() {
		return new TaskDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TaskDates> typeFormatValidator() {
		return new TaskDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TaskDates, Set<String>> onlyExistsValidator() {
		return new TaskDatesOnlyExistsValidator();
	}
}
