package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityFixedPrice;
import fpml.consolidated.com.validation.CommodityFixedPriceTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityFixedPriceValidator;
import fpml.consolidated.com.validation.exists.CommodityFixedPriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityFixedPrice.class)
public class CommodityFixedPriceMeta implements RosettaMetaData<CommodityFixedPrice> {

	@Override
	public List<Validator<? super CommodityFixedPrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityFixedPrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityFixedPrice> validator(ValidatorFactory factory) {
		return factory.<CommodityFixedPrice>create(CommodityFixedPriceValidator.class);
	}

	@Override
	public Validator<? super CommodityFixedPrice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityFixedPrice>create(CommodityFixedPriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityFixedPrice> validator() {
		return new CommodityFixedPriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityFixedPrice> typeFormatValidator() {
		return new CommodityFixedPriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFixedPrice, Set<String>> onlyExistsValidator() {
		return new CommodityFixedPriceOnlyExistsValidator();
	}
}
