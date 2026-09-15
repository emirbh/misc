package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.validation.CurrencyTypeFormatValidator;
import fpml.consolidated.shared.validation.CurrencyValidator;
import fpml.consolidated.shared.validation.exists.CurrencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Currency.class)
public class CurrencyMeta implements RosettaMetaData<Currency> {

	@Override
	public List<Validator<? super Currency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Currency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Currency> validator(ValidatorFactory factory) {
		return factory.<Currency>create(CurrencyValidator.class);
	}

	@Override
	public Validator<? super Currency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Currency>create(CurrencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Currency> validator() {
		return new CurrencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Currency> typeFormatValidator() {
		return new CurrencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Currency, Set<String>> onlyExistsValidator() {
		return new CurrencyOnlyExistsValidator();
	}
}
