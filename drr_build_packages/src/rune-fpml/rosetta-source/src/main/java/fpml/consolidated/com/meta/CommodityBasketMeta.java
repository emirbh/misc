package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityBasket;
import fpml.consolidated.com.validation.CommodityBasketTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityBasketValidator;
import fpml.consolidated.com.validation.datarule.CommodityBasketChoice;
import fpml.consolidated.com.validation.exists.CommodityBasketOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityBasket.class)
public class CommodityBasketMeta implements RosettaMetaData<CommodityBasket> {

	@Override
	public List<Validator<? super CommodityBasket>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityBasket>create(CommodityBasketChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityBasket, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityBasket> validator(ValidatorFactory factory) {
		return factory.<CommodityBasket>create(CommodityBasketValidator.class);
	}

	@Override
	public Validator<? super CommodityBasket> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityBasket>create(CommodityBasketTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBasket> validator() {
		return new CommodityBasketValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBasket> typeFormatValidator() {
		return new CommodityBasketTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBasket, Set<String>> onlyExistsValidator() {
		return new CommodityBasketOnlyExistsValidator();
	}
}
