package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Basket;
import fpml.consolidated.asset.validation.BasketTypeFormatValidator;
import fpml.consolidated.asset.validation.BasketValidator;
import fpml.consolidated.asset.validation.exists.BasketOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Basket.class)
public class BasketMeta implements RosettaMetaData<Basket> {

	@Override
	public List<Validator<? super Basket>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Basket, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Basket> validator(ValidatorFactory factory) {
		return factory.<Basket>create(BasketValidator.class);
	}

	@Override
	public Validator<? super Basket> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Basket>create(BasketTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Basket> validator() {
		return new BasketValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Basket> typeFormatValidator() {
		return new BasketTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Basket, Set<String>> onlyExistsValidator() {
		return new BasketOnlyExistsValidator();
	}
}
