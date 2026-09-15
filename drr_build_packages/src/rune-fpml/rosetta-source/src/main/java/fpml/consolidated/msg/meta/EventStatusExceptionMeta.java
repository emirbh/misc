package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.EventStatusException;
import fpml.consolidated.msg.validation.EventStatusExceptionTypeFormatValidator;
import fpml.consolidated.msg.validation.EventStatusExceptionValidator;
import fpml.consolidated.msg.validation.exists.EventStatusExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EventStatusException.class)
public class EventStatusExceptionMeta implements RosettaMetaData<EventStatusException> {

	@Override
	public List<Validator<? super EventStatusException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventStatusException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EventStatusException> validator(ValidatorFactory factory) {
		return factory.<EventStatusException>create(EventStatusExceptionValidator.class);
	}

	@Override
	public Validator<? super EventStatusException> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EventStatusException>create(EventStatusExceptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EventStatusException> validator() {
		return new EventStatusExceptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EventStatusException> typeFormatValidator() {
		return new EventStatusExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventStatusException, Set<String>> onlyExistsValidator() {
		return new EventStatusExceptionOnlyExistsValidator();
	}
}
