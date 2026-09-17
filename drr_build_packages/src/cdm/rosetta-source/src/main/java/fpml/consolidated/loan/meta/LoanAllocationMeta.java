package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocation;
import fpml.consolidated.loan.validation.LoanAllocationTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocation.class)
public class LoanAllocationMeta implements RosettaMetaData<LoanAllocation> {

	@Override
	public List<Validator<? super LoanAllocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocation> validator(ValidatorFactory factory) {
		return factory.<LoanAllocation>create(LoanAllocationValidator.class);
	}

	@Override
	public Validator<? super LoanAllocation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocation>create(LoanAllocationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocation> validator() {
		return new LoanAllocationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocation> typeFormatValidator() {
		return new LoanAllocationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocation, Set<String>> onlyExistsValidator() {
		return new LoanAllocationOnlyExistsValidator();
	}
}
