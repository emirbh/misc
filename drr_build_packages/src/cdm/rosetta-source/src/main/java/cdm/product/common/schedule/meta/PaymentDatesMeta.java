package cdm.product.common.schedule.meta;

import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.schedule.validation.PaymentDatesTypeFormatValidator;
import cdm.product.common.schedule.validation.PaymentDatesValidator;
import cdm.product.common.schedule.validation.datarule.PaymentDatesFpML_ird_35_cd_31;
import cdm.product.common.schedule.validation.datarule.PaymentDatesNonZeroPeriodMultiplier;
import cdm.product.common.schedule.validation.exists.PaymentDatesOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=PaymentDates.class)
public class PaymentDatesMeta implements RosettaMetaData<PaymentDates> {

	@Override
	public List<Validator<? super PaymentDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PaymentDates>create(PaymentDatesFpML_ird_35_cd_31.class),
			factory.<PaymentDates>create(PaymentDatesNonZeroPeriodMultiplier.class)
		);
	}
	
	@Override
	public List<Function<? super PaymentDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaymentDates> validator(ValidatorFactory factory) {
		return factory.<PaymentDates>create(PaymentDatesValidator.class);
	}

	@Override
	public Validator<? super PaymentDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PaymentDates>create(PaymentDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PaymentDates> validator() {
		return new PaymentDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PaymentDates> typeFormatValidator() {
		return new PaymentDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentDates, Set<String>> onlyExistsValidator() {
		return new PaymentDatesOnlyExistsValidator();
	}
}
