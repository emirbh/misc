package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxDigitalAmericanExercise;
import fpml.consolidated.fx.validation.FxDigitalAmericanExerciseTypeFormatValidator;
import fpml.consolidated.fx.validation.FxDigitalAmericanExerciseValidator;
import fpml.consolidated.fx.validation.exists.FxDigitalAmericanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxDigitalAmericanExercise.class)
public class FxDigitalAmericanExerciseMeta implements RosettaMetaData<FxDigitalAmericanExercise> {

	@Override
	public List<Validator<? super FxDigitalAmericanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDigitalAmericanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxDigitalAmericanExercise> validator(ValidatorFactory factory) {
		return factory.<FxDigitalAmericanExercise>create(FxDigitalAmericanExerciseValidator.class);
	}

	@Override
	public Validator<? super FxDigitalAmericanExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxDigitalAmericanExercise>create(FxDigitalAmericanExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxDigitalAmericanExercise> validator() {
		return new FxDigitalAmericanExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxDigitalAmericanExercise> typeFormatValidator() {
		return new FxDigitalAmericanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDigitalAmericanExercise, Set<String>> onlyExistsValidator() {
		return new FxDigitalAmericanExerciseOnlyExistsValidator();
	}
}
