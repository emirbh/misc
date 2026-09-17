package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.FloatingAmountEvents;
import fpml.consolidated.cd.validation.FloatingAmountEventsTypeFormatValidator;
import fpml.consolidated.cd.validation.FloatingAmountEventsValidator;
import fpml.consolidated.cd.validation.exists.FloatingAmountEventsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FloatingAmountEvents.class)
public class FloatingAmountEventsMeta implements RosettaMetaData<FloatingAmountEvents> {

	@Override
	public List<Validator<? super FloatingAmountEvents>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingAmountEvents, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingAmountEvents> validator(ValidatorFactory factory) {
		return factory.<FloatingAmountEvents>create(FloatingAmountEventsValidator.class);
	}

	@Override
	public Validator<? super FloatingAmountEvents> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingAmountEvents>create(FloatingAmountEventsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingAmountEvents> validator() {
		return new FloatingAmountEventsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingAmountEvents> typeFormatValidator() {
		return new FloatingAmountEventsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingAmountEvents, Set<String>> onlyExistsValidator() {
		return new FloatingAmountEventsOnlyExistsValidator();
	}
}
