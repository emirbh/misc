package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.CountryCode;
import fpml.consolidated.shared.validation.CountryCodeTypeFormatValidator;
import fpml.consolidated.shared.validation.CountryCodeValidator;
import fpml.consolidated.shared.validation.exists.CountryCodeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CountryCode.class)
public class CountryCodeMeta implements RosettaMetaData<CountryCode> {

	@Override
	public List<Validator<? super CountryCode>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CountryCode, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CountryCode> validator(ValidatorFactory factory) {
		return factory.<CountryCode>create(CountryCodeValidator.class);
	}

	@Override
	public Validator<? super CountryCode> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CountryCode>create(CountryCodeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CountryCode> validator() {
		return new CountryCodeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CountryCode> typeFormatValidator() {
		return new CountryCodeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CountryCode, Set<String>> onlyExistsValidator() {
		return new CountryCodeOnlyExistsValidator();
	}
}
