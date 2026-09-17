package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityAmericanExercise;
import fpml.consolidated.com.validation.CommodityAmericanExerciseTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityAmericanExerciseValidator;
import fpml.consolidated.com.validation.datarule.CommodityAmericanExerciseChoice;
import fpml.consolidated.com.validation.exists.CommodityAmericanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityAmericanExercise.class)
public class CommodityAmericanExerciseMeta implements RosettaMetaData<CommodityAmericanExercise> {

	@Override
	public List<Validator<? super CommodityAmericanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityAmericanExercise>create(CommodityAmericanExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityAmericanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityAmericanExercise> validator(ValidatorFactory factory) {
		return factory.<CommodityAmericanExercise>create(CommodityAmericanExerciseValidator.class);
	}

	@Override
	public Validator<? super CommodityAmericanExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityAmericanExercise>create(CommodityAmericanExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityAmericanExercise> validator() {
		return new CommodityAmericanExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityAmericanExercise> typeFormatValidator() {
		return new CommodityAmericanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityAmericanExercise, Set<String>> onlyExistsValidator() {
		return new CommodityAmericanExerciseOnlyExistsValidator();
	}
}
