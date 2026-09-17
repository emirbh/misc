package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLoanContractEvent;
import fpml.consolidated.loan.validation.AbstractLoanContractEventTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractLoanContractEventValidator;
import fpml.consolidated.loan.validation.exists.AbstractLoanContractEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractLoanContractEvent.class)
public class AbstractLoanContractEventMeta implements RosettaMetaData<AbstractLoanContractEvent> {

	@Override
	public List<Validator<? super AbstractLoanContractEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanContractEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractLoanContractEvent> validator(ValidatorFactory factory) {
		return factory.<AbstractLoanContractEvent>create(AbstractLoanContractEventValidator.class);
	}

	@Override
	public Validator<? super AbstractLoanContractEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractLoanContractEvent>create(AbstractLoanContractEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanContractEvent> validator() {
		return new AbstractLoanContractEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanContractEvent> typeFormatValidator() {
		return new AbstractLoanContractEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanContractEvent, Set<String>> onlyExistsValidator() {
		return new AbstractLoanContractEventOnlyExistsValidator();
	}
}
