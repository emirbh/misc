package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.NotDomesticCurrency;
import fpml.consolidated.cd.validation.NotDomesticCurrencyTypeFormatValidator;
import fpml.consolidated.cd.validation.NotDomesticCurrencyValidator;
import fpml.consolidated.cd.validation.exists.NotDomesticCurrencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NotDomesticCurrency.class)
public class NotDomesticCurrencyMeta implements RosettaMetaData<NotDomesticCurrency> {

	@Override
	public List<Validator<? super NotDomesticCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotDomesticCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotDomesticCurrency> validator(ValidatorFactory factory) {
		return factory.<NotDomesticCurrency>create(NotDomesticCurrencyValidator.class);
	}

	@Override
	public Validator<? super NotDomesticCurrency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotDomesticCurrency>create(NotDomesticCurrencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotDomesticCurrency> validator() {
		return new NotDomesticCurrencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NotDomesticCurrency> typeFormatValidator() {
		return new NotDomesticCurrencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotDomesticCurrency, Set<String>> onlyExistsValidator() {
		return new NotDomesticCurrencyOnlyExistsValidator();
	}
}
