package iso20022.auth030.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.CurrencyExchange22__1;
import iso20022.auth030.mas.validation.CurrencyExchange22__1TypeFormatValidator;
import iso20022.auth030.mas.validation.CurrencyExchange22__1Validator;
import iso20022.auth030.mas.validation.exists.CurrencyExchange22__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CurrencyExchange22__1.class)
public class CurrencyExchange22__1Meta implements RosettaMetaData<CurrencyExchange22__1> {

	@Override
	public List<Validator<? super CurrencyExchange22__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CurrencyExchange22__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CurrencyExchange22__1> validator(ValidatorFactory factory) {
		return factory.<CurrencyExchange22__1>create(CurrencyExchange22__1Validator.class);
	}

	@Override
	public Validator<? super CurrencyExchange22__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CurrencyExchange22__1>create(CurrencyExchange22__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CurrencyExchange22__1> validator() {
		return new CurrencyExchange22__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CurrencyExchange22__1> typeFormatValidator() {
		return new CurrencyExchange22__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CurrencyExchange22__1, Set<String>> onlyExistsValidator() {
		return new CurrencyExchange22__1OnlyExistsValidator();
	}
}
