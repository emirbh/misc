package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityBasketByPercentage;
import fpml.consolidated.com.validation.CommodityBasketByPercentageTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityBasketByPercentageValidator;
import fpml.consolidated.com.validation.exists.CommodityBasketByPercentageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityBasketByPercentage.class)
public class CommodityBasketByPercentageMeta implements RosettaMetaData<CommodityBasketByPercentage> {

	@Override
	public List<Validator<? super CommodityBasketByPercentage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBasketByPercentage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityBasketByPercentage> validator(ValidatorFactory factory) {
		return factory.<CommodityBasketByPercentage>create(CommodityBasketByPercentageValidator.class);
	}

	@Override
	public Validator<? super CommodityBasketByPercentage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityBasketByPercentage>create(CommodityBasketByPercentageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBasketByPercentage> validator() {
		return new CommodityBasketByPercentageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBasketByPercentage> typeFormatValidator() {
		return new CommodityBasketByPercentageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBasketByPercentage, Set<String>> onlyExistsValidator() {
		return new CommodityBasketByPercentageOnlyExistsValidator();
	}
}
