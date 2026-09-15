package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.TradeLegPriceChange;
import fpml.consolidated.business.events.validation.TradeLegPriceChangeTypeFormatValidator;
import fpml.consolidated.business.events.validation.TradeLegPriceChangeValidator;
import fpml.consolidated.business.events.validation.datarule.TradeLegPriceChangeChoice;
import fpml.consolidated.business.events.validation.exists.TradeLegPriceChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeLegPriceChange.class)
public class TradeLegPriceChangeMeta implements RosettaMetaData<TradeLegPriceChange> {

	@Override
	public List<Validator<? super TradeLegPriceChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeLegPriceChange>create(TradeLegPriceChangeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeLegPriceChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeLegPriceChange> validator(ValidatorFactory factory) {
		return factory.<TradeLegPriceChange>create(TradeLegPriceChangeValidator.class);
	}

	@Override
	public Validator<? super TradeLegPriceChange> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeLegPriceChange>create(TradeLegPriceChangeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeLegPriceChange> validator() {
		return new TradeLegPriceChangeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeLegPriceChange> typeFormatValidator() {
		return new TradeLegPriceChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeLegPriceChange, Set<String>> onlyExistsValidator() {
		return new TradeLegPriceChangeOnlyExistsValidator();
	}
}
