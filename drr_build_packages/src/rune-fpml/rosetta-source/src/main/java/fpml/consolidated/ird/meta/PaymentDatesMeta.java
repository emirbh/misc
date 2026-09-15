package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.PaymentDates;
import fpml.consolidated.ird.validation.PaymentDatesTypeFormatValidator;
import fpml.consolidated.ird.validation.PaymentDatesValidator;
import fpml.consolidated.ird.validation.datarule.PaymentDatesChoice;
import fpml.consolidated.ird.validation.exists.PaymentDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PaymentDates.class)
public class PaymentDatesMeta implements RosettaMetaData<PaymentDates> {

	@Override
	public List<Validator<? super PaymentDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PaymentDates>create(PaymentDatesChoice.class)
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
