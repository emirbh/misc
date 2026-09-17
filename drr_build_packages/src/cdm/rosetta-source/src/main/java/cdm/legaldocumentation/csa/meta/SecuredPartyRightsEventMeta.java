package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.SecuredPartyRightsEvent;
import cdm.legaldocumentation.csa.validation.SecuredPartyRightsEventTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.SecuredPartyRightsEventValidator;
import cdm.legaldocumentation.csa.validation.datarule.SecuredPartyRightsEventFailureToPayLanguage;
import cdm.legaldocumentation.csa.validation.exists.SecuredPartyRightsEventOnlyExistsValidator;
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
@RosettaMeta(model=SecuredPartyRightsEvent.class)
public class SecuredPartyRightsEventMeta implements RosettaMetaData<SecuredPartyRightsEvent> {

	@Override
	public List<Validator<? super SecuredPartyRightsEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SecuredPartyRightsEvent>create(SecuredPartyRightsEventFailureToPayLanguage.class)
		);
	}
	
	@Override
	public List<Function<? super SecuredPartyRightsEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecuredPartyRightsEvent> validator(ValidatorFactory factory) {
		return factory.<SecuredPartyRightsEvent>create(SecuredPartyRightsEventValidator.class);
	}

	@Override
	public Validator<? super SecuredPartyRightsEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecuredPartyRightsEvent>create(SecuredPartyRightsEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecuredPartyRightsEvent> validator() {
		return new SecuredPartyRightsEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SecuredPartyRightsEvent> typeFormatValidator() {
		return new SecuredPartyRightsEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecuredPartyRightsEvent, Set<String>> onlyExistsValidator() {
		return new SecuredPartyRightsEventOnlyExistsValidator();
	}
}
