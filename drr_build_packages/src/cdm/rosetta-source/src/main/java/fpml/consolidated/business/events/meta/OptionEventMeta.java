package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.OptionEvent;
import fpml.consolidated.business.events.validation.OptionEventTypeFormatValidator;
import fpml.consolidated.business.events.validation.OptionEventValidator;
import fpml.consolidated.business.events.validation.datarule.OptionEventChoice0;
import fpml.consolidated.business.events.validation.datarule.OptionEventChoice1;
import fpml.consolidated.business.events.validation.exists.OptionEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OptionEvent.class)
public class OptionEventMeta implements RosettaMetaData<OptionEvent> {

	@Override
	public List<Validator<? super OptionEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OptionEvent>create(OptionEventChoice0.class),
			factory.<OptionEvent>create(OptionEventChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super OptionEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionEvent> validator(ValidatorFactory factory) {
		return factory.<OptionEvent>create(OptionEventValidator.class);
	}

	@Override
	public Validator<? super OptionEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionEvent>create(OptionEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionEvent> validator() {
		return new OptionEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionEvent> typeFormatValidator() {
		return new OptionEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionEvent, Set<String>> onlyExistsValidator() {
		return new OptionEventOnlyExistsValidator();
	}
}
