package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilityPrepaymentFeePayment;
import fpml.consolidated.loan.validation.FacilityPrepaymentFeePaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.FacilityPrepaymentFeePaymentValidator;
import fpml.consolidated.loan.validation.exists.FacilityPrepaymentFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FacilityPrepaymentFeePayment.class)
public class FacilityPrepaymentFeePaymentMeta implements RosettaMetaData<FacilityPrepaymentFeePayment> {

	@Override
	public List<Validator<? super FacilityPrepaymentFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityPrepaymentFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FacilityPrepaymentFeePayment> validator(ValidatorFactory factory) {
		return factory.<FacilityPrepaymentFeePayment>create(FacilityPrepaymentFeePaymentValidator.class);
	}

	@Override
	public Validator<? super FacilityPrepaymentFeePayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FacilityPrepaymentFeePayment>create(FacilityPrepaymentFeePaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FacilityPrepaymentFeePayment> validator() {
		return new FacilityPrepaymentFeePaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FacilityPrepaymentFeePayment> typeFormatValidator() {
		return new FacilityPrepaymentFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityPrepaymentFeePayment, Set<String>> onlyExistsValidator() {
		return new FacilityPrepaymentFeePaymentOnlyExistsValidator();
	}
}
