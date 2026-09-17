package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityBasketUnderlyingBase;
import fpml.consolidated.com.validation.CommodityBasketUnderlyingBaseTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityBasketUnderlyingBaseValidator;
import fpml.consolidated.com.validation.exists.CommodityBasketUnderlyingBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityBasketUnderlyingBase.class)
public class CommodityBasketUnderlyingBaseMeta implements RosettaMetaData<CommodityBasketUnderlyingBase> {

	@Override
	public List<Validator<? super CommodityBasketUnderlyingBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBasketUnderlyingBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityBasketUnderlyingBase> validator(ValidatorFactory factory) {
		return factory.<CommodityBasketUnderlyingBase>create(CommodityBasketUnderlyingBaseValidator.class);
	}

	@Override
	public Validator<? super CommodityBasketUnderlyingBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityBasketUnderlyingBase>create(CommodityBasketUnderlyingBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBasketUnderlyingBase> validator() {
		return new CommodityBasketUnderlyingBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBasketUnderlyingBase> typeFormatValidator() {
		return new CommodityBasketUnderlyingBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBasketUnderlyingBase, Set<String>> onlyExistsValidator() {
		return new CommodityBasketUnderlyingBaseOnlyExistsValidator();
	}
}
