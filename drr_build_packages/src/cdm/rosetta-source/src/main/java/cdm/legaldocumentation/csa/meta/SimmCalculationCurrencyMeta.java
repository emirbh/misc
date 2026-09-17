package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.SimmCalculationCurrency;
import cdm.legaldocumentation.csa.validation.SimmCalculationCurrencyTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.SimmCalculationCurrencyValidator;
import cdm.legaldocumentation.csa.validation.exists.SimmCalculationCurrencyOnlyExistsValidator;
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
@RosettaMeta(model=SimmCalculationCurrency.class)
public class SimmCalculationCurrencyMeta implements RosettaMetaData<SimmCalculationCurrency> {

	@Override
	public List<Validator<? super SimmCalculationCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SimmCalculationCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SimmCalculationCurrency> validator(ValidatorFactory factory) {
		return factory.<SimmCalculationCurrency>create(SimmCalculationCurrencyValidator.class);
	}

	@Override
	public Validator<? super SimmCalculationCurrency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SimmCalculationCurrency>create(SimmCalculationCurrencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SimmCalculationCurrency> validator() {
		return new SimmCalculationCurrencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SimmCalculationCurrency> typeFormatValidator() {
		return new SimmCalculationCurrencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SimmCalculationCurrency, Set<String>> onlyExistsValidator() {
		return new SimmCalculationCurrencyOnlyExistsValidator();
	}
}
