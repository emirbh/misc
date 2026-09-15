package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationTransferFeeDue;
import fpml.consolidated.loan.validation.LoanAllocationTransferFeeDueTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationTransferFeeDueValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationTransferFeeDueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationTransferFeeDue.class)
public class LoanAllocationTransferFeeDueMeta implements RosettaMetaData<LoanAllocationTransferFeeDue> {

	@Override
	public List<Validator<? super LoanAllocationTransferFeeDue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationTransferFeeDue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationTransferFeeDue> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationTransferFeeDue>create(LoanAllocationTransferFeeDueValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationTransferFeeDue> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationTransferFeeDue>create(LoanAllocationTransferFeeDueTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationTransferFeeDue> validator() {
		return new LoanAllocationTransferFeeDueValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationTransferFeeDue> typeFormatValidator() {
		return new LoanAllocationTransferFeeDueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationTransferFeeDue, Set<String>> onlyExistsValidator() {
		return new LoanAllocationTransferFeeDueOnlyExistsValidator();
	}
}
