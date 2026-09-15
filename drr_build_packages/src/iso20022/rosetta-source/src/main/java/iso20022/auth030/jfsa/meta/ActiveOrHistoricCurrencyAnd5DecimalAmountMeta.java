package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.jfsa.validation.ActiveOrHistoricCurrencyAnd5DecimalAmountTypeFormatValidator;
import iso20022.auth030.jfsa.validation.ActiveOrHistoricCurrencyAnd5DecimalAmountValidator;
import iso20022.auth030.jfsa.validation.exists.ActiveOrHistoricCurrencyAnd5DecimalAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ActiveOrHistoricCurrencyAnd5DecimalAmount.class)
public class ActiveOrHistoricCurrencyAnd5DecimalAmountMeta implements RosettaMetaData<ActiveOrHistoricCurrencyAnd5DecimalAmount> {

	@Override
	public List<Validator<? super ActiveOrHistoricCurrencyAnd5DecimalAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ActiveOrHistoricCurrencyAnd5DecimalAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd5DecimalAmount> validator(ValidatorFactory factory) {
		return factory.<ActiveOrHistoricCurrencyAnd5DecimalAmount>create(ActiveOrHistoricCurrencyAnd5DecimalAmountValidator.class);
	}

	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd5DecimalAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ActiveOrHistoricCurrencyAnd5DecimalAmount>create(ActiveOrHistoricCurrencyAnd5DecimalAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd5DecimalAmount> validator() {
		return new ActiveOrHistoricCurrencyAnd5DecimalAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd5DecimalAmount> typeFormatValidator() {
		return new ActiveOrHistoricCurrencyAnd5DecimalAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ActiveOrHistoricCurrencyAnd5DecimalAmount, Set<String>> onlyExistsValidator() {
		return new ActiveOrHistoricCurrencyAnd5DecimalAmountOnlyExistsValidator();
	}
}
