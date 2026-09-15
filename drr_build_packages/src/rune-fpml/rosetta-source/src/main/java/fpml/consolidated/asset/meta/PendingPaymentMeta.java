package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.PendingPayment;
import fpml.consolidated.asset.validation.PendingPaymentTypeFormatValidator;
import fpml.consolidated.asset.validation.PendingPaymentValidator;
import fpml.consolidated.asset.validation.exists.PendingPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PendingPayment.class)
public class PendingPaymentMeta implements RosettaMetaData<PendingPayment> {

	@Override
	public List<Validator<? super PendingPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PendingPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PendingPayment> validator(ValidatorFactory factory) {
		return factory.<PendingPayment>create(PendingPaymentValidator.class);
	}

	@Override
	public Validator<? super PendingPayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PendingPayment>create(PendingPaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PendingPayment> validator() {
		return new PendingPaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PendingPayment> typeFormatValidator() {
		return new PendingPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PendingPayment, Set<String>> onlyExistsValidator() {
		return new PendingPaymentOnlyExistsValidator();
	}
}
