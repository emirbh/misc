package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityExerciseBasket;
import fpml.consolidated.com.validation.CommodityExerciseBasketTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityExerciseBasketValidator;
import fpml.consolidated.com.validation.datarule.CommodityExerciseBasketChoice0;
import fpml.consolidated.com.validation.datarule.CommodityExerciseBasketChoice1;
import fpml.consolidated.com.validation.exists.CommodityExerciseBasketOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityExerciseBasket.class)
public class CommodityExerciseBasketMeta implements RosettaMetaData<CommodityExerciseBasket> {

	@Override
	public List<Validator<? super CommodityExerciseBasket>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityExerciseBasket>create(CommodityExerciseBasketChoice0.class),
			factory.<CommodityExerciseBasket>create(CommodityExerciseBasketChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityExerciseBasket, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityExerciseBasket> validator(ValidatorFactory factory) {
		return factory.<CommodityExerciseBasket>create(CommodityExerciseBasketValidator.class);
	}

	@Override
	public Validator<? super CommodityExerciseBasket> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityExerciseBasket>create(CommodityExerciseBasketTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityExerciseBasket> validator() {
		return new CommodityExerciseBasketValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityExerciseBasket> typeFormatValidator() {
		return new CommodityExerciseBasketTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityExerciseBasket, Set<String>> onlyExistsValidator() {
		return new CommodityExerciseBasketOnlyExistsValidator();
	}
}
