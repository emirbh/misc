package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.EventsChoice;
import fpml.consolidated.business.events.validation.EventsChoiceTypeFormatValidator;
import fpml.consolidated.business.events.validation.EventsChoiceValidator;
import fpml.consolidated.business.events.validation.datarule.EventsChoiceChoice;
import fpml.consolidated.business.events.validation.exists.EventsChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EventsChoice.class)
public class EventsChoiceMeta implements RosettaMetaData<EventsChoice> {

	@Override
	public List<Validator<? super EventsChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EventsChoice>create(EventsChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EventsChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EventsChoice> validator(ValidatorFactory factory) {
		return factory.<EventsChoice>create(EventsChoiceValidator.class);
	}

	@Override
	public Validator<? super EventsChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EventsChoice>create(EventsChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EventsChoice> validator() {
		return new EventsChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EventsChoice> typeFormatValidator() {
		return new EventsChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventsChoice, Set<String>> onlyExistsValidator() {
		return new EventsChoiceOnlyExistsValidator();
	}
}
