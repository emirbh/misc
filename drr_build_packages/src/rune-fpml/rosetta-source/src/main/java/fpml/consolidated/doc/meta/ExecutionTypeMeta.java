package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.ExecutionType;
import fpml.consolidated.doc.validation.ExecutionTypeTypeFormatValidator;
import fpml.consolidated.doc.validation.ExecutionTypeValidator;
import fpml.consolidated.doc.validation.exists.ExecutionTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExecutionType.class)
public class ExecutionTypeMeta implements RosettaMetaData<ExecutionType> {

	@Override
	public List<Validator<? super ExecutionType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExecutionType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExecutionType> validator(ValidatorFactory factory) {
		return factory.<ExecutionType>create(ExecutionTypeValidator.class);
	}

	@Override
	public Validator<? super ExecutionType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExecutionType>create(ExecutionTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionType> validator() {
		return new ExecutionTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionType> typeFormatValidator() {
		return new ExecutionTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionType, Set<String>> onlyExistsValidator() {
		return new ExecutionTypeOnlyExistsValidator();
	}
}
