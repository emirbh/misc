package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.AdditionalTerminationEvent;
import cdm.legaldocumentation.csa.validation.AdditionalTerminationEventTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.AdditionalTerminationEventValidator;
import cdm.legaldocumentation.csa.validation.exists.AdditionalTerminationEventOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=AdditionalTerminationEvent.class)
public class AdditionalTerminationEventMeta implements RosettaMetaData<AdditionalTerminationEvent> {

	@Override
	public List<Validator<? super AdditionalTerminationEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdditionalTerminationEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalTerminationEvent> validator(ValidatorFactory factory) {
		return factory.<AdditionalTerminationEvent>create(AdditionalTerminationEventValidator.class);
	}

	@Override
	public Validator<? super AdditionalTerminationEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdditionalTerminationEvent>create(AdditionalTerminationEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalTerminationEvent> validator() {
		return new AdditionalTerminationEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalTerminationEvent> typeFormatValidator() {
		return new AdditionalTerminationEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalTerminationEvent, Set<String>> onlyExistsValidator() {
		return new AdditionalTerminationEventOnlyExistsValidator();
	}
}
