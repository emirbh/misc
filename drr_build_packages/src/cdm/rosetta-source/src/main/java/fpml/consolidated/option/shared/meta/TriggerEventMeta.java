package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.TriggerEvent;
import fpml.consolidated.option.shared.validation.TriggerEventTypeFormatValidator;
import fpml.consolidated.option.shared.validation.TriggerEventValidator;
import fpml.consolidated.option.shared.validation.exists.TriggerEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TriggerEvent.class)
public class TriggerEventMeta implements RosettaMetaData<TriggerEvent> {

	@Override
	public List<Validator<? super TriggerEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TriggerEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TriggerEvent> validator(ValidatorFactory factory) {
		return factory.<TriggerEvent>create(TriggerEventValidator.class);
	}

	@Override
	public Validator<? super TriggerEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TriggerEvent>create(TriggerEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TriggerEvent> validator() {
		return new TriggerEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TriggerEvent> typeFormatValidator() {
		return new TriggerEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TriggerEvent, Set<String>> onlyExistsValidator() {
		return new TriggerEventOnlyExistsValidator();
	}
}
