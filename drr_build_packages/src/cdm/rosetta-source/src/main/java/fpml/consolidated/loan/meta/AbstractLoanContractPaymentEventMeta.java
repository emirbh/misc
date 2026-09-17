package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLoanContractPaymentEvent;
import fpml.consolidated.loan.validation.AbstractLoanContractPaymentEventTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractLoanContractPaymentEventValidator;
import fpml.consolidated.loan.validation.exists.AbstractLoanContractPaymentEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractLoanContractPaymentEvent.class)
public class AbstractLoanContractPaymentEventMeta implements RosettaMetaData<AbstractLoanContractPaymentEvent> {

	@Override
	public List<Validator<? super AbstractLoanContractPaymentEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanContractPaymentEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractLoanContractPaymentEvent> validator(ValidatorFactory factory) {
		return factory.<AbstractLoanContractPaymentEvent>create(AbstractLoanContractPaymentEventValidator.class);
	}

	@Override
	public Validator<? super AbstractLoanContractPaymentEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractLoanContractPaymentEvent>create(AbstractLoanContractPaymentEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanContractPaymentEvent> validator() {
		return new AbstractLoanContractPaymentEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanContractPaymentEvent> typeFormatValidator() {
		return new AbstractLoanContractPaymentEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanContractPaymentEvent, Set<String>> onlyExistsValidator() {
		return new AbstractLoanContractPaymentEventOnlyExistsValidator();
	}
}
