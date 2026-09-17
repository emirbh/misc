package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxMultipleExercise;
import fpml.consolidated.fx.validation.FxMultipleExerciseTypeFormatValidator;
import fpml.consolidated.fx.validation.FxMultipleExerciseValidator;
import fpml.consolidated.fx.validation.exists.FxMultipleExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxMultipleExercise.class)
public class FxMultipleExerciseMeta implements RosettaMetaData<FxMultipleExercise> {

	@Override
	public List<Validator<? super FxMultipleExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxMultipleExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxMultipleExercise> validator(ValidatorFactory factory) {
		return factory.<FxMultipleExercise>create(FxMultipleExerciseValidator.class);
	}

	@Override
	public Validator<? super FxMultipleExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxMultipleExercise>create(FxMultipleExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxMultipleExercise> validator() {
		return new FxMultipleExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxMultipleExercise> typeFormatValidator() {
		return new FxMultipleExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxMultipleExercise, Set<String>> onlyExistsValidator() {
		return new FxMultipleExerciseOnlyExistsValidator();
	}
}
