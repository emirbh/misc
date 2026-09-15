package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.MiscFeePayment;
import fpml.consolidated.loan.validation.MiscFeePaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.MiscFeePaymentValidator;
import fpml.consolidated.loan.validation.datarule.MiscFeePaymentChoice;
import fpml.consolidated.loan.validation.exists.MiscFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MiscFeePayment.class)
public class MiscFeePaymentMeta implements RosettaMetaData<MiscFeePayment> {

	@Override
	public List<Validator<? super MiscFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MiscFeePayment>create(MiscFeePaymentChoice.class)
		);
	}
	
	@Override
	public List<Function<? super MiscFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MiscFeePayment> validator(ValidatorFactory factory) {
		return factory.<MiscFeePayment>create(MiscFeePaymentValidator.class);
	}

	@Override
	public Validator<? super MiscFeePayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MiscFeePayment>create(MiscFeePaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MiscFeePayment> validator() {
		return new MiscFeePaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MiscFeePayment> typeFormatValidator() {
		return new MiscFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MiscFeePayment, Set<String>> onlyExistsValidator() {
		return new MiscFeePaymentOnlyExistsValidator();
	}
}
