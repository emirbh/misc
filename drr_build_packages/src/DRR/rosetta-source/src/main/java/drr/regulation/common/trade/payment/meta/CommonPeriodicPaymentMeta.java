package drr.regulation.common.trade.payment.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.payment.PeriodicPayment;
import drr.base.trade.payment.validation.datarule.PeriodicPaymentDayCountConventionChoice;
import drr.base.trade.payment.validation.datarule.PeriodicPaymentPaymentFrequencyPeriodChoice;
import drr.base.trade.payment.validation.datarule.PeriodicPaymentPaymentFrequencyPeriodMultiplierChoice;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.regulation.common.trade.payment.validation.CommonPeriodicPaymentTypeFormatValidator;
import drr.regulation.common.trade.payment.validation.CommonPeriodicPaymentValidator;
import drr.regulation.common.trade.payment.validation.exists.CommonPeriodicPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CommonPeriodicPayment.class)
public class CommonPeriodicPaymentMeta implements RosettaMetaData<CommonPeriodicPayment> {

	@Override
	public List<Validator<? super CommonPeriodicPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PeriodicPayment>create(PeriodicPaymentDayCountConventionChoice.class),
			factory.<PeriodicPayment>create(PeriodicPaymentPaymentFrequencyPeriodChoice.class),
			factory.<PeriodicPayment>create(PeriodicPaymentPaymentFrequencyPeriodMultiplierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommonPeriodicPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommonPeriodicPayment> validator(ValidatorFactory factory) {
		return factory.<CommonPeriodicPayment>create(CommonPeriodicPaymentValidator.class);
	}

	@Override
	public Validator<? super CommonPeriodicPayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommonPeriodicPayment>create(CommonPeriodicPaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommonPeriodicPayment> validator() {
		return new CommonPeriodicPaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommonPeriodicPayment> typeFormatValidator() {
		return new CommonPeriodicPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommonPeriodicPayment, Set<String>> onlyExistsValidator() {
		return new CommonPeriodicPaymentOnlyExistsValidator();
	}
}
