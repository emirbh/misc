package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.Market;
import fpml.consolidated.riskdef.validation.MarketTypeFormatValidator;
import fpml.consolidated.riskdef.validation.MarketValidator;
import fpml.consolidated.riskdef.validation.exists.MarketOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Market.class)
public class MarketMeta implements RosettaMetaData<Market> {

	@Override
	public List<Validator<? super Market>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Market, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Market> validator(ValidatorFactory factory) {
		return factory.<Market>create(MarketValidator.class);
	}

	@Override
	public Validator<? super Market> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Market>create(MarketTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Market> validator() {
		return new MarketValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Market> typeFormatValidator() {
		return new MarketTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Market, Set<String>> onlyExistsValidator() {
		return new MarketOnlyExistsValidator();
	}
}
