package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.FxHaircutCurrency;
import cdm.legaldocumentation.csa.validation.FxHaircutCurrencyTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.FxHaircutCurrencyValidator;
import cdm.legaldocumentation.csa.validation.datarule.FxHaircutCurrencyFxDesignatedCurrency;
import cdm.legaldocumentation.csa.validation.datarule.FxHaircutCurrencyTerminationCurrency;
import cdm.legaldocumentation.csa.validation.exists.FxHaircutCurrencyOnlyExistsValidator;
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
@RosettaMeta(model=FxHaircutCurrency.class)
public class FxHaircutCurrencyMeta implements RosettaMetaData<FxHaircutCurrency> {

	@Override
	public List<Validator<? super FxHaircutCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxHaircutCurrency>create(FxHaircutCurrencyTerminationCurrency.class),
			factory.<FxHaircutCurrency>create(FxHaircutCurrencyFxDesignatedCurrency.class)
		);
	}
	
	@Override
	public List<Function<? super FxHaircutCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxHaircutCurrency> validator(ValidatorFactory factory) {
		return factory.<FxHaircutCurrency>create(FxHaircutCurrencyValidator.class);
	}

	@Override
	public Validator<? super FxHaircutCurrency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxHaircutCurrency>create(FxHaircutCurrencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxHaircutCurrency> validator() {
		return new FxHaircutCurrencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxHaircutCurrency> typeFormatValidator() {
		return new FxHaircutCurrencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxHaircutCurrency, Set<String>> onlyExistsValidator() {
		return new FxHaircutCurrencyOnlyExistsValidator();
	}
}
