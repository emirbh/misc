package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.NonNegativePayment;
import fpml.consolidated.shared.validation.NonNegativePaymentTypeFormatValidator;
import fpml.consolidated.shared.validation.NonNegativePaymentValidator;
import fpml.consolidated.shared.validation.exists.NonNegativePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NonNegativePayment.class)
public class NonNegativePaymentMeta implements RosettaMetaData<NonNegativePayment> {

	@Override
	public List<Validator<? super NonNegativePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonNegativePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonNegativePayment> validator(ValidatorFactory factory) {
		return factory.<NonNegativePayment>create(NonNegativePaymentValidator.class);
	}

	@Override
	public Validator<? super NonNegativePayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonNegativePayment>create(NonNegativePaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonNegativePayment> validator() {
		return new NonNegativePaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonNegativePayment> typeFormatValidator() {
		return new NonNegativePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonNegativePayment, Set<String>> onlyExistsValidator() {
		return new NonNegativePaymentOnlyExistsValidator();
	}
}
