package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.PaymentCalculationPeriod;
import fpml.consolidated.ird.validation.PaymentCalculationPeriodTypeFormatValidator;
import fpml.consolidated.ird.validation.PaymentCalculationPeriodValidator;
import fpml.consolidated.ird.validation.datarule.PaymentCalculationPeriodChoice;
import fpml.consolidated.ird.validation.exists.PaymentCalculationPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PaymentCalculationPeriod.class)
public class PaymentCalculationPeriodMeta implements RosettaMetaData<PaymentCalculationPeriod> {

	@Override
	public List<Validator<? super PaymentCalculationPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PaymentCalculationPeriod>create(PaymentCalculationPeriodChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PaymentCalculationPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaymentCalculationPeriod> validator(ValidatorFactory factory) {
		return factory.<PaymentCalculationPeriod>create(PaymentCalculationPeriodValidator.class);
	}

	@Override
	public Validator<? super PaymentCalculationPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PaymentCalculationPeriod>create(PaymentCalculationPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PaymentCalculationPeriod> validator() {
		return new PaymentCalculationPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PaymentCalculationPeriod> typeFormatValidator() {
		return new PaymentCalculationPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentCalculationPeriod, Set<String>> onlyExistsValidator() {
		return new PaymentCalculationPeriodOnlyExistsValidator();
	}
}
