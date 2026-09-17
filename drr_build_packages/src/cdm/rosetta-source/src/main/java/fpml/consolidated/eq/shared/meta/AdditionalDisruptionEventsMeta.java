package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.AdditionalDisruptionEvents;
import fpml.consolidated.eq.shared.validation.AdditionalDisruptionEventsTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.AdditionalDisruptionEventsValidator;
import fpml.consolidated.eq.shared.validation.exists.AdditionalDisruptionEventsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdditionalDisruptionEvents.class)
public class AdditionalDisruptionEventsMeta implements RosettaMetaData<AdditionalDisruptionEvents> {

	@Override
	public List<Validator<? super AdditionalDisruptionEvents>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdditionalDisruptionEvents, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalDisruptionEvents> validator(ValidatorFactory factory) {
		return factory.<AdditionalDisruptionEvents>create(AdditionalDisruptionEventsValidator.class);
	}

	@Override
	public Validator<? super AdditionalDisruptionEvents> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdditionalDisruptionEvents>create(AdditionalDisruptionEventsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalDisruptionEvents> validator() {
		return new AdditionalDisruptionEventsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalDisruptionEvents> typeFormatValidator() {
		return new AdditionalDisruptionEventsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalDisruptionEvents, Set<String>> onlyExistsValidator() {
		return new AdditionalDisruptionEventsOnlyExistsValidator();
	}
}
