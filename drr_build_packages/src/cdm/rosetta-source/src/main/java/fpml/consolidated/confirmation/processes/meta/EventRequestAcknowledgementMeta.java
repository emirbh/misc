package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.EventRequestAcknowledgement;
import fpml.consolidated.confirmation.processes.validation.EventRequestAcknowledgementTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.EventRequestAcknowledgementValidator;
import fpml.consolidated.confirmation.processes.validation.exists.EventRequestAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EventRequestAcknowledgement.class)
public class EventRequestAcknowledgementMeta implements RosettaMetaData<EventRequestAcknowledgement> {

	@Override
	public List<Validator<? super EventRequestAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventRequestAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EventRequestAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<EventRequestAcknowledgement>create(EventRequestAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super EventRequestAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EventRequestAcknowledgement>create(EventRequestAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EventRequestAcknowledgement> validator() {
		return new EventRequestAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EventRequestAcknowledgement> typeFormatValidator() {
		return new EventRequestAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventRequestAcknowledgement, Set<String>> onlyExistsValidator() {
		return new EventRequestAcknowledgementOnlyExistsValidator();
	}
}
