package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FundingFeePayment;
import fpml.consolidated.loan.validation.FundingFeePaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.FundingFeePaymentValidator;
import fpml.consolidated.loan.validation.exists.FundingFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FundingFeePayment.class)
public class FundingFeePaymentMeta implements RosettaMetaData<FundingFeePayment> {

	@Override
	public List<Validator<? super FundingFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FundingFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FundingFeePayment> validator(ValidatorFactory factory) {
		return factory.<FundingFeePayment>create(FundingFeePaymentValidator.class);
	}

	@Override
	public Validator<? super FundingFeePayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FundingFeePayment>create(FundingFeePaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FundingFeePayment> validator() {
		return new FundingFeePaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FundingFeePayment> typeFormatValidator() {
		return new FundingFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FundingFeePayment, Set<String>> onlyExistsValidator() {
		return new FundingFeePaymentOnlyExistsValidator();
	}
}
