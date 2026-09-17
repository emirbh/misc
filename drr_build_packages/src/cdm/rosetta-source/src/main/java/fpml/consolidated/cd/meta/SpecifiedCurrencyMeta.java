package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.SpecifiedCurrency;
import fpml.consolidated.cd.validation.SpecifiedCurrencyTypeFormatValidator;
import fpml.consolidated.cd.validation.SpecifiedCurrencyValidator;
import fpml.consolidated.cd.validation.exists.SpecifiedCurrencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SpecifiedCurrency.class)
public class SpecifiedCurrencyMeta implements RosettaMetaData<SpecifiedCurrency> {

	@Override
	public List<Validator<? super SpecifiedCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SpecifiedCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SpecifiedCurrency> validator(ValidatorFactory factory) {
		return factory.<SpecifiedCurrency>create(SpecifiedCurrencyValidator.class);
	}

	@Override
	public Validator<? super SpecifiedCurrency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SpecifiedCurrency>create(SpecifiedCurrencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SpecifiedCurrency> validator() {
		return new SpecifiedCurrencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SpecifiedCurrency> typeFormatValidator() {
		return new SpecifiedCurrencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SpecifiedCurrency, Set<String>> onlyExistsValidator() {
		return new SpecifiedCurrencyOnlyExistsValidator();
	}
}
