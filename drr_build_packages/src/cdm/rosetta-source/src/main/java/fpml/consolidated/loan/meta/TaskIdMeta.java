package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.TaskId;
import fpml.consolidated.loan.validation.TaskIdTypeFormatValidator;
import fpml.consolidated.loan.validation.TaskIdValidator;
import fpml.consolidated.loan.validation.exists.TaskIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TaskId.class)
public class TaskIdMeta implements RosettaMetaData<TaskId> {

	@Override
	public List<Validator<? super TaskId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TaskId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TaskId> validator(ValidatorFactory factory) {
		return factory.<TaskId>create(TaskIdValidator.class);
	}

	@Override
	public Validator<? super TaskId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TaskId>create(TaskIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TaskId> validator() {
		return new TaskIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TaskId> typeFormatValidator() {
		return new TaskIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TaskId, Set<String>> onlyExistsValidator() {
		return new TaskIdOnlyExistsValidator();
	}
}
