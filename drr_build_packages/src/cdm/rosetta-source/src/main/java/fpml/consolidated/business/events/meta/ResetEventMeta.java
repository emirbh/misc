package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ResetEvent;
import fpml.consolidated.business.events.validation.ResetEventTypeFormatValidator;
import fpml.consolidated.business.events.validation.ResetEventValidator;
import fpml.consolidated.business.events.validation.exists.ResetEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ResetEvent.class)
public class ResetEventMeta implements RosettaMetaData<ResetEvent> {

	@Override
	public List<Validator<? super ResetEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResetEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ResetEvent> validator(ValidatorFactory factory) {
		return factory.<ResetEvent>create(ResetEventValidator.class);
	}

	@Override
	public Validator<? super ResetEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ResetEvent>create(ResetEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ResetEvent> validator() {
		return new ResetEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ResetEvent> typeFormatValidator() {
		return new ResetEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResetEvent, Set<String>> onlyExistsValidator() {
		return new ResetEventOnlyExistsValidator();
	}
}
