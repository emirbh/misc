package cdm.product.template.meta;

import cdm.product.template.EarlyTerminationEvent;
import cdm.product.template.validation.EarlyTerminationEventTypeFormatValidator;
import cdm.product.template.validation.EarlyTerminationEventValidator;
import cdm.product.template.validation.datarule.EarlyTerminationEventFpML_ird_39;
import cdm.product.template.validation.datarule.EarlyTerminationEventFpML_ird_40;
import cdm.product.template.validation.datarule.EarlyTerminationEventFpML_ird_41;
import cdm.product.template.validation.exists.EarlyTerminationEventOnlyExistsValidator;
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
@RosettaMeta(model=EarlyTerminationEvent.class)
public class EarlyTerminationEventMeta implements RosettaMetaData<EarlyTerminationEvent> {

	@Override
	public List<Validator<? super EarlyTerminationEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EarlyTerminationEvent>create(EarlyTerminationEventFpML_ird_39.class),
			factory.<EarlyTerminationEvent>create(EarlyTerminationEventFpML_ird_40.class),
			factory.<EarlyTerminationEvent>create(EarlyTerminationEventFpML_ird_41.class)
		);
	}
	
	@Override
	public List<Function<? super EarlyTerminationEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EarlyTerminationEvent> validator(ValidatorFactory factory) {
		return factory.<EarlyTerminationEvent>create(EarlyTerminationEventValidator.class);
	}

	@Override
	public Validator<? super EarlyTerminationEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EarlyTerminationEvent>create(EarlyTerminationEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EarlyTerminationEvent> validator() {
		return new EarlyTerminationEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EarlyTerminationEvent> typeFormatValidator() {
		return new EarlyTerminationEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EarlyTerminationEvent, Set<String>> onlyExistsValidator() {
		return new EarlyTerminationEventOnlyExistsValidator();
	}
}
