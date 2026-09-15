package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.ExchangeTradedFund;
import fpml.consolidated.asset.validation.ExchangeTradedFundTypeFormatValidator;
import fpml.consolidated.asset.validation.ExchangeTradedFundValidator;
import fpml.consolidated.asset.validation.exists.ExchangeTradedFundOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExchangeTradedFund.class)
public class ExchangeTradedFundMeta implements RosettaMetaData<ExchangeTradedFund> {

	@Override
	public List<Validator<? super ExchangeTradedFund>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExchangeTradedFund, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExchangeTradedFund> validator(ValidatorFactory factory) {
		return factory.<ExchangeTradedFund>create(ExchangeTradedFundValidator.class);
	}

	@Override
	public Validator<? super ExchangeTradedFund> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExchangeTradedFund>create(ExchangeTradedFundTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExchangeTradedFund> validator() {
		return new ExchangeTradedFundValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExchangeTradedFund> typeFormatValidator() {
		return new ExchangeTradedFundTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeTradedFund, Set<String>> onlyExistsValidator() {
		return new ExchangeTradedFundOnlyExistsValidator();
	}
}
