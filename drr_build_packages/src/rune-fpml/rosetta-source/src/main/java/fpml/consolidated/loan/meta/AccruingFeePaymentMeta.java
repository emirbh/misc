package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AccruingFeePayment;
import fpml.consolidated.loan.validation.AccruingFeePaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.AccruingFeePaymentValidator;
import fpml.consolidated.loan.validation.exists.AccruingFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AccruingFeePayment.class)
public class AccruingFeePaymentMeta implements RosettaMetaData<AccruingFeePayment> {

	@Override
	public List<Validator<? super AccruingFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AccruingFeePayment> validator(ValidatorFactory factory) {
		return factory.<AccruingFeePayment>create(AccruingFeePaymentValidator.class);
	}

	@Override
	public Validator<? super AccruingFeePayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AccruingFeePayment>create(AccruingFeePaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AccruingFeePayment> validator() {
		return new AccruingFeePaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AccruingFeePayment> typeFormatValidator() {
		return new AccruingFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingFeePayment, Set<String>> onlyExistsValidator() {
		return new AccruingFeePaymentOnlyExistsValidator();
	}
}
