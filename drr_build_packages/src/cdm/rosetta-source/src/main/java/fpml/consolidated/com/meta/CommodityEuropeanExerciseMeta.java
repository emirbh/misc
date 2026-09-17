package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityEuropeanExercise;
import fpml.consolidated.com.validation.CommodityEuropeanExerciseTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityEuropeanExerciseValidator;
import fpml.consolidated.com.validation.exists.CommodityEuropeanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityEuropeanExercise.class)
public class CommodityEuropeanExerciseMeta implements RosettaMetaData<CommodityEuropeanExercise> {

	@Override
	public List<Validator<? super CommodityEuropeanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityEuropeanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityEuropeanExercise> validator(ValidatorFactory factory) {
		return factory.<CommodityEuropeanExercise>create(CommodityEuropeanExerciseValidator.class);
	}

	@Override
	public Validator<? super CommodityEuropeanExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityEuropeanExercise>create(CommodityEuropeanExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityEuropeanExercise> validator() {
		return new CommodityEuropeanExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityEuropeanExercise> typeFormatValidator() {
		return new CommodityEuropeanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityEuropeanExercise, Set<String>> onlyExistsValidator() {
		return new CommodityEuropeanExerciseOnlyExistsValidator();
	}
}
