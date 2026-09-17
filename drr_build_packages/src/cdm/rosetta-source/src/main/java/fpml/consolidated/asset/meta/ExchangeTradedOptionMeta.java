package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.ExchangeTradedOption;
import fpml.consolidated.asset.validation.ExchangeTradedOptionTypeFormatValidator;
import fpml.consolidated.asset.validation.ExchangeTradedOptionValidator;
import fpml.consolidated.asset.validation.exists.ExchangeTradedOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExchangeTradedOption.class)
public class ExchangeTradedOptionMeta implements RosettaMetaData<ExchangeTradedOption> {

	@Override
	public List<Validator<? super ExchangeTradedOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExchangeTradedOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExchangeTradedOption> validator(ValidatorFactory factory) {
		return factory.<ExchangeTradedOption>create(ExchangeTradedOptionValidator.class);
	}

	@Override
	public Validator<? super ExchangeTradedOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExchangeTradedOption>create(ExchangeTradedOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExchangeTradedOption> validator() {
		return new ExchangeTradedOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExchangeTradedOption> typeFormatValidator() {
		return new ExchangeTradedOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeTradedOption, Set<String>> onlyExistsValidator() {
		return new ExchangeTradedOptionOnlyExistsValidator();
	}
}
