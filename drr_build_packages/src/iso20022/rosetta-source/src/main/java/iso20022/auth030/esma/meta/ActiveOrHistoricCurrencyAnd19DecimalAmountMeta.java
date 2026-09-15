package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.ActiveOrHistoricCurrencyAnd19DecimalAmount;
import iso20022.auth030.esma.validation.ActiveOrHistoricCurrencyAnd19DecimalAmountTypeFormatValidator;
import iso20022.auth030.esma.validation.ActiveOrHistoricCurrencyAnd19DecimalAmountValidator;
import iso20022.auth030.esma.validation.exists.ActiveOrHistoricCurrencyAnd19DecimalAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ActiveOrHistoricCurrencyAnd19DecimalAmount.class)
public class ActiveOrHistoricCurrencyAnd19DecimalAmountMeta implements RosettaMetaData<ActiveOrHistoricCurrencyAnd19DecimalAmount> {

	@Override
	public List<Validator<? super ActiveOrHistoricCurrencyAnd19DecimalAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ActiveOrHistoricCurrencyAnd19DecimalAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd19DecimalAmount> validator(ValidatorFactory factory) {
		return factory.<ActiveOrHistoricCurrencyAnd19DecimalAmount>create(ActiveOrHistoricCurrencyAnd19DecimalAmountValidator.class);
	}

	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd19DecimalAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ActiveOrHistoricCurrencyAnd19DecimalAmount>create(ActiveOrHistoricCurrencyAnd19DecimalAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd19DecimalAmount> validator() {
		return new ActiveOrHistoricCurrencyAnd19DecimalAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd19DecimalAmount> typeFormatValidator() {
		return new ActiveOrHistoricCurrencyAnd19DecimalAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ActiveOrHistoricCurrencyAnd19DecimalAmount, Set<String>> onlyExistsValidator() {
		return new ActiveOrHistoricCurrencyAnd19DecimalAmountOnlyExistsValidator();
	}
}
