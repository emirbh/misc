package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLoanAllocationSettlementEvent;
import fpml.consolidated.loan.validation.AbstractLoanAllocationSettlementEventTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractLoanAllocationSettlementEventValidator;
import fpml.consolidated.loan.validation.exists.AbstractLoanAllocationSettlementEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractLoanAllocationSettlementEvent.class)
public class AbstractLoanAllocationSettlementEventMeta implements RosettaMetaData<AbstractLoanAllocationSettlementEvent> {

	@Override
	public List<Validator<? super AbstractLoanAllocationSettlementEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanAllocationSettlementEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractLoanAllocationSettlementEvent> validator(ValidatorFactory factory) {
		return factory.<AbstractLoanAllocationSettlementEvent>create(AbstractLoanAllocationSettlementEventValidator.class);
	}

	@Override
	public Validator<? super AbstractLoanAllocationSettlementEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractLoanAllocationSettlementEvent>create(AbstractLoanAllocationSettlementEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanAllocationSettlementEvent> validator() {
		return new AbstractLoanAllocationSettlementEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanAllocationSettlementEvent> typeFormatValidator() {
		return new AbstractLoanAllocationSettlementEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanAllocationSettlementEvent, Set<String>> onlyExistsValidator() {
		return new AbstractLoanAllocationSettlementEventOnlyExistsValidator();
	}
}
