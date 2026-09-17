package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityBasketByNotional;
import fpml.consolidated.com.validation.CommodityBasketByNotionalTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityBasketByNotionalValidator;
import fpml.consolidated.com.validation.exists.CommodityBasketByNotionalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityBasketByNotional.class)
public class CommodityBasketByNotionalMeta implements RosettaMetaData<CommodityBasketByNotional> {

	@Override
	public List<Validator<? super CommodityBasketByNotional>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBasketByNotional, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityBasketByNotional> validator(ValidatorFactory factory) {
		return factory.<CommodityBasketByNotional>create(CommodityBasketByNotionalValidator.class);
	}

	@Override
	public Validator<? super CommodityBasketByNotional> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityBasketByNotional>create(CommodityBasketByNotionalTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBasketByNotional> validator() {
		return new CommodityBasketByNotionalValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBasketByNotional> typeFormatValidator() {
		return new CommodityBasketByNotionalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBasketByNotional, Set<String>> onlyExistsValidator() {
		return new CommodityBasketByNotionalOnlyExistsValidator();
	}
}
