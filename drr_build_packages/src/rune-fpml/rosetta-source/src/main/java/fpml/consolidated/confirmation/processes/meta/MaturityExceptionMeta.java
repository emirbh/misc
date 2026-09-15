package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.MaturityException;
import fpml.consolidated.confirmation.processes.validation.MaturityExceptionTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.MaturityExceptionValidator;
import fpml.consolidated.confirmation.processes.validation.exists.MaturityExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MaturityException.class)
public class MaturityExceptionMeta implements RosettaMetaData<MaturityException> {

	@Override
	public List<Validator<? super MaturityException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MaturityException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MaturityException> validator(ValidatorFactory factory) {
		return factory.<MaturityException>create(MaturityExceptionValidator.class);
	}

	@Override
	public Validator<? super MaturityException> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MaturityException>create(MaturityExceptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MaturityException> validator() {
		return new MaturityExceptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MaturityException> typeFormatValidator() {
		return new MaturityExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MaturityException, Set<String>> onlyExistsValidator() {
		return new MaturityExceptionOnlyExistsValidator();
	}
}
