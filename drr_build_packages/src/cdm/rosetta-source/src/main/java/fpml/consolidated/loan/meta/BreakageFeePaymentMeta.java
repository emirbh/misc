package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.BreakageFeePayment;
import fpml.consolidated.loan.validation.BreakageFeePaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.BreakageFeePaymentValidator;
import fpml.consolidated.loan.validation.exists.BreakageFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BreakageFeePayment.class)
public class BreakageFeePaymentMeta implements RosettaMetaData<BreakageFeePayment> {

	@Override
	public List<Validator<? super BreakageFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BreakageFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BreakageFeePayment> validator(ValidatorFactory factory) {
		return factory.<BreakageFeePayment>create(BreakageFeePaymentValidator.class);
	}

	@Override
	public Validator<? super BreakageFeePayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BreakageFeePayment>create(BreakageFeePaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BreakageFeePayment> validator() {
		return new BreakageFeePaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BreakageFeePayment> typeFormatValidator() {
		return new BreakageFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BreakageFeePayment, Set<String>> onlyExistsValidator() {
		return new BreakageFeePaymentOnlyExistsValidator();
	}
}
