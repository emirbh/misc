package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.ExchangeTradedContractUnderlyer;
import fpml.consolidated.asset.validation.ExchangeTradedContractUnderlyerTypeFormatValidator;
import fpml.consolidated.asset.validation.ExchangeTradedContractUnderlyerValidator;
import fpml.consolidated.asset.validation.datarule.ExchangeTradedContractUnderlyerChoice;
import fpml.consolidated.asset.validation.exists.ExchangeTradedContractUnderlyerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExchangeTradedContractUnderlyer.class)
public class ExchangeTradedContractUnderlyerMeta implements RosettaMetaData<ExchangeTradedContractUnderlyer> {

	@Override
	public List<Validator<? super ExchangeTradedContractUnderlyer>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ExchangeTradedContractUnderlyer>create(ExchangeTradedContractUnderlyerChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExchangeTradedContractUnderlyer, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExchangeTradedContractUnderlyer> validator(ValidatorFactory factory) {
		return factory.<ExchangeTradedContractUnderlyer>create(ExchangeTradedContractUnderlyerValidator.class);
	}

	@Override
	public Validator<? super ExchangeTradedContractUnderlyer> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExchangeTradedContractUnderlyer>create(ExchangeTradedContractUnderlyerTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExchangeTradedContractUnderlyer> validator() {
		return new ExchangeTradedContractUnderlyerValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExchangeTradedContractUnderlyer> typeFormatValidator() {
		return new ExchangeTradedContractUnderlyerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeTradedContractUnderlyer, Set<String>> onlyExistsValidator() {
		return new ExchangeTradedContractUnderlyerOnlyExistsValidator();
	}
}
