package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.ExchangeTradedContract;
import fpml.consolidated.asset.validation.ExchangeTradedContractTypeFormatValidator;
import fpml.consolidated.asset.validation.ExchangeTradedContractValidator;
import fpml.consolidated.asset.validation.exists.ExchangeTradedContractOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExchangeTradedContract.class)
public class ExchangeTradedContractMeta implements RosettaMetaData<ExchangeTradedContract> {

	@Override
	public List<Validator<? super ExchangeTradedContract>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExchangeTradedContract, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExchangeTradedContract> validator(ValidatorFactory factory) {
		return factory.<ExchangeTradedContract>create(ExchangeTradedContractValidator.class);
	}

	@Override
	public Validator<? super ExchangeTradedContract> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExchangeTradedContract>create(ExchangeTradedContractTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExchangeTradedContract> validator() {
		return new ExchangeTradedContractValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExchangeTradedContract> typeFormatValidator() {
		return new ExchangeTradedContractTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeTradedContract, Set<String>> onlyExistsValidator() {
		return new ExchangeTradedContractOnlyExistsValidator();
	}
}
