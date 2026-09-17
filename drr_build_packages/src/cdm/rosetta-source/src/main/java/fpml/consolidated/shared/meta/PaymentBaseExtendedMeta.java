package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PaymentBaseExtended;
import fpml.consolidated.shared.validation.PaymentBaseExtendedTypeFormatValidator;
import fpml.consolidated.shared.validation.PaymentBaseExtendedValidator;
import fpml.consolidated.shared.validation.exists.PaymentBaseExtendedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PaymentBaseExtended.class)
public class PaymentBaseExtendedMeta implements RosettaMetaData<PaymentBaseExtended> {

	@Override
	public List<Validator<? super PaymentBaseExtended>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentBaseExtended, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaymentBaseExtended> validator(ValidatorFactory factory) {
		return factory.<PaymentBaseExtended>create(PaymentBaseExtendedValidator.class);
	}

	@Override
	public Validator<? super PaymentBaseExtended> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PaymentBaseExtended>create(PaymentBaseExtendedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PaymentBaseExtended> validator() {
		return new PaymentBaseExtendedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PaymentBaseExtended> typeFormatValidator() {
		return new PaymentBaseExtendedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentBaseExtended, Set<String>> onlyExistsValidator() {
		return new PaymentBaseExtendedOnlyExistsValidator();
	}
}
