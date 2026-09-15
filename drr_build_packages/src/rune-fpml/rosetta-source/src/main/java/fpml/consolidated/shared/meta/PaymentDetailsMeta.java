package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PaymentDetails;
import fpml.consolidated.shared.validation.PaymentDetailsTypeFormatValidator;
import fpml.consolidated.shared.validation.PaymentDetailsValidator;
import fpml.consolidated.shared.validation.exists.PaymentDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PaymentDetails.class)
public class PaymentDetailsMeta implements RosettaMetaData<PaymentDetails> {

	@Override
	public List<Validator<? super PaymentDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaymentDetails> validator(ValidatorFactory factory) {
		return factory.<PaymentDetails>create(PaymentDetailsValidator.class);
	}

	@Override
	public Validator<? super PaymentDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PaymentDetails>create(PaymentDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PaymentDetails> validator() {
		return new PaymentDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PaymentDetails> typeFormatValidator() {
		return new PaymentDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentDetails, Set<String>> onlyExistsValidator() {
		return new PaymentDetailsOnlyExistsValidator();
	}
}
