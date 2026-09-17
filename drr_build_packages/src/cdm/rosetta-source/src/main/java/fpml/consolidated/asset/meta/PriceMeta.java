package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Price;
import fpml.consolidated.asset.validation.PriceTypeFormatValidator;
import fpml.consolidated.asset.validation.PriceValidator;
import fpml.consolidated.asset.validation.datarule.PriceChoice;
import fpml.consolidated.asset.validation.exists.PriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Price.class)
public class PriceMeta implements RosettaMetaData<Price> {

	@Override
	public List<Validator<? super Price>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Price>create(PriceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Price, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Price> validator(ValidatorFactory factory) {
		return factory.<Price>create(PriceValidator.class);
	}

	@Override
	public Validator<? super Price> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Price>create(PriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Price> validator() {
		return new PriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Price> typeFormatValidator() {
		return new PriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Price, Set<String>> onlyExistsValidator() {
		return new PriceOnlyExistsValidator();
	}
}
