package cdm.legaldocumentation.master.isda.meta;

import cdm.legaldocumentation.master.isda.PartyOptionTerminationCurrency;
import cdm.legaldocumentation.master.isda.validation.PartyOptionTerminationCurrencyTypeFormatValidator;
import cdm.legaldocumentation.master.isda.validation.PartyOptionTerminationCurrencyValidator;
import cdm.legaldocumentation.master.isda.validation.datarule.PartyOptionTerminationCurrencyTerminationCurrencyCondition;
import cdm.legaldocumentation.master.isda.validation.exists.PartyOptionTerminationCurrencyOnlyExistsValidator;
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
@RosettaMeta(model=PartyOptionTerminationCurrency.class)
public class PartyOptionTerminationCurrencyMeta implements RosettaMetaData<PartyOptionTerminationCurrency> {

	@Override
	public List<Validator<? super PartyOptionTerminationCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PartyOptionTerminationCurrency>create(PartyOptionTerminationCurrencyTerminationCurrencyCondition.class)
		);
	}
	
	@Override
	public List<Function<? super PartyOptionTerminationCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyOptionTerminationCurrency> validator(ValidatorFactory factory) {
		return factory.<PartyOptionTerminationCurrency>create(PartyOptionTerminationCurrencyValidator.class);
	}

	@Override
	public Validator<? super PartyOptionTerminationCurrency> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PartyOptionTerminationCurrency>create(PartyOptionTerminationCurrencyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PartyOptionTerminationCurrency> validator() {
		return new PartyOptionTerminationCurrencyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PartyOptionTerminationCurrency> typeFormatValidator() {
		return new PartyOptionTerminationCurrencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyOptionTerminationCurrency, Set<String>> onlyExistsValidator() {
		return new PartyOptionTerminationCurrencyOnlyExistsValidator();
	}
}
