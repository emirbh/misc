package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PaymentReference;
import fpml.consolidated.shared.validation.PaymentReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.PaymentReferenceValidator;
import fpml.consolidated.shared.validation.exists.PaymentReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PaymentReference.class)
public class PaymentReferenceMeta implements RosettaMetaData<PaymentReference> {

	@Override
	public List<Validator<? super PaymentReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaymentReference> validator(ValidatorFactory factory) {
		return factory.<PaymentReference>create(PaymentReferenceValidator.class);
	}

	@Override
	public Validator<? super PaymentReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PaymentReference>create(PaymentReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PaymentReference> validator() {
		return new PaymentReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PaymentReference> typeFormatValidator() {
		return new PaymentReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentReference, Set<String>> onlyExistsValidator() {
		return new PaymentReferenceOnlyExistsValidator();
	}
}
