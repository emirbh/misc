package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanSimplePayment;
import fpml.consolidated.loan.validation.LoanSimplePaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanSimplePaymentValidator;
import fpml.consolidated.loan.validation.exists.LoanSimplePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanSimplePayment.class)
public class LoanSimplePaymentMeta implements RosettaMetaData<LoanSimplePayment> {

	@Override
	public List<Validator<? super LoanSimplePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanSimplePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanSimplePayment> validator(ValidatorFactory factory) {
		return factory.<LoanSimplePayment>create(LoanSimplePaymentValidator.class);
	}

	@Override
	public Validator<? super LoanSimplePayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanSimplePayment>create(LoanSimplePaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanSimplePayment> validator() {
		return new LoanSimplePaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanSimplePayment> typeFormatValidator() {
		return new LoanSimplePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanSimplePayment, Set<String>> onlyExistsValidator() {
		return new LoanSimplePaymentOnlyExistsValidator();
	}
}
