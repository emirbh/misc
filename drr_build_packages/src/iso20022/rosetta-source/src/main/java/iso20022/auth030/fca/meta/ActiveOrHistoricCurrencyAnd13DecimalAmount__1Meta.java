package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.ActiveOrHistoricCurrencyAnd13DecimalAmount__1;
import iso20022.auth030.fca.validation.ActiveOrHistoricCurrencyAnd13DecimalAmount__1TypeFormatValidator;
import iso20022.auth030.fca.validation.ActiveOrHistoricCurrencyAnd13DecimalAmount__1Validator;
import iso20022.auth030.fca.validation.exists.ActiveOrHistoricCurrencyAnd13DecimalAmount__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ActiveOrHistoricCurrencyAnd13DecimalAmount__1.class)
public class ActiveOrHistoricCurrencyAnd13DecimalAmount__1Meta implements RosettaMetaData<ActiveOrHistoricCurrencyAnd13DecimalAmount__1> {

	@Override
	public List<Validator<? super ActiveOrHistoricCurrencyAnd13DecimalAmount__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ActiveOrHistoricCurrencyAnd13DecimalAmount__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd13DecimalAmount__1> validator(ValidatorFactory factory) {
		return factory.<ActiveOrHistoricCurrencyAnd13DecimalAmount__1>create(ActiveOrHistoricCurrencyAnd13DecimalAmount__1Validator.class);
	}

	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd13DecimalAmount__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ActiveOrHistoricCurrencyAnd13DecimalAmount__1>create(ActiveOrHistoricCurrencyAnd13DecimalAmount__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd13DecimalAmount__1> validator() {
		return new ActiveOrHistoricCurrencyAnd13DecimalAmount__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super ActiveOrHistoricCurrencyAnd13DecimalAmount__1> typeFormatValidator() {
		return new ActiveOrHistoricCurrencyAnd13DecimalAmount__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ActiveOrHistoricCurrencyAnd13DecimalAmount__1, Set<String>> onlyExistsValidator() {
		return new ActiveOrHistoricCurrencyAnd13DecimalAmount__1OnlyExistsValidator();
	}
}
