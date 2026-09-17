package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationTransferFeeOwed;
import fpml.consolidated.loan.validation.LoanAllocationTransferFeeOwedTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationTransferFeeOwedValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationTransferFeeOwedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationTransferFeeOwed.class)
public class LoanAllocationTransferFeeOwedMeta implements RosettaMetaData<LoanAllocationTransferFeeOwed> {

	@Override
	public List<Validator<? super LoanAllocationTransferFeeOwed>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationTransferFeeOwed, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationTransferFeeOwed> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationTransferFeeOwed>create(LoanAllocationTransferFeeOwedValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationTransferFeeOwed> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationTransferFeeOwed>create(LoanAllocationTransferFeeOwedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationTransferFeeOwed> validator() {
		return new LoanAllocationTransferFeeOwedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationTransferFeeOwed> typeFormatValidator() {
		return new LoanAllocationTransferFeeOwedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationTransferFeeOwed, Set<String>> onlyExistsValidator() {
		return new LoanAllocationTransferFeeOwedOnlyExistsValidator();
	}
}
