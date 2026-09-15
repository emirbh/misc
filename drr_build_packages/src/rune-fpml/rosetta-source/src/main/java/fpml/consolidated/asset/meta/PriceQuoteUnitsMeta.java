package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.PriceQuoteUnits;
import fpml.consolidated.asset.validation.PriceQuoteUnitsTypeFormatValidator;
import fpml.consolidated.asset.validation.PriceQuoteUnitsValidator;
import fpml.consolidated.asset.validation.exists.PriceQuoteUnitsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PriceQuoteUnits.class)
public class PriceQuoteUnitsMeta implements RosettaMetaData<PriceQuoteUnits> {

	@Override
	public List<Validator<? super PriceQuoteUnits>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PriceQuoteUnits, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PriceQuoteUnits> validator(ValidatorFactory factory) {
		return factory.<PriceQuoteUnits>create(PriceQuoteUnitsValidator.class);
	}

	@Override
	public Validator<? super PriceQuoteUnits> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PriceQuoteUnits>create(PriceQuoteUnitsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PriceQuoteUnits> validator() {
		return new PriceQuoteUnitsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PriceQuoteUnits> typeFormatValidator() {
		return new PriceQuoteUnitsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PriceQuoteUnits, Set<String>> onlyExistsValidator() {
		return new PriceQuoteUnitsOnlyExistsValidator();
	}
}
