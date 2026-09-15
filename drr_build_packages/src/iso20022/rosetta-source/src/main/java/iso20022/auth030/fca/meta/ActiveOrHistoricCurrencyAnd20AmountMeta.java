package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.ActiveOrHistoricCurrencyAnd20Amount;
import iso20022.auth030.fca.validation.ActiveOrHistoricCurrencyAnd20AmountTypeFormatValidator;
import iso20022.auth030.fca.validation.ActiveOrHistoricCurrencyAnd20AmountValidator;
import iso20022.auth030.fca.validation.exists.ActiveOrHistoricCurrencyAnd20AmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ActiveOrHistoricCurrencyAnd20Amount.class)
public class ActiveOrHistoricCurrencyAnd20AmountMeta implements RosettaMetaData<ActiveOrHistoricCurrencyAnd20Amount> {

	@Override
	public List<Validator<? super ActiveOrHistoricCurrencyAnd20Amount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ActiveOrHistoricCurrencyAnd20Amount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd20Amount> validator(ValidatorFactory factory) {
		return factory.<ActiveOrHistoricCurrencyAnd20Amount>create(ActiveOrHistoricCurrencyAnd20AmountValidator.class);
	}

	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd20Amount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ActiveOrHistoricCurrencyAnd20Amount>create(ActiveOrHistoricCurrencyAnd20AmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd20Amount> validator() {
		return new ActiveOrHistoricCurrencyAnd20AmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd20Amount> typeFormatValidator() {
		return new ActiveOrHistoricCurrencyAnd20AmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ActiveOrHistoricCurrencyAnd20Amount, Set<String>> onlyExistsValidator() {
		return new ActiveOrHistoricCurrencyAnd20AmountOnlyExistsValidator();
	}
}
