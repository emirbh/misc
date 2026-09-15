package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.EventPaymentSequence;
import fpml.consolidated.loan.validation.EventPaymentSequenceTypeFormatValidator;
import fpml.consolidated.loan.validation.EventPaymentSequenceValidator;
import fpml.consolidated.loan.validation.exists.EventPaymentSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EventPaymentSequence.class)
public class EventPaymentSequenceMeta implements RosettaMetaData<EventPaymentSequence> {

	@Override
	public List<Validator<? super EventPaymentSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventPaymentSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EventPaymentSequence> validator(ValidatorFactory factory) {
		return factory.<EventPaymentSequence>create(EventPaymentSequenceValidator.class);
	}

	@Override
	public Validator<? super EventPaymentSequence> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EventPaymentSequence>create(EventPaymentSequenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EventPaymentSequence> validator() {
		return new EventPaymentSequenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EventPaymentSequence> typeFormatValidator() {
		return new EventPaymentSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventPaymentSequence, Set<String>> onlyExistsValidator() {
		return new EventPaymentSequenceOnlyExistsValidator();
	}
}
