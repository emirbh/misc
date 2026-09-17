package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.SimplePayment;
import fpml.consolidated.shared.validation.SimplePaymentTypeFormatValidator;
import fpml.consolidated.shared.validation.SimplePaymentValidator;
import fpml.consolidated.shared.validation.exists.SimplePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SimplePayment.class)
public class SimplePaymentMeta implements RosettaMetaData<SimplePayment> {

	@Override
	public List<Validator<? super SimplePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SimplePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SimplePayment> validator(ValidatorFactory factory) {
		return factory.<SimplePayment>create(SimplePaymentValidator.class);
	}

	@Override
	public Validator<? super SimplePayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SimplePayment>create(SimplePaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SimplePayment> validator() {
		return new SimplePaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SimplePayment> typeFormatValidator() {
		return new SimplePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SimplePayment, Set<String>> onlyExistsValidator() {
		return new SimplePaymentOnlyExistsValidator();
	}
}
