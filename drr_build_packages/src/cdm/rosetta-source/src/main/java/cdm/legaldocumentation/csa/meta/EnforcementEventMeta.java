package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.EnforcementEvent;
import cdm.legaldocumentation.csa.validation.EnforcementEventTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.EnforcementEventValidator;
import cdm.legaldocumentation.csa.validation.exists.EnforcementEventOnlyExistsValidator;
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
@RosettaMeta(model=EnforcementEvent.class)
public class EnforcementEventMeta implements RosettaMetaData<EnforcementEvent> {

	@Override
	public List<Validator<? super EnforcementEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnforcementEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnforcementEvent> validator(ValidatorFactory factory) {
		return factory.<EnforcementEvent>create(EnforcementEventValidator.class);
	}

	@Override
	public Validator<? super EnforcementEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnforcementEvent>create(EnforcementEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnforcementEvent> validator() {
		return new EnforcementEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EnforcementEvent> typeFormatValidator() {
		return new EnforcementEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnforcementEvent, Set<String>> onlyExistsValidator() {
		return new EnforcementEventOnlyExistsValidator();
	}
}
