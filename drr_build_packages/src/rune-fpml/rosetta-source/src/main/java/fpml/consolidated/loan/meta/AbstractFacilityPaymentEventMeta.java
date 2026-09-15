package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractFacilityPaymentEvent;
import fpml.consolidated.loan.validation.AbstractFacilityPaymentEventTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractFacilityPaymentEventValidator;
import fpml.consolidated.loan.validation.exists.AbstractFacilityPaymentEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractFacilityPaymentEvent.class)
public class AbstractFacilityPaymentEventMeta implements RosettaMetaData<AbstractFacilityPaymentEvent> {

	@Override
	public List<Validator<? super AbstractFacilityPaymentEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractFacilityPaymentEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractFacilityPaymentEvent> validator(ValidatorFactory factory) {
		return factory.<AbstractFacilityPaymentEvent>create(AbstractFacilityPaymentEventValidator.class);
	}

	@Override
	public Validator<? super AbstractFacilityPaymentEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractFacilityPaymentEvent>create(AbstractFacilityPaymentEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractFacilityPaymentEvent> validator() {
		return new AbstractFacilityPaymentEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractFacilityPaymentEvent> typeFormatValidator() {
		return new AbstractFacilityPaymentEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractFacilityPaymentEvent, Set<String>> onlyExistsValidator() {
		return new AbstractFacilityPaymentEventOnlyExistsValidator();
	}
}
