package drr.base.trade.payment.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.payment.OtherPayment;
import drr.base.trade.payment.validation.OtherPaymentTypeFormatValidator;
import drr.base.trade.payment.validation.OtherPaymentValidator;
import drr.base.trade.payment.validation.exists.OtherPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=OtherPayment.class)
public class OtherPaymentMeta implements RosettaMetaData<OtherPayment> {

	@Override
	public List<Validator<? super OtherPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OtherPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OtherPayment> validator(ValidatorFactory factory) {
		return factory.<OtherPayment>create(OtherPaymentValidator.class);
	}

	@Override
	public Validator<? super OtherPayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OtherPayment>create(OtherPaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OtherPayment> validator() {
		return new OtherPaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OtherPayment> typeFormatValidator() {
		return new OtherPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtherPayment, Set<String>> onlyExistsValidator() {
		return new OtherPaymentOnlyExistsValidator();
	}
}
