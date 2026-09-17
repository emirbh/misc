package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.ReturnSwapPaymentDates;
import fpml.consolidated.eq.shared.validation.ReturnSwapPaymentDatesTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.ReturnSwapPaymentDatesValidator;
import fpml.consolidated.eq.shared.validation.exists.ReturnSwapPaymentDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReturnSwapPaymentDates.class)
public class ReturnSwapPaymentDatesMeta implements RosettaMetaData<ReturnSwapPaymentDates> {

	@Override
	public List<Validator<? super ReturnSwapPaymentDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapPaymentDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnSwapPaymentDates> validator(ValidatorFactory factory) {
		return factory.<ReturnSwapPaymentDates>create(ReturnSwapPaymentDatesValidator.class);
	}

	@Override
	public Validator<? super ReturnSwapPaymentDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReturnSwapPaymentDates>create(ReturnSwapPaymentDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapPaymentDates> validator() {
		return new ReturnSwapPaymentDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapPaymentDates> typeFormatValidator() {
		return new ReturnSwapPaymentDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapPaymentDates, Set<String>> onlyExistsValidator() {
		return new ReturnSwapPaymentDatesOnlyExistsValidator();
	}
}
