package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.PaymentProjection;
import fpml.consolidated.loan.validation.PaymentProjectionTypeFormatValidator;
import fpml.consolidated.loan.validation.PaymentProjectionValidator;
import fpml.consolidated.loan.validation.exists.PaymentProjectionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PaymentProjection.class)
public class PaymentProjectionMeta implements RosettaMetaData<PaymentProjection> {

	@Override
	public List<Validator<? super PaymentProjection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentProjection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaymentProjection> validator(ValidatorFactory factory) {
		return factory.<PaymentProjection>create(PaymentProjectionValidator.class);
	}

	@Override
	public Validator<? super PaymentProjection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PaymentProjection>create(PaymentProjectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PaymentProjection> validator() {
		return new PaymentProjectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PaymentProjection> typeFormatValidator() {
		return new PaymentProjectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentProjection, Set<String>> onlyExistsValidator() {
		return new PaymentProjectionOnlyExistsValidator();
	}
}
