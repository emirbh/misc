package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.DualCurrencyStrikePrice;
import fpml.consolidated.fx.validation.DualCurrencyStrikePriceTypeFormatValidator;
import fpml.consolidated.fx.validation.DualCurrencyStrikePriceValidator;
import fpml.consolidated.fx.validation.exists.DualCurrencyStrikePriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DualCurrencyStrikePrice.class)
public class DualCurrencyStrikePriceMeta implements RosettaMetaData<DualCurrencyStrikePrice> {

	@Override
	public List<Validator<? super DualCurrencyStrikePrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DualCurrencyStrikePrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DualCurrencyStrikePrice> validator(ValidatorFactory factory) {
		return factory.<DualCurrencyStrikePrice>create(DualCurrencyStrikePriceValidator.class);
	}

	@Override
	public Validator<? super DualCurrencyStrikePrice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DualCurrencyStrikePrice>create(DualCurrencyStrikePriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DualCurrencyStrikePrice> validator() {
		return new DualCurrencyStrikePriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DualCurrencyStrikePrice> typeFormatValidator() {
		return new DualCurrencyStrikePriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DualCurrencyStrikePrice, Set<String>> onlyExistsValidator() {
		return new DualCurrencyStrikePriceOnlyExistsValidator();
	}
}
