package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.EventCurrency;
import cdm.legaldocumentation.transaction.additionalterms.validation.EventCurrencyTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.EventCurrencyValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.EventCurrencyOnlyExistsValidator;
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
@RosettaMeta(model=EventCurrency.class)
public class EventCurrencyMeta implements RosettaMetaData<EventCurrency> {

	@Override
	public List<Validator<? super EventCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EventCurrency> validator(ValidatorFactory factory) {
		return factory.<EventCurrency>create(EventCurrencyValidator.class);
	}

	@Override
	public Validator<? super EventCurrency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EventCurrency>create(EventCurrencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EventCurrency> validator() {
		return new EventCurrencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EventCurrency> typeFormatValidator() {
		return new EventCurrencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventCurrency, Set<String>> onlyExistsValidator() {
		return new EventCurrencyOnlyExistsValidator();
	}
}
