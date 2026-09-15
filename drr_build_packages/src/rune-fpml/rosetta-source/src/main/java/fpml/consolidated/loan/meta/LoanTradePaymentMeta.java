package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradePayment;
import fpml.consolidated.loan.validation.LoanTradePaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradePaymentValidator;
import fpml.consolidated.loan.validation.exists.LoanTradePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradePayment.class)
public class LoanTradePaymentMeta implements RosettaMetaData<LoanTradePayment> {

	@Override
	public List<Validator<? super LoanTradePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradePayment> validator(ValidatorFactory factory) {
		return factory.<LoanTradePayment>create(LoanTradePaymentValidator.class);
	}

	@Override
	public Validator<? super LoanTradePayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradePayment>create(LoanTradePaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradePayment> validator() {
		return new LoanTradePaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradePayment> typeFormatValidator() {
		return new LoanTradePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradePayment, Set<String>> onlyExistsValidator() {
		return new LoanTradePaymentOnlyExistsValidator();
	}
}
