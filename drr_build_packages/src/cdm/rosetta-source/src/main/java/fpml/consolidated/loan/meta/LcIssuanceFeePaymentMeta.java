package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LcIssuanceFeePayment;
import fpml.consolidated.loan.validation.LcIssuanceFeePaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.LcIssuanceFeePaymentValidator;
import fpml.consolidated.loan.validation.exists.LcIssuanceFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LcIssuanceFeePayment.class)
public class LcIssuanceFeePaymentMeta implements RosettaMetaData<LcIssuanceFeePayment> {

	@Override
	public List<Validator<? super LcIssuanceFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcIssuanceFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LcIssuanceFeePayment> validator(ValidatorFactory factory) {
		return factory.<LcIssuanceFeePayment>create(LcIssuanceFeePaymentValidator.class);
	}

	@Override
	public Validator<? super LcIssuanceFeePayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LcIssuanceFeePayment>create(LcIssuanceFeePaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LcIssuanceFeePayment> validator() {
		return new LcIssuanceFeePaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LcIssuanceFeePayment> typeFormatValidator() {
		return new LcIssuanceFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcIssuanceFeePayment, Set<String>> onlyExistsValidator() {
		return new LcIssuanceFeePaymentOnlyExistsValidator();
	}
}
