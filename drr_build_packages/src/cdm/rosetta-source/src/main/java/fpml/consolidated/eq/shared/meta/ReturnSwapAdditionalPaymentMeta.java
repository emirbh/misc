package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.ReturnSwapAdditionalPayment;
import fpml.consolidated.eq.shared.validation.ReturnSwapAdditionalPaymentTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.ReturnSwapAdditionalPaymentValidator;
import fpml.consolidated.eq.shared.validation.exists.ReturnSwapAdditionalPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReturnSwapAdditionalPayment.class)
public class ReturnSwapAdditionalPaymentMeta implements RosettaMetaData<ReturnSwapAdditionalPayment> {

	@Override
	public List<Validator<? super ReturnSwapAdditionalPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapAdditionalPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnSwapAdditionalPayment> validator(ValidatorFactory factory) {
		return factory.<ReturnSwapAdditionalPayment>create(ReturnSwapAdditionalPaymentValidator.class);
	}

	@Override
	public Validator<? super ReturnSwapAdditionalPayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReturnSwapAdditionalPayment>create(ReturnSwapAdditionalPaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapAdditionalPayment> validator() {
		return new ReturnSwapAdditionalPaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapAdditionalPayment> typeFormatValidator() {
		return new ReturnSwapAdditionalPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapAdditionalPayment, Set<String>> onlyExistsValidator() {
		return new ReturnSwapAdditionalPaymentOnlyExistsValidator();
	}
}
