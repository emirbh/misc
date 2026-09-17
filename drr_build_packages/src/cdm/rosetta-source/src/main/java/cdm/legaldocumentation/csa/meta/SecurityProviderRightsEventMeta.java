package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.SecurityProviderRightsEvent;
import cdm.legaldocumentation.csa.validation.SecurityProviderRightsEventTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.SecurityProviderRightsEventValidator;
import cdm.legaldocumentation.csa.validation.datarule.SecurityProviderRightsEventRightsEvent_customElection;
import cdm.legaldocumentation.csa.validation.datarule.SecurityProviderRightsEventRightsEvent_includeCoolingOffLanguage;
import cdm.legaldocumentation.csa.validation.exists.SecurityProviderRightsEventOnlyExistsValidator;
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
@RosettaMeta(model=SecurityProviderRightsEvent.class)
public class SecurityProviderRightsEventMeta implements RosettaMetaData<SecurityProviderRightsEvent> {

	@Override
	public List<Validator<? super SecurityProviderRightsEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SecurityProviderRightsEvent>create(SecurityProviderRightsEventRightsEvent_includeCoolingOffLanguage.class),
			factory.<SecurityProviderRightsEvent>create(SecurityProviderRightsEventRightsEvent_customElection.class)
		);
	}
	
	@Override
	public List<Function<? super SecurityProviderRightsEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecurityProviderRightsEvent> validator(ValidatorFactory factory) {
		return factory.<SecurityProviderRightsEvent>create(SecurityProviderRightsEventValidator.class);
	}

	@Override
	public Validator<? super SecurityProviderRightsEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecurityProviderRightsEvent>create(SecurityProviderRightsEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecurityProviderRightsEvent> validator() {
		return new SecurityProviderRightsEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SecurityProviderRightsEvent> typeFormatValidator() {
		return new SecurityProviderRightsEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecurityProviderRightsEvent, Set<String>> onlyExistsValidator() {
		return new SecurityProviderRightsEventOnlyExistsValidator();
	}
}
