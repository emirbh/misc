package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.ActiveOrHistoricCurrencyAnd20DecimalAmount;
import iso20022.auth108.iso.validation.ActiveOrHistoricCurrencyAnd20DecimalAmountTypeFormatValidator;
import iso20022.auth108.iso.validation.ActiveOrHistoricCurrencyAnd20DecimalAmountValidator;
import iso20022.auth108.iso.validation.exists.ActiveOrHistoricCurrencyAnd20DecimalAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ActiveOrHistoricCurrencyAnd20DecimalAmount.class)
public class ActiveOrHistoricCurrencyAnd20DecimalAmountMeta implements RosettaMetaData<ActiveOrHistoricCurrencyAnd20DecimalAmount> {

	@Override
	public List<Validator<? super ActiveOrHistoricCurrencyAnd20DecimalAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ActiveOrHistoricCurrencyAnd20DecimalAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd20DecimalAmount> validator(ValidatorFactory factory) {
		return factory.<ActiveOrHistoricCurrencyAnd20DecimalAmount>create(ActiveOrHistoricCurrencyAnd20DecimalAmountValidator.class);
	}

	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd20DecimalAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ActiveOrHistoricCurrencyAnd20DecimalAmount>create(ActiveOrHistoricCurrencyAnd20DecimalAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd20DecimalAmount> validator() {
		return new ActiveOrHistoricCurrencyAnd20DecimalAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd20DecimalAmount> typeFormatValidator() {
		return new ActiveOrHistoricCurrencyAnd20DecimalAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ActiveOrHistoricCurrencyAnd20DecimalAmount, Set<String>> onlyExistsValidator() {
		return new ActiveOrHistoricCurrencyAnd20DecimalAmountOnlyExistsValidator();
	}
}
