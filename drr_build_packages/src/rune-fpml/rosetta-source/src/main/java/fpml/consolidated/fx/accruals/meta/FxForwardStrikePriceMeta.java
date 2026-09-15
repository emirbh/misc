package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxForwardStrikePrice;
import fpml.consolidated.fx.accruals.validation.FxForwardStrikePriceTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxForwardStrikePriceValidator;
import fpml.consolidated.fx.accruals.validation.exists.FxForwardStrikePriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxForwardStrikePrice.class)
public class FxForwardStrikePriceMeta implements RosettaMetaData<FxForwardStrikePrice> {

	@Override
	public List<Validator<? super FxForwardStrikePrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxForwardStrikePrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxForwardStrikePrice> validator(ValidatorFactory factory) {
		return factory.<FxForwardStrikePrice>create(FxForwardStrikePriceValidator.class);
	}

	@Override
	public Validator<? super FxForwardStrikePrice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxForwardStrikePrice>create(FxForwardStrikePriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxForwardStrikePrice> validator() {
		return new FxForwardStrikePriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxForwardStrikePrice> typeFormatValidator() {
		return new FxForwardStrikePriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxForwardStrikePrice, Set<String>> onlyExistsValidator() {
		return new FxForwardStrikePriceOnlyExistsValidator();
	}
}
