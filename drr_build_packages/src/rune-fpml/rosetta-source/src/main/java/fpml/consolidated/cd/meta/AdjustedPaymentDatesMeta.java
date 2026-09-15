package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.AdjustedPaymentDates;
import fpml.consolidated.cd.validation.AdjustedPaymentDatesTypeFormatValidator;
import fpml.consolidated.cd.validation.AdjustedPaymentDatesValidator;
import fpml.consolidated.cd.validation.exists.AdjustedPaymentDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdjustedPaymentDates.class)
public class AdjustedPaymentDatesMeta implements RosettaMetaData<AdjustedPaymentDates> {

	@Override
	public List<Validator<? super AdjustedPaymentDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdjustedPaymentDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustedPaymentDates> validator(ValidatorFactory factory) {
		return factory.<AdjustedPaymentDates>create(AdjustedPaymentDatesValidator.class);
	}

	@Override
	public Validator<? super AdjustedPaymentDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdjustedPaymentDates>create(AdjustedPaymentDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdjustedPaymentDates> validator() {
		return new AdjustedPaymentDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdjustedPaymentDates> typeFormatValidator() {
		return new AdjustedPaymentDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustedPaymentDates, Set<String>> onlyExistsValidator() {
		return new AdjustedPaymentDatesOnlyExistsValidator();
	}
}
