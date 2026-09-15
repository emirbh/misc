package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Price;
import fpml.consolidated.asset.validation.datarule.PriceChoice;
import fpml.consolidated.eq.shared.ReturnLegValuationPrice;
import fpml.consolidated.eq.shared.validation.ReturnLegValuationPriceTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.ReturnLegValuationPriceValidator;
import fpml.consolidated.eq.shared.validation.exists.ReturnLegValuationPriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReturnLegValuationPrice.class)
public class ReturnLegValuationPriceMeta implements RosettaMetaData<ReturnLegValuationPrice> {

	@Override
	public List<Validator<? super ReturnLegValuationPrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Price>create(PriceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReturnLegValuationPrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnLegValuationPrice> validator(ValidatorFactory factory) {
		return factory.<ReturnLegValuationPrice>create(ReturnLegValuationPriceValidator.class);
	}

	@Override
	public Validator<? super ReturnLegValuationPrice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReturnLegValuationPrice>create(ReturnLegValuationPriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReturnLegValuationPrice> validator() {
		return new ReturnLegValuationPriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReturnLegValuationPrice> typeFormatValidator() {
		return new ReturnLegValuationPriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnLegValuationPrice, Set<String>> onlyExistsValidator() {
		return new ReturnLegValuationPriceOnlyExistsValidator();
	}
}
