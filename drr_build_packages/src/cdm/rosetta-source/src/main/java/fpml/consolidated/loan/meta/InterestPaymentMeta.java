package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.InterestPayment;
import fpml.consolidated.loan.validation.InterestPaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.InterestPaymentValidator;
import fpml.consolidated.loan.validation.exists.InterestPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InterestPayment.class)
public class InterestPaymentMeta implements RosettaMetaData<InterestPayment> {

	@Override
	public List<Validator<? super InterestPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestPayment> validator(ValidatorFactory factory) {
		return factory.<InterestPayment>create(InterestPaymentValidator.class);
	}

	@Override
	public Validator<? super InterestPayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestPayment>create(InterestPaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestPayment> validator() {
		return new InterestPaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestPayment> typeFormatValidator() {
		return new InterestPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestPayment, Set<String>> onlyExistsValidator() {
		return new InterestPaymentOnlyExistsValidator();
	}
}
