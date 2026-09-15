package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxEuropeanExercise;
import fpml.consolidated.fx.validation.FxEuropeanExerciseTypeFormatValidator;
import fpml.consolidated.fx.validation.FxEuropeanExerciseValidator;
import fpml.consolidated.fx.validation.exists.FxEuropeanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxEuropeanExercise.class)
public class FxEuropeanExerciseMeta implements RosettaMetaData<FxEuropeanExercise> {

	@Override
	public List<Validator<? super FxEuropeanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxEuropeanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxEuropeanExercise> validator(ValidatorFactory factory) {
		return factory.<FxEuropeanExercise>create(FxEuropeanExerciseValidator.class);
	}

	@Override
	public Validator<? super FxEuropeanExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxEuropeanExercise>create(FxEuropeanExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxEuropeanExercise> validator() {
		return new FxEuropeanExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxEuropeanExercise> typeFormatValidator() {
		return new FxEuropeanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxEuropeanExercise, Set<String>> onlyExistsValidator() {
		return new FxEuropeanExerciseOnlyExistsValidator();
	}
}
