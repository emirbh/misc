package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityBasketUnderlyingByPercentage;
import fpml.consolidated.com.validation.CommodityBasketUnderlyingByPercentageTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityBasketUnderlyingByPercentageValidator;
import fpml.consolidated.com.validation.exists.CommodityBasketUnderlyingByPercentageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityBasketUnderlyingByPercentage.class)
public class CommodityBasketUnderlyingByPercentageMeta implements RosettaMetaData<CommodityBasketUnderlyingByPercentage> {

	@Override
	public List<Validator<? super CommodityBasketUnderlyingByPercentage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBasketUnderlyingByPercentage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityBasketUnderlyingByPercentage> validator(ValidatorFactory factory) {
		return factory.<CommodityBasketUnderlyingByPercentage>create(CommodityBasketUnderlyingByPercentageValidator.class);
	}

	@Override
	public Validator<? super CommodityBasketUnderlyingByPercentage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityBasketUnderlyingByPercentage>create(CommodityBasketUnderlyingByPercentageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBasketUnderlyingByPercentage> validator() {
		return new CommodityBasketUnderlyingByPercentageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBasketUnderlyingByPercentage> typeFormatValidator() {
		return new CommodityBasketUnderlyingByPercentageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBasketUnderlyingByPercentage, Set<String>> onlyExistsValidator() {
		return new CommodityBasketUnderlyingByPercentageOnlyExistsValidator();
	}
}
