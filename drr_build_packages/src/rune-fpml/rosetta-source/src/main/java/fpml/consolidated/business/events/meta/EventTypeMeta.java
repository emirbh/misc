package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.EventType;
import fpml.consolidated.business.events.validation.EventTypeTypeFormatValidator;
import fpml.consolidated.business.events.validation.EventTypeValidator;
import fpml.consolidated.business.events.validation.exists.EventTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EventType.class)
public class EventTypeMeta implements RosettaMetaData<EventType> {

	@Override
	public List<Validator<? super EventType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EventType> validator(ValidatorFactory factory) {
		return factory.<EventType>create(EventTypeValidator.class);
	}

	@Override
	public Validator<? super EventType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EventType>create(EventTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EventType> validator() {
		return new EventTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EventType> typeFormatValidator() {
		return new EventTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventType, Set<String>> onlyExistsValidator() {
		return new EventTypeOnlyExistsValidator();
	}
}
