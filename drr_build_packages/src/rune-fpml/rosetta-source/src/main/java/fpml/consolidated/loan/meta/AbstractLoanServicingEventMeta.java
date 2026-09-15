package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLoanServicingEvent;
import fpml.consolidated.loan.validation.AbstractLoanServicingEventTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractLoanServicingEventValidator;
import fpml.consolidated.loan.validation.exists.AbstractLoanServicingEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractLoanServicingEvent.class)
public class AbstractLoanServicingEventMeta implements RosettaMetaData<AbstractLoanServicingEvent> {

	@Override
	public List<Validator<? super AbstractLoanServicingEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanServicingEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractLoanServicingEvent> validator(ValidatorFactory factory) {
		return factory.<AbstractLoanServicingEvent>create(AbstractLoanServicingEventValidator.class);
	}

	@Override
	public Validator<? super AbstractLoanServicingEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractLoanServicingEvent>create(AbstractLoanServicingEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanServicingEvent> validator() {
		return new AbstractLoanServicingEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanServicingEvent> typeFormatValidator() {
		return new AbstractLoanServicingEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanServicingEvent, Set<String>> onlyExistsValidator() {
		return new AbstractLoanServicingEventOnlyExistsValidator();
	}
}
