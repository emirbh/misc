package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxStrikePrice;
import fpml.consolidated.fx.validation.FxStrikePriceTypeFormatValidator;
import fpml.consolidated.fx.validation.FxStrikePriceValidator;
import fpml.consolidated.fx.validation.exists.FxStrikePriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxStrikePrice.class)
public class FxStrikePriceMeta implements RosettaMetaData<FxStrikePrice> {

	@Override
	public List<Validator<? super FxStrikePrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxStrikePrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxStrikePrice> validator(ValidatorFactory factory) {
		return factory.<FxStrikePrice>create(FxStrikePriceValidator.class);
	}

	@Override
	public Validator<? super FxStrikePrice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxStrikePrice>create(FxStrikePriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxStrikePrice> validator() {
		return new FxStrikePriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxStrikePrice> typeFormatValidator() {
		return new FxStrikePriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxStrikePrice, Set<String>> onlyExistsValidator() {
		return new FxStrikePriceOnlyExistsValidator();
	}
}
