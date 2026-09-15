package iso20022.auth030.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import iso20022.auth030.mas.validation.ActiveOrHistoricCurrencyAnd13DecimalAmountTypeFormatValidator;
import iso20022.auth030.mas.validation.ActiveOrHistoricCurrencyAnd13DecimalAmountValidator;
import iso20022.auth030.mas.validation.exists.ActiveOrHistoricCurrencyAnd13DecimalAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ActiveOrHistoricCurrencyAnd13DecimalAmount.class)
public class ActiveOrHistoricCurrencyAnd13DecimalAmountMeta implements RosettaMetaData<ActiveOrHistoricCurrencyAnd13DecimalAmount> {

	@Override
	public List<Validator<? super ActiveOrHistoricCurrencyAnd13DecimalAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ActiveOrHistoricCurrencyAnd13DecimalAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd13DecimalAmount> validator(ValidatorFactory factory) {
		return factory.<ActiveOrHistoricCurrencyAnd13DecimalAmount>create(ActiveOrHistoricCurrencyAnd13DecimalAmountValidator.class);
	}

	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd13DecimalAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ActiveOrHistoricCurrencyAnd13DecimalAmount>create(ActiveOrHistoricCurrencyAnd13DecimalAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd13DecimalAmount> validator() {
		return new ActiveOrHistoricCurrencyAnd13DecimalAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd13DecimalAmount> typeFormatValidator() {
		return new ActiveOrHistoricCurrencyAnd13DecimalAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ActiveOrHistoricCurrencyAnd13DecimalAmount, Set<String>> onlyExistsValidator() {
		return new ActiveOrHistoricCurrencyAnd13DecimalAmountOnlyExistsValidator();
	}
}
