package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.FloatingLegCalculation;
import fpml.consolidated.com.FloatingStrikePrice;
import fpml.consolidated.com.validation.FloatingStrikePriceTypeFormatValidator;
import fpml.consolidated.com.validation.FloatingStrikePriceValidator;
import fpml.consolidated.com.validation.datarule.FloatingLegCalculationChoice;
import fpml.consolidated.com.validation.exists.FloatingStrikePriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FloatingStrikePrice.class)
public class FloatingStrikePriceMeta implements RosettaMetaData<FloatingStrikePrice> {

	@Override
	public List<Validator<? super FloatingStrikePrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FloatingLegCalculation>create(FloatingLegCalculationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FloatingStrikePrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingStrikePrice> validator(ValidatorFactory factory) {
		return factory.<FloatingStrikePrice>create(FloatingStrikePriceValidator.class);
	}

	@Override
	public Validator<? super FloatingStrikePrice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingStrikePrice>create(FloatingStrikePriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingStrikePrice> validator() {
		return new FloatingStrikePriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingStrikePrice> typeFormatValidator() {
		return new FloatingStrikePriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingStrikePrice, Set<String>> onlyExistsValidator() {
		return new FloatingStrikePriceOnlyExistsValidator();
	}
}
