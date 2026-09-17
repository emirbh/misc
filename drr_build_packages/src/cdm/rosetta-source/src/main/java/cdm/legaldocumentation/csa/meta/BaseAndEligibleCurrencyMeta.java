package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.BaseAndEligibleCurrency;
import cdm.legaldocumentation.csa.validation.BaseAndEligibleCurrencyTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.BaseAndEligibleCurrencyValidator;
import cdm.legaldocumentation.csa.validation.exists.BaseAndEligibleCurrencyOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=BaseAndEligibleCurrency.class)
public class BaseAndEligibleCurrencyMeta implements RosettaMetaData<BaseAndEligibleCurrency> {

	@Override
	public List<Validator<? super BaseAndEligibleCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BaseAndEligibleCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BaseAndEligibleCurrency> validator(ValidatorFactory factory) {
		return factory.<BaseAndEligibleCurrency>create(BaseAndEligibleCurrencyValidator.class);
	}

	@Override
	public Validator<? super BaseAndEligibleCurrency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BaseAndEligibleCurrency>create(BaseAndEligibleCurrencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BaseAndEligibleCurrency> validator() {
		return new BaseAndEligibleCurrencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BaseAndEligibleCurrency> typeFormatValidator() {
		return new BaseAndEligibleCurrencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BaseAndEligibleCurrency, Set<String>> onlyExistsValidator() {
		return new BaseAndEligibleCurrencyOnlyExistsValidator();
	}
}
