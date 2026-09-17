package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.AdditionalRightsEvent;
import cdm.legaldocumentation.csa.validation.AdditionalRightsEventTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.AdditionalRightsEventValidator;
import cdm.legaldocumentation.csa.validation.datarule.AdditionalRightsEventQualification;
import cdm.legaldocumentation.csa.validation.exists.AdditionalRightsEventOnlyExistsValidator;
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
@RosettaMeta(model=AdditionalRightsEvent.class)
public class AdditionalRightsEventMeta implements RosettaMetaData<AdditionalRightsEvent> {

	@Override
	public List<Validator<? super AdditionalRightsEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AdditionalRightsEvent>create(AdditionalRightsEventQualification.class)
		);
	}
	
	@Override
	public List<Function<? super AdditionalRightsEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalRightsEvent> validator(ValidatorFactory factory) {
		return factory.<AdditionalRightsEvent>create(AdditionalRightsEventValidator.class);
	}

	@Override
	public Validator<? super AdditionalRightsEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdditionalRightsEvent>create(AdditionalRightsEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalRightsEvent> validator() {
		return new AdditionalRightsEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalRightsEvent> typeFormatValidator() {
		return new AdditionalRightsEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalRightsEvent, Set<String>> onlyExistsValidator() {
		return new AdditionalRightsEventOnlyExistsValidator();
	}
}
