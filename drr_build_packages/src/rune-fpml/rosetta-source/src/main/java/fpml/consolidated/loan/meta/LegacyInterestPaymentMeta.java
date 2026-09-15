package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LegacyInterestPayment;
import fpml.consolidated.loan.validation.LegacyInterestPaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.LegacyInterestPaymentValidator;
import fpml.consolidated.loan.validation.exists.LegacyInterestPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LegacyInterestPayment.class)
public class LegacyInterestPaymentMeta implements RosettaMetaData<LegacyInterestPayment> {

	@Override
	public List<Validator<? super LegacyInterestPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegacyInterestPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyInterestPayment> validator(ValidatorFactory factory) {
		return factory.<LegacyInterestPayment>create(LegacyInterestPaymentValidator.class);
	}

	@Override
	public Validator<? super LegacyInterestPayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyInterestPayment>create(LegacyInterestPaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyInterestPayment> validator() {
		return new LegacyInterestPaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyInterestPayment> typeFormatValidator() {
		return new LegacyInterestPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyInterestPayment, Set<String>> onlyExistsValidator() {
		return new LegacyInterestPaymentOnlyExistsValidator();
	}
}
