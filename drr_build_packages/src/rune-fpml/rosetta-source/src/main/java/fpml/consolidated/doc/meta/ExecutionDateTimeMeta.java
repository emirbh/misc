package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.validation.ExecutionDateTimeTypeFormatValidator;
import fpml.consolidated.doc.validation.ExecutionDateTimeValidator;
import fpml.consolidated.doc.validation.exists.ExecutionDateTimeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExecutionDateTime.class)
public class ExecutionDateTimeMeta implements RosettaMetaData<ExecutionDateTime> {

	@Override
	public List<Validator<? super ExecutionDateTime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExecutionDateTime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExecutionDateTime> validator(ValidatorFactory factory) {
		return factory.<ExecutionDateTime>create(ExecutionDateTimeValidator.class);
	}

	@Override
	public Validator<? super ExecutionDateTime> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExecutionDateTime>create(ExecutionDateTimeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionDateTime> validator() {
		return new ExecutionDateTimeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionDateTime> typeFormatValidator() {
		return new ExecutionDateTimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionDateTime, Set<String>> onlyExistsValidator() {
		return new ExecutionDateTimeOnlyExistsValidator();
	}
}
