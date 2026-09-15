package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxOptionStrikePrice;
import fpml.consolidated.fx.accruals.validation.FxOptionStrikePriceTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxOptionStrikePriceValidator;
import fpml.consolidated.fx.accruals.validation.exists.FxOptionStrikePriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxOptionStrikePrice.class)
public class FxOptionStrikePriceMeta implements RosettaMetaData<FxOptionStrikePrice> {

	@Override
	public List<Validator<? super FxOptionStrikePrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxOptionStrikePrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxOptionStrikePrice> validator(ValidatorFactory factory) {
		return factory.<FxOptionStrikePrice>create(FxOptionStrikePriceValidator.class);
	}

	@Override
	public Validator<? super FxOptionStrikePrice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxOptionStrikePrice>create(FxOptionStrikePriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxOptionStrikePrice> validator() {
		return new FxOptionStrikePriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxOptionStrikePrice> typeFormatValidator() {
		return new FxOptionStrikePriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxOptionStrikePrice, Set<String>> onlyExistsValidator() {
		return new FxOptionStrikePriceOnlyExistsValidator();
	}
}
