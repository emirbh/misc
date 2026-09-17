package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.SharedAmericanExercise;
import fpml.consolidated.shared.validation.SharedAmericanExerciseTypeFormatValidator;
import fpml.consolidated.shared.validation.SharedAmericanExerciseValidator;
import fpml.consolidated.shared.validation.datarule.SharedAmericanExerciseChoice;
import fpml.consolidated.shared.validation.exists.SharedAmericanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SharedAmericanExercise.class)
public class SharedAmericanExerciseMeta implements RosettaMetaData<SharedAmericanExercise> {

	@Override
	public List<Validator<? super SharedAmericanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SharedAmericanExercise>create(SharedAmericanExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SharedAmericanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SharedAmericanExercise> validator(ValidatorFactory factory) {
		return factory.<SharedAmericanExercise>create(SharedAmericanExerciseValidator.class);
	}

	@Override
	public Validator<? super SharedAmericanExercise> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SharedAmericanExercise>create(SharedAmericanExerciseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SharedAmericanExercise> validator() {
		return new SharedAmericanExerciseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SharedAmericanExercise> typeFormatValidator() {
		return new SharedAmericanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SharedAmericanExercise, Set<String>> onlyExistsValidator() {
		return new SharedAmericanExerciseOnlyExistsValidator();
	}
}
