package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ConsentException;
import fpml.consolidated.confirmation.processes.validation.ConsentExceptionTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ConsentExceptionValidator;
import fpml.consolidated.confirmation.processes.validation.exists.ConsentExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ConsentException.class)
public class ConsentExceptionMeta implements RosettaMetaData<ConsentException> {

	@Override
	public List<Validator<? super ConsentException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ConsentException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConsentException> validator(ValidatorFactory factory) {
		return factory.<ConsentException>create(ConsentExceptionValidator.class);
	}

	@Override
	public Validator<? super ConsentException> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ConsentException>create(ConsentExceptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ConsentException> validator() {
		return new ConsentExceptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ConsentException> typeFormatValidator() {
		return new ConsentExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConsentException, Set<String>> onlyExistsValidator() {
		return new ConsentExceptionOnlyExistsValidator();
	}
}
