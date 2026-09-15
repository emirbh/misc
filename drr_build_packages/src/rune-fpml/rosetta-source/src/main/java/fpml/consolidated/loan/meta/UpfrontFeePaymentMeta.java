package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.UpfrontFeePayment;
import fpml.consolidated.loan.validation.UpfrontFeePaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.UpfrontFeePaymentValidator;
import fpml.consolidated.loan.validation.exists.UpfrontFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=UpfrontFeePayment.class)
public class UpfrontFeePaymentMeta implements RosettaMetaData<UpfrontFeePayment> {

	@Override
	public List<Validator<? super UpfrontFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UpfrontFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UpfrontFeePayment> validator(ValidatorFactory factory) {
		return factory.<UpfrontFeePayment>create(UpfrontFeePaymentValidator.class);
	}

	@Override
	public Validator<? super UpfrontFeePayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<UpfrontFeePayment>create(UpfrontFeePaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super UpfrontFeePayment> validator() {
		return new UpfrontFeePaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super UpfrontFeePayment> typeFormatValidator() {
		return new UpfrontFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UpfrontFeePayment, Set<String>> onlyExistsValidator() {
		return new UpfrontFeePaymentOnlyExistsValidator();
	}
}
