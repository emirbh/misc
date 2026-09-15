package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationPayment;
import fpml.consolidated.loan.validation.LoanAllocationPaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationPaymentValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationPayment.class)
public class LoanAllocationPaymentMeta implements RosettaMetaData<LoanAllocationPayment> {

	@Override
	public List<Validator<? super LoanAllocationPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationPayment> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationPayment>create(LoanAllocationPaymentValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationPayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationPayment>create(LoanAllocationPaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationPayment> validator() {
		return new LoanAllocationPaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationPayment> typeFormatValidator() {
		return new LoanAllocationPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationPayment, Set<String>> onlyExistsValidator() {
		return new LoanAllocationPaymentOnlyExistsValidator();
	}
}
