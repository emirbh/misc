package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.TaskIdentifier;
import fpml.consolidated.loan.validation.TaskIdentifierTypeFormatValidator;
import fpml.consolidated.loan.validation.TaskIdentifierValidator;
import fpml.consolidated.loan.validation.datarule.TaskIdentifierChoice;
import fpml.consolidated.loan.validation.exists.TaskIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TaskIdentifier.class)
public class TaskIdentifierMeta implements RosettaMetaData<TaskIdentifier> {

	@Override
	public List<Validator<? super TaskIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TaskIdentifier>create(TaskIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TaskIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TaskIdentifier> validator(ValidatorFactory factory) {
		return factory.<TaskIdentifier>create(TaskIdentifierValidator.class);
	}

	@Override
	public Validator<? super TaskIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TaskIdentifier>create(TaskIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TaskIdentifier> validator() {
		return new TaskIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TaskIdentifier> typeFormatValidator() {
		return new TaskIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TaskIdentifier, Set<String>> onlyExistsValidator() {
		return new TaskIdentifierOnlyExistsValidator();
	}
}
