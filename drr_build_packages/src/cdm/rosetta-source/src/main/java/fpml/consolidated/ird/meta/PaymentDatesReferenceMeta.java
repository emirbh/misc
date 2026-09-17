package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.PaymentDatesReference;
import fpml.consolidated.ird.validation.PaymentDatesReferenceTypeFormatValidator;
import fpml.consolidated.ird.validation.PaymentDatesReferenceValidator;
import fpml.consolidated.ird.validation.exists.PaymentDatesReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PaymentDatesReference.class)
public class PaymentDatesReferenceMeta implements RosettaMetaData<PaymentDatesReference> {

	@Override
	public List<Validator<? super PaymentDatesReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentDatesReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaymentDatesReference> validator(ValidatorFactory factory) {
		return factory.<PaymentDatesReference>create(PaymentDatesReferenceValidator.class);
	}

	@Override
	public Validator<? super PaymentDatesReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PaymentDatesReference>create(PaymentDatesReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PaymentDatesReference> validator() {
		return new PaymentDatesReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PaymentDatesReference> typeFormatValidator() {
		return new PaymentDatesReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentDatesReference, Set<String>> onlyExistsValidator() {
		return new PaymentDatesReferenceOnlyExistsValidator();
	}
}
