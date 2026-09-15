package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbRates;
import drr.standards.iosco.upi.validation.AnnaDsbRatesTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbRatesValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbRatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbRates.class)
public class AnnaDsbRatesMeta implements RosettaMetaData<AnnaDsbRates> {

	@Override
	public List<Validator<? super AnnaDsbRates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbRates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbRates> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbRates>create(AnnaDsbRatesValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbRates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbRates>create(AnnaDsbRatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbRates> validator() {
		return new AnnaDsbRatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbRates> typeFormatValidator() {
		return new AnnaDsbRatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbRates, Set<String>> onlyExistsValidator() {
		return new AnnaDsbRatesOnlyExistsValidator();
	}
}
