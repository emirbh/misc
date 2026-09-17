package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationEvent;
import fpml.consolidated.loan.validation.LoanAllocationEventTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationEventValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationEvent.class)
public class LoanAllocationEventMeta implements RosettaMetaData<LoanAllocationEvent> {

	@Override
	public List<Validator<? super LoanAllocationEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationEvent> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationEvent>create(LoanAllocationEventValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationEvent>create(LoanAllocationEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationEvent> validator() {
		return new LoanAllocationEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationEvent> typeFormatValidator() {
		return new LoanAllocationEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationEvent, Set<String>> onlyExistsValidator() {
		return new LoanAllocationEventOnlyExistsValidator();
	}
}
