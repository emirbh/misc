package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LegacyLoanInterestPayment;
import fpml.consolidated.loan.validation.LegacyLoanInterestPaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.LegacyLoanInterestPaymentValidator;
import fpml.consolidated.loan.validation.exists.LegacyLoanInterestPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LegacyLoanInterestPayment.class)
public class LegacyLoanInterestPaymentMeta implements RosettaMetaData<LegacyLoanInterestPayment> {

	@Override
	public List<Validator<? super LegacyLoanInterestPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegacyLoanInterestPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyLoanInterestPayment> validator(ValidatorFactory factory) {
		return factory.<LegacyLoanInterestPayment>create(LegacyLoanInterestPaymentValidator.class);
	}

	@Override
	public Validator<? super LegacyLoanInterestPayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyLoanInterestPayment>create(LegacyLoanInterestPaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyLoanInterestPayment> validator() {
		return new LegacyLoanInterestPaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyLoanInterestPayment> typeFormatValidator() {
		return new LegacyLoanInterestPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyLoanInterestPayment, Set<String>> onlyExistsValidator() {
		return new LegacyLoanInterestPaymentOnlyExistsValidator();
	}
}
