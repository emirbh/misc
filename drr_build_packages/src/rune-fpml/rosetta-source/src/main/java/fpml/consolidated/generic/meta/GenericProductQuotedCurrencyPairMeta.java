package fpml.consolidated.generic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.generic.GenericProductQuotedCurrencyPair;
import fpml.consolidated.generic.validation.GenericProductQuotedCurrencyPairTypeFormatValidator;
import fpml.consolidated.generic.validation.GenericProductQuotedCurrencyPairValidator;
import fpml.consolidated.generic.validation.exists.GenericProductQuotedCurrencyPairOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GenericProductQuotedCurrencyPair.class)
public class GenericProductQuotedCurrencyPairMeta implements RosettaMetaData<GenericProductQuotedCurrencyPair> {

	@Override
	public List<Validator<? super GenericProductQuotedCurrencyPair>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericProductQuotedCurrencyPair, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericProductQuotedCurrencyPair> validator(ValidatorFactory factory) {
		return factory.<GenericProductQuotedCurrencyPair>create(GenericProductQuotedCurrencyPairValidator.class);
	}

	@Override
	public Validator<? super GenericProductQuotedCurrencyPair> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericProductQuotedCurrencyPair>create(GenericProductQuotedCurrencyPairTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericProductQuotedCurrencyPair> validator() {
		return new GenericProductQuotedCurrencyPairValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericProductQuotedCurrencyPair> typeFormatValidator() {
		return new GenericProductQuotedCurrencyPairTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericProductQuotedCurrencyPair, Set<String>> onlyExistsValidator() {
		return new GenericProductQuotedCurrencyPairOnlyExistsValidator();
	}
}
