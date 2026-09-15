package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.EarlyTerminationEvent;
import fpml.consolidated.ird.validation.EarlyTerminationEventTypeFormatValidator;
import fpml.consolidated.ird.validation.EarlyTerminationEventValidator;
import fpml.consolidated.ird.validation.exists.EarlyTerminationEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EarlyTerminationEvent.class)
public class EarlyTerminationEventMeta implements RosettaMetaData<EarlyTerminationEvent> {

	@Override
	public List<Validator<? super EarlyTerminationEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EarlyTerminationEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EarlyTerminationEvent> validator(ValidatorFactory factory) {
		return factory.<EarlyTerminationEvent>create(EarlyTerminationEventValidator.class);
	}

	@Override
	public Validator<? super EarlyTerminationEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EarlyTerminationEvent>create(EarlyTerminationEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EarlyTerminationEvent> validator() {
		return new EarlyTerminationEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EarlyTerminationEvent> typeFormatValidator() {
		return new EarlyTerminationEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EarlyTerminationEvent, Set<String>> onlyExistsValidator() {
		return new EarlyTerminationEventOnlyExistsValidator();
	}
}
