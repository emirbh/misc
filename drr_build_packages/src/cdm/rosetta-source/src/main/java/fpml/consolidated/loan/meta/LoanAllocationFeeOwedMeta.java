package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationFeeOwed;
import fpml.consolidated.loan.validation.LoanAllocationFeeOwedTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationFeeOwedValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationFeeOwedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationFeeOwed.class)
public class LoanAllocationFeeOwedMeta implements RosettaMetaData<LoanAllocationFeeOwed> {

	@Override
	public List<Validator<? super LoanAllocationFeeOwed>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationFeeOwed, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationFeeOwed> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationFeeOwed>create(LoanAllocationFeeOwedValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationFeeOwed> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationFeeOwed>create(LoanAllocationFeeOwedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationFeeOwed> validator() {
		return new LoanAllocationFeeOwedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationFeeOwed> typeFormatValidator() {
		return new LoanAllocationFeeOwedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationFeeOwed, Set<String>> onlyExistsValidator() {
		return new LoanAllocationFeeOwedOnlyExistsValidator();
	}
}
