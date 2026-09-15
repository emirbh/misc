package drr.base.trade.basket.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.basket.CustomBasket;
import drr.base.trade.basket.validation.CustomBasketTypeFormatValidator;
import drr.base.trade.basket.validation.CustomBasketValidator;
import drr.base.trade.basket.validation.exists.CustomBasketOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CustomBasket.class)
public class CustomBasketMeta implements RosettaMetaData<CustomBasket> {

	@Override
	public List<Validator<? super CustomBasket>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CustomBasket, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustomBasket> validator(ValidatorFactory factory) {
		return factory.<CustomBasket>create(CustomBasketValidator.class);
	}

	@Override
	public Validator<? super CustomBasket> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CustomBasket>create(CustomBasketTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CustomBasket> validator() {
		return new CustomBasketValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CustomBasket> typeFormatValidator() {
		return new CustomBasketTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustomBasket, Set<String>> onlyExistsValidator() {
		return new CustomBasketOnlyExistsValidator();
	}
}
