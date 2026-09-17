package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.TradeMaturity;
import fpml.consolidated.business.events.validation.TradeMaturityTypeFormatValidator;
import fpml.consolidated.business.events.validation.TradeMaturityValidator;
import fpml.consolidated.business.events.validation.exists.TradeMaturityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeMaturity.class)
public class TradeMaturityMeta implements RosettaMetaData<TradeMaturity> {

	@Override
	public List<Validator<? super TradeMaturity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeMaturity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeMaturity> validator(ValidatorFactory factory) {
		return factory.<TradeMaturity>create(TradeMaturityValidator.class);
	}

	@Override
	public Validator<? super TradeMaturity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeMaturity>create(TradeMaturityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeMaturity> validator() {
		return new TradeMaturityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeMaturity> typeFormatValidator() {
		return new TradeMaturityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeMaturity, Set<String>> onlyExistsValidator() {
		return new TradeMaturityOnlyExistsValidator();
	}
}
