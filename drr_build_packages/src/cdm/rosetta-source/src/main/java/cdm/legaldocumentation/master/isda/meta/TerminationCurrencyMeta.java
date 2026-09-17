package cdm.legaldocumentation.master.isda.meta;

import cdm.legaldocumentation.master.isda.TerminationCurrency;
import cdm.legaldocumentation.master.isda.validation.TerminationCurrencyTypeFormatValidator;
import cdm.legaldocumentation.master.isda.validation.TerminationCurrencyValidator;
import cdm.legaldocumentation.master.isda.validation.exists.TerminationCurrencyOnlyExistsValidator;
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
@RosettaMeta(model=TerminationCurrency.class)
public class TerminationCurrencyMeta implements RosettaMetaData<TerminationCurrency> {

	@Override
	public List<Validator<? super TerminationCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TerminationCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TerminationCurrency> validator(ValidatorFactory factory) {
		return factory.<TerminationCurrency>create(TerminationCurrencyValidator.class);
	}

	@Override
	public Validator<? super TerminationCurrency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TerminationCurrency>create(TerminationCurrencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TerminationCurrency> validator() {
		return new TerminationCurrencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TerminationCurrency> typeFormatValidator() {
		return new TerminationCurrencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TerminationCurrency, Set<String>> onlyExistsValidator() {
		return new TerminationCurrencyOnlyExistsValidator();
	}
}
