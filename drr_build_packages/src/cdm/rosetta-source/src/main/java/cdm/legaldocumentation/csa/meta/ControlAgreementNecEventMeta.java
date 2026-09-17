package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ControlAgreementNecEvent;
import cdm.legaldocumentation.csa.validation.ControlAgreementNecEventTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ControlAgreementNecEventValidator;
import cdm.legaldocumentation.csa.validation.exists.ControlAgreementNecEventOnlyExistsValidator;
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
@RosettaMeta(model=ControlAgreementNecEvent.class)
public class ControlAgreementNecEventMeta implements RosettaMetaData<ControlAgreementNecEvent> {

	@Override
	public List<Validator<? super ControlAgreementNecEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ControlAgreementNecEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ControlAgreementNecEvent> validator(ValidatorFactory factory) {
		return factory.<ControlAgreementNecEvent>create(ControlAgreementNecEventValidator.class);
	}

	@Override
	public Validator<? super ControlAgreementNecEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ControlAgreementNecEvent>create(ControlAgreementNecEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ControlAgreementNecEvent> validator() {
		return new ControlAgreementNecEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ControlAgreementNecEvent> typeFormatValidator() {
		return new ControlAgreementNecEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ControlAgreementNecEvent, Set<String>> onlyExistsValidator() {
		return new ControlAgreementNecEventOnlyExistsValidator();
	}
}
