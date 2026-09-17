package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.validation.IdentifiedCurrencyTypeFormatValidator;
import fpml.consolidated.shared.validation.IdentifiedCurrencyValidator;
import fpml.consolidated.shared.validation.exists.IdentifiedCurrencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=IdentifiedCurrency.class)
public class IdentifiedCurrencyMeta implements RosettaMetaData<IdentifiedCurrency> {

	@Override
	public List<Validator<? super IdentifiedCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IdentifiedCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IdentifiedCurrency> validator(ValidatorFactory factory) {
		return factory.<IdentifiedCurrency>create(IdentifiedCurrencyValidator.class);
	}

	@Override
	public Validator<? super IdentifiedCurrency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IdentifiedCurrency>create(IdentifiedCurrencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IdentifiedCurrency> validator() {
		return new IdentifiedCurrencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super IdentifiedCurrency> typeFormatValidator() {
		return new IdentifiedCurrencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IdentifiedCurrency, Set<String>> onlyExistsValidator() {
		return new IdentifiedCurrencyOnlyExistsValidator();
	}
}
