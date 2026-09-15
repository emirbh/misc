package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.validation.ExceptionTypeFormatValidator;
import fpml.consolidated.msg.validation.ExceptionValidator;
import fpml.consolidated.msg.validation.exists.ExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=fpml.consolidated.msg.Exception.class)
public class ExceptionMeta implements RosettaMetaData<fpml.consolidated.msg.Exception> {

	@Override
	public List<Validator<? super fpml.consolidated.msg.Exception>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super fpml.consolidated.msg.Exception, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super fpml.consolidated.msg.Exception> validator(ValidatorFactory factory) {
		return factory.<fpml.consolidated.msg.Exception>create(ExceptionValidator.class);
	}

	@Override
	public Validator<? super fpml.consolidated.msg.Exception> typeFormatValidator(ValidatorFactory factory) {
		return factory.<fpml.consolidated.msg.Exception>create(ExceptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super fpml.consolidated.msg.Exception> validator() {
		return new ExceptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super fpml.consolidated.msg.Exception> typeFormatValidator() {
		return new ExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super fpml.consolidated.msg.Exception, Set<String>> onlyExistsValidator() {
		return new ExceptionOnlyExistsValidator();
	}
}
