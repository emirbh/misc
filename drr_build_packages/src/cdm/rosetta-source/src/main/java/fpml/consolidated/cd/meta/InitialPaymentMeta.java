package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.InitialPayment;
import fpml.consolidated.cd.validation.InitialPaymentTypeFormatValidator;
import fpml.consolidated.cd.validation.InitialPaymentValidator;
import fpml.consolidated.cd.validation.exists.InitialPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InitialPayment.class)
public class InitialPaymentMeta implements RosettaMetaData<InitialPayment> {

	@Override
	public List<Validator<? super InitialPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InitialPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InitialPayment> validator(ValidatorFactory factory) {
		return factory.<InitialPayment>create(InitialPaymentValidator.class);
	}

	@Override
	public Validator<? super InitialPayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InitialPayment>create(InitialPaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InitialPayment> validator() {
		return new InitialPaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InitialPayment> typeFormatValidator() {
		return new InitialPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InitialPayment, Set<String>> onlyExistsValidator() {
		return new InitialPaymentOnlyExistsValidator();
	}
}
