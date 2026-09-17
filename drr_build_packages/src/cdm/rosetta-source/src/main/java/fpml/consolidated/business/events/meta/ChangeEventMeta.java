package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ChangeEvent;
import fpml.consolidated.business.events.validation.ChangeEventTypeFormatValidator;
import fpml.consolidated.business.events.validation.ChangeEventValidator;
import fpml.consolidated.business.events.validation.exists.ChangeEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ChangeEvent.class)
public class ChangeEventMeta implements RosettaMetaData<ChangeEvent> {

	@Override
	public List<Validator<? super ChangeEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ChangeEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ChangeEvent> validator(ValidatorFactory factory) {
		return factory.<ChangeEvent>create(ChangeEventValidator.class);
	}

	@Override
	public Validator<? super ChangeEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ChangeEvent>create(ChangeEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ChangeEvent> validator() {
		return new ChangeEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ChangeEvent> typeFormatValidator() {
		return new ChangeEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ChangeEvent, Set<String>> onlyExistsValidator() {
		return new ChangeEventOnlyExistsValidator();
	}
}
